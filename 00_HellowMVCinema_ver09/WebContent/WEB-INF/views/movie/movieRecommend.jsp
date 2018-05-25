<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="background:#DADBD6;"><div class="wrap"><img src="/cinema/data/dokjun.jpg"  width=100%/></div></div>
<%@ include file="/WEB-INF/views/common/header_non_wrap.jsp" %>
<script src="<%=path %>/js/seat.js"></script>


<style>
	.hwrap{padding:0px 0px 20px 0px;}
	.hwrap > div{padding:20px 0px;}
	.hwrap > div h3{padding:10px 0px;}
	.hwrap > div h4{padding:10px 0px;}
	.hwrap > div h5{padding:10px 0px;}
	.hwrap > input{background:#1986ff; border:1px solid #1986ff; font-size:18px; padding:10px 20px; color:#fff; }
	.hwrap > input:hover{border:1px solid #1986ff; background:#fff; color:#1986ff;}
	.title_wrap{background:black; }
	.title_wrap div{height:300px; width:100%; overflow:hidden; background : url("/cinema/data/society_back.jpg") no-repeat no-repeat center center}
	table{width:auto; overflow:hidden;}
	table td{padding:0px; border:none;}
	table table td{padding:10px; border: 1px solid #ececec;}
	table table td img{width:280px;}
	select{padding:10px 15px; font-size:20px; margin:10px 0px; }
	input{margin:10px 0px;}
	#recommend-text{font-size:24px; font-weight:normal; padding:20px 0px;}
	#detail-recommend{margin-bottom:30px;}
</style>

<div class="title_wrap">
	<div></div>
</div>







<style>
#seat {
	width: 40px;
	height: 40px;
}

input:hover {
	background-color: lightgray;
}

#showRecommendMovie{

	width : 100%;
}

#multi-genre{
	width : 85%;
	line-height: 2;

}
</style>

