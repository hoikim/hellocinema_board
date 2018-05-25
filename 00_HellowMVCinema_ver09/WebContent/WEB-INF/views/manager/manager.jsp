<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>

<% 
	//List<Movie> mlist = (List<Movie>)request.getAttribute("mlist"); 
	//String pageBar = (String)request.getAttribute("pageBar");
%>

<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
 



<script>

$(function(){
	$.ajax({
		url : "/cinema/manager/theater",
		data : {type : "selectTheater"},
		dataType : "json",
		type : "post",
		success : function(data){
			console.log(data);
		}
		
	});
});

</script>



<input type="hidden" name="" id="" /> <br />
 


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

<form action="<%=request.getContextPath() %>/manager/managerReg" method="POST">

<table class="common_style_table" id="room_table">
		<tr>
			<th>영화관선택</th>
			<td><select name="tcode" id="tid_selector"></select></td>
			<td class="who"></td>
			<td></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id"/>	 </td>
			<th>비밀번호</th>
			<td><input type="password" name="pw"/>  </td>
		</tr>
		<tr>
			<th>담당자 이름</th>
			<td><input type="text" name="name"/></td>
			<th>사진</th>
			<td><input type="file" name="tcode"/></td>
		</tr>
		<tr>
		<td colspan=4 style="text-align:center;"><button type="submit">등록</button></td>
		</tr>
</table>
</form>

<script>
function fn_showList(){
	$.ajax({
		url : "<%=theater %>",
		dataType:"json",
		type: "post",
		data : { type : "showAllTheater"},
		success:function(data){
	 		console.log(data);
	 		html = "";
	 		
	 		for(i in data){
	 			html += "<option value="+data[i].tid+">"+data[i].name+"</option>";
	 		}
	 		
	 		
	 		
	 		$("#tid_selector").html(html);
	 		
		}

	});
}





function chk_exist_theaterManger(tid){
	$.ajax({
		url : "<%=manager %>",
		dataType:"json",
		type: "post",
		data : { type : "selectTheater", theaterNo : tid},
		success:function(data){
	 		console.log(data);
	 		console.log(data.id);
			if(data.id == undefined){	 
	 			$(".who").html("");
			}else{
	 			$(".who").html(data.id)
			}
		}

	});
}



$("#tid_selector").change(function(){
	chk_exist_theaterManger($(this).val());
});




$(function(){
	fn_showList();
	
	
});

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	