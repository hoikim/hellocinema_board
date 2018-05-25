<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>

<% 
	List<Movie> mlist = (List<Movie>)request.getAttribute("mlist"); 
	String pageBar = (String)request.getAttribute("pageBar");
%>

<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>



 
<style>
*{padding:0px; margin:0px; }
.table_common{border-collapse: collapse;}
.table_common th, .table_common td{border:1px solid #ececec; padding:10px; font-size:12px;}
.mid{width:50px;}
.name{width:300px;}
.ename{width:200px;}
.director{width:100px;}
.grade{width:50px;}
.actor{width:100px;}
.genre{width:80px;}


#cinema_container *{box-sizing: border-box; outline:none; }
#cinema_container{background:#fff; padding:0px;   /*border-top:3px solid #1986ff; */}
#cinema_container{overflow:hidden;}
#cinema_container table{float:left; border-collapse: collapse; padding:0p;  width:50%; }
#cinema_container table th, #cinema_container table td{padding:10px; border:none;}
#cinema_container th{  text-align:left;}
#cinema_container table th{width:25% }
#cinema_container input{padding:10px; width:100%;}
#cinema_container input[type='button']{background:#ddd; border:none;}

#cinema_container tr:nth-child(even) {
    background-color: #fafafa;
}
#cinema_container tr:nth-child(odd) {
    background-color: #fff;
}
#cinema_container table .birth_tr td{padding:10px 0px;}
#cinema_container table .birth_tr td input{text-align:center;}
#cinema_container table .birth_tr .birth{width:80px; padding:10px;}
#cinema_container table .birth_tr td:first-of-type{padding-right:0px;}
#cinema_container table .birth_tr td:nth-of-type(3){padding:10px 0px }
#cinema_container table .birth_tr td:nth-of-type(5){padding-left: 0px}


#cinema_container table .phone_tr td{padding:10px 0px; text-align:center;}
#cinema_container table .phone_tr td input{text-align:center;;}
#cinema_container table .phone_tr .phone{width:80px; padding:10px;}
#cinema_container table .phone_tr td:first-of-type{padding-right:0px; width:90px;}
#cinema_container table .phone_tr td:nth-of-type(3){padding:10px 0px; }
#cinema_container table .phone_tr td:nth-of-type(5){padding-left: 0px}