<script>
	$(function() {
			
		function onKeyDown(){
		     if(event.keyCode == 13)  {
		          $(".enter-btn").click();
		     }
		}

		
		
		//장르 선택 영화 추천
		var genre="";
		$("#multi-genre").hide();
		$("#second-grade").hide();
		$("#thrid-director").hide();
		$("#forth-actor").hide();
		$("#fifth-random").hide();
		
		
		$("#null-text").hide();
		$("#recommend-text").hide();
		$("#showRecommendMovie").hide();
		
		$("#button-genre").click(function(){
			$("#detail-recommend").hide();
			$("#second-grade").hide();
			$("#thrid-director").hide();
			$("#forth-actor").hide();
			$("#fifth-random").hide();

			$("#multi-genre").show();
			
			$("#null-text").hide();
			$("#recommend-text").hide();
			$("#showRecommendMovie").hide();
			
			
		});
		$("#button-grade").click(function(){
			$("#detail-recommend").hide();
			$("#multi-genre").hide();
			$("#thrid-director").hide();
			$("#forth-actor").hide();
			$("#fifth-random").hide();
			
			$("#second-grade").show();
			
			$("#null-text").hide();
			$("#recommend-text").hide();
			$("#showRecommendMovie").hide();
			
		});
		$("#button-director").click(function(){
			$("#detail-recommend").hide();
			$("#multi-genre").hide();
			$("#second-grade").hide();
			$("#forth-actor").hide();
			$("#fifth-random").hide();
			
			$("#thrid-director").show();
			
			$("#null-text").hide();
			$("#recommend-text").hide();
			$("#showRecommendMovie").hide();
		});
		$("#button-actor").click(function(){
			$("#detail-recommend").hide();
			$("#multi-genre").hide();
			$("#thrid-director").hide();
			$("#second-grade").hide();
			$("#fifth-random").hide();
			
			$("#forth-actor").show();
			
			$("#null-text").hide();
			$("#recommend-text").hide();
			$("#showRecommendMovie").hide();
		});
		$("#button-random").click(function(){
			$("#detail-recommend").hide();
			$("#multi-genre").hide();
			$("#thrid-director").hide();
			$("#forth-actor").hide();
			$("#second-grade").hide();
			
			$("#fifth-random").show();
			
			$("#null-text").hide();
			$("#recommend-text").hide();
			$("#showRecommendMovie").hide();
		});
		$("#button-all").click(function(){
			$("#fifth-random").hide();
			$("#multi-genre").hide();
			$("#thrid-director").hide();
			$("#forth-actor").hide();
			$("#second-grade").hide();
			
			$("#detail-recommend").show();
			
			$("#null-text").hide();
			$("#recommend-text").hide();
			$("#showRecommendMovie").hide();
		});
		
		
		
		
		
		$(".btn-genre").click(function() {
			if ($(this).attr("status") != 1) {
				$(this).css({
					"background" : "darkgray",
					"color" : "lightgray"

				});
				
				genre += $(this).val()+"|";
				console.log( "버튼 눌렀을 때 장르 값" + genre);
				
				$(this).attr("status","1");
			} /* else {
				$(this).removeAttr("style");
				$(this).attr("status","");
			} */
		});
		
		$("#btn-remove-cho").click(function() {
			console.log("일단 들어노느 오지?");
			$(".btn-genre").removeAttr("style");
			$(".btn-genre").attr("status","");
			genre = "";
			console.log("다시선택 했을 때 장르 값" + genre);
			
		});

			
		
		 //장르 다중 선택 영화 추천 
		 //검색 눌렀을 때 아작스 돌아가도록 하기. 
		 $("#btn-search-rec").click(function(){
			console.log("검색버튼 눌렀을 때 장르값 =" + genre);
			 
			  $.ajax({
			        url : "<%=request.getContextPath()%>/movie/recommendGenre",
			              type: "post",
			              data: {genre:genre},
			              dataType:"json",
			              success: function(data){
			             	console.log(data);
			             	
			             	var text ="";
			             	var html ="";
			             	
			             	if(data==null){

			             		text += genre+" 장르의 영화를 찾을 수 없습니다.";
 					             		$("#null-text").html(text).show();
 					             		$("#recommend-text").hide();
 					           			$("#showReconnedMovie").hide();
 					             		
			             	}else{
			                   	
			             	
			                     
			                     text += "<h4> 선택하신 장르 <strong> |" + genre +"</strong>중에서" + "</h4>";
			                     text += "<h4> MVCinema가 추천하는 영화는" +data.name + "입니다! <h4>";
			                     
			                     html += "<tr><td><img src='<%=request.getContextPath()%>/upload/movie/"+ data.poster + "'/></td></tr>";
			                     html += "<tr><td>"+data.name+"</td></tr>";
			                     html += "<tr><td>"+data.ename+"</td></tr>";
			                     html += "<tr><td> 상영등급 :"+data.grade+"</td></tr>";
			                     html += "<tr><td> 러닝타임 : "+data.time+"</td></tr>";
			                     html += "<tr><td> 감독 : "+data.director+"</td></tr>";
			                     html += "<tr><td> 배우 : "+data.actor+"</td></tr>";
			                     html += "<tr><td> 장르 : "+data.genre+"</td></tr>";
			                     html += "<tr><td> 줄거리 : "+data.story+"</td></tr>";
			                     html += "<tr><td> 개봉일자 : "+data.relDate+"</td></tr>";
			                     html += "<tr><td> 스틸컷 : "+data.subimg+"</td></tr>";
			                     html += "<tr><td> 예고편 : "+data.trailer+"</td></tr>";

			                  
			                  html += "</table>"
			                  $("#showRecommendMovie").html(html).show();
			                  $("#recommend-text").html(text).show();
			                  $("#null-text").hide();
			             	
			             	}
			            

			              },
			              error:function(jqxhr,textStatus,errorThrown){
			                 console.log("ajax 처리실패!");
			                 console.log(jqxhr);
			                 console.log(textStatus);
			                 console.log(errorThrown);
			              }
			                  
			       }); // ajax end 
			 
		 }); 
		 
		 //감독 검색
		 //검색 눌렀을 때 아작스 돌아가도록 하기. 
		 $("#btn-director").click(function(){
			 
			 var director = $("#text-director").val();
			 
			console.log("검색버튼 눌렀을 때 장르값 =" + director);
			 
			  $.ajax({
			        url : "<%=request.getContextPath()%>/movie/director",
			              type: "post",
			              data: {director:director},
			              dataType:"json",
			              success: function(data){
			             	console.log(data);
			             	
			             	var text ="";
			             	var html ="";
			             	if(data==null){

			             		text += director+" 감독의 영화를 찾을 수 없습니다.";
 					             		$("#null-text").html(text).show(); 
 					             		$("#showRecommendMovie").hide();
 						                  $("#recommend-text").hide();
			             	}else{

			                     text += "<h4> 선택하신  <strong> |" + director +"</strong>감독의 영화 중에서" + "</h4>";
			                     text += "<h4> MVCinema가 추천하는 영화는" + data.name + "입니다! <h4>";
			                     
			                     html += "<tr><td><img src='<%=request.getContextPath()%>/upload/movie/"+ data.poster + "'/></td></tr>";
			                     html += "</table>"
			                     html += "<table>"
			                     html += "<tr><td>"+data.name+"</td></tr>";
			                     html += "<tr><td>"+data.ename+"</td></tr>";
			                     html += "<tr><td> 상영등급 :"+data.grade+"</td></tr>";
			                     html += "<tr><td> 러닝타임 : "+data.runtime+"</td></tr>";
			                     html += "<tr><td> 감독 : "+data.director+"</td></tr>";
			                     html += "<tr><td> 배우 : "+data.actor+"</td></tr>";
			                     html += "<tr><td> 장르 : "+data.genre+"</td></tr>";
			                     html += "<tr><td> 줄거리 : "+data.story+"</td></tr>";
			                     html += "<tr><td> 개봉일자 : "+data.relDate+"</td></tr>";
			                     html += "<tr><td> 스틸컷 : "+data.subimg+"</td></tr>";
			                     html += "<tr><td> 예고편 : "+data.trailer+"</td></tr>";
			                     html += "</table>"

			                  $("#showRecommendMovie").html(html).show();
			                  $("#recommend-text").html(text).show();
			             	
			             	}
			            

			              },
			              error:function(jqxhr,textStatus,errorThrown){
			                 console.log("ajax 처리실패!");
			                 console.log(jqxhr);
			                 console.log(textStatus);
			                 console.log(errorThrown);
			              }
			                  
			       }); // ajax end 
			 
		 }); 
		 
		//배우 검색
		 //검색 눌렀을 때 아작스 돌아가도록 하기. 
		 $("#btn-actor").click(function(){
			 
			 var actor = $("#text-actor").val();
			 
			console.log("검색버튼 눌렀을 때 장르값 =" + actor);
			 
			  $.ajax({
			        url : "<%=request.getContextPath()%>/movie/actor",
			              type: "post",
			              data: {actor:actor},
			              dataType:"json",
			              success: function(data){
			             	console.log(data);
			             	
			             	var text ="";
			             	var html ="";
			             
			             	if(data==null){
			             		text += actor+" 배우가 출연하는"+" 영화를 찾을 수 없습니다.";
			             		$("#null-text").html(text).show(); 
			             		$("#showRecommendMovie").hide();
				                  $("#recommend-text").hide();
			             	}else{
			                   	
			                     text += "<h4> 선택하신  <strong> " + actor +"</strong>배우의 영화 중에서" + "</h4>";
			                     text += "<h4> MVCinema가 추천하는 영화는" + data.name + "입니다! <h4>";
			                     
			                     html += "<tr><td><img src='<%=request.getContextPath()%>/upload/movie/"+ data.poster + "'/></td></tr>";
			                     html += "<tr><td>"+data.name+"</td></tr>";
			                     html += "<tr><td>"+data.ename+"</td></tr>";
			                     html += "<tr><td> 상영등급 :"+data.grade+"</td></tr>";
			                     html += "<tr><td> 러닝타임 : "+data.time+"</td></tr>";
			                     html += "<tr><td> 감독 : "+data.director+"</td></tr>";
			                     html += "<tr><td> 배우 : "+data.actor+"</td></tr>";
			                     html += "<tr><td> 장르 : "+data.genre+"</td></tr>";
			                     html += "<tr><td> 줄거리 : "+data.story+"</td></tr>";
			                     html += "<tr><td> 개봉일자 : "+data.relDate+"</td></tr>";
			                     html += "<tr><td> 스틸컷 : "+data.subimg+"</td></tr>";
			                     html += "<tr><td> 예고편 : "+data.trailer+"</td></tr>";


			                  html += "</table>"
			                  $("#showRecommendMovie").html(html).show();
			                  $("#recommend-text").html(text).show();
			             	
			             	}
			            

			              },
			              error:function(jqxhr,textStatus,errorThrown){
			                 console.log("ajax 처리실패!");
			                 console.log(jqxhr);
			                 console.log(textStatus);
			                 console.log(errorThrown);
			              }
			                  
			       }); // ajax end 
			 
		 }); 
		
		//랜덤 검색
		 //검색 눌렀을 때 아작스 돌아가도록 하기. 
		 $("#btn-random").click(function(){

			 
			  $.ajax({
			        url : "<%=request.getContextPath()%>/movie/random",
			              type: "post",
			              dataType:"json",
			              success: function(data){
			             	console.log(data);
			             	
			             	var text ="";
			             	var html ="";
		             			 html += "<table><tr><td>";		
			             		 html += "<table>";
			                     text += "<h4> 영화를 고르기 힘든 당신에게</h4>";
			                     text += "<h4> MVCinema가 추천하는 영화는" + data.name + "입니다! <h4>";
			                     html += "<tr><td><img src='<%=request.getContextPath()%>/upload/movie/"+ data.poster + "'/></td></tr>";
			                     html += "</table>";
			                     html += "</td>";
			                     
			                     
			                     html += "<td>";
			                     html += "<table>";
			                     html += "<tr><td>"+data.name+"</td></tr>";
			                     html += "<tr><td>"+data.ename+"</td></tr>";
			                     html += "<tr><td> 상영등급 :"+data.grade+"</td></tr>";
			                     html += "<tr><td> 러닝타임 : "+data.runtime+"</td></tr>";
			                     html += "<tr><td> 감독 : "+data.director+"</td></tr>";
			                     html += "<tr><td> 배우 : "+data.actor+"</td></tr>";
			                     html += "<tr><td> 장르 : "+data.genre+"</td></tr>";
			                     html += "<tr><td> 줄거리 : "+data.story+"</td></tr>";
			                     html += "<tr><td> 개봉일자 : "+data.relDate+"</td></tr>";
			                     html += "<tr><td> 예고편 : "+data.trailer+"</td></tr>";
			                     html += "</table>";
			                     html += "<td></td></tr>";
			                  
			                  html += "</table>";
			                  $("#showRecommendMovie").html(html).show();
			                  $("#recommend-text").html(text).show();
			             	
			             	
			            

			              },
			              error:function(jqxhr,textStatus,errorThrown){
			                 console.log("ajax 처리실패!");
			                 console.log(jqxhr);
			                 console.log(textStatus);
			                 console.log(errorThrown);
			              }
			                  
			       }); // ajax end 
			 
		 }); 
		 
		//상세 검색
		 //검색 눌렀을 때 아작스 돌아가도록 하기. 
		 $("#btn-detailRandom").click(function(){
			var detailGenre = $("#detail-genre option:selected").val();
			var datailGrade = $("#detail-grade option:selected").val();
			var detailDirector = $("#detail-director").val();
			var detailActor = $("#detail-actor").val();
			
			console.log(datailGrade);
			 
			  $.ajax({
			        url : "<%=request.getContextPath()%>/movie/detail",
			              type: "post",
			              data:{detailGenre:detailGenre, datailGrade:datailGrade, detailDirector:detailDirector, 
			            	  detailActor:detailActor},
			              dataType:"json",
			              success: function(data){
			             	console.log(data);
			             	var text ="";
			             	var html ="";
			             	
			             	if(data==null){
			             		text += detailGenre+ " 장르 , " +  $("#detail-grade option:selected").text()+"관람가, "+detailDirector+" 감독, "
			             		+detailActor+" 배우가 출연하는"+" 영화를 찾을 수 없습니다.";
			             		$("#null-text").html(text).show(); 
			             		$("#showRecommendMovie").hide();
				                  $("#recommend-text").hide(); 
			             	}else{
			             	
			             
			             		$("#null-text").hide();
			                     text += "<h4>" +detailGenre+ " 장르 , " +  $("#detail-grade option:selected").text()+"관람가, "+detailDirector+" 감독, "
				             		+detailActor+" 배우가 출연하는 영화 중 </h4>";
			                     text += "<h4> MVCinema가 추천하는 영화는" + data.name + "입니다! <h4>";
			                     
			                     html += "<tr><td><img src='<%=request.getContextPath()%>/upload/movie/"+ data.poster + "'/></td></tr>";
			                     html += "<tr><td>"+data.name+"("+data.ename+")</td></tr>";
			                     /* html += "<tr><td>"+data.ename+"</td></tr>"; */
			                     html += "<tr><td> 상영등급 :"+data.grade+"</td></tr>";
			                     html += "<tr><td> 러닝타임 : "+data.time+"</td></tr>";
			                     html += "<tr><td> 감독 : "+data.director+"</td></tr>";
			                     html += "<tr><td> 배우 : "+data.actor+"</td></tr>";
			                     html += "<tr><td> 장르 : "+data.genre+"</td></tr>";
			                     html += "<tr><td> 줄거리 : "+data.story+"</td></tr>";
			                     html += "<tr><td> 개봉일자 : "+data.relDate+"</td></tr>";
			                     html += "<tr><td> 스틸컷 : "+data.subimg+"</td></tr>";
			                     html += "<tr><td> 예고편 : "+data.trailer+"</td></tr>";

			                 
			                  html += "</table>"
			                  $("#showRecommendMovie").html(html).show();
			                  $("#recommend-text").html(text).show(); 

			              }
			              },
			              error:function(jqxhr,textStatus,errorThrown){
			                 console.log("ajax 처리실패!");
			                 console.log(jqxhr);
			                 console.log(textStatus);
			                 console.log(errorThrown);
			              }
			                  
			       }); // ajax end 
			 
		 }); 
		
		

	});
