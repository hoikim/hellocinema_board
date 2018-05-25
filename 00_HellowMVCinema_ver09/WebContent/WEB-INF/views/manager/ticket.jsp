<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>

<% 
	List<Map<String, String>> mlist = (List<Map<String, String>>)request.getAttribute("tlist"); 
	String g = (String)request.getAttribute("glist");
	System.out.println(g);
	
%>
<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
 


<style>
.ticketList table tr:last-child{border-bottom:1px solid #1986ff;}
.ticketList table{text-align:center;  margin-top:10px; border-top:2px solid #1986ff;}
.ticketList table th{padding:15px 10px; background:#f9f9f9; font-weight:bold; border:none; border-bottom:1px solid #e0e0e0;}
.ticketList table td{padding:15px; border:none; border-bottom:1px solid #e0e0e0; }
#pageBar{text-align:center; margin-top:10px;z}
#pageBar span{ cursor:pointer; display:inline-block; padding:10px; border:1px solid #ececec; width:50px; margin-left:10px; }
</style>


<div>
</div>
<h3 style="margin-top:20px;">예매리스트</h2>
<div class="ticketList">
	<table>
	<tr>
		<th>NO</th>
		<th>예매번호</th>
		<th>영화포스터</th>
		<th>영화명</th>
		<th>영화관</th>
		<th>상영관</th>
		<th>상영일시</th>
		<th>예매일</th>
	</tr>

	<% int i=0;  for(Map <String, String> m : mlist){ %>
		<tr onclick='fn_showTicketDetail("<%=i %>")'>
		<td><%=m.get("BID") %></td>
		<td>T9049-005-11<%=m.get("BID") %></td>
		<td><img src="/cinema/upload/movie/<%=m.get("POSTER") %>" alt="" width="70"/></td>
		<td><%=m.get("MNAME") %></td>
		<td><%=m.get("TNAME") %></td>
		<td><%=m.get("RNAME") %></td>
		<td><%=m.get("STIME") %></td>
		<td><%=m.get("REGDATE") %></td>
		</tr>
	<% i++; } %>

	</table>
		<div id="pageBar"><%=request.getAttribute("pageBar") %></div>
</div>
<script>
$(function(){
	obj = <%= g %>;
	
});

function fn_showTicketDetail(value){
console.log(obj[value]);
}





<%@ include file="/WEB-INF/views/common/footer.jsp" %>	