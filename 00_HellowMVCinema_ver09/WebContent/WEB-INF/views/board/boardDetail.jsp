<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.cinema.*, com.cinema.board.model.vo.Board" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    	Board b = (Board)request.getAttribute("selectBoard");
    	Board bb = (Board)request.getAttribute("selectBoardBefore");
    	Board ba = (Board)request.getAttribute("selectBoardAfter");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<style>
	table, tr, th, td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/board/boardDetail?bdid=${b.bdid}" method='post'>
		<input type="hidden" name="uPage" value='update'/>
		<input type="submit" value="수정" onclick='fn_updateNotice()' />
	</form>
	<input type="button" value="목록" onclick='fn_list()'/>
	<script>
		function fn_list(){
			location.href = "<%=request.getContextPath()%>/board/boardView";
		}
	</script>
	
	<table>
		<tr>
			<th colspan='1'>제목</th>
			<td colspan='3'>${b.title}</td>
		</tr>
		<tr>
			<th>영화관</th>
			<td>${b.tinfo}</td>
			<th>등록일</th>
			<td>${b.regdate}</td>
		</tr>
		<tr>
			<th colspan='1'>첨부파일</th>
			<td colspan='3'>
				${b.img}
			</td>
		</tr>
		<tr>
			<th colspan='1'>내용</th>
			<td colspan='3'>${b.content}</td>
		</tr>
	</table>
	<c:if test="${empty bb.title }">
		<p>이전글 : 이전글이 없습니다.</p>
	</c:if>
	<c:if test="${!empty bb.tilte }">
		<p onclick="fn_next('${bb.bdid}')">이전글 : ${bb.title}</p>	
	</c:if>
	<c:if test="${empty ba.title }">
		<p>다음글 : 다음글이 없습니다.</p>
	</c:if>
	<c:if test="${!empty ba.tilte }">
		<p onclick="fn_next('${bb.bdid}')">다음글 : ${bb.title}</p>
	</c:if>
	<script>
		function fn_next(bdid){
			location.href = "<%=request.getContextPath()%>/board/boardDetail?bdid="+ bdid;
		}
	</script>
<%-- 	<form action="<%=request.getContextPath()%>/board/boardDetail?bdid=<%=b.getBdid() %>" method='post'>
		<input type="hidden" name="uPage" value='update'/>
		<input type="submit" value="수정" onclick='fn_updateNotice()' />
	</form>
	<input type="button" value="목록" onclick='fn_list()'/>
	<script>
		function fn_list(){
			location.href = "<%=request.getContextPath()%>/board/boardView";
		}
	</script>
	
	<table>
		<tr>
			<th colspan='1'>제목</th>
			<td colspan='3'><%=b.getTitle() %></td>
		</tr>
		<tr>
			<th>영화관</th>
			<td><%=b.getTinfo() %></td>
			<th>등록일</th>
			<td><%=b.getRegdate() %></td>
		</tr>
		<tr>
			<th colspan='1'>첨부파일</th>
			<td colspan='3'>
				<%=b.getImg() %>
			</td>
		</tr>
		<tr>
			<th colspan='1'>내용</th>
			<td colspan='3'><%=b.getContent() %></td>
		</tr>
	</table>
	<%if(bb.getTitle()==null){ %>
		<p>이전글 : 이전글이 없습니다.</p>
	<%}else{%>
		<p onclick="fn_next('<%=bb.getBdid()%>')">이전글 : <%=bb.getTitle() %></p>
	<%} %>
	<%if(ba.getTitle()==null){ %>
		<p>다음글 : 다음글이 없습니다.</p>
	<%}else{%>
		<p onclick="fn_next('<%=ba.getBdid()%>')">다음글 : <%=ba.getTitle() %></p>
	<%} %>
	<script>
		function fn_next(bdid){
			location.href = "<%=request.getContextPath()%>/board/boardDetail?bdid="+ bdid;
		}
	</script> --%>
	
	

</body>
</html>