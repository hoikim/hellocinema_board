<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cinema.user.model.vo.*, com.cinema.admin.model.vo.*"%>


<%

	User userSession = null;
	String userId = "";
	if(session.getAttribute("userSession") != null){
		userSession = (User)session.getAttribute("userSession");
	}else{
		
	}

	String path = request.getContextPath();

	
	String MovieListPath = path+"/movie/showMovieList";
	String JoinUser = path+"/user/join";
	String BoardPath = path + "/board/boardView";
	String RecomandMoviePath = path+"/movie/recommand.do";
	String TheatersPath = path+"/userTheater";
	
	String Managerlogin ="/managerLogin";
	
	
	//관리자가 아닌경우 
	Manager sessionManager = (Manager)request.getSession(true).getAttribute("managerSession");
	
	
	String view="";
	if(sessionManager != null) {
		Managerlogin = path + "/manager/movie";
	}else{
		Managerlogin = path + "/managerLogin";
	}

	Cookie[] cookies = request.getCookies();
	
	boolean usaveId = false;
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
	   		if("usaveId".equals(key)){
	   			usaveId = true;
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
<script src="<%=path %>/js/date.js"></script>
<link rel="stylesheet" href="<%=path %>/css/style.css" />
<script>

function fn_login_pop(){
	$(".login_pop").toggle();
	console.log($(".login_pop"));
}
function fn_login(){
	$id = $("#id").val();
	$pw = $("#pw").val();
	$usaveId = $("#usaveId").val();
	
		$.ajax({
		url : "<%=path %>/login/userlogin", 
		data : {id : $id, pw : $pw, usaveId : $usaveId},
		type : "post", 
		dataType : "html",
		success : function(data){
			console.log(data);
			location.href="/cinema";
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


function fn_login_hidden(){
	$id = $(".loginBox .login_hidden_id").val();
	$pw = $(".loginBox .login_hidden_pw").val();
	$usaveId = "";
	
	
	$.ajax({
		url : "<%=path %>/login/userlogin", 
		data : {id : $id, pw : $pw, usaveId : $usaveId},
		type : "post", 
		dataType : "html",
		success : function(data){
			console.log(data);
			location.href="/cinema";
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
function fn_join(){
	location.href="<%=JoinUser%>";
}

function fn_manager_login(){
	location.href="<%=Managerlogin%>";
}
</script>
</head>

<style>
header{ border-bottom:3px solid #1986ff; position:relative; }
header h1{float:left;}
header h1 a{padding:10px; display:inline-block;}
nav{overflow:hidden;}
nav::after{content:""; clear:both;}
nav > ul {float:left; margin-left:50px; overflow:hidden;}
nav > ul > li{float:left; border-left:1px solid #ececec; border-right:1px solid #ececec; min-width:100px; text-align:center;}
nav > ul > li a{padding:20px; display:inline-block; width:100%;}
nav > ul > li a:hover{  color:#1986ff; font-weight:bold;}
.login_pop{
	display:none;
	width:300px;
	height:280px;
	position:absolute;
	background:#fff;
	right:30px;
	top:61px;
	border-top:2px solid #1986ff;
	border-radius:0px 0px 3px 3px;
	overflow:hidden;
}
.login_pop input{
	margin-bottom:10px;
	border-radius:2px;
	border-style:none;
	border:1px solid #ececec;
	outline:none;
	font-size:14px;
	}

.login_section{
	padding:20px;
	overflow:hidden; 
	position:relative;
}
.login_section h3{
display:block;
padding:15px 0px;

}
.login_pop input:focus{
border:1px solid #1986ff}
#id{-webkit-appearance :none; width:100%;}
#pw{-webkit-appearance :none; width:100%;}
.login_adversting {position:absolute; bottom:0px; height:60px;}
.login_adversting img{ width:100%;}
.input_section{float:left; width:60%;}
.login_btn_section{margin-left:10px; float:right; width:35%; }
.btn_login{height:86px; width:100%;}
.login_saveId{clear:both; font-size:12px; padding-top:10px; }
.login_saveId span{cursor:pointer;}
#saveId{vertical-align: top; }
.user_logged{padding:0px 10px; font-size:12px; height:60px; border-right:none;}
.user_logged span{display:inline-block; padding:21px 0px; }
.logout_btn{cursor:pointer;}
.logo{float:left;}
.logo a{padding:0px; padding-top:18px; display:inline-block; letter-spacing: 2px;}

</style>


<header>
	<div class="wrap">
		<h3 class="logo"><a href="<%= path%>"> MVCINEMA </a></h3>
		<nav>
			<ul>
				<li><a href="<%= MovieListPath %>">영화</a></li>
				<li><a href="<%= RecomandMoviePath%>">추천영화</a></li>
				<li><a href="<%= TheatersPath %>">영화관</a></li>
				<li><a href="<%=BoardPath %>">이벤트</a></li>
				<% if(userSession == null) {%>
				<li><a href="javascript:fn_login_pop()" >로그인</a></li>
				<li><a href="javascript:fn_manager_login()">관리자</a></li>			
				<%}else{ %>
				<li class="user_logged">
				&nbsp;&nbsp;
					<span><%= userSession.getName() %>님, 안녕하세요.</span> &nbsp;&nbsp;
					<span class="my_infor" onclick="fn_showInfo()" style="cursor:pointer;">내정보보기</span> &nbsp;&nbsp;
					<span class="logout_btn" onclick="fn_logout()">로그아웃</span>
				</li>
				<%} %>
			</ul>
		</nav>
		
		<%-- <%=userSession.getName() %> --%>

		<div class="login_pop">
		<div class="login_section">
		<% if(userSession == null) {%>
			<h3>MVCINEMA 로그인</h3>
			<div class="input_section">

				<input type="text" name="id" id="id" placeholder="아이디" value ="<%= usaveId ? userIdSaved : "" %>"/>
				<input type="password" name="pw" id="pw" placeholder="비밀번호" />
			</div>
			<div class="login_btn_section">
				<button onclick="fn_login()" class="btn_login">로그인</button>	
			</div>
			<div class="login_saveId">
				<input type="checkbox" name="usaveId" id="usaveId" <%= usaveId ? "checked":"" %> />
				<label for="usaveId">아이디 저장</label>
				&nbsp;&nbsp; <span onclick="fn_join()">회원가입</span>
			</div>
			
		<%}else{ %>
			<%= userSession.getName() %> 님, 안녕하세요.
			<button onclick="fn_login()">내정보보기</button>
			<%} %>
		</div>
		<div class="login_adversting">
			<img src="/cinema/data/adversting.jpg" alt="" />
		</div>
		</div>
	</div>
</header>
<script>
function fn_logout(){
	
	location.href="/cinema/user/logout";
	
}
function fn_showInfo(){
	location.href="/cinema/users?type=viewInfo";
}
 

</script>
<section id="container">
	<section id="content">
	<div class="wrap">