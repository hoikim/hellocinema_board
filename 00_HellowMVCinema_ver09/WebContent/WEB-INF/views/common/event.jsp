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
		width: 232px;
		height: 334px;
	}
	div.div-inline{
		display: inline-block;
	}  
</style>



<div class="wrap jwrap">
	
	<!-- 공지사항 -->
	<div id="boardView"></div>
	<div id="none"></div>
	<script>

	</script>
	
	<!-- 이벤트 팝업창 -->
	<div id="event-popup" class='div-enroll'>
		<span class="close"></span>
		
	</div>
	
	<script>
		var pPage=8;
		var lPage=8;
		$("#eventList").click(function(){
			fn_showEventTab();
		});
		
		
		function fn_showEventTab(){
			var html = "";
			
			html += "<div class='button_tab'>";
			html += "<span class='checked' id='present'>진행중 이벤트 </span><div></div> ";
			html += "<span id='last'>종료된 이벤트 </span>";
			
			$("#boardView").html(html);
			fn_add_present();
			$("#boardView").on("click",".button_tab span",function(){
				$(".button_tab span").removeClass("checked");
				if(this.id=="present"){
					$(this).addClass("checked");
					fn_add_present();	
					lPage=8;
				}
				if(this.id=="last"){
					$(this).addClass("checked");
					fn_add_last();	
					pPage=8;
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
					console.log(data);
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
						phtml += "<div class='jtable' id="+i.bdid+">";
						phtml += "<div class='thumb'>"+ "<img id='clickEvent' src='<%=request.getContextPath()%>/upload/board/"+ i.img +"' / >" + "</div>";
						phtml += "<div class='jtitle'> "+ i.title + "</div>";
						phtml += "<div class='jdate'>" + ds.getFullYear() + "-" + (ds.getMonth()+1) + "-" + ds.getDate() + " ~ "  + de.getFullYear() + "-" + (de.getMonth()+1) + "-" + de.getDate()+"</div>";
						phtml += "</div>";
						phtml += "</div>"
						if(presentEventCnt%3==2){
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
							pPage += 8;
							fn_add_present();							
						}
					});
					
					//on 동적으로 부모의 자식이벤트를 달아준다. //단, 부모는 동적으로 생성되면 안된다.
					//현재 진행중인 이벤트, 지난 이벤트의  수정 팝업창
					$("div#none").on("click",".jtable", function(){
						$("#event-popup").css("display","block");
						console.log(this.id);
						var html="";
						for(var a in data){
							console.log(b);
							
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
								
								html += "<div class='jevent_wrap'>";
								html += "<input type='hidden' name='bdid' value='"+b.bdid+"'>"
								html += "<input type='hidden' name='old_file' value='"+b.img+"'>";
								html += "<span class='close'></span><br/>";
								html += "<h3>"+b.title+"</h3>";
								html += "<p class='jdate'>"+dsYear + "-" + dsMonth + "-" + dsDate + " ~ "  + deYear + "-" + deMonth + "-" + deDate+"</p> ";
								html += "<img src='<%=request.getContextPath()%>/upload/board/"+ b.img +"'/>";								
								html += "<div class='jcontent'>" + i.content+ "</div>";								
								html += "</div>";
								html += "<div class='jbackgboard'></div>";								
							}
						}
						console.log(html);
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
						lhtml += "<div class='jtable' id="+i.bdid+">";
						lhtml += "<div class='thumb'>"+ "<img id='clickEvent' src='<%=request.getContextPath()%>/upload/board/"+ i.img +"' / >" + "</div>";
						lhtml += "<div class='jtitle'> "+ i.title + "</div>";
						lhtml += "<div class='jdate'>" + ds.getFullYear() + "-" + (ds.getMonth()+1) + "-" + ds.getDate() + " ~ "  + de.getFullYear() + "-" + (de.getMonth()+1) + "-" + de.getDate() +"</div>";
						lhtml += "</div>";
						lhtml += "</div>"
		 
						
						
						if(endEventCnt%3==2){
							//lhtml += "</br>";
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
							lPage += 8;
							fn_add_last();							
						}
					});
					
					//on 동적으로 부모의 자식이벤트를 달아준다. //단, 부모는 동적으로 생성되면 안된다.
					//현재 진행중인 이벤트, 지난 이벤트의  수정 팝업창
					$("div#none").on("click",".jtable", function(){
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
								
								
								
								html += "<div class='jevent_wrap'>";
								html += "<input type='hidden' name='type' value='updateEvent'>";
								html += "<input type='hidden' name='bdid' value='"+b.bdid+"'>"
								html += "<input type='hidden' name='old_file' value='"+b.img+"'>";
								html += "<span class='close'></span><br/>";
								html += "<h3>"+b.title+"</h3>";
								html += "<p class='jdate'>"+dsYear + "-" + dsMonth + "-" + dsDate + " ~ "  + deYear + "-" + deMonth + "-" + deDate+"</p> ";
								html += "<img src='<%=request.getContextPath()%>/upload/board/"+ b.img +"'/>";								
								html += "</div>";
								html += "<div class='jbackgboard'></div>";	
								
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
		
		$(function(){
			fn_add_present();
			fn_showEventTab();
		});

	</script>
<style>
.div-inline{margin-right:12px; margin-bottom:12px; cursor:pointer; }
#notice-table{width:100%;}
.jwrap .thumb{background:#fff;}
.jtable{border: 1px solid #ececec;}
.jwrap .jtitle{padding:10px 10px 0px 10px; font-size:18px; }
.jwrap .jdate{ padding:10px; font-size:12px; color:#999; }
div.div-enroll{
	position: fixed;
	top : 0;
	left : 0;
	width:100%; 
	height:100%;
	display: none;
	
}
.div-enroll .jevent_wrap{position:relative; background:#fff; width:500px; margin:0 auto; padding:20px; top:60px; z-index:100; border-top:3px solid #1986ff;}
.div-enroll .jevent_wrap .close{width:40px; height:50px; display:inline-block; overflow:hidden;   position:relative; float:right;}

.div-enroll .jevent_wrap .close:after{content:""; position:absolute; border-top:1px solid #333; width:50px; transform : rotate(45deg); transform-origin: 0% 0%; top:0px; left:0px; }
.div-enroll .jevent_wrap .close:before{content:""; position:absolute; border-top:1px solid #333; width:50px; transform : rotate(-45deg); transform-origin: 0% 0%; bottom:13px; left:0px; }

.jbackgboard{position:absolute;; width:100%; height:100%; background:#000; opacity: 0.5; z-index:50; top:0; left:0;}
.jcontent{margin-top:10px;}
#event-popup .jdate{padding:10px 0px 20px 0px; border-bottom:1px solid #e0e0e0; margin-bottom:10px; }

.button_tab{padding:10px;}
.button_tab div{display:inline-block; height:10px; border-right:1px solid #e0e0e0;}
.button_tab span{ display:inline-block; padding:10px; cursor:pointer; font-size:12px; color:#333; }
.button_tab span:hover{color:#1985ff;}

.button_tab .checked{font-weight:bold; color:#1985ff;}
#add-present{ width:100%; background:#ececec; border:none; margin-bottom:10px; }
</style>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
