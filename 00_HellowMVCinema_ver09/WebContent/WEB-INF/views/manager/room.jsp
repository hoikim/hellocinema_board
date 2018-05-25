<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>

<% 
	//List<Movie> mlist = (List<Movie>)request.getAttribute("mlist"); 
	//String pageBar = (String)request.getAttribute("pageBar");

%>

<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
 



<input type="hidden" name="" id="" /> <br />
 


<style>
.mg_tables{margin-bottom:50px;}
.mg_tables td{padding:10px;}
.mg_tables select{width:100px; font-size:16px; padding:6px;}
.mg_tables button{padding:15px 40px;}
.info{float:right; width:auto;}
</style>

<table class="mg_tables info">
	<tr>
		<td style="width:150px;">MT번호</td>
		<td style="width:150px;"><input type="text" name="mg_number" id="mg_number" readonly="readonly"  value="<%= managerSession.getTid() %>"/></td>
		<td>영화관</td>
		<td><input type="text" name="theater" id="theaters" readonly="readonly" style="width:80px;"/></td>
	</tr>
</table>

<table class="mg_tables" id="room_table">
	<tr>
		<td>이름</td>
		<td><input type="text" name="roomname" id="" style="width:100px;"/> </td>
		<td>타입</td>
		<td>
			<select name="rtype" id="">
				<option value="2D">2D</option>
				<option value="3D">3D</option>
				<option value="4D">4D</option>
			</select>
		</td>
		<td>좌석</td>
		<td><select name="seatSetting" id="seat" name="seat" ></select></td>
		<td>기타</td>
		<td><input type="text" name="etc" id="" style="width:70px;"/> </td>
		<td style="text-align:center;"><button onclick="fn_insert()">등록</button></td>
	</tr>
</table>



<script>

function fn_getRoom(){
	$.ajax({
		url : "<%=room %>",
		dataType:"json",
		type: "post",
		data : {type : "showRoomList" , tid : <%= managerSession.getTid() %>},
		success:function(data){
			console.log(data);
				var html = "";
			for(i in data){
				html += "<tr>";
				html += "<td>이름</td>";
				html += "<td class='update_name'>" +data[i].name+ "</td>";
				html += "<td>타입</td>";
				html += "<td class='update_type'>" +data[i].type+ "</td>";
				html += "<td>좌석</td>";
				html += "<td class='update_seat'>" +data[i].sid+ "</td>";
				html += "<td>기타</td>";
				html += "<td class='update_etc'>" +data[i].etc+ "</td>";
				html += '<td style="text-align:center;"><button onclick="fn_update('+data[i].rid+')">등록</button></td>';
				html += "</tr>";
			}

			
			$("#room_table").append(html);
 
		}
	});
	
	
}
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
	 		$("#locals").append("<option value='"+data[i].lid+"'>"+data[i].lname+"</option>");
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
	$rtype = $("[name=rtype]").val();
	
	
	$.ajax({
		url : "<%=room %>", 
		data : {type  : "insertRoom" , tid : $tid, sid : $sid, name : $name, rtype : $rtype,  etc : $etc},
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

fn_getRoom();
fn_showLocalList();
fn_setTheater();
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	