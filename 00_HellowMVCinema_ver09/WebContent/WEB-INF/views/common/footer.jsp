<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
		</div> <!-- wrap -->
   	</section>
</section> 
	
	
	<footer>
	<div class="wrap">
		<div>
	<div class="mvcinema_wrap">
		<h4 class="mvcinema">MVCINEMA 영화관 찾기</h4>
		<dl class="clearfix">
			<dt>서울</dt>
			<dd>강남</dd>
			<dd>강남대로(씨티)</dd>
			<dd>강동</dd>
			<dd>동대문</dd>
			<dd>마곡</dd>
			<dd>목동</dd>
			<dd>상봉</dd>
			<dd>센트럴</dd>
			<dd>신촌</dd>			
			<dd>은평</dd>
			<dd>이수</dd>                                 
			<dd>창동</dd>	
			<dd>코엑스</dd>
	        <dd>화곡</dd>
			<dd>ARTNINE</dd>
			<dd>EOE4</dd>
		</dl>
		<dl class="clearfix">
			<dt>경기</dt>
			<dd>고양스타필드</dd>
			<dd>김포</dd>
			<dd>남양주</dd>
			<dd>동탄</dd>
   			<dd>백석</dd>
			<dd>별내</dd>
			<dd>분당</dd>
			<dd>수원</dd>
			<dd>수원남문</dd>
			<dd>양주</dd>
			<dd>영통</dd>
			<dd>오산</dd>
			<dd>의정부 민락</dd>
 			<dd>일산</dd>
			<dd>일산벨라시타</dd>
			<dd>킨텍스</dd>
			<dd>파주금촌</dd>
			<dd>파주운정</dd>                            
			<dd>평택</dd>
			<dd>하남스타필드</dd>
		</dl>
		<dl class="clearfix">
			<dt>인천</dt>
			<dd>검단</dd>
			<dd>송도</dd>
			<dd>인천논현</dd>
			<dd>청라</dd>
		</dl>
		<dl class="clearfix dt_st1">
			<dt>대전  |  세종  |  충청</dt>
			<dd>공주</dd>
			<dd>대전</dd>
			<dd>세종</dd>
			<dd>오창</dd>

			<dd>제천</dd>
			<dd>진천</dd>
			<dd>천안</dd>
			<dd>충주</dd>
			<dd>홍성내포</dd>
		</dl>
		<dl class="clearfix dt_st2">
			<dt>부산  |  경상</dt>
			<dd>거창</dd>
			<dd>경남대</dd>

			<dd>경산하양</dd>
			<dd>경주</dd>
			<dd>구미</dd>
			<dd>구미강동</dd>
			<dd>김천</dd>

			<dd>남포항</dd>
			<dd>대구(칠성로)</dd>
			<dd>덕천</dd>
			<dd>대구 신세계</dd>
			
			<dd>마산</dd>
			<dd>문경</dd>
			<dd>부산극장</dd>
			<dd>부산대</dd>
			<dd>북대구(칠곡)</dd>
			<dd>사천</dd>
			<dd>삼천포</dd>
			<dd>서면</dd>
			<dd>안동</dd>
			<dd>양산</dd>
			<dd>울산</dd>
			<dd>정관</dd>
			<dd>창원</dd>
			
			<dd>해운대(장산)</dd>	</dl>
		<dl class="clearfix dt_st2">
			<dt>광주  |  전라</dt>
			<dd>광주(충장로)</dd>
			<dd>광주상무</dd>
			<dd>광주하남</dd>			
			<dd>남원</dd>
			<dd>목포</dd>
			<dd>목포하당(포르모)</dd>
			<dd>송천</dd>
			<dd>순천</dd>
			<dd>여수</dd>
	
			<dd>여수웅천</dd>
			<dd>전대(광주)</dd>
			<dd>전주(객사)</dd>
			<dd>첨단(광주)</dd>
		</dl>
		<dl class="clearfix">
			<dt>강원</dt>
			<dd>남춘천</dd>
			<dd>속초</dd>
			<dd>원주</dd>
			<dd>원주센트럴</dd>
		</dl>
		<dl class="clearfix">
			<dt>제주</dt>
			<dd>제주</dd>
			<dd>제주아라</dd>
		</dl>
	</div>
		</div>
	</div>
	</footer>
	
