<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>

<% 
	//List<Movie> mlist = (List<Movie>)request.getAttribute("mlist"); 
	//String pageBar = (String)request.getAttribute("pageBar");

%>

<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
 



<style>
.common_style_table{margin-bottom:50px;}
.common_style_table td{padding:10px;}
.common_style_table select{width:100px; font-size:16px; padding:6px;}
.common_style_table button{padding:15px 40px;}
.info{float:right; width:auto;}

.common_style_table th{
  background: #ededed;
  width: 120px;
}
.common_style_table td:nth-child(1n) {

}
</style>


<table class="common_style_table" id="room_table">
		<tr>
			<th>영화관 이름</th>
			<td><input type="text" name="name" id="" placeholder="이름" /> </td>
			<td class="who"></td>
			<td></td>
		</tr>
		<tr>
			<th>지역설정</th>
			<td><input type="text" name="local" id="" placeholder="지역"/>	 </td>
			<th>비밀번호</th>
			<td><select name="" id="locals"></select></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="addr" id="" placeholder="주소" /></td>
			<th>연락처</th>
			<td><input type="text" name="tel" id="" placeholder="번호" /></td>
		</tr>
		<tr>
		<td colspan=4 style="text-align:center;"><button onclick="fn_insert()">등록</button></td>
		</tr>
</table>
<script>

function fn_showList(){
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
	 	
	 	
	 	$("#locals").click(function(){
	 		$("[name=local]").val($("#locals").val());
	 		console.log($(this).val());
	 	});
	 	
	 	
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
	$name = $("[name=name]").val();
	$local = $("[name=local]").val();
	$addr = $("[name=addr]").val();
	$tel = $("[name=tel]").val();
	$.ajax({
		url : "<%=theater %>", 
		data : {type : "insertTheater", name : $name, local : $local, addr : $addr, tel : $tel},
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

fn_showList();

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	