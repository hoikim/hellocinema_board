<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ page import = "java.util.List, com.cinema.admin.model.vo.Local" %>
    <%
    	int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			//cPage 파라미터가 값이 없거나, 부정 입력된 경우 대비 
			cPage=1;
		}
    %>  
<div style="background:#0E1B45;"><div class="wrap"><img src="/cinema/data/bean.jpg"  width=100%/></div></div>
<%@ include file="/WEB-INF/views/common/header_non_wrap.jsp" %>

<style>
	.title_wrap{background:black; }
	.title_wrap div{height:300px; width:100%; overflow:hidden; background : url("/cinema/data/special.jpg") no-repeat no-repeat center center}
</style>

<div class="title_wrap">
	<div></div>
</div>


<style>
	th, td, tr{
		border: 1px solid black;
	}
	div.tab{
		border: 1px solid black;
		display: inline;
	}
	body{
		position: relative;
		top : 0;
		left : 0;
	}
	div.div-enroll{
		border: 1px solid black;
		position: fixed;
		top : 10%;
		left : 40%;
		width: 500px;
		display: none;
		background: white;
	}
	table{
		display: inline;
	}
	table#notice-table{
		display : block;
	}
	.update-event{
		display: none;
	}
	.jwrap img{
		width: 250px;
		height: 300px;
	}
	div.div-inline{
		display: inline;
	}  
</style>



