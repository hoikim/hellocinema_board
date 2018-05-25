<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ page import="com.cinema.board.model.vo.Board,java.util.List, com.cinema.admin.model.vo.Local" %>
    <%
    	Board b = (Board)request.getAttribute("selectBoard");
	    List<Local> localList = (List<Local>)request.getAttribute("localList");
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
span#fname{
	position: absolute;
	left: 115px;
	top: 15px;
	width: 285px;
	background: white;
 }
</style>
	<input type="button" value="목록" onclick='fn_list()'/>
	<script>
		function fn_list(){
			location.href = "<%=request.getContextPath()%>/board/boardView";
		}
	</script>
	<form action="<%=request.getContextPath() %>/board/boardEnroll" method="post" enctype="multipart/form-data">
		<input type="hidden" name='type' value="updateNotice"  />
		<input type="hidden" name="bdid" value="<%=b.getBdid() %>" />
		<table>
			<tr><th>제목</th><td colspan='2'><input type="text" name="title" id="title" value="<%=b.getTitle() %>" /></td></tr>
			<tr>
				<th>영화관 지역 정보</th>
				<td>
					<select id="local1">
						<option value="전체">전체</option>
						<%for(Local l : localList){ %>
						<option value="<%=l.getLid()%>"><%=l.getLname()%></option>
						<%} %>
					</select>	
					<p id='theater-p'></p>	
				</td>
				<td id='theater-td'></td>
			</tr>
			<tr><th>첨부파일</th><td colspan='2' style="position:relative;">
			<%if(b.getImg()!=null){ %>
				 <img src="<%=request.getContextPath()+"/upload/board/file.png"%>" />
				 <input type="file" name="up-notice-file" id="up-notice-file" />
<%-- 			<span id='fname'><%=b.getImg() %></span> --%>	
				<input type="hidden" name="old_file" value="<%=b.getImg() %>" />
			<%} else {%>
				<input type="file" name="up-notice-file" id="up-notice-file" />		
			<%} %>
			</td></tr>
			<tr><th>내용</th><td colspan='2'><input type="text" name="content" id="content" value="<%=b.getContent() %>" /></td></tr>
			<tr><td colspan='3'> <input type="submit" value="수정" /> <input type="reset" value="취소" /> </td></tr>
		</table>
	</form>
	
	<!-- 영화관 지역에 따른 지점 정보 출력 -->
	<script>
			$(function(){
				//select 값이 변경되면 ajax를 통해 그 지역에 해당하는 영화관을 보여준다.
				$("#local1").change(function(){
					var lName = "";
					var localId = $(this).val();
					if(localId!="전체"){
						$.ajax({
							url: "<%=request.getContextPath()%>/board/boardAjax2.do",
							data: {lid: localId},
							type: "post",
							dataType: "json",
							success: function(data){
								console.log(data);	
							
								var html ="";
								<%for(Local l : localList){ %>
									if("<%=l.getLid()%>"==localId){
										lName = "<%=l.getLname()%>";
									}
								<%} %>
									html += "<select name='theater' id='theater' style='inline' >";
									html += "<option value=''>지점</option>";
								for(var index in data){
									var i = data[index];
									html += "<option value='"+i.name+"'>";
									html += i.name;
									html += "</option>";						
								}
								html += "</select>";
								html += "<input type='hidden' name='local' value='"+lName+"'/>";
								
								$("#theater-p").html(html);
								
							}, error: function(){
								console.log("ajax 처리 실패");
							}
						}); //ajax
					}else{
						$("#theater-p").html("<input type='hidden' name='local' value='전체' />");
					}
					});	//#local1 change
						
			}); //function
		</script>
	
	
	
	
	
</html>















