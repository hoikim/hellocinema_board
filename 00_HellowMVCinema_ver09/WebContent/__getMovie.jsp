<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<title> </title>

</head>

<body>

<input type="text" id="searchMovie"/>
<div id="test">
	
</div>

<button id="btn">테스트</button>


</body>

<form action="<%=request.getContextPath() %>/insertmovie.do" id="form_data" method="post" >
<input type="text" name="data" id="data" />
</form>

<script>

$("#btn").click(function(){
	var content = $("#test");
	var keyword =$("#searchMovie").val().trim();
	var movie = null;
	$.ajax({
		url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=430156241533f1d058c603178cc3ca0e&curPage=10&itemPerPage=200&movieNm="+keyword,
		//url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=430156241533f1d058c603178cc3ca0e&movieCd=20177478",
		dataType:"json",
		success:function(data){
			console.log(data);
			var mList = data.movieListResult.movieList;
//			var mList = data.movieInfoResult.movieInfo;
			movie = data; 
			var addContent = "";
			for(i in mList){
				console.log(mList[i]);
				addContent += mList[i].movieNm;
				addContent += mList[i].movieNmEn + "<br > ";
							
			}
			
			content.html(addContent);
			
			
			
		}, 	error : function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
			}, complete : function(){
				var mList = movie.movieListResult.movieList;
				//var mList = movie.movieInfoResult.movieInfo;
				$("#data").val(JSON.stringify(mList));
				$("#form_data").submit();
				for(i in mList){
					console.log(mList[i].movieNm);
				}
				
				
				
		}
	
	}); //아작스
});
</script>
</html>