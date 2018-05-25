<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
    <%
    
    String localPath = request.getContextPath()+"/manager/local";
    %>
<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<style>

table th{background:#333; color:#fff; padding:20px; font-weight:normal;}
table td input{width:100%; font-size:18px;}
table td button{width:100%;}
</style>


<!-- <button onclick="fn_showList()">검색</button>
<button onclick="fn_insert()">삽입</button> -->

<!-- 	<input type="text" name="localCode" id ="localCode"/>
	<input type="text" name="localName" id="localName"/> -->


<div id="viewList">
</div>

<script>

function fn_delete(localCode, name){
	console.log(name);
	$.ajax({
		url : "<%=localPath %>",
		dataType:"html",
		type: "post",
		data : { type : "delete", localCode : localCode},
		success:function(data){
	 	console.log(data);
		fn_showList();
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
	$localCode = $("#localCode").val();
	$localName = $("#localName").val();
	
	console.log($localCode);
	$.ajax({
		url : "<%=localPath %>",
		dataType:"html",
		type: "post",
		data : { type : "insert", localCode : $localCode, localName : $localName},
		success:function(data){
	 	console.log(data);
		fn_showList();
			
		}, 	error : function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
	}, complete : function(){
	}

	});	
}
function fn_showList(){
$.ajax({
	url : "<%=localPath %>",
	dataType:"json",
	type: "post",
	data : { type : "list"},
	success:function(data){
 	console.log(data);
 	
 	console.log(data.length);
 	
 	
 	var html = "<table><tr><th>No</th><th>지역코드</th><th>지역이름</th><th>수정</th><th>삭제</th></tr>";
 		html +="<tr><td></td><td><input type='text' id='localCode'></td><td><input type='text' id='localName'></td>";
 		html +="<td colspan='2'><button onclick='fn_insert()'>등록</button></td></tr>";
 	for(var i=0; i< data.length; i++){
 		console.log(data[i]);
 		html += "<tr><td>"+(i+1)+"</td>";
 		html += "<td><input type='text' value='"+data[i].lid+"'></td>";
 		html += "<td><input type='text' value='"+data[i].lname+"'></td>";
 		html += "<td><button onclick='("+data[i].lid+", "+data[i].lname+")'>수정</button></td>";
 		html += "<td><button onclick=fn_delete('"+data[i].lid+"','"+data[i].lname+"')>삭제</button></td>";
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
fn_showList();
</script>
</body>
</html>