<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div style="background:#0C1325;"><div class="wrap"><img src="/cinema/data/topAD.jpg" /></div></div>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
#slider{position:relative;background:#333;}
.thumb img{ width:100%;}

</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<%=path %>/js/seat.js"></script>
<style>
#draggable { position:absolute; right:50px; top: 100px; width: 230px;  z-index:5; background:#fff;}
#draggable .close_pop{ cursor:pointer; position:absolute; right:0px; top:10px; width:50px; height:50px; }

#draggable .close_pop:after{content:""; position:absolute; border-top:1px solid #fff; width:50px; transform : rotate(45deg); transform-origin: 0% 0%; top:0px; left:0px; }
#draggable .close_pop:before{content:""; position:absolute; border-top:1px solid #fff; width:50px; transform : rotate(-45deg); transform-origin: 0% 0%; bottom:13px; left:0px; }

</style>


</head>
<body>
 
<div id="draggable" class="">
<img src="/cinema/data/popevent.jpg" width=100% onclick="location.href='/cinema/userTheater'"/>
<div class="close_pop"></div>
</div>

  <script>
  $( function() {
    $( "#draggable" ).draggable();
  } );
  
  $("#draggable").on("click", ".close_pop", function(){
	  console.log("test");
	  $( "#draggable" ).hide();
  });
  
  </script>
<section id="slider">

	<div id="slider">
	  <ul>
	    <li><img src="/cinema/data/01.jpg" /></li>
	    <li><img src="/cinema/data/02.jpg" /></li>
	    <li><img src="/cinema/data/03.jpg" /></li>
	    <li><img src="/cinema/data/04.jpg" /></li>
	  </ul>  
	</div>


</section>





<div>
	<ul class="movie_list">
	</ul>
</div>
<style>

.view_info_wrap{
overflow:hidden;
}

