<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<script>


//영화 디테일 가져오기
$("#tet").click(function(){
	$.ajax({
		url : "/cinema/test.do",
		dataType:"json",
		type: "post",
		success:function(data){
	 		console.log(data);
		},error : function(jqxhr, textStatus, errorThrown){
		}, complete : function(){}
	});	
});


//영화 리플 가져오기



</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	