.submit_tr button{ background :#503396; border:none; padding:20px; color:#fff; font-size:18px;}
.submit_tr .cancle_btn{background:#ddd; color:#898989;}
.submit_btn{ background :#503396; border:none; padding:20px; color:#fff; font-size:18px;}


.table_copy_wrap{overflow-y:scroll; height:950px;}
#cinema_container .table_copy_wrap table{width:100%;}

.movies_ul{overflow:hidden;position:relative; height:100%; padding:20px;}
.movies{}
.movies{padding:10px; float:left; margin-bottom:10px;}
.movies{width:50%; height:340px}
.movies img{width:100%;}
.newMovies{}
.newMovies div{border:3px dotted #ececec;  text-align:center; padding:130px 0px;  }
.newMovies div:hover{border:3px dotted #1986ff;}
</style>



<section id="cinema_container">
		<table>
			<tr>
				<th>영화명</th>
				<td colspan="6"><input type="hidden" name="mid"  value ="" /><input type="text" name="name"  value ="영화제목" /> </td>
			</tr>		
			<tr>
				<th>영문명</th>
				<td colspan="6"><input type="text" name="ename" value ="English_name"           /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>영화등급</th>                                            
				<td colspan="6"><input type="text" name="grade" value ="15세이상"          /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>러닝타임</th>                                            
				<td colspan="6"><input type="text" name="time"   value ="160"         /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>개봉일자</th>                                            
				<td colspan="6"><input type="text" name="reldate" /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>장르</th>                                              
				<td colspan="6"><input type="text" name="genre"    value ="액션"        /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>연기자</th>                                             
				<td colspan="6"><input type="text" name="actor"    value ="연기자들"        /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>감독</th>                                              
				<td colspan="6"><input type="text" name="director"   value ="감독"         /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>스토리</th>                                             
				<td colspan="6"><input type="text" name="story"      value ="스토리"      /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>포스터</th>                                             
				<td colspan="6"><input type="file" name="poster"  id="file"          /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>서브이미지</th>                                           
				<td colspan="6"><input type="file" name="subimg"  id="subimg"      /> </td>
			</tr>		                                                 
			<tr>                                                         
				<th>예고편</th>                                             
				<td colspan="6"><input type="text" name="trailer"     value ="예고편"      /> </td>
			</tr>		
		 
				
			<tr class="submit_tr">
				<td colspan="9" style="text-align:center">
					<button id="delMovie">삭제하기</button>
					<button class="cancle_btn">취소하기</button>
					<button id="moviemultipart">등록하기</button>
				</td>
			
			</tr>
		</table>
		<div class="table_copy_wrap">
			<table class="table_copy">

			</table>
		</div>
</section>





















<div>
	<ul class="movie_list">
		<%
			if(mlist==null || mlist.isEmpty()){
		%>
		<% }else{		
			for(Movie m : mlist){
		%>	
		<li class="movie_item">
			<div class="thumb">
			</div>
			<div class="movie_infor">
				<div class="">
					<span class="movie_title"><%= m.getName() %></span>
				</div>
				<div class="movie_btn">
					<button>상세보기</button>
					<button>예매하기</button>
				</div>
			</div>		
		</li>
	
				<%}
		}%>
	</ul>
</div>



	<table class="table_common"  style="display:none;">
		<tr>
			<th class="mid">영화코드</th>
			<th class="name">제목</th>
			<th class="ename">영문제목</th>
			<th class="grade">연령</th>
			<th class="time">시간</th>
			<th class="director">감독</th>
			<th class="actor">출연진</th>
			<th class="genre">장르</th>
			<th class="story">스토리</th>
			<th class="reldate">개봉일</th>	
			<th class="poster">포스트</th>	
			<th class="subimg">서브이미지</th>	
			<th class="trailer">트레일러</th>	
			<th class="regdate">등록일자</th>	
		</tr>
	</table>
	<script>
	
	$(function(){
		
		//글자수 처리
		$(".movie_title").each(function(){
			if($(this).text().length > 10){
				$(this).text($(this).text().substr(0,10)+"...");
			}
		});
	});
		
 
	
	
	  $(function() {
/* 		    $("[name=reldate]").datepicker();
		    $("[name=reldate]").datepicker( "option", "dateFormat", "yy/mm/dd"); */
  		    $("[name=reldate]").datepicker();
		    $("[name=reldate]").datepicker( "option", "dateFormat", "yy/mm/dd");
		    
		   /* 
 		    jQuery("[name=reldate]").datetimepicker();
		    jQuery("[name=reldate]").datetimepicker({ 
		    	  format : 'Y/m/d H:i',
		    	  //format : 'Y,m,d,H,i',
		    	  formatDate:'y,m,d,H,i',
		    	  inline:false,
		    	  lang:'ko'}); */
	  });
	
	
	</script>
	
	
	
	<script>



$("#delMovie").click(function(){
	var mid = $("[name=mid]").val();
	$.ajax({
		url : "/cinema/manager/movie",
		data : {type : "delMovie" , mid : mid},
		type : 'POST',
		sucess : function(data){

		}
})		.done(function(){
		location.href='/cinema/manager/movie';
	})

	
	
});

$("#moviemultipart").click(function(){
	
	var type = "";
	var data = new FormData();

	
	var mid = $("[name=mid]").val();
	var name = $("[name=name]").val();
	var ename = $("[name=ename]").val();
	var grade = $("[name=grade]").val();
	var time = $("[name=time]").val();
	var mtype = $("[name=mtype]").val();
	var reldate =  $("[name=reldate]").val();
	
	
	var prddate = $("[name=prddate]").val();
	var genre = $("[name=genre]").val();
	var actor = $("[name=actor]").val();
	var director = $("[name=director]").val();
	var staff = $("[name=staff]").val();
	var story = $("[name=story]").val();
	var trailer = $("[name=trailer]").val();
	
	
	data.append('file', document.getElementById("file").files[0]);
	data.append('subfile', document.getElementById("subimg").files[0]);
	if(mid.length>0){
		data.append('mid', mid);
	};
	data.append('name', name);
	data.append('ename', ename);	
	data.append('grade', grade);	
	data.append('time', time);	
	data.append('mtype', mtype);	
	data.append('reldate', reldate);	
	data.append('prddate', prddate);	
	data.append('genre', genre);	
	data.append('actor', actor);	
	data.append('staff', staff);	
	data.append('story', story);	
	data.append('director', director);	
	data.append('trailer', trailer);	
	
	
	$.ajax({
		url : "/cinema/manager/moviemultipart",
		data : data,
		cache : false,
		contentType : false,
		processData : false, 
		dataType : "json",
		type : 'POST',
		sucess : function(data){
			
			}
		})
		.done(function(){
			location.href='/cinema/manager/movie';
		})
	
		
	
});

function fn_showMovieList(){
	
	
	
	$.ajax({
		url : "/cinema/movie.do",
		dataType:"json",
		type: "post",
		success:function(data){
	console.log(data);
		var mitem = "";
		var movieCopie = "<ul class='movies_ul'>";
			movieCopie += "<li class='movies newMovies'><div>신규등록</div></li>";
		for(i in data){
			mitem += "<tr>";
			mitem += "<td>" + data[i].mid    + "</td>";
			mitem += "<td>" + data[i].name      + "</td>";
			mitem += "<td>" + data[i].ename     + "</td>";
			mitem += "<td>" + data[i].grade       + "</td>";
			mitem += "<td>" + data[i].time      + "</td>";
			mitem += "<td>" + data[i].director       + "</td>";
			mitem += "<td>" + data[i].actor       + "</td>";
			mitem += "<td>" + data[i].genre       + "</td>";
			mitem += "<td>" + data[i].story       + "</td>";
			mitem += "<td>" + data[i].reldate      + "</td>";
			mitem += "<td>" + data[i].poster       + "</td>";
			mitem += "<td>" + data[i].subimg      + "</td>";
			mitem += "<td>" + data[i].trailer      + "</td>";
			mitem += "<td>" + data[i].regdate      + "</td>";
			mitem += "</tr>";
			
			movieCopie += "<li class='movies'>";
			movieCopie += "<div><img src=/cinema/upload/movie/"+data[i].poster+ " /></div>"
			movieCopie += "<div><span class='mmid'>" +data[i].mid+"</span><span>" +data[i].name+ "</span>";
			movieCopie += "<div>"+data[i].ename+"</div>";
			movieCopie += "</li>";
		}
		movieCopie += "</ul>";
		//$(".table_common").append(mitem);
		$(".table_copy").append(movieCopie);
		
		$(".movies").eq(0).click(function(){
			
			$("input").val("");
		});
		$(".movies").not(":eq(0)").click(function(){
			var mid = $(this).find(".mmid").text();
			var rmid 		= $("[name=mid]");
			var name 		= $("[name=name]");
			var ename 		= $("[name=ename]");
			var grade 		= $("[name=grade]");
			var time 		= $("[name=time]");
			var mtype 		= $("[name=mtype]");
			var reldate 	= $("[name=reldate]");
			var prddate 	= $("[name=prddate]");
			var genre 		= $("[name=genre]");
			var actor 		= $("[name=actor]");
			var staff 		= $("[name=staff]");
			var story 		= $("[name=story]");
			var director 	= $("[name=director]");
			var trailer 	= $("[name=trailer]");
				$.ajax({
					url : "/cinema/movie/movieDetail",
					dataType:"json",
					type : "post",
					data : {mid : mid}, 
					success:function(data){
						rmid.val(data.mid);
						name.val(data.name); 	
						ename.val(data.ename); 	
						grade.val(data.grade); 	
						time.val(data.runtime); 	
						mtype.val(data.mtype); 	
						reldate.val(data.reldate); 
						prddate.val(data.prddate); 
						genre.val(data.genre); 	
						actor.val(data.actor); 	
						director.val(data.director);
						staff.val(data.staff); 	
						story.val(data.story); 	
						trailer.val(data.trailer); 
					}
				});
			
		});
		
		
		
		
		}
	});	// ajax end 
};

fn_showMovieList();



</script>
	
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	