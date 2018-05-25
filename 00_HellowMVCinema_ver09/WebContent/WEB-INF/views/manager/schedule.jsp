<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>

<% 
	//List<Movie> mlist = (List<Movie>)request.getAttribute("mlist"); 
	//String pageBar = (String)request.getAttribute("pageBar");
%>

<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>


<script>

d = new Date();
var mids = 0;



function fn_showMovieList(){
	$.ajax({
		url : "<%=movie %>", 
		data : {type  : "showMovieList" , keyword : ""},
		type : "post", 
		dataType : "html",
		success : function(data){
			console.log(data);
		}  
	});
	
}


function fn_showScheduleList(type){
	$tid = <%=managerSession.getTid() %>; 				 
 	//영화관에서
 	
	$.ajax({
		url : "<%=theater %>", 
		data : {type  : "insertRoom" , tid : $tid, sid : $sid, name : $name, etc : $etc},
		type : "post", 
		dataType : "html",
		success : function(data){
			console.log(data);
		}  
	});
	
 	
 	
	//룸 가져오기
	$.ajax({
		url : "<%=schedule %>", 
		data : {type  : "insertRoom" , tid : $tid, sid : $sid, name : $name, etc : $etc},
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
	
	//좌석에서
}


/*			#  1       2        3        4           5         6         7         8
#SHID     RID      MID      SEAT       LSEAT      TIME    ENDTIME    REGDATE
#NUMBER   NUMBER   NUMBER   VARCHAR    VARCHAR    DATE    DATE       DATE		*/	
function fn_insert(){
	$rid = $("");
	$mid = $("");
	$seat = $("");
	$lseat = $("");
	$time = $("");
	$endtime = $("");
	
	
	
	$tid = <%=managerSession.getTid() %>; 				 
 	//영화관에서
	//룸 가져오기
	$.ajax({
		url : "<%=room %>", 
		data : {type  : "insertSchedule" , rid : $rid, mid : $mid, seat : $seat, lseat : $lseat, time : $time, endtime: $endtime},
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
	
	//좌석에서
}



//일단 호출 
//fn_showMovieList();

function fn_showTime(){
	var s = 0;
	var min = 10;
}

</script>
<style>
.formSetter{float:left;}
#time_wrap{ position:relative;  border:1px solid #ededed;padding-left:55px; width:435px; overflow:hidden;}
#time_wrap .timeUlwrap{overflow:hidden; width:350px;  position:relative;}
#time_wrap span{position:absolute; top:0px; z-index:10}
#time_wrap .left_arrow{height:100%; display:inline-block ;top:0px; left:10px; border-right:1px solid #ededed;padding-right:10px; padding-left:10px; background:#fff;}
#time_wrap .right_arrow{height:100%; display:inline-block; top:0px; right:10px;border-left:1px solid #ededed;padding-right:10px; padding-left:10px; background:#fff;}
#time_wrap ul{z-index:9; position:relative; overflow:hidden;  width:1500px;   }
#time_wrap ul li{ float:left; text-align:center; width:50px; padding: 5px 10px; border-left:1px solid #ededed;   font-size:12px;}
#min_wrap{height:400px; overflow-y:scroll; width:435px; margin-top:10px; border:1px solid #ececec;}
#min_wrap li{border-bottom:1px solid #ececec; padding:5px; }
#min_wrap .reserved{background:#333; border-bottom:#333; color:#fff;}

.movieChoose{position:absolute; background:#fff; border:1px solid #e0e0e0;}
.movieChoose li{padding:10px; border-bottom:1px solid #ececec;}
</style>
<div>


<%-- 	<%= managerSession.getTid() %> --%>


	<script>
var roomObj;

//영화관 가져오기
function fn_getTheater(){
	$.ajax({
		url : "<%=theater %>",
		dataType : "json",
		data : {type : "selectTheater", theaterNo : <%= managerSession.getTid() %> },
		success : function(data){
			console.log("영화관 가져오기"+data.name); 
			$theaterObj = data;
			
		}
	}).done(function(){
	
	});
}
//상영관 가져오기
function fn_getRoom(){
	
	$.ajax({
		url : "<%=room %>",
		dataType : "json",
		data : {type : "showRoomList", tid : <%= managerSession.getTid() %>},
		success : function(data){

			var roomView  = "";
			for(i in data){
				roomView += "<option value='"+data[i].sid+"' room='"+data[i].rid+"'>"+data[i].name+"</option>"
			}
			$("#selectRoom").append(roomView);
			console.log("상영관 가져오기"+data);
			roomObj = data;
			
			
			
			
		}
	}).done(function(data){
		
	});


}
//좌석 가져오기 


var seat;

function fn_getSeat(sid){
	$.ajax({
		url : "<%=seat %>",
		dataType : "json",
		data : {type : "showSidSeat", sid : sid},
		success : function(data){
			console.log("좌석 가져오기"+data.shape);
			$(".seat").html(data.name);
			
			seat = data;
			
		}
	}).done(function(){
		console.log("모두 가져옴");
	});	
}

//스케쥴 등록 ---------------------------------------------------------------------------------------등록
function fn_setSchedule(){
	$rid = $("#selectRoom option:selected").attr("room");
	console.log("mid===" + mids);
	$seat = seat.shape;
	$lseat = 0;
	$time = $(".settime").text();
	$endtime = $(".setEndtime").text();
	
	//console.log($rid);
	
	$.ajax({
		url : "<%=schedule %>",
		dataType : "json",
		type: "post",
		data : {type :"insertSchedule", rid : $rid, mid : mids, seat : $seat, lseat : $lseat, time : $time, endtime : $endtime},
		success : function(data){
			console.log("인서트 결과다" + data)
			
			
		}
	}).done(function(){
		console.log("모두 가져옴");
	});	
}

$(function(){
	$theaterObj = fn_getTheater();
	$roomObj = fn_getRoom();
	fn_getSeat(9);

	$("[name=showDate]").datepicker();
	$("[name=showDate]").datepicker( "option", "dateFormat", "yy/mm/dd");
	
	
});



</script>




<div class="shceduler_wrap">
	<div class="formSetter">
	
		<table>
			<tr>
				<th>날짜선택</th>
				<td><input type="text" name="showDate" /></td>
				<td><button class="chk_schedule" onclick="fn_chk_schedule()">스케줄확인</button></td>
			</tr>
			<tr>
				<th>영화 검색</th>
				<td><input type="text" id="searchName" /><div class="movieChoose"></div></td>
				<td></td>
			</tr>
			<tr>
				<th>상영관</th>
				<td><select name="" id="selectRoom" style="font-size:18px; padding:10px;"></select></td>
				<td></td>
			</tr>
			<tr>
				<th>좌석타입</th>
				<td><div class="seat"></div></td>
				<td></td>
			</tr>
			<tr>
				<th>시작시간</th>
				<td><div class="settime"></div></td>
				<td></td>
			</tr>
			<tr>
				<th>종료시간</th>
				<td><div class="setEndtime"></div></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3"><button id="insertSchedule">전송</button></td>
			</tr>
		
		
		</table>
		
		
	</div>


	<div class="time_viewer">
		<div id="time_wrap">
			<span class='left_arrow'><</span><span class='right_arrow'>></span>
			<div class="timeUlwrap"></div>
		</div>
		<div id="min_wrap">
			<ul>
			</ul>
		</div>
	</div>
</div>
</div>
<style>
.time_viewer{float:left;}
.shceduler_wrap{overflow:hidden; width:100%; padding:50px 0px;  }
.formSetter{margin-right:20px;}
</style>
<script>
function fn_showTime(){
	var s = 0;
	var min = 10;

	var hour = 24; 
	var min = 6;
	var date = new Date();
	
	var hours = date.getHours();
	var time = date.getTime();
	
	
	
	var time_wrap = $("#time_wrap");
	var min_wrap = $("#min_wrap");
	var min_wrap_ul = $("#min_wrap ul");
	
	view = "";
	
	
	view += "<ul>";
	for(var i = 0; i < hour; i++){
		view += "<li>" + i + "</li>"
	}
	view += "</ul>";
	time_wrap.find(".timeUlwrap").html(view);
	
	min_view = "";
	
	
	for(var j=0; j<24; j++){
		for(var i = 0; i < min; i++){
			min_view += "<li id='min-"+j+i+"' totaltime='"+(j < 10 ? "0"+j : j )+i+0+"' time-hour='"+j+"' time-min='"+ i+"0"+"' toMin ='"+((j * 60 )+ (i+"0")*1)+"' >" +(j < 10 ? "0"+j : j ) + ":"+(i == 0 ? "0"+i : i+"0") + "</li>"; 
		}
	}
	
	min_wrap_ul.html(min_view);


	time_wrap.find("ul").css("left", -hours * 45);
}

$("#time_wrap").on("click", ".left_arrow", function(){
	console.log("3");
	var time_wrap = $("#time_wrap");

	if(! (time_wrap.find("ul").position().left < -950)){
		time_wrap.find("ul").css("left", "-=50" );
	}
	
	
});

$("#time_wrap").on("click", ".right_arrow", function(){

	var time_wrap = $("#time_wrap");
	
	if((time_wrap.find("ul").position().left < -50)){
		console.log("right");
		time_wrap.find("ul").css("left", "+=50" );
	}
});





$("#time_wrap").on("click", "li", function(){
	console.log($(this).text());
});


var temp=[];









$("#min_wrap").on("click","li:not(.reserved)", function(){
	

	$("#min_wrap li").not(".reserved").removeAttr("selected_min");
	
	var time = movie.runtime;
	
	//console.log($(this).attr("time-hour"));
	
	var select_time = $(this).attr("time-hour");
	var select_min = $(this).attr("time-min");
	
	
	//console.log("현재 선택한 시간은" + select_time +" : " + select_min);
	 
	var start_min = select_time*60 + parseInt(select_min);   // 10      10   20  30  40 
	var end_min = new Number(start_min)+ new Number(time);   // 40        10  20  30  40

	
	var up_count=0;
	if(end_min > 60 && end_min%60 != 0){
		up_count = parseInt((end_min/60));
	}
	
	//console.log("시작시간" + start_min)
	//console.log("끝나는 시간"+ end_min);
	
	//console.log("뺀값" + (end_min-start_min));
	
	

	//console.log("인덱스값"+$(this).index());
	
	
	for(var i = $(this).index(); i <= $(this).index()+(time/10); i++){
		
		if($("#min_wrap li").eq(i).attr("class") == "reserved"){
			
			console.log("예약할수 없음");
			return;
		}		
	}
	$("#min_wrap li").not(".reserved").css("background-color", "#fff");
	for(var i = $(this).index(); i <= $(this).index()+(time/10); i++){
			$("#min_wrap li").eq(i).not(".reserved").css("background", "#ececec");
			$("#min_wrap li").eq(i).not(".reserved").attr("selected_min", "1");
			console.log($("#min_wrap li").eq(i).attr("class"));
	}
	
	
	//선택된 시간을 설정해준다.
	
	console.log($(this).attr("totaltime"));
	$(".settime").text($("[name=showDate]").val() +" " + ($(this).attr("time-hour") < 10 ? "0" + $(this).attr("time-hour") : $(this).attr("time-hour"))+ ":" + $(this).attr("time-min"));
	$(".setEndtime").text($("[name=showDate]").val() +" " + $("li[selected_min]").last().text());
	
});

function fn_setReservedSchedule(){
	
	mObj = reservedSchedulObj;
	
	
	
	console.log("여긴 세팅해주는곳인데요" + reservedSchedulObj);
	

	
	var min_wrap  = $("#min_wrap li");
	
	
	for(i in mObj){
		
		ttime = (mObj[i].time.substring(0,2)*60)+(mObj[i].time.substring(3,5)*1);
		ettime = (mObj[i].endtime.substring(0,2)*60)+(mObj[i].endtime.substring(3,5)*1);
		
		for(var j=0; j< min_wrap.length; j++){
			var toMin = $("#min_wrap li").eq(j).attr("tomin");
			if( toMin >= ttime && toMin <= ettime ){
				$("#min_wrap li").eq(j).addClass("reserved");
				//$("#min_wrap li").eq(j).append("  예약불가");
			}
			
		}
	}	
	
	
}


$("#selectRoom").on("change", function(){
	console.log($(this).val());
	fn_getSeat($(this).val());
});	

var reservedSchedulObj; 

function fn_chk_schedule(){
	
	var showDate = $("[name=showDate]").val();
	var room = $("#selectRoom option:selected").attr("room");
	$.ajax({
		url:"/cinema/schedulerCommon",
		type:"post",
		data:{ type : "showScheduleforSchedule", showDate : showDate, room : room},
		dataType:"json",
		success:function(data){
			console.log(data);
			
			reservedSchedulObj = data;			
			fn_setReservedSchedule();
		}
	});
}

//영화 선택시 처리
function fn_selectMovie(mid, mname, moviedata){
	mids = mid;
	movie = moviedata;
	console.log(mids);
	console.log(movie.runtime);
	$(".movieChoose").empty();
	$(".movieChoose").hide();
	$("#searchName").val(mname);
}

//영화 검색시 처리

var moive; 
$("#searchName").keyup(function(e){
	console.log(e);
	console.log(e.key+", " + $(this).val());
	
	//방향키 (ArrowUp, ArrowDown), 엔터(Enter)일 경우, 선택효과
	//그 외의 키일 경우 ajax요청처리
	if($(this).val()==""){
		return;
	}
	var sel = $(".sel");
	var li = $("#autoComplete li");
	var movieChoose = $(".movieChoose");
	movieChoose.show();
	
	
	if(e.key == 'ArrowDown'){
		console.log('ArrowDown');
		//아무것도 선택되지 않은경우
		if(sel.length == 0) {
			$("#autoComplete li:first").addClass("sel");			
			
		//선택된 sel이 마지막 li태그인 경우	
		}else if(sel.is(li.last())){
			sel.removeClass("sel");
		}else{
			sel.removeClass("sel").next().addClass("sel");
		}
	}else if(e.key =='ArrowUp'){
		console.log('ArrowUp');
		if(sel.length == 0) {
			$("#autoComplete li:last").addClass("sel");			
			
		//선택된 sel이 마지막 li태그인 경우	
		}else if(sel.is(li.first())){
			sel.removeClass("sel");
			
		}else{
			sel.removeClass("sel").prev().addClass("sel");
		}	
	}else if(e.key == 'Enter'){
		console.log('Enter');
		$(this).val(sel.text());
		
		$("#autoComplete").hide().children().remove();
	}else{
		searchNamed =  $(this).val();
		$.ajax({
			url:"<%=movie %>",
			type:"post",
			data:{ type : "showMovieListKey", keyword : searchNamed},
			dataType:"json",
			success:function(data){
				console.log(data);
				//아무값도 넘어오지 않는 경우, data.split(",")의 배열 길이가 1임.
				movieChoose.empty();
				for(i in data){
					var moviedata = JSON.stringify(data[i]);
					movieChoose.append("<li onclick='fn_selectMovie("+data[i].mid+", \""+data[i].name+"\","+moviedata+")'>" + data[i].mid+ " , "+data[i].name +"</li>" );
				}

				
			}
		});
	}
	
	
});

function fn_init_sch(){

	$("#min_wrap li").removeClass("reserved");
	$("#min_wrap li").removeClass("reserved");
	movie="";
}
//영화 INSERT 
$("#insertSchedule").click(function(){
	fn_setSchedule();
});

$("[name=showDate]").click(function(){
	fn_init_sch();	
});


fn_showTime();
fn_setReservedSchedule();
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	
