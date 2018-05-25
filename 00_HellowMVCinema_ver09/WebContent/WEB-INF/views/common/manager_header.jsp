<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cinema.admin.model.vo.*"%>


<%
	Manager managerSession = (Manager)session.getAttribute("managerSession");
	System.out.println("유저 로긴 세션 확인 "+managerSession);
	String path = request.getContextPath();

	
	String MovieListPath = path+"/movie/showMovieList.do";
	String LocaManaging = path+"/manager/local?type=list";
	
	
	String movie = path+"/manager/movie";
	String manager = path+"/manager/manager";
	String local = path+"/manager/local";
	String theater = path+"/manager/theater";
	String seat = path+"/manager/seat";
	String room = path+"/manager/room";
	String schedule = path+"/manager/schedule";
	String ticket = path+"/manager/ticket";
	String price = path+"/manager/price";
	String board = path+"/board/boardView";

	
	
	
	Cookie[] cookies = request.getCookies();
	
	boolean saveId = false;
	String userIdSaved = "";
	
   	if(cookies !=null){
   		System.out.println("--------------------------------");
   		System.out.println("브라우져가 전송한 쿠키목록");
   		System.out.println("--------------------------------");
		for(Cookie c : cookies ){
			String key = c.getName();
			String value = c.getValue();
	   		System.out.println("쿠키가요 ===> " + key + " : " + value );
	   		
	   		//아이디저장 쿠키검사
	   		if("saveId".equals(key)){
	   			saveId = true;
	   			userIdSaved = value;
	   		}else{
	   			
	   		}
		}   		
   		System.out.println("--------------------------------");
   	}
   	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello MVC</title>
<script src="<%=path %>/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/cinema/css/jquery.datetimepicker.min.css">
<script src="/cinema/js/jquery.datetimepicker.full.min.js"></script>


<link rel="stylesheet" href="<%=path %>/css/style.css" />
<script>
function fn_login_pop(){
	$(".login_pop").toggle();
	console.log($(".login_pop"));
}
function fn_login(){
	$id = $("#id").val();
	$pw = $("#pw").val();
	
	
	console.log($id);
	console.log($pw);
	
	$.ajax({
		url : "<%=path %>/login/userlogin", 
		data : {id : $id, pw : $pw},
		type : "post", 
		dataType : "html",
		success : function(data){
			console.log(data);
		},
		error :function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
		},
		complete: function(){
			console.log("ajax 어찌됬던 종료!");
		}
	});
}

function fn_logout(){
	location.href="<%=path %>/manager/logout";
}
</script>
</head>

<style>
header{ border-bottom:3px solid #1986ff; position:relative; }
header h2{float:left;}
header h2 a{padding:10px; display:inline-block;}
nav{overflow:hidden;}
nav::after{content:""; clear:both;}
nav > ul {float:left; margin-left:20px; overflow:hidden;}
nav > ul > li{float:left; border-left:1px solid #ececec; border-right:1px solid #ececec; min-width:80px; text-align:center;}
nav > ul > li a{padding:20px 10px; display:inline-block; width:100%;}
nav > ul > li a:hover{background:#333; color:#fff;}
.login_pop{
	display:none;
	width:500px;
	height:500px;
	border:1px solid #ececec; position:absolute;
	background:#ececec;
	right:0px;
}
</style>
<header>
	<div class="wrap">
		<h2><a href="<%= path%>">MVCINEMA</a></h2>
		<nav>
			<ul>
				<li><a href="<%=movie %>">영화</a></li>
				<li><a href="<%=manager %>">매니저</a></li>
				<li><a href="<%=local %>">지역</a></li>
				<li><a href="<%=theater %>">영화관</a></li>
				<li><a href="<%=seat %>">M좌석 </a></li>
				<li><a href="<%=room %>">M상영관 </a></li>
				<li><a href="<%=schedule %>">M스케쥴</a></li>
				<li><a href="<%=ticket %>">M예매</a></li>
				<li><a href="<%=price %>">가격</a></li>
				<li><a href="<%=board %>">게시판</a></li>
			</ul>
		</nav>
	</div>
	
	
</header>
<script>
function showTheaterName(tid){
	$.ajax({
		url : "<%=theater %>",
		dataType:"json",
		type: "post",
		data : { type : "selectTheater", theaterNo : tid},
		success:function(data){
			console.log(data);
			if(data.name == undefined){	 
	 			$(".theater_where").html("");
			}else{
	 			$(".theater_where").html(data.name);
			}
		}

	});
}
<% if(managerSession != null) { %>
$(function(){
	showTheaterName(<%= managerSession.getTid() %>);
})
<% } %>

</script>
<section id="container">
	<section id="content">
		<div class="manager_inforBox">
			<div class="wrap">
			<% if(managerSession != null) {%>
			<span class="theater_where"></span>  <%= managerSession.getName() %> 님, 안녕하세요.
			<span onclick="fn_logout()">로그아웃</span>
			<%} %>
			</div>
		</div>
	<div class="wrap">

