<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>

<% 
	//List<Movie> mlist = (List<Movie>)request.getAttribute("mlist"); 
	//String pageBar = (String)request.getAttribute("pageBar");

%>

<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
 

<style>
#price_table input{width:105px;}
#price_table tr:first-child {
background:#ececec;
	
}
#price_table button{width:100%;}
</style>
<table id="price_table">
	<tr>
		<th>정책</th>
		<td><input type="text" name="name"  placeholder="성인" /></td>
		<th>가격</th>
		<td><input type="text" name="price"   placeholder="가격" /></td>
		<th>종류</th>
		<td><input type="text" name="kind"  placeholder="가격종류"/> </td>
		<th>기타</th>
		<td><input type="text" name="etc"  placeholder="뭘 넣을까" /></td>
		<td><button onclick="fn_insert()">삽입</button></td>
	</tr>


</table>






<script>

function fn_insert(){
	$name = $("[name=name]").val();
	$price = $("[name=price]").val();
	$kind = $("[name=kind]").val();
	$etc = $("[name=etc]").val();
	
	$.ajax({
		url : "<%=price %>", 
		data : {name : $name, price : $price, kind : $kind, etc : $etc},
		type : "post", 
		dataType : "html",
		success : function(data){
			console.log(data);
		},
		error :function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
		},
		complete: function(){
			console.log("ajax 어찌됬던 종료!");
		}
	});
}


function fn_getPrice(){
	$.ajax({
		url : "<%=price %>", 
		data : {type : "getPrice"},
		type : "post", 
		dataType : "json",
		success : function(data){
			var pt = $("#price_table");
			var html = "";
console.log(data);

			
			for(i in data){
				html += "<tr>";
				html += "<th>이름</th>";
				html += "<td><input type='text' value='"+data[i].name+"'></td>"; 
				html += "<th>가격</th>";
				html += "<td><input type='text' value='"+data[i].price+"'></td>"; 
				html += "<th>종류</th>";
				html += "<td><input type='text' value='"+data[i].kind+"'></td>"; 
				html += "<th>기타</th>";
				html += "<td><input type='text' value='"+data[i].etc+"'></td>"; 
				html += "<td><button onclick='fn_insert("+data[i].pid+")'>수정</button></td>"; 
				html += "</tr>";
				
			}
			
			pt.append(html);
			
		}
	});
}
$(function(){
	
	fn_getPrice();
	
});
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	