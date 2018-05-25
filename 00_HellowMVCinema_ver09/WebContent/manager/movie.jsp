<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
    <%
    
    String moviePath = request.getContextPath()+"/movie/showMovieList.do";
    %>
<!DOCTYPE html>
<html>
<head>
<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>

</head>

<body>



<button onclick="fn_showList()">검색</button>
<button onclick="fn_insert()">삽입</button>

<form action="<%=moviePath %>" method="post">
	<input type="text" name="localCode" id ="localCode"/>
	<input type="text" name="localName" id="localName"/>
	<input type="hidden" name="type" value="insert"/>
	<button type="submit">전송</button>
</form>


<div id="viewList">
	


</div>

<script>
function fn_insert(){
	$localCode = $("#localCode").val();
	$localName = $("#localName").val();
	
	$.ajax({
		url : "<%=moviePath %>",
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
	url : "<%=moviePath %>",
	dataType:"html",
	type: "post",
	data : { type : "list"},
	success:function(data){
 	console.log(data);
 	
 	console.log(data.length);
 	$("#viewList").html(data);
 	
		
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