<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ page import="com.cinema.board.model.vo.Board" %>
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
    
<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>

<style>
	table, tr, th, td{
		border: 1px solid black;
	}
</style>
	<form action="<%=request.getContextPath()%>/board/boardDetail?bdid=<%=b.getBdid() %>" method='post'>
		<input type="hidden" name="uPage" value='update'/>
		<input type="submit" value="수정" />
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
			<td colspan='3'><%=(b.getTitle()==null?"제목없음":b.getTitle() )%></td>
		</tr>
		<tr>
			<th>영화관</th>
			<td><%=arr[0]%>
			<%if(!"null".equals(arr[1])) {%>
			<%if(arr[1]!=null) {%>			
			/<%=arr[1]%>
			<%} %>
			<%} %>
			</td>
			<th>등록일</th>
			<td><%=b.getRegdate() %></td>
		</tr>
		<tr>
			<th colspan='1'>첨부파일</th>
			<td colspan='3'>
				<%if(b.getImg()==null){ %>
					등록된 첨부 파일이 없습니다.
				<%} else{%>
					<%=b.getImg() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<th colspan='1'>내용</th>
			<td colspan='3'>
				<%=b.getContent() %>
				<%if(b.getImg()!=null){ %>
					<img src="<%=request.getContextPath() %>/upload/board/<%=b.getImg() %>" alt="attachFile" style="max-width: 500px;"/>
				<%} %>
			</td>
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
	
