<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.cinema.*, com.cinema.board.model.vo.Board" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	Board b = (Board)request.getAttribute("selectBoard");
    	String arr[] = b.getTinfo().split("/");
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<style>
span#fname{
	position: absolute;
	left: 115px;
	top: 15px;
	width: 285px;
	background: white;
 }
</style>
</head>
<body>
	<%-- <input type="button" value="목록" onclick='fn_list()'/>
	<script>
		function fn_list(){
			location.href = "<%=request.getContextPath()%>/board/boardView";
		}
	</script>
	<form action="<%=request.getContextPath() %>/board/boardEnroll" method="post" enctype="multipart/form-data">
		<input type="hidden" name='type' value="updateNotice"  />
		<input type="hidden" name="bdid" value="<%=b.getBdid() %>" />
		<table>
			<tr><th>제목</th><td><input type="text" name="title" id="title" value="<%=b.getTitle() %>" /></td></tr>
			<tr><th>영화관정보</th><td><input type="text" name="local" id="local" value="<%=arr[0] %>" /><input type="text" name="theater" id="theater" value="<%=arr[1] %>" /></td></tr>
			<tr><th>첨부파일</th><td style="position:relative;">
			<%if(b.getImg()!=null){ %>
				 <img src="<%=request.getContextPath()+"/upload/board/file.png"%>" />
				 <input type="file" name="up-notice-file" id="up-notice-file" />
			<span id='fname'><%=b.getImg() %></span>	
				<input type="hidden" name="old_file" value="<%=b.getImg() %>" />
			<%} else {%>
				<input type="file" name="up-notice-file" id="up-notice-file" />		
			<%} %>
			</td></tr>
			<tr><th>내용</th><td><input type="text" name="content" id="content" value="<%=b.getContent() %>" /></td></tr>
			<tr><td> <input type="submit" value="수정" /> <input type="reset" value="취소" /> </td></tr>
		</table>
	</form> --%>
	<input type="button" value="목록" onclick='fn_list()'/>
	<script>
		function fn_list(){
			location.href = ${request.contextPath}+"/board/boardView";
		}
	</script>
	<form action="<%=request.getContextPath() %>/board/boardEnroll" method="post" enctype="multipart/form-data">
		<input type="hidden" name='type' value="updateNotice"  />
		<input type="hidden" name="bdid" value="${b.bdid }" />
		<table>
			<tr><th>제목</th><td><input type="text" name="title" id="title" value="${b.title }" /></td></tr>
			<tr><th>영화관정보</th><td><input type="text" name="local" id="local" value="${arr[0]}" /><input type="text" name="theater" id="theater" value="<%=arr[1] %>" /></td></tr>
			<tr><th>첨부파일</th><td style="position:relative;">
			
			<c:if test="${empty b.img }">
				 <img src="<%=request.getContextPath()+"/upload/board/file.png"%>" />
				 <input type="file" name="up-notice-file" id="up-notice-file" />
				<span id='fname'>${b.img }</span>	
				<input type="hidden" name="old_file" value="${b.img }" />
				
			</c:if>
			<c:if test="${!empty b.img }">
				<input type="file" name="up-notice-file" id="up-notice-file" />		
			</c:if>
			</td></tr>
			<tr><th>내용</th><td><input type="text" name="content" id="content" value="${b.content }" /></td></tr>
			<tr><td> <input type="submit" value="수정" /> <input type="reset" value="취소" /> </td></tr>
		</table>
	</form>

</body>
</html>