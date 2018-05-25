<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>

<% 
	//List<Movie> mlist = (List<Movie>)request.getAttribute("mlist"); 
	//String pageBar = (String)request.getAttribute("pageBar");

%>

<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
 


<%= "test"+managerSession.getTid() %>
<input type="hidden" name="" id="" />  <br />
현재영화관<input type="text" name="theater" id="theaters" readonly="readonly" /> <br>
상영관이름<input type="text" name="roomname" id="" placeholder="상영관 이름" /> <br>
좌석 타입설정
<select name="seatSetting" id="seat" name="seat">
	
</select>
기타<input type="text" name="etc" id="" placeholder="기타" /><br>
<button onclick="fn_insert()">삽입</button>

<script>

function fn_setTheater(){
	
	console.log("test");
	$.ajax({
		url : "<%=theater %>",
		dataType:"json",
		type: "post",
		data : {type : "selectTheater" ,theaterNo : <%= managerSession.getTid() %>},
		success:function(data){
			console.log(data);
		$("#theaters").val(data.name);
 
		}, 	error : function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
	}, complete : function(){
	}

	});
	
	
	
	
	
	
	////////////////////////////////좌석 설정///////////////////////////////
	
	
	$.ajax({
		url : "<%=room %>",
		dataType:"json",
		type: "post",
		data : {type : "seatList"},
		success:function(data){
			var seat = $("#seat");
			console.log(data.seat);
			
			var html = "";
			
			
			for(key in data.seat){
				console.log(data.seat[key].sid);
				html += "<option sid='"+data.seat[key].sid+"' val='"+data.seat[key].name+"'>"+data.seat[key].name+"</option>"
			}
			seat.append(html);
			
		}, 	error : function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
	}, complete : function(){
	}

	});
	
	
}


function fn_showLocalList(){

	$.ajax({
		url : "<%=local %>",
		dataType:"json",
		type: "post",
		data : { type : "list"},
		success:function(data){
	 	console.log(data);
	 	
	 	
	 	for(var i = 0; i<data.length; i++){
	 		$("#locals").append("<option value='"+data[i].lid+"'>"+data[i].lname+"</option>")
	 	}
	 	
	 	console.log(data.length);
	 	
	 	
	 	var html = "<table> "
	 	for(var i=0; i< data.length; i++){
	 		console.log(data[i]);
	 		html += "<tr>";
	 		html += "<td>지역코드<input type='text' value='"+data[i].lid+"'></td>";
	 		html += "<td>지역이름<input type='text' value='"+data[i].lname+"'></td>";
	 		html += "<td><button onclick='fn_delete("+data[i].lid+", "+data[i].lname+")'>삭제</button><button onclick='("+data[i].lid+", "+data[i].lname+")'>수정</button></td>";
	 		html += "</tr>";
	 	}
			html += "</table>"; 	
	 	$("#viewList").html(html);
		}, 	error : function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
	}, complete : function(){
	}

	});
}
function fn_insert(){
	$tid = <%=managerSession.getTid() %>; 					   //현재 상영관
	console.log("헛헛"+$tid );
	$sid = $("#seat").find("option:selected").attr("sid"); //좌석
	$name = $("[name=roomname]").val();						   //상영관 이름
	$etc = $("[name=etc]").val();						   //별도
	console.log("싯싯"+$sid);
	
	
	$.ajax({
		url : "<%=room %>", 
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
}

fn_showLocalList();
fn_setTheater();
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	