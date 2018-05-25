<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/cinema/js/jquery-3.3.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>

</head>

<body>

	<input type="Date" />
	<input type="text" name="time" class="time" value="2018-05-09 07:30"/>
	
	<button class="btn">전송</button>
<script>



$(".btn").click(function(){
var time = $(".time").val();
time2 = new Date(time);
time2 = Date.parse(time);
console.log(time2);

	$.ajax({
	url:"/cinema/testdo",
	type:"post",
	data:{ time : time, time2 : time2},
	dataType:"json",
	success:function(data){
		console.log(data);
	}
});
});

</script>



</body>
</html>