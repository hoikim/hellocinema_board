<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
    <%
    
    String localPath = request.getContextPath()+"/manager/local";
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


영화관 등록<br/>
	영화관 이름<input type="text" name="localCode" id ="localCode"/> 
	영화관 지역<input type="text" name="localName" id="localName"/>
	영화관 <input type="hidden" name="type" value="insert"/>




영화관 리스트 / 수정
<div id="viewList">
영화관 이름


</div>

<script>

</script>
</body>
</html>