<style>

	
.movie_show_detail{
	display:none;
	position:fixed;
	width:100%;
	height:100%;
	top:0px;
	overflow-y: scroll;
}
.movie_show_detail > div
{

	width:100%;

}
.movie_show_detail .back_board{
	background:#fff;
	height:100%;
	opacity:0.6;
	z-index:30;
	top:0px;
	position:absolute;
}
.movie_show_detail .view_board{
	position:relative;
	color:#333;
	z-index:31;
	width:880px;
	margin:0 auto;
	margin-top:40px ;
	background:#fff;
}
.movie_show_detail .view_board .view_detail{
	padding:40px;

}
.booking{
	display:none;
	position:fixed;
	width:100%;
	height:100%;
	top:0px;
	overflow-y: scroll;
}
.booking > div
{
	width:100%;

}
.booking .back_board{
	background:#fff;
	height:100%;
	opacity:0.6;
	z-index:30;
	top:0px;
	position:absolute;
}
.booking .view_board{
height:565px;
	position:relative;
	color:#333;
	z-index:31;
	width:760px;
	margin:0 auto;
	margin-top:40px ;
	background:#fff;
}

.showLocal{
	display:none;
	position:fixed;
	width:100%;
	height:100%;
	top:0px;
	overflow-y: scroll;
}
.showLocal > div
{
	width:100%;

}
.showLocal .back_board{
	background:#fff;
	height:100%;
	opacity:0.6;
	z-index:30;
	top:0px;
	position:absolute;
}
.showLocal .view_board{
	height:570px;
	position:relative;
	color:#333;
	z-index:31;
	width:940px;
	margin:0 auto;
	margin-top:40px ;
	background:#fff;
}
.showLocal .localWrap{height:470px;background:#fff;}
.showLocal .view_board .localWrap > div {
float:left; }
.showLocal .view_board .setLocal{
}
.showLocal .btn_local{padding:10px; background:#ededed;}
.btn_movie{padding:10px; background:#ededed;}
.btn_wrap button{padding:10px 28px; font-size:16px;}
.btn_wrap .btn_combie_ok{ background:#1986ff; color:#fff;}
.btn_wrap .btn_combie_cancle{border:1px solid #d9d9d9; color:#777}
.btn_wrap .btn_combie_cancle:hover{color:#333;}


.showSeat{
	display:none;
	position:fixed;
	width:100%;
	height:100%;
	top:0px;
	overflow-y: scroll;
}
.showSeat > div
{
	width:100%;

}
.showSeat .back_board{
	background:#fff;
	height:100%;
	opacity:0.6;
	z-index:30;
	top:0px;
	position:absolute;
}
.showSeat .view_board{
	overflow:hidden;
	height:665px;
	position:relative;
	color:#333;
	z-index:31;
	width:950px;
	margin:0 auto;
	margin-top:40px ;
	background:#fff;
}


.closeBtn{
	width:50px; 
	height:50px; 
	background:#333; 
	position:absolute; 
	right:0px; 
	top:0px;
	cursor:pointer;
	z-index:30;
}
.closeBtn:before{content:""; position:absolute; border-top:2px solid white; width:60px; transform : rotate(-45deg); transform-origin: 0% 0%; bottom:4px; left:3px; }
.closeBtn:after{content:""; position:absolute; border-top:2px solid white; width:60px; transform : rotate(45deg); transform-origin: 0% 0%; top:2px; left:3px; }
.view_thumbnail{width:250px; }
.view_thumbnail img{width:100%;}


.view_moiveList_bord{
 display:block;
 background:#333;
 height:500px;
 position:absolute;
 top:30px;
}

.show_another_detail{
	position:fixed;
	width:100%;
	height:100%;
	top:0px;
	overflow-y: scroll;
	display:none;
}


.show_another_detail .back_board{
	background:#fff;
	height:100%;
	width:100%;
	opacity:0.6;
	z-index:30;
	top:0px;
	position:absolute;
}
.show_another_detail .view_board{
	position:relative;
	color:#333;
	z-index:31;
	height:540px;
	width:940px;
	margin:0 auto;
	margin-top:40px ;
	background:#fff;
}


.loginBox{
	position:fixed;
	width:100%;
	height:100%;
	top:0px;
	overflow-y: scroll;
	display:block;
}


.loginBox .back_board{
	background:#fff;
	height:100%;
	width:100%;
	opacity:0.6;
	z-index:30;
	top:0px;
	position:absolute;
}
.loginBox .view_board{
	position:relative;
	color:#333;
	z-index:31;
	height:300px;
	width:400px;
	margin:0 auto;
	margin-top:200px ;
	background:#fff;
}





.show_another_detail .view_board ul{overflow:hidden; padding:10px }
.show_another_detail .view_board .selectList span{display:inline-block; padding:5px 10px; font-size:12px; background:#e0e0e0; border-radius:10px;margin-right:10px; }
.show_another_detail .view_board .selectList{border-bottom:1px solid #e0e0e0; border-top:1px solid #e0e0e0;}
.show_another_detail .view_board li{
width:100px; float:left;
padding:10px; 
}
.show_another_detail .view_board li img{
width:100%;}

.show_another_detail .view_board .selected{
background:#333;}
.btn_local{clear:both; width:100%; text-align:right;}
.btn_movie{clear:both; width:100%; text-align:right;}
.view_select_local{clear:both; width:100%;}
.select_local_text{height:50px; border-top:1px solid #e0e0e0; border-bottom:1px solid #e0e0e0; padding:10px;  }
.select_local_text span {display:inline-block; padding:5px 10px; font-size:12px; background:#ececec; margin-right:10px; border-radius:10px; }
.schedules{overflow:hidden; border-bottom:1px solid #ececec;}
.schedules > div{padding:10px; float:left;}
.stime{ width: 30%;}
.sname{width:50%;}
.slocal{ width:20%}
.schedules{padding:10px; background:#fff;} 
.schedules .timeWrap{text-align:right;} 
.schedules .start_time{font-size:20px;}
.schedules .end_time{font-size:16px; }
.schedules .mname{font-size:18px;  }
.schedules .mname .mgrade{}
.schedules .sname{border-right:1px solid #e0e0e0; border-left:1px solid #e0e0e0;}
.schedules .slocal{font-size:12px; text-align:right;}

.showSeat .titlebar{padding:15px 10px; background:#eaeaea; font-size:24px; }
.showSeat .reservation_section{float:left; width:80%; height:100%;position:relative;}
.showSeat .info_section{float:left; width:20%; height:100%; background:#333; box-sizing: content-box; position:relative;}
.showSeat .info_section img{width:100%;}
.showSeat .info_section .price{font-size:34px; font-weight:bold; padding:20px; }
.showSeat .info_section .next{padding:15px 30px; margin-top:10px;}

.seatWrap{padding-top:10px;}
.select_person{padding:20px; border-top:1px solid #eaeaea; border-bottom:1px solid #eaeaea; }
.select_person select{font-size:24px; padding:5px 10px; margin:0px 20px; }
.cnt_section{clear:both; text-align:right; padding:15px 10px; border-top:1px solid #eaeaea; margin-top:20px;}
.infor_wrap{padding:10px; background:#333; color:#fff;}
.screen{height:30px; text-align:center; font-size:20px; width: 80%; background:#999; color:#fff; margin-bottom:30px;}
</style>

<div class="movie_show_detail">
	<div class="view_board">
		<div class="closeBtn"></div>
	</div>
	<div class="back_board"> </div>
</div>

<div class="booking">
	<div class="view_board">
		<div class="closeBtn"></div>
	</div>
	<div class="back_board"> </div>
</div>



<div class="show_another_detail">
	<div class="view_board">
		<div class="btn_movie btn_wrap">
			<button class="btn_movie_cancle btn_combie_cancle">취소</button>
			<button class="btn_movie_ok btn_combie_ok">확인</button>
		</div>
	<div><ul class="selectList"></ul></div>
	<div class="mList">
		<ul>
	
		</ul>
	</div>
	</div>
	<div class="back_board"> </div>
</div>

<div class="showLocal">
	<div class="view_board">
		<div class="btn_local btn_wrap">
			<button class="btn_local_cancle btn_combie_cancle">취소</button>
			<button class="btn_local_ok btn_combie_ok">확인</button>
		</div>
		<div class="select_local_text"></div>
		<div class="localWrap">
		
		</div>
	</div>
	<div class="back_board"> </div>
</div>

<div class="showSeat">
	<div class="view_board">
		<div class="titlebar">인원/좌석선택</div>
		<div class="reservation_section">
			<div class="select_person">
			</div>
			<div class="screen">
			screen
			</div> 
			<div class="seatWrap">
			</div>
		</div>
		<div class="info_section">

		</div>
		<div class="closeBtn"></div>
	</div>
	<div class="back_board"> </div>
</div>
<style>
.loginBox .view_board .inputer_wrap{

}
.loginBox .view_board .titleLogin{padding:20px 30px;  border-bottom : 3px solid #1986ff;}
.inputer_wrap{}
.loginBox .input_section{padding:20px 30px; width:100%;}
.loginBox .input_section input{ border:1px solid #e0e0e0; padding:15px 10px; font-size:18px; width:100%; margin-bottom:10px;}
.loginBox .btn_section{padding:20px 30px; text-align:center;}
.loginBox .btn_section button{width:100px;}
.loginBox .login_btn{}
.loginBox .cancle_btn{}
.loginBox{display:none;}

div.edit-container{
	display:block;
}
div.edit-hide{
	display:none;
}
div.hide{
	display:none;
}
span.regdate{
	font-size:10px;
}
div.movieReviewList{
	clear:both;
} 

#review-content{width:100%; height:120px; padding:20px; font-size:12px; font-family:dotum;}
.movie_show_detail .review-write{padding:30px; }
#star{ padding:10px; margin-bottom:10px; cursor:pointer; }
.movieReviewList {overflow:hidden;}
.movieReviewList ul{overflow:hidden; border-top:1px solid #ececec; border-bottom:1px solid #ececec;}
.movieReviewList li{width:50%; float:left;padding:25px; border-bottom:1px solid #ececec;   height:130px; }
.movieReviewList li:nth-child(2n) {
 border-left:1px solid #ececec;
}
.movieReviewList li:last-of-type{border-right:1px solid #ececec; border-bottom:none;}


.btn_reviewer button{padding:10px; font-size:12px; }
.viewReview{float:left;}
.viewReview {width:250px; margin-left:15px;}
.viewReview .content{display:block; }
.viewReview .id{font-size:18px;  color:#1985ff; }
.reviewr_img {float:left; }
.reviewr_img img {width:50px;  }
.fa{color:#e0e0e0}
.khchecked {
    color: orange;
}
#pageBar{text-align:center; padding:10px; }
#pageBar span{display:inline-block; background:#ececec; padding:10px; width:50px;  margin-left:10px; }
#pageBar span:hover{border:1px solid #1985ff; color:#1985ff; }
.textarea, .btn-enroll{float:left;}
.textarea{width:85%}
.btn-enroll{width:15%}
.btn-enroll button{width:100%; height:120px;}
.review-write .names{padding-top:5px;height:20px; position:relative; }
</style>


<div class="movie_show_detail">
	<div class="view_board">
		<div class="closeBtn"></div>
		<div class='view_detail_container'></div>
		<div class='review-wrap'>
			<!-- 리뷰 등록폼, 리스트 컨테이너 -->
			<div class="review-container">
				<div class="review-write">
					<div class="name"><span id="userName"></span><span id='wordCheckCount'></span></div>
					<div class="input">
						<div id="star"><input type="hidden" name="starScore" value='3' />
						
							<span class="fa fa-star khchecked fz"></span>
							<span class="fa fa-star khchecked fz"></span>
							<span class="fa fa-star khchecked fz"></span>
							<span class="fa fa-star fz"></span>
							<span class="fa fa-star fz"></span>
							<div class="names"></div>
						</div>
					<div class="textarea"><textarea name="" id="review-content" cols="30" rows="10"></textarea></div>
					<div class="btn-enroll"><button type="button">등록</button></div>
					</div>
				</div>
				<div class="movieReviewList">
				</div>
				<input type="hidden" name="isWritten" value='false' />
				<div id="pageBar"></div>
			</div>
		</div>
	</div>

	
	<div class="back_board"> </div>
</div>
<script>
var starName = ["괜히봤어요", "기대하지 말아요", "무난 했어요", "기대해도 좋아요",  "인생영화임" ];
$(".fz").hover(function(){
	$(".fz").removeClass("khchecked");
	console.log();
	
	$("[name=starScore]").val($(this).index());
	$(".names").text(starName[$(this).index()-1]);	
	for(var i =0; i< $(this).index(); i++ ){
		$(".fz").eq(i).addClass("khchecked");
	}
	
	
	
	
});

</script>


<div class="loginBox">
	<div class="view_board">
	<div class="inputer_wrap">
		<div class="titleLogin"><h3>로그인</h3></div>
		<div class="input_section">
			<div> <input type="text" class="login_hidden_id" placeholder="아이디" /></div>
			<div> <input type="password" class="login_hidden_pw" placeholder="비밀번호"/></div>
		</div>
		<div class="btn_section">
			<button class="cancle_btn">취소</button>
			<button class="login_btn" onclick="fn_login_hidden();">로그인</button>
		</div>
	</div>
	</div>
	<div class="back_board"> </div>
</div>


<script>



//스케쥴 리스트를 가져오자!!
function fn_query(){
	$th = $(".theaters");
	$th.text("");
	$(".showLocal").hide();
	$(".scheduleSelector").empty();
	for(var i=0; i<locals.length; i++){
		$th.eq(i).text(locals[i].name);
	}
	
	
	
	var moviesed = "";
	var localsed = "";
	var date = $(".datepicker_min .selected").attr("fulldate");
	
	for(var i = 0; i<tempList.length; i++){
		if(i != 0){
			moviesed +=","+tempList[i].mid;
		}else{
			moviesed += tempList[i].mid;
		}
	}
	
	
	for(var i = 0; i<locals.length; i++){
		if(i != 0){
			localsed += ","+locals[i].tid;
		}else{
			localsed += locals[i].tid;
		}
	}
	
	$.ajax({
		url : "schedule",
		dataType:"json",
		type: "post",
		data : {theaters : localsed , movies : moviesed, date : date},
	
		success:function(data){
			
			var schedule = "";
			console.log("스케쥴 확인용"+data);
			console.log(data[0]);
			
			
			for(i in data){
				dataItem = JSON.stringify(data[i]);
			schedule += "<li class='schedules' onclick='fn_SeatWindow("+dataItem+")'>";
			
			schedule += "<div class='stime'>";
			schedule += 	"<div>";
			schedule +=	    	"<div></div>"
			schedule += 	"</div>";
			schedule += 	"<div class='timeWrap'>";
			schedule +=	    	"<div><span class='start_time'>"+(data[i].stime).substring(10, 16) +" ~</span><span class='end_time'>"+ (data[i].sendtime).substring(10, 16)+"</span></div>";
			schedule += 	"</div>";				
			schedule += "</div>";
			
			//연령 제목 
			schedule += "<div class='sname'>";
			schedule += 	"<div>";
			schedule += 		"<div class='mname'><span class='mgrade'>"+data[i].grade+"</span>"+data[i].mname+"</div>";
			schedule += 	"</div>";
			schedule += 	"<div>";
			schedule += 		"<div>"+data[i].rtype+"</div>";
			schedule += 	"</div>";				
			schedule += "</div>";
			
			
			//영화관 , 상영관 , 남은수/최대수
			schedule += "<div class='slocal'>";
			schedule += 	"<div>";
			schedule += 		"<div>"+data[i].name+"</div>";
			schedule += 	"</div>";
			schedule += 	"<div>";
			schedule += 		"<div>"+data[i].rname+"</div>";
			schedule += 	"</div>";				
			schedule += 	"<div>";
			schedule += 		"<div>"+data[i].slcnt+"/"+data[i].scnt+"</div>";
			schedule += 	"</div>";				
			schedule += "</div>";
			
				schedule += "</li>"
			}
			$(".scheduleSelector").append(schedule);

			
			$(".schedules").click(function(){
				
			});
			
		}
		
	});
	
}




	$(".btn_local_ok").click(function(){
		fn_query();
	});
	$(".btn_movie_ok").click(function(){
		console.log(locals);
		
		$mv = $(".movieSetter .movies");
		$mv.html("");
		$(".show_another_detail").hide();
		for(var i=0; i<$mv.length; i++){
			$mv.eq(i).html("<img src='/cinema/upload/movie/"+tempList[i].poster+"'/>" );			
		}
		
		fn_query();
	});
	var datas = null;
	$(".movie_show_detail .closeBtn").click(function(){
		document.body.style.overflow = 'auto';
		$(".movie_show_detail").hide();
		$(".view_detail").remove();
	});
	
	$(".booking .closeBtn").click(function(){
		document.body.style.overflow = 'auto';
		$(".booking").hide();
		$(".view_detail").remove();
		$(".time_wrap").empty();
		movies = [];
		locals = [];
		theaters = [];
		$(".movieSetter .movies").html("");
	});
	
	$(".showSeat .closeBtn").click(function(){
		document.body.style.overflow = 'auto';
		$(".showSeat").hide();
		$(".select_person").empty();
		$(".info_section").empty();
		$(".seatWrap").empty();
		movies = [];
		locals = [];
		theaters = [];
		
	});
	
	$(".show_another_detail .btn_movie_cancle").click(function(){
		$(".show_another_detail").hide();
		$(".show_another_detail .view_detail").remove();
	});
	
	$(".showLocal .closeBtn").click(function(){
		$(".showLocal").hide();
		$(".showLocal .view_detail").remove();
	});
	
	$(".showLocal .btn_local_cancle").click(closer = function(){
		$(".showLocal").hide();
		$(".showLocal .view_detail").remove();
	});
	
 
	
	function fn_getMovieList(num){
		$(".selectList").empty();
		$(".show_another_detail").show();
		$(".show_another_detail .view_board .movies").remove();
		var num = num;
		var mo = null;
		mo = movies[0];
		
		$.ajax({
			url : "/cinema/movie.do",
			dataType:"json",
			type: "post",
			success:function(data){
				datas = data;
				var selectedChk;
				console.log(tempList);
				for(i in data){ 
					selectedChk =  (data[i].mid == mo.mid? "selected" : " ");
					dataItem = JSON.stringify(data[i]);
					$(".show_another_detail .view_board .mList ul").append("<li class='movies'><img src=/cinema/upload/movie/" + data[i].poster +" onclick='fn_addMovie("+data[i].mid+","+num+", "+ dataItem +")' /></li>");
				}
				var html = "";
				for(var i =0; i<tempList.length; i++){
					html += "<span>"+tempList[i].name+"</span>";
				}
				$(".selectList").html(html);
				
			}
		});
	}
	

var tempList = [];
function fn_addMovie(mid, num, obj){
	for(var i =0; i<tempList.length; i++){
		if(obj.mid == tempList[i].mid){
			tempList.splice(i, 1);
			if(tempList.length>0){			
				var html = "";
				for(var i =0; i<tempList.length; i++){
					html += "<span>"+tempList[i].name+"</span>";
				}
				$(".selectList").html(html);
			}else{
				$(".selectList").html("");
			}
			return console.log(mid + "값을 뺏습니다. 남은 값" + tempList);
		}
	}
	
	if(tempList.length >= 4){
		return console.log("4개까지만 선택가능 ");
	}		
	
	tempList.push(obj);
	console.log(tempList);

	var mList = $(".mList li");
	var html = "";
	for(var i =0; i<tempList.length; i++){
		html += "<span>"+tempList[i].name+"</span>";
	}
	$(".selectList").html(html);
	
}

$(".booking").on("click", ".movies", function(){
	fn_getMovieList($(this).index());
	console.log($(this).index()+"처음 넘겨줄때");

});

</script>


<style>


.seatWrap{margin-top:10px; width:100%; overflow:hidden; padding:0px 50px 0px 50px;}
.seatWrap table{border-collapse: separate; border-spacing:1px;   float:left; width:auto; margin-bottom:30px;}

.seatWrap table td{padding:0px; overflow:hidden; position:relative;background:#333; color:#fff; text-align:center; min-width:17px; max-width:17px; height:17px;  max-height:17px; cursor:pointer; font-size:11px;}
.seatWrap table .seats[variable="1"]:hover{background:#fff; color:#333}
.seatWrap table .select{background:#333; color:#333; background:#ececec;}
.seatWrap table .select:after{content:""; position:absolute; border-top:2px solid white; width:20px; transform : rotate(45deg); transform-origin: 0% 0%; top:5px; left:5px; }
.seatWrap table .select:before{content:""; position:absolute; border-top:2px solid white; width:20px; transform : rotate(-45deg); transform-origin: 0% 0%; bottom:4px; left:3px; }
.seatWrap table td[variable="0"]{background:#fff;}
.seatWrap table td[variable="0"]:after{content:""; position:absolute; border-top:1px solid red; width:13px; transform : rotate(45deg); transform-origin: 0% 0%; top:3px; left:3px;}
.seatWrap table td[variable="0"]:before{content:""; position:absolute; border-top:1px solid red; width:13px; transform : rotate(-45deg); transform-origin: 0% 0%; top:12px; left:2px;}
.seatWrap table td[variable="-1"]{background:#fff;}
.seatWrap table td[variable="-1"]:after{content:""; position:absolute; border-top:1px solid #ddd; width:13px; transform : rotate(45deg); transform-origin: 0% 0%; top:3px; left:3px;}
.seatWrap table td[variable="-1"]:before{content:""; poinfo_sectionsition:absolute; border-top:1px solid #ddd; width:13px; transform : rotate(-45deg); transform-origin: 0% 0%; top:12px; left:2px;}
.seatWrap table .blank{background:#fff; border:none; padding:0px; margin:-2px;  width:20px; height:15px;  }
.seatWrap table .blank:hover{cursor:default;}
.seatWrap table{}
.seatWrap table .setInfo{background:#ececec; color:#333; margin-right:10px; cursor:default;}


#room{ font-size:25px; padding:10px;}
.seatWrap .seat .setInfo{background:#ececec; color:#333; margin-right:10px; cursor:default;}


.copy{background:#221f1f; color:#666;}
.qmenu{padding:20px;}
.qmenu span{ text-align:left; cursor:pointer; padding:10px; font-size:12px;}
.qmenu span:hover{color:#fff;}
.qmenu div{ display:inline-block; border-right:1px solid #333; height:10px; }
.addr{font-size:12px;  padding:0px 0px 30px 30px; line-height:150%; }

.mvcinema_wrap{text-align:left;}
.mvcinema_wrap .mvcinema{font-size:18px; margin-bottom:30px;}
.mvcinema_wrap .clearfix{font-size:12px; clear:left; overflow:hidden; }
.mvcinema_wrap .clearfix{position:relative; padding:0 0 10px 130px; margin-bottom:5px; line-height:18px;}
.mvcinema_wrap .clearfix:after{display:table; content :"";}
.mvcinema_wrap .clearfix dt{position:absolute; left:0px; top:0px;}
.mvcinema_wrap .clearfix dd{float:left; padding:0px 5px; }
.mvcinema_wrap .clearfix dd:first-of-type {
}
</style>

<div class="copy">
<div class="qmenu">
<span>회사소개</span><div></div><span>채용정보</span><div></div><span>제휴/광고/부대사업 문의</span><div></div><span>이용약관</span><div></div><span>개인정보 처리방침</span><div></div><span>고객센터</span>
</div>
<div class="addr">
서울특별시 강남구 테헤란로14길 6 남도빌딩 2F, 3F, 4F, 5F  <br />
대표자명 MVCINEMA | 개인정보보호 책임자 경영지원실에 없다 왜 <br />
사업자등록번호 211-86-45678 | 통신판매업신고번호 제 345호<br />
Copyright© 김률민, 김회진, 허경희, 고현영, 김희운
</div>

</div>