<div class="wrap jwrap">
	<div class='tab' id='noticeList'>공지사항</div>
	<div class='tab' id='eventList'>이벤트</div>
	
	<!-- 공지사항 -->
	<div id="boardView"></div>
	<div id="none"></div>
	<script>
		//페이지 로드시, noticeList 버튼 클릭
		window.onload = pageLoad;
	    function pageLoad(){
	    	document.getElementById("noticeList").click();
	    };
		$(function(){
			//공지사항 탭
			$("#noticeList").click(function(){
				var noticeType = this.id;
				//$("div#none").css("display","none");
				$.ajax({
					url : "<%=request.getContextPath()%>/board/boardAjax1.do",
					data : {listType : noticeType, cPage : <%=cPage%>},
					type : "post",
					dataType : "json",
					success : function(data){
						console.log(data);
						var nhtml = "";
						var html = "<table id='notice-table'>";
						html += "<tr><th>no</th><th>지역/영화관</th><th>제목</th><th>등록일</th></tr>";
						data.sort(function(a,b){
							return b.bdid-a.bdid;
						});
						var pageBar="";
						for(var index in data){
							var i = data[index];
							var d = new Date(i.regdate.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
							html += "<tr>"+ "<td>" + i.bdid + "</td>";
							html += "<td>" + i.tinfo + "</td>";
							html += "<td> <a href='<%=request.getContextPath()%>/board/boardDetail?bdid="+i.bdid+"'>" + (i.title==null?"제목없음":i.title) + "</a></td>";
							html += "<td>" + d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate() + "</td>" +"</tr>";
							pageBar = i.pageBar;
						}
						html += "</table>";
						console.log(pageBar);
						html += "<div id='pageBar'>"+pageBar+"</div>";
						
						$("#boardView").html(nhtml);
						$("div#none").html(html);
						
						$("div#none").on("click","#"+<%=cPage%>, function(){
							pageBar = "<span value='"+<%=cPage-1%>+"'>"+<%=cPage-1%>+"</span><a href=/project/board/boardView?cPage="+<%=cPage%>+" id='"+<%=cPage%>+"'><span value='"+<%=cPage%>+"'>"+<%=cPage%>+"</span></a>";
							var h="<div id='pageBar'>"+pageBar+"</div>";								
							
							$("div#none").append(h);
						});
						
						
					},
					error : function(){
						console.log("ajax처리 실패");
					}
				});//ajax
			});//notice 버튼
		});//function
	</script>
	
	<!-- 이벤트 팝업창 -->
	<div id="event-popup" class='div-enroll'>
		<span class="close">&times;</span>
		
	</div>
	
	<script>
		var pPage=6;
		var lPage=6;
		$("#eventList").click(function(){
			fn_showEventTab();
		});
		
		
		function fn_showEventTab(){
			var html = "";
			html += "<input type='radio' name='event-status' id='present' class='present' checked><label for='present'>진행 중인 이벤트</label>";
			html += "<input type='radio' name='event-status' id='last' class='last'><label for='last'>지난 이벤트</label>";			
			$("#boardView").html(html);
			fn_add_present();
			$("#boardView").on("change","[name=event-status]",function(){
				if(this.id=="present"){
					fn_add_present();	
					lPage=6;
				}
				if(this.id=="last"){
					fn_add_last();	
					pPage=6;
				}
			});
		}
		
		
		function fn_add_present(){
			$.ajax({
				url : "<%=request.getContextPath()%>/board/boardAjax1.do",
				data : {listType : "eventList", status: "present", pPage: pPage},
				type : "post",
				dataType : "json",
				success : function(data){
					var phtml="";
					var presentEventCnt=0;
					data.sort(function(a,b){
						return a.order-b.order;
					});
					
					for(var index in data){
						var i = data[index];
						var d = new Date();
						var ds = new Date(i.startterm.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
						var de = new Date(i.endterm.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
						//끝나는 시간이 현재 시간보다 크거나 같으면 현재 진행중인 이벤트
						phtml += "<div class='div-inline' id='eventp"+presentEventCnt+"'>"
						phtml += "<table class='table' id="+i.bdid+">";
						phtml += "<tr><td>"+ "<img id='clickEvent' src='<%=request.getContextPath()%>/upload/board/"+ i.img +"' / >" + "</td></tr>";
						phtml += "<tr><td> "+ i.title + "</td></tr>";
						phtml += "<tr><td>" + ds.getFullYear() + "-" + (ds.getMonth()+1) + "-" + ds.getDate() + " ~ "  + de.getFullYear() + "-" + (de.getMonth()+1) + "-" + de.getDate()+"</td></tr>";
						phtml += "</table>";
						phtml += "</div>"
						if(presentEventCnt%3==2){
							phtml += "</br>";
						}
						if(presentEventCnt==(pPage-1)){
							phtml += "<input type='button' id='add-present' value='더보기'>";		
							phtml += "</br>";
						}
							
							presentEventCnt++;
					}
					$("div#none").html(phtml);
					
					//지난 이벤트의 더보기 버튼
					$("div#none").on("click","#add-present",function(){
						$(this).css("display","none");
						if(presentEventCnt==pPage){
							pPage += 6;
							fn_add_present();							
						}
					});
					
					//on 동적으로 부모의 자식이벤트를 달아준다. //단, 부모는 동적으로 생성되면 안된다.
					//현재 진행중인 이벤트, 지난 이벤트의  수정 팝업창
					$("div#none").on("click","table.table", function(){
						$("#event-popup").css("display","block");
						console.log(this.id);
						var html="";
						for(var a in data){
							var b = data[a];
							if(b.bdid==this.id){
								console.log(b.bdid);
								var ds = new Date(b.startterm.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
								var de = new Date(b.endterm.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
								var dsYear = ds.getFullYear();
								var dsMonth = ds.getMonth()+1;
								var dsDate = ds.getDate();
								var deYear = de.getFullYear();
								var deMonth = de.getMonth()+1;
								var deDate = de.getDate();
								
								if(dsMonth<10){
									dsMonth = "0"+dsMonth;
								}
								if(dsDate<10){
									dsDate = "0"+dsDate
								}
								if(deMonth<10){
									deMonth = "0"+deMonth;
								}
								if(deDate<10){
									deDate = "0"+deDate
								}
								html += "<input type='hidden' name='bdid' value='"+b.bdid+"'>"
								html += "<input type='hidden' name='old_file' value='"+b.img+"'>";
								html += "<span class='close'>&times;</span><br/>";
								html += "<h3>"+b.title+"</h3>";
								html += "<p>"+dsYear + "-" + dsMonth + "-" + dsDate + " ~ "  + deYear + "-" + deMonth + "-" + deDate+"</p><br/>";
								html += "<hr><br>";
								html += "<img src='<%=request.getContextPath()%>/upload/board/"+ b.img +"'/>";								
							}
						}
						$("#event-popup").html(html);
						$("#event-popup").on("click",".close",function(){
							$("#event-popup").css("display","none");
						});
						
					});
					
					
				},
				error : function(){
					console.log("ajax처리 실패");
				}
			});
		}
		function fn_add_last(){
			$.ajax({
				url : "<%=request.getContextPath()%>/board/boardAjax1.do",
				data : {listType : "eventList", status: "last", lPage: lPage},
				type : "post",
				dataType : "json",
				success : function(data){
					var endEventCnt=0;
					var lhtml="";
					data.sort(function(a,b){
						return a.order-b.order;
					});
					console.log(data);
					for(var index in data){
						var i = data[index];
						var ds = new Date(i.startterm.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
						var de = new Date(i.endterm.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
						
						lhtml += "<div class='div-inline' id='eventl"+endEventCnt+"'>"
						lhtml += "<table class='table' id="+i.bdid+">";
						lhtml += "<tr><td>"+ "<img id='clickEvent' src='<%=request.getContextPath()%>/upload/board/"+ i.img +"'/ >" + "</td></tr>";
						lhtml += "<tr><td>" + i.title + "</td></tr>";
						lhtml += "<tr><td>" + ds.getFullYear() + "-" + (ds.getMonth()+1) + "-" + ds.getDate() + " ~ "  + de.getFullYear() + "-" + (de.getMonth()+1) + "-" + de.getDate() +"</td>"+"</tr>";
						lhtml += "</table>";
						lhtml += "</div>"
						if(endEventCnt%3==2){
							lhtml += "</br>";
						}
						if(endEventCnt==(lPage-1)){
							console.log(endEventCnt+"???");
							lhtml += "<input type='button' id='add-last' value='더보기'>";		
							lhtml += "</br>";
						}
					
						endEventCnt++;
						
					}
					$("div#none").html(lhtml);
					
					//지난 이벤트의 더보기 버튼
					$("div#none").on("click","#add-last",function(){
						$(this).css("display","none");
						if(endEventCnt==lPage){
							lPage += 6;
							fn_add_last();							
						}
					});
					
					//on 동적으로 부모의 자식이벤트를 달아준다. //단, 부모는 동적으로 생성되면 안된다.
					//현재 진행중인 이벤트, 지난 이벤트의  수정 팝업창
					$("div#none").on("click","table.table", function(){
						$("#event-popup").css("display","block");
						console.log(this.id);
						var html="";
						for(var a in data){
							var b = data[a];
							if(b.bdid==this.id){
								console.log(b.bdid);
								var ds = new Date(b.startterm.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
								var de = new Date(b.endterm.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
								var dsYear = ds.getFullYear();
								var dsMonth = ds.getMonth()+1;
								var dsDate = ds.getDate();
								var deYear = de.getFullYear();
								var deMonth = de.getMonth()+1;
								var deDate = de.getDate();
								
								if(dsMonth<10){
									dsMonth = "0"+dsMonth;
								}
								if(dsDate<10){
									dsDate = "0"+dsDate
								}
								if(deMonth<10){
									deMonth = "0"+deMonth;
								}
								if(deDate<10){
									deDate = "0"+deDate
								}
								html += "<input type='hidden' name='type' value='updateEvent'>";
								html += "<input type='hidden' name='bdid' value='"+b.bdid+"'>"
								html += "<input type='hidden' name='old_file' value='"+b.img+"'>";
								html += "<span class='close'>&times;</span><br/>";
								html += "<h3 class='event-popup'>"+b.title+"</h3>";
								html += "<p class='event-popup'>"+dsYear + "-" + dsMonth + "-" + dsDate + " ~ "  + deYear + "-" + deMonth + "-" + deDate+"</p><br/>";
								html += "<hr class='event-popup'><br>";
								html += "<img src='<%=request.getContextPath()%>/upload/board/"+ b.img +"'/ class='event-popup'>";								
							}
						}
						$("#event-popup").html(html);
						$("#event-popup").on("click",".close",function(){
							$("#event-popup").css("display","none");
						});
						
					});
					
				},
				error : function(){
					console.log("ajax처리 실패");
				}
			});
		}
		

	</script>
<style>
#notice-table{width:100%;}

</style>