.view_info_wrap > div{
float:left;
}
.view_info_wrap .grade{}
.view_info{margin-left:30px; width:65%;}
.title{font-size:28px; padding-bottom:5px;}
.etitle{padding-bottom:10px; border-bottom: 1px solid #ccc; width:100%; color:#999; font-size:13px; letter-spacing:1px;}
.view_detail_info{padding:20px 0px; line-height: 160%; border-bottom: 1px solid #ececec; font-size:14px;position:relative;}
.view_detail_info .vtitle{font-weight:bold; display:inline-block; width: 80px; }
.res_btn{position:absolute; right:0px; top: 10px; background:#1986ff; font-size:18px; color:#fff; padding:20px 30px; }
.story{clear:both;}
.movie_list .name .grade{font-size:12px; font-weight:normal;}
.grade{padding:2px 4px;   border-radius:10px; color:white}
.gradeall{background:#2D9E48}
.grade12{background:#1993D2;}
.grade15{background:#eba621;}
.grade18{background:#CD2027;}
.grade19{background:red;}
.movie_list .name{margin:5px 0px;}
#theater_map{width:64%; height:450px;}

</style>

<script>

var movies = [];
var locals = [];
var theaters = [];

function fn_checkId(){
	<% if(userSession == null) {%>
		console.log("test");
		return "null";
	<% }else { %>
		console.log("<%= userSession.getId() %>");
		console.log("로그인했습니다.");
		return "<%= userSession.getUsid() %>";
	<% } %>
}

$(function(){
	fn_checkId();
});


function fn_showMovieList(){
	$.ajax({
		url : "/cinema/movie.do",
		dataType:"json",
		type: "post",
		success:function(data){
		console.log(data);
		var mitem = "";
		
		for(i in data){
			dataItem = JSON.stringify(data[i]);
			mitem += "<li class='movie_item'>";
			mitem += "<div class='thumb'><img src='/cinema/upload/movie/"+data[i].poster+"' /></div>";
			mitem += "<div class='movie_infor'>";
			mitem += "<div class='name'><span class='grade grade"+data[i].grade+"'>"+data[i].grade+"</span> <span>"+data[i].name+"</span></div>";
			mitem += "<div class='movie_btn'>";
			mitem += "<button onclick='fn_showMovieDetail("+data[i].mid+", "+dataItem+");'>상세보기</button>"
			mitem += "<button onclick='fn_showReservationDetail("+data[i].mid+", "+dataItem+");'>예매하기</button>"
			mitem += "</div>"
			mitem += "</div>"		
			mitem += "</li>";
		}
		$(".movie_list").html(mitem);
		
		$(".movie_infor span").each(function(){
			if($(this).text().length > 9){
				$(this).text($(this).text().substr(0,9)+"...");
			}
		});
		}
	});	// ajax end 
};

fn_showMovieList();

function fn_showMovieDetail(mid){
	
	document.body.style.overflow = 'hidden';
	$(".movie_show_detail").show();	
	
	$.ajax({
		url : "/cinema/movie/movieDetail",
		dataType:"json",
		type : "post",
		data : {mid : mid}, 
		success:function(data){

			var mitem = "<div class='view_detail'>";
						
			mitem += "<div class='view_info_wrap'>";
			mitem += "<div class='view_thumbnail'><img src=/cinema/upload/movie/"+data.poster+ " /></div>";
			mitem += "<div class='view_info'>";
			
			mitem += "<div class='title'><span class='grade'>청불 </span><span>"+data.name+"</span></div>"
			mitem += "<div class='etitle'><span>"+data.ename+" </span>"+data.reldate+"<span></span></div>"
			mitem += "<div class='view_detail_info'>";
			mitem += "<div class='reldate'><span class='vtitle'>개봉일</span><span>"+data.reldate+"</span></div>"
			mitem += "<div class='director'><span class='vtitle'>감독</span><span>"+data.director+"</span></div>"
			mitem += "<div class='director'><span class='vtitle'>출연진</span><span>"+data.actor+"</span></div>"
			mitem += "<div class='director'><span class='vtitle'>장르</span><span>"+data.genre+"</span></div>"
			mitem += "<button class='res_btn'>예매하기</button>";
			
			
			
			mitem += "</div>";
			mitem += "</div>"
			
			
			mitem += "<div class='story'>";
			mitem += "test";
			mitem += "</div>"
			mitem += "<div class='story'>";
			mitem += "스틸컷";
			mitem += "</div>"
				/*--------------여기서부터 바뀌었습니다 ----------------------------------------------------------*/
				/* mitem += "<div class='review-wrap'>";
				mitem += "한줄평";
				mitem += "</div>"  */

				mitem += "</div>";
				$(".view_detail_container").html(mitem);
				//컨테이너를 따로 또 만들어서 거기다 붙힘. (footer.jsp)
				
				
				showReviewlist(mid); //리뷰리스트 불러오는 함수 호출
			}
		});
		
		
		
	}
	/* 리뷰 관련 함수 ------------------------------------------------- */
	/* 영화 상세보기 페이지 로딩시 영화에 대한 리뷰들을 가져옴 함수*/
	 

	var movieMid=0; //리뷰를 불러올 영화 아이디 고정. 전역변수
	function showReviewlist(mid){
		<%if(userSession!=null){%> //유저가 로그인했다면 리뷰창쪽에 이름을 써준다.
			$("span#userName").text('<%=userSession.getName()%>');
		<%}%>
		movieMid =mid;
		

		 $.ajax({
			url:"/cinema/review/reviewlist",
			data:{mid:movieMid},
			dataType:"json",
			success:function(data){
				var html ="<ul>";
				if("null"==data[0]){ //댓글이 없다. 
					console.log("댓글이없어");
					html +="<li>댓글이 없습니다.</li>";
					html +="</ul>";
					$("div#pageBar").html(""); //페이지바 비우기
					
				}else{ //댓글 있다. 
					console.log("리스트 가져오기 성공"+data);
					/* html = "<ul>"; */
					for(var i in data){
						var review = data[i];
						
						
						var starGrader = "";
						 for(var k=1; k<=5; k++ ){
							if(k <= review.grade){
							 starGrader += "<span class='fa fa-star khchecked'></span>";
							}else{
								starGrader += "<span class='fa fa-star fz'></span>";
							}
						 }
						
						
						
						
						html += "<li><div class='reviewr_img'><img src=/cinema/data/profile_m.png width=50/></div> <div class='viewReview'><div class='id'>"+review.id+"</div><span class='regdate'>"+review.regdate+"</span> <span class='star'>"+starGrader+"</span>\r\n<span class='content'>"+review.content+"</span>";
						<%if(userSession!=null){%>
						
							if(review.usid==<%=userSession.getUsid()%>){
								$("input[name=isWritten]").val("true"); //리뷰가 이미 등록해있음을 체크 
								html +="<div class='btn_reviewer'><button type='button' class='btn-update'>수정</button><button type='button' class='btn-delete'>삭제</button></div>";
								
							}
						<% }%>

						<%if(userSession!=null){%>
							if(review.usid==<%=userSession.getUsid()%>){
								html +="<div class='edit-hide'><div class='id'>"+review.id+"</div><input type='number' name='star' min='1' max='5' value='"+review.grade+"'>";
								html +="<textarea class='review-update'>"+review.content+"</textarea><button type='button' class='updateend'>완료</button><button type='button' class='cancel'>취소</button><input type='hidden' name='userid' value='"+review.usid+"'><input type='hidden' name='rvid' value='"+review.rvid+"'></div>";
								
							}
						
						<%} else{%> //유저가 로그인을 안한 경우
							$("textarea#review-content").val("로그인후 이용가능 합니다");
						<%}%>
						html +="</div>";
						html +="</li>";
					}//for in문 end
					$("div#pageBar").html(data[0].pageBar);
					
				}//else end
				
				$("div.movieReviewList").html(html);
				$("div.review-container").detach().appendTo($("div.review-wrap")); //상세보기 페이지 안에 붙이기
				
				
			},error:function(){
				console.log("처리 실패");
			}
		}); 
		
		
		
		
		
	}
	// 영화 상세보기 페이지 로딩시 영화에 대한 리뷰들을 가져옴 함수 End
	 
	 

	$(function(){
		
		/*리뷰 등록 버튼 클릭 이벤트 */
		$("div.btn-enroll button").click(function(e){
			console.log("리뷰 등록 버튼 클릭");
			//이미 등록한 리뷰가 있는지 확인.	
			if($("input[name=isWritten]").val()=="true"){
				
				alert("이미 리뷰를 등록하셨습니다.");
				return;
			}
			<% if(userSession!=null){%> //유저가 로그인 하고 리뷰 등록을 한 경우
			
				var review = {userid:<%=userSession.getUsid()%>,mid:movieMid,content:$("textarea#review-content").val(),starScore:$("input[name=starScore]").val()};
				console.log(review);
				$.ajax({
					url:"/cinema/review/reviewEnroll.do",
					dataType:"json",
					data:review,
					success:function(data){
						
						$("input[name=isWritten]").val("true"); //리뷰 이미 등록 여부 체크. 리뷰가 이미 등록해있음을 체크 
						var html = "<ul>";
						for(var i in data){
							
							var review = data[i];
							html += "<li><div class='viewReview'><div class='id'>"+review.id+"</div><span class='regdate'>"+review.regdate+"</span>&nbsp;<span class='star'>"+review.grade+"점</span>\r\n<span class='content'>"+review.content+"</span>";
							<%if(userSession!=null){%>
							
								if(review.usid==<%=userSession.getUsid()%>){
									$("input[name=isWritten]").val("true"); //리뷰가 이미 등록해있음을 체크 
									console.log($("input[name=isWritten]").val()+"자기가 쓴글 보기 ");
									html +="<button type='button' class='btn-update'>수정</button><button type='button' class='btn-delete'>삭제</button>";
									
								}
							<% }%>
							html +="</div>";
							html +="</li>";
							<%if(userSession!=null){%>
								if(review.usid==<%=userSession.getUsid()%>){
									html +="<div class='edit-hide'><div class='id'>"+review.id+"</div><input type='number' name='star' min='1' max='5' value='"+review.grade+"'>";
									html +="<textarea class='review-update'>"+review.content+"</textarea><button type='button' class='updateend'>완료</button><button type='button' class='cancel'>취소</button><input type='hidden' name='userid' value='"+review.usid+"'><input type='hidden' name='rvid' value='"+review.rvid+"'></div>";
									
								}
							
							<%}%>
						}//for in end
						
						$("div#pageBar").html(data[0].pageBar);	//페이지바 넣기
						$("div.movieReviewList").html(html); //리뷰 리스트 set
					},error:function(a,b,c){
						console.log(a);
						console.log(b);
						console.log(c);
					}
				}); //ajax end
			<%} %> //userSession이 널이 아닐때
			
		}); //리뷰 등록 버튼 클릭 이벤트  end
		

		/*리뷰 수정 버튼 클릭 이벤트 */
		$("div.movieReviewList").on("click","button.btn-update",function(){ 
			console.log("수정버튼");
			$(this).parent("div").parent("li").next("div").removeClass("edit-hide").addClass("edit-container");
			$(this).parent("div").addClass("hide");
		});
		
		
		/*리뷰 수정 완료 버튼 클릭 이벤트 */
		$("div.movieReviewList").on("click","button.updateend",function(){
			var review = {mid:movieMid,rvid:$("input[name=rvid]").val(),star:$("input[name=star]").val(),content:$("textarea.review-update").val()};
			$.ajax({
				url:"/cinema/review/reviewUpdate.do",
				data:review,
				dataType:"json",
				success:function(data){
					var html = "<ul>";
					for(var i in data){
						var review = data[i];
						html += "<li><div class='viewReview'><div class='id'>"+review.id+"</div><span class='regdate'>"+review.regdate+"</span>&nbsp;<span class='star'>"+review.grade+"점</span>\r\n<span class='content'>"+review.content+"</span>";
						<%if(userSession!=null){%>
						
							if(review.usid==<%=userSession.getUsid()%>){
								$("input[name=isWritten]").val("true"); //리뷰가 이미 등록해있음을 체크 
								console.log($("input[name=isWritten]").val()+"자기가 쓴글 보기 ");
								html +="<button type='button' class='btn-update'>수정</button><button type='button' class='btn-delete'>삭제</button>";
								
							}
						<% }%>
						html +="</div>";
						html +="</li>";
						<%if(userSession!=null){%>
							if(review.usid==<%=userSession.getUsid()%>){
								html +="<div class='edit-hide'><div class='id'>"+review.id+"</div><input type='number' name='star' min='1' max='5' value='"+review.grade+"'>";
								html +="<textarea class='review-update'>"+review.content+"</textarea><button type='button' class='updateend'>완료</button><button type='button' class='cancel'>취소</button><input type='hidden' name='userid' value='"+review.usid+"'><input type='hidden' name='rvid' value='"+review.rvid+"'></div>";
								
							}
						
						<%}%>
					}//for in end
					
					$("div#pageBar").html(data[0].pageBar);	//페이지바 넣기
					$("div.movieReviewList").html(html);
				},error:function(){
					console.log("ajax 처리 실패")
				}
				
			}); 
		});
		
		/* 리뷰 삭제 버튼 클릭 이벤트*/
		$("div.movieReviewList").on("click","button.btn-delete",function(){
				if(confirm("삭제하시겠습니까")){
					$.ajax({
						url:"/cinema/review/reviewDelete.do",
						data:{rvid:$("input[name=rvid]").val(),mid:movieMid},
						dataType:"json",
						success:function(data){
							console.log(data);
							$("input[name=isWritten]").val("false"); //리뷰가 이미 등록해있음을 체크 
							var html ="<ul>";
							if("null"==data[0]){ //댓글이 없다. 
								console.log("댓글이없어");
								html +="<li>댓글이 없습니다.</li>";
								html +="</ul>";
								$("div#pageBar").html(""); //페이지바 비우기
								
							}else{ //댓글 있다. 
								console.log("리스트 가져오기 성공"+data);
								/* html = "<ul>"; */
								for(var i in data){
									var review = data[i];
									html += "<li><div class='viewReview'><div class='id'>"+review.id+"</div><span class='regdate'>"+review.regdate+"</span>&nbsp;<span class='star'>"+review.grade+"점</span>\r\n<span class='content'>"+review.content+"</span>";
									<%if(userSession!=null){%>
									
										if(review.usid==<%=userSession.getUsid()%>){
											$("input[name=isWritten]").val("true"); //리뷰가 이미 등록해있음을 체크 
											console.log($("input[name=isWritten]").val()+"자기가 쓴글 보기 ");
											html +="<button type='button' class='btn-update'>수정</button><button type='button' class='btn-delete'>삭제</button>";
											
										}
									<% }%>
									html +="</div>";
									html +="</li>";
									<%if(userSession!=null){%>
										if(review.usid==<%=userSession.getUsid()%>){
											html +="<div class='edit-hide'><div class='id'>"+review.id+"</div><input type='number' name='star' min='1' max='5' value='"+review.grade+"'>";
											html +="<textarea class='review-update'>"+review.content+"</textarea><button type='button' class='updateend'>완료</button><button type='button' class='cancel'>취소</button><input type='hidden' name='userid' value='"+review.usid+"'><input type='hidden' name='rvid' value='"+review.rvid+"'></div>";
											
										}
									
									<%} else{%> //유저가 로그인을 안한 경우
										$("textarea#review-content").val("로그인후 이용가능 합니다");
									<%}%>
									
								}//for in문 end
								$("div#pageBar").html(data[0].pageBar);
								
							}//else end
							
							$("div.movieReviewList").html(html);
							$("div.review-container").detach().appendTo($("div.review-wrap")); //상세보기 페이지 안에 붙이기
							
							
						},error:function(){
							console.log("처리 실패");
						}
					}); 
				}//삭제여부if
		});
		//리뷰 삭제 버튼 클릭 이벤트 end
		
		
		
		/*리뷰 수정 취소 버튼 클릭 이벤트*/
		$("div.movieReviewList").on("click","button.cancel",function(){ //한줄평 수정 화면에서 수정 취소 버튼을 눌렀다. 취소 버튼 클릭 이벤트 
			console.log("취소버튼");
			
			$(this).parent("div").removeClass("edit-container").addClass("edit-hide");
			$("div.hide").removeClass("hide").addClass("viewReview");

			
		}); 
		

		
	});


	function fn_showReviewList(cPage,mid){ //페이징 처리  1,2,3,4 페이지 이동 주소와 cPage, mid 넘겨줌. 위치는 꼭 여기 있어야 됨. 동적으로 생기는 a에 건 onclick이라서? 
		$.ajax({
			url:"/cinema/review/reviewlist?cPage="+cPage+"&mid="+mid,
			dataType:"json",
			success:function(data){
				var html = "<ul>";
				for(var i in data){
					var review = data[i];
					html += "<li><div class='viewReview'><div class='id'>"+review.id+"</div><span class='regdate'>"+review.regdate+"</span>&nbsp;<span class='star'>"+review.grade+"점</span>\r\n<span class='content'>"+review.content+"</span>";
					<%if(userSession!=null){%>
					
						if(review.usid==<%=userSession.getUsid()%>){
							$("input[name=isWritten]").val("true"); //리뷰가 이미 등록해있음을 체크 
							console.log($("input[name=isWritten]").val()+"자기가 쓴글 보기 ");
							html +="<button type='button' class='btn-update'>수정</button><button type='button' class='btn-delete'>삭제</button>";
						}
					<%}%>
					html +="</div>";
					html +="</li>";
					<%if(userSession!=null){%>
						if(review.usid==<%=userSession.getUsid()%>){
							html +="<div class='edit-hide'><div class='id'>"+review.id+"</div><input type='number' name='star' min='1' max='5' value='"+review.grade+"'>";
							html +="<textarea class='review-update'>"+review.content+"</textarea><button type='button' class='updateend'>완료</button><button type='button' class='cancel'>취소</button><input type='hidden' name='userid' value='"+review.usid+"'><input type='hidden' name='rvid' value='"+review.rvid+"'></div>";
							
						}
					
					<%}%>
					
				}
				$("div#pageBar").html(data[0].pageBar); // 1,2,3,4 ...이전을 나타내는 태그.
				$("div.movieReviewList").html(html);	// 리뷰 리스트 넣기
			},error:function(){
				conosle.log("ajax 처리 실패");
			}
		});
	}
</script>

<style>
	.time_wrap{border:1px solid #e0e0e0; border-radius:2px; background:#fff;}
	.time_overflow{padding:0px 50px;  width:100%;   position:relative;}
	.time_arrows{position:absolute; width:100%;  left:0px; top:0px; }
	.time_arrows > span{ width:50px; text-align:center; padding:3px 0px 4px 0px;}
	.time_arrows .left{float:left;  border-right:1px solid #ddd;}
	.time_arrows .right{float:right;  border-left:1px solid #ddd;}
	.time_scroll_wrap{overflow:hidden;}
	.datepicker_min{position:relative; overflow:hidden;}
	.datepicker_min li{float:left; width:50px; text-align:center; padding:5px 0px; font-size:13px;}
	.datepicker_min .selected{background:#1986ff; color:#fff;}

</style>
<script>

function fn_showReservationDetail(mid, obj){
	console.log(mid);
	console.log(obj);
	$(".time_wrap").html("");
	document.body.style.overflow = 'hidden';
	$(".booking .view_board").width("940px");
	$(".booking").show();	

	$.ajax({
		url : "/cinema/movie/movieDetail",
		dataType:"json",
		type : "post",
		data : {mid : mid}, 
		success:function(data){
			movies =[];
			movies.push(data);
			tempList.push(data);
			var mitem = "<div class='view_detail'>";
				mitem +=   "<div class='bookingWrap'>";
				mitem += 	"<div class='leftSection'>";
				mitem += 		"<div class='dateSetter'>";
				mitem += 			"<div><h3>날짜</h3> <div class='time_wrap'></div></div>";
				mitem += 		"</div>";
				mitem += 		"<div class='theaterSetter'>";
				mitem += 			"<div><h3>극장</h3> <div></div></div>";
				mitem += 			"<div><div class='theaters'></div><div class='theaters'></div><div class='theaters'></div><div class='theaters'></div></div>";
				mitem += 		"</div>";
				mitem += 		"<div class='movieSetter'>";
				mitem += 			"<div><h3>영화</h3> <div>refresh</div></div>";
				mitem += 			"<div><div class='movies'><img src=/cinema/upload/movie/"+data.poster+ " /></div><div class='movies'></div><div class='movies'></div><div class='movies'></div></div>";
				mitem += 		"</div>";
				mitem += 	"</div>";
				        
				mitem += 	"<div class='rightSection'>";
				mitem += 		"<div class='timeSetter'>";
				mitem += 			"<div><h3>날짜</h3> <div>달력</div></div>";
				mitem += 				"<div class='timeSeleter'> </div>";
				mitem += 			"</div>";

				mitem += 		"<div class='scheduleSelector'>";
				mitem += 		"</div>";
				mitem += 	"</div>";				
				mitem += 	"</div>";				
				mitem += 	"<div class='adversting'><img src='/cinema/data/booking_adv.jpg'/></div>";				
				mitem += 	"</div>";
			mitem += "</div>";
			
			$(".booking .view_board").append(mitem);
			
			
			
			//$setDate();
			
			func(2018, 6 , 0);
			
			var dater = "";
			dater += "<div class='time_overflow'>"
			dater += "<div class='time_arrows'><span class='left'><</span><span class='right'>></span></div>"
			dater += "<div class='time_scroll_wrap'>";
			dater += str;
			dater += "</div>";
			dater += "</div>";
			
			
			
			
			var showdate = new Date();

			$(".time_wrap").html(dater);
			
			
			var date_length = $(".datepicker_min li").length;
			var date_width = $(".datepicker_min li").width();
			
			
			$(".datepicker_min").width(date_length * date_width);
			$(".datepicker_min li").eq(0).attr("class", "selected");
			
			$(".datepicker_min li").click(function(){
				console.log($(this).index());
				$(".datepicker_min li").removeClass("selected");
				$(".datepicker_min li").eq($(this).index()).attr("class", "selected");
				$(".datepicker_min").animate({"left" : -(date_width * $(this).index())}, 100);
				indexes = $(this).index();
				fn_query();
				
			})
			
			var indexes = 1;
			$(".time_arrows .left").click(function(){
				if(indexes > 1){
				$(".datepicker_min").animate({"left" : "+="+date_width }, 100);
				indexes--;
				console.log(indexes);
				}
			});
			
			$(".time_arrows .right").click(function(){
				$(".datepicker_min").animate({"left" : "-="+date_width }, 100);
				indexes++;
				console.log(indexes);
			});
 
			
	
	$(".theaterSetter").on("click", ".theaters", function(){
		
		fn_showLocal();
		

		
	});
	
		} //아작스
	});
	
}

var map;
var infowindow;
function initMap() {
	var pyrmont = {lat: 37.499231, lng:  127.032941};
    map = new google.maps.Map(document.getElementById('theater_map'), {
      center: pyrmont,
      zoom: 13
    });
    
    
    var request = {
   	    location: pyrmont,
   	    radius: '500',
   	    query: '메가박스'
	};
    
    
    var infoWindow = new google.maps.InfoWindow({map : map });
    
    var service = new google.maps.places.PlacesService(map);
    ervice = new google.maps.places.PlacesService(map);
    service.textSearch(request, callback)
    

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function(position) {
        var pos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };

        infoWindow.setPosition(pos);
        infoWindow.setContent('잡았다 요놈');
        map.setCenter(pos);
      }, function() {
        handleLocationError(true, infoWindow, map.getCenter());
      });
    } else {
      handleLocationError(false, infoWindow, map.getCenter());
    }
   
  }

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
  infoWindow.setPosition(pos);
  infoWindow.setContent(browserHasGeolocation ?
                        'Error: The Geolocation service failed.' :
                        'Error: Your browser doesn\'t support geolocation.');
}
function callback(results, status) {
  if (status === google.maps.places.PlacesServiceStatus.OK) {
    for (var i = 0; i < results.length; i++) {
      createMarker(results[i]);
    }
  }
}

function createMarker(place) {
  var placeLoc = place.geometry.location;
  var marker = new google.maps.Marker({
    map: map,
    position: place.geometry.location
  });

  google.maps.event.addListener(marker, 'click', function() {
    infowindow.setContent(place.name);
    infowindow.open(map, this);
  });
}
function fn_showLocal(){
	html = "";
	
	var showLocal = $(".showLocal");
	
	showLocal.show();
	$(".localWrap").empty();
	$.ajax({
		url : "/cinema/locals",
		dataType:"json",
		type : "post",
		data : { type : "list" }, 
		success:function(data){
		
			html += "<div class='setLocal'><ul>";
			for(i in data){
				html += "<li onclick='fn_getTheater("+data[i].lid+")' class='local_name' lid='"+data[i].lid+"''>"+data[i].lname +"</li>";
			}
			html += "</ul></div>"
			html += "<div class='theater'></div>"
			html += "<div id='theater_map'></div>"
			$(".localWrap").append(html);
			fn_getTheater(2);
		}//성공시
	}).done(function(){
		initMap();
	});//아작스 끝
	
	
	
	
	
	
}

function fn_getTheater(lid){
	
	
	$(".theater").empty();
	$.ajax({
		url : "/cinema/userTheater",
		dataType:"json",
		type : "post",
		data : { type : "showTheaterLID", LocalNo : lid }, 
		success:function(data){
			console.log(data);
			html ="";
			html += "<ul>";
			for(i in data){

			dataItem = JSON.stringify(data[i]);
			html += "<li onclick='fn_setLocals("+dataItem+")'; tid="+data[i].tid+" lid="+data[i].lid+">"+data[i].name+"</li>";
			}
			html +="</ul>";			
			
			$(".theater").append(html);
		}
	});
	
}

function fn_setLocals(data){

	for(var i =0; i<locals.length; i++){
		if(locals[i].tid==data.tid){
			locals.splice(i, 1);
			
			if(locals.length>0){
				html = "";
				for(var i =0; i<locals.length; i++){
					html+= "<span>"+ locals[i].name +"</span>";	
				}
				$(".select_local_text").html(html);
			}else{
				$(".select_local_text").html("");
			}
		return;		
		}
	}
	
	if(locals.length>=4){
		console.log("4개 이상은 안되요");
		return;
	}
	
	
	locals.push(data);
	console.log(locals);
	
	html = "";
	for(var i =0; i<locals.length; i++){
		html+= "<span>"+ locals[i].name +"</span>";	
	}
	$(".select_local_text").html(html);
	
}


$(function(){
	initMap();
	//fn_showReservationDetail();
	//n_showMovieDetail(112);
});

jQuery(document).ready(function ($) {
	    setInterval(function () {
	        moveRight();
	    }, 3000);
		var slideCount = $('#slider ul li').length;
		var slideWidth = $('#slider ul li').width();
		var slideHeight = $('#slider ul li').height();
		var sliderUlWidth = slideCount * slideWidth;
		
		$('#slider').css({ width: slideWidth, height: slideHeight });
		
		$('#slider ul').css({ width: sliderUlWidth, marginLeft: - slideWidth });
		
	    $('#slider ul li:last-child').prependTo('#slider ul');

	    function moveLeft() {
	        $('#slider ul').animate({
	            left: + slideWidth
	        }, 200, function () {
	            $('#slider ul li:last-child').prependTo('#slider ul');
	            $('#slider ul').css('left', '');
	        });
	    };

	    function moveRight() {
	        $('#slider ul').animate({
	            left: - slideWidth
	        }, 200, function () {
	            $('#slider ul li:first-child').appendTo('#slider ul');
	            $('#slider ul').css('left', '');
	        });
	    };

	    $('a.control_prev').click(function () {
	        moveLeft();
	    });

	    $('a.control_next').click(function () {
	        moveRight();
	    });

	});    


</script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js" >
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA0jyQv8bkQTbFgBvGuHks6n4rF1tD73cA&libraries=places&callback=initMap" async defer></script>

<style>
.booking .view_detail{ }
.booking h3{margin-bottom:10px;}
.booking .view_detail .bookingWrap{overflow:hidden;position:relative; height:100%; background:#f9f9f9;}
.booking .view_detail .bookingWrap > div{float:left;}
.booking .view_detail .leftSection{width:48%;}
.booking .view_detail .leftSection > div {padding:20px;}
.booking .view_detail .leftSection .dateSetter{border-bottom:1px solid #e0e0e0;}
.booking .view_detail .leftSection .theaterSetter{border-bottom:1px solid #e0e0e0; overflow:hidden; }
.booking .view_detail .leftSection .theaterSetter .theaters{ float:left; border:1px solid #e0e0e0;height:70px; width:200px; margin-bottom:10px; text-align:center; padding-top:24px;}
.booking .view_detail .leftSection .theaterSetter .theaters:nth-child(2n-1){margin-right:10px;}
.booking .view_detail .leftSection .movieSetter {overflow:hidden;}
.booking .view_detail .leftSection .movieSetter .movies{float:left; border:1px solid #e0e0e0;height:130px; width:95px; margin-left:10px;}
.booking .view_detail .leftSection .movieSetter .movies:nth-child(1){margin-left:0px;}
.booking .view_detail .leftSection .movieSetter .movies img{width:100%}
.booking .view_detail .rightSection{width:52%; border-bottom:1px solid #e0e0e0; border-left: 1px solid #e0e0e0; height:100%;}
.booking .view_detail .rightSection .timeSetter{padding:20px; border-bottom:1px solid #e0e0e0;}
.booking .view_detail .rightSection .scheduleSelector{height:460px; overflow-y:scroll;}
.booking .view_detail .rightSection .scheduleSelector .schdules{height:100px; border-bottom:1px solid #e0e0e0}
.booking .view_detail .adversting{ width:100%;}
.booking .view_detail .adversting img{width:100%;}



.showLocal .setLocal ul{overflow:hidden; border-right:1px solid #ececec;}
.showLocal .setLocal ul li{width:150px; border-bottom:1px solid #ececec; background:#fff; }
.showLocal ul{height:100%; overflow-y:auto;}
.showLocal li{padding:13px; background:#f9f9f9; cursor:pointer;}
.showLocal li:hover{background:#f1f1f1;}
.theater{width:180px;}
.theater ul{border-right:1px solid #e0e0e0;}








.reservation_payment{    
	width: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
    height: 100%;
    background: #fff;
}

.payment_selector{
	line-height: 225%;
    text-align: center;
    margin-top: 100px;
    font-size: 30px;

}
.payment_selector input{
	width: 20px;
    height: 20px;

}
.payment_selector button{margin-left:10px;}











</style>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>