</script>

<div class="wrap hwrap">

<input type="button" value="상세 선택" id="button-all"/>
<input type="button" value="장르 선택" id="button-genre"/>
<input type="button" value="관람가 선택" id="button-grade"/>
<input type="button" value="감독 선택" id="button-director"/>
<input type="button" value="배우 선택" id="button-actor"/>
<input type="button" value="진짜 랜덤!" id="button-random" />



	

<div id="multi-genre">
	 <p>장르 다중 선택</p>
	<input type="button" value="드라마" class="btn-genre" />
	<input type="button" value="판타지" class="btn-genre" />
	<input type="button" value="서부" class="btn-genre" />
	<input type="button" value="공포" class="btn-genre" />
	<input type="button" value="로맨스" class="btn-genre" />
	<input type="button" value="모험" class="btn-genre" />
	<input type="button" value="스릴러" class="btn-genre" />
	<input type="button" value="느와르" class="btn-genre" />
	<input type="button" value="다큐멘터리" class="btn-genre" />
	<input type="button" value="코미디" class="btn-genre" />
	<input type="button" value="가족" class="btn-genre" />
	<input type="button" value="미스터리" class="btn-genre" />
	<input type="button" value="전쟁" class="btn-genre" />
	<input type="button" value="애니메이션" class="btn-genre" />
	<input type="button" value="범죄" class="btn-genre" />
	<input type="button" value="뮤지컬" class="btn-genre" />
	<input type="button" value="SF" class="btn-genre" />
	<input type="button" value="액션" class="btn-genre" />
	<input type="button" value="무협" class="btn-genre" />
	<input type="button" value="서스펜스" class="btn-genre" />
	<input type="button" value="공연실황" class="btn-genre" />
	<br /><br />
	<input type="button" value="다시 선택" id="btn-remove-cho"/>
	<input type="button" value="검색" id="btn-search-rec" onKeyDown="onKeyDown();" class="enter-btn"/>
