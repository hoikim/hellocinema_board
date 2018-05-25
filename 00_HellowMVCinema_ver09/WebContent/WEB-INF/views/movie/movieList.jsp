<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.cinema.movie.model.vo.*"%>

<% 
	List<Movie> mlist = (List<Movie>)request.getAttribute("mlist"); 
	String pageBar = (String)request.getAttribute("pageBar");
%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
 
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
#cinema_container *{box-sizing: border-box; outline:none;}
#cinema_container{background:#fff; padding:0px;}
#cinema_container table{border-collapse: collapse; padding:0p; border-top:3px solid #503396; width:100%}
#cinema_container table th, #cinema_container table td{padding:10px; border-bottom:1px solid #ccc; }
#cinema_container th{background:#ececec; text-align:left;}
#cinema_container table th{width:13%;}
#cinema_container input{padding:10px; width:100%;}
#cinema_container input[type='button']{background:#ddd; border:none;}

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
</style>
<section id="cinema_container">
 
<div>
	<ul class="movie_list">
	</ul>
</div>
<div class="pageBar"></div>
</section>







 

 
	<script>
	var pageNum = 1;
	function fn_showMovieList(pageNum){

		$.ajax({
			url : "/cinema/movie/showMovieList",
			dataType:"json",
			type: "post",
			data : {type : "pagingRequest", cPage : pageNum},
			success:function(data){
			var mitem = "";
			for(var i = 1; i<data.length;  i++){
				dataItem = JSON.stringify(data[i]);
				mitem += "<li class='movie_item'>";
				mitem += "<div class='thumb'><img src='/cinema/upload/movie/"+data[i].poster+"' /></div>";
				mitem += "<div class='movie_infor'>";
				mitem += "<div class='name'><span>"+data[i].grade+"</span> &nbsp; <span>"+data[i].name+"</span></div>";
				mitem += "<div class='movie_btn'>";
				mitem += "<button onclick='fn_showMovieDetail("+data[i].mid+", "+dataItem+");'>상세보기</button>"
				mitem += "<button onclick='fn_showReservationDetail("+data[i].mid+", "+dataItem+");'>예매하기</button>"
				mitem += "</div>"
				mitem += "</div>"		
				mitem += "</li>";
			}
			$(".movie_list").append(mitem);
			
			
			
			var cPage = data[0].cPage;
			var pageBar = data[0].pageBar;
			
			console.log(pageBar);
			$(".pageBar").html("<a href='javascript:void(0);' onclick='fn_showMovieList("+pageNum+")'>다음</a>");
			
			$(".movie_infor span").each(function(){
				if($(this).text().length > 9){
					$(this).text($(this).text().substr(0,9)+"...");
				}
			});
			}
		});	// ajax end
		pageNum++;
	};
	
	
	
	$(function(){
		fn_showMovieList(pageNum);
	});
	</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	