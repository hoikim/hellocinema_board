<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
    <%@ page import="com.cinema.board.model.vo.Board" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    	Board b = (Board)request.getAttribute("selectBoard");
    	Board bb = (Board)request.getAttribute("selectBoardBefore");
    	Board ba = (Board)request.getAttribute("selectBoardAfter");
    	String arr[]= new String[2] ;
    	if(b.getTinfo()==null){
    		arr[0]="전체";
    	} else{
    		if(b.getTinfo().contains("/")){
		    	arr = b.getTinfo().split("/");
    		}else{
    			arr[0] = b.getTinfo();
    		}
    	}
    %>
    
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<style>
	table, tr, th, td{
		border: 1px solid black;
	}
</style>
	<input type="button" value="목록" onclick='fn_list()'/>
	<script>
		function fn_list(){
			location.href = "<%=request.getContextPath()%>/board/boardView";
		}
	</script>
	
	<table>
		<tr>
			<th colspan='1'>제목</th>
			<td colspan='3'>
				<c:if test="${empty b.title ? '제목없음' : b.title }"></c:if>
			</td>
		</tr>
		<tr>
			<th>영화관</th>
			<td>${arr[0]}
			<c:if test="${!empty b.title }">
				<c:if test="${'null'!=arr[1]}">/${arr[1] }</c:if>
			</c:if>
			
			</td>
			<th>등록일</th>
			<td>${b.regdate}</td>
		</tr>
		<tr>
			<th colspan='1'>첨부파일</th>
			<td colspan='3'>
				<c:if test="${empty b.img}">
					등록된 첨부 파일이 없습니다.
				</c:if>
				<c:if test="${!empty b.img}">
					${b.img }
				</c:if>
			</td>
		</tr>
		<tr>
			<th colspan='1'>내용</th>
			<td colspan='3'>
				${b.content }
				<c:if test="${!empty b.img }">
					<img src="<%=request.getContextPath() %>/upload/board/${b.img}" alt="attachFile" style="max-width: 500px;"/>
				</c:if>
			</td>
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
	
	<br />
	<br />
	<br />
	<br />
	<br />
	<script>
		function fn_next(bdid){
			location.href = "<%=request.getContextPath()%>/board/boardDetail?bdid="+ bdid;
		}
	</script>
	