</div>

<div id="second-grade">
	<h4>관람가 선택</h4>
	<select name="cho-grade" id="cho-grade">
		<option value="전체">전체관람가</option>
		<option value="12">12세 관람가</option>
		<option value="12|15|청불">12세 이상</option>
		<option value="15">15세 관람가</option>
		<option value="15|청불">15세 이상</option>
		<option value="청불">청소년 관람 불가</option>
	</select>
	
	<input type="button" value="검색" id="btn-grade" onKeyDown="onKeyDown();" class="enter-btn"/>
</div>

<div id="thrid-director">

	<h4>감독 선택</h4>
<input type="text" name="text-director" id="text-director" />
<input type="button" value="검색" id="btn-director" onKeyDown="onKeyDown();" class="enter-btn"/>

</div>

<div id="forth-actor">

	<h4>배우 선택</h4>
<input type="text" name="text-actor" id="text-actor" />
<input type="button" value="검색" id="btn-actor" onKeyDown="onKeyDown();" class="enter-btn"/>

</div>

<div id="fifth-random">
<h4>랜덤 선택</h4>

<input type="button" value="검색" id="btn-random" onKeyDown="onKeyDown();" class="enter-btn"/>

</div>



<div id="detail-recommend">
	<h3>상세 선택</h3>
	<h4>상세선택은 장르, 관람가, 감독, 배우 모두 선택해주시면 거기에 맞는 추천 영화를 알려드리겠습니다.</h4>
	장르선택
	<select name="detail-genre" id="detail-genre">
		<option >장르를 선택하세요</option>
		<option value="드라마">드라마</option>
		<option value="판타지">판타지</option>
		<option value="서부">서부</option>
		<option value="공포">공포</option>
		<option value="로맨스">로맨스</option>
		<option value="모험">모험</option>
		<option value="스릴러">스릴러</option>
		<option value="느와르">느와르</option>
		<option value="다큐멘터리">다큐멘터리</option>
		<option value="코디미">코미디</option>
		<option value="가족">가족</option>
		<option value="미스터리">미스터리</option>
		<option value="전쟁">전쟁</option>
		<option value="애니메이션">애니메이션</option>
		<option value="범죄">범죄</option>
		<option value="뮤지컬">뮤지컬</option>
		<option value="SF">SF</option>
		<option value="액션">액션</option>
		<option value="서스펜스">서스펜스</option>
		<option value="공연실황">공연실황</option>
	
	</select>
	
	<br />
	관람선택
	<select name="detail-grade" id="detail-grade">
		<option >관람가를 선택하세요.</option>
		<option value="전체">전체관람가</option>
		<option value="12">12세 관람가</option>
		<option value="12|15|청불">12세 이상</option>
		<option value="15">15세 관람가</option>
		<option value="15|청불">15세 이상</option>
		<option value="청불">청소년 관람 불가</option>
	</select>
	<br />
	감독 선택
	<input type="text" name="detail-director" id="detail-director" />
	<br />
	배우 선택
	<input type="text" name="detail-actor" id="detail-actor" />
	
	<br />
	<input type="button" value="검색" id="btn-detailRandom" onKeyDown="onKeyDown();" class="enter-btn"/>

</div>

	<div id="null-text"></div>
	<div id ="recommend-text"></div>
	<div id="showRecommendMovie"></div>
	
<script>
$(function(){
	
	
	$("#go-multi").click(function(){
		$("#multi-genre").show();
	});
	
	//관람가에 따른 영화 추천 
	
	$("#btn-grade").click(function(){
		var grade = $("#cho-grade option:selected").val();
		console.log(grade);
		$.ajax({
	        url : "<%=request.getContextPath()%>/movie/recommendGrade",
	              type: "post",
	              data: {grade:grade},
	              dataType:"json",
	              success: function(data){
	             	console.log(data);
	             	
	             	var text ="";
	             	var html ="";
	                               
	                     text += "<h4> 선택하신 관람가 <strong> " + $("#cho-grade option:selected").text() +"</strong>중에서" + "</h4>";
	                     text += "<h4> MVCinema가 추천하는 영화는" + data.name + "입니다! <h4>";
	                     
	                     html += "<tr><td><img src='<%=request.getContextPath()%>/upload/movie/"+ data.poster + "'/></td></tr>";
	                     html += "<tr><td>"+data.name+"</td></tr>";
	                     html += "<tr><td>"+data.ename+"</td></tr>";
	                     html += "<tr><td> 상영등급 :"+data.grade+"</td></tr>";
	                     html += "<tr><td> 러닝타임 : "+data.time+"</td></tr>";
	                     html += "<tr><td> 감독 : "+data.director+"</td></tr>";
	                     html += "<tr><td> 배우 : "+data.actor+"</td></tr>";
	                     html += "<tr><td> 장르 : "+data.genre+"</td></tr>";
	                     html += "<tr><td> 줄거리 : "+data.story+"</td></tr>";
	                     html += "<tr><td> 개봉일자 : "+data.relDate+"</td></tr>";
	                     html += "<tr><td> 스틸컷 : "+data.subimg+"</td></tr>";
	                     html += "<tr><td> 예고편 : "+data.trailer+"</td></tr>";


	                  
	                  html += "</table>"
	                  $("#showRecommendMovie").html(html).show();
	                  $("#recommend-text").html(text).show();


	              },
	              error:function(jqxhr,textStatus,errorThrown){
	                 console.log("ajax 처리실패!");
	                 console.log(jqxhr);
	                 console.log(textStatus);
	                 console.log(errorThrown);
	              }
	                  
	       }); // ajax end 
		
		
	});
	
	
	
	
	
	
	
});


</script>
	





<%@ include file="/WEB-INF/views/common/footer.jsp" %>