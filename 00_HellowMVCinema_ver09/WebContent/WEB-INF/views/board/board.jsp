<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.List, com.cinema.*" %>
    <%
    	/* List<Local> localList = (List<Local>)request.getAttribute("localList");
    	List<Theater> theaterList = (List<Theater>)request.getAttribute("theaterList"); */
    	int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			//cPage 파라미터가 값이 없거나, 부정 입력된 경우 대비 
			cPage=1;
		}
    %>  
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
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
		position: absolute;
		top : 5%;
		left : 10%;
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
	img{
		width: 250px;
		height: 300px;
	}
	div.div-inline{
		display: inline;
	}  
</style>
</head>
<body>

	<h2>고객센터</h2>
	<div class='tab' id='noticeList'>공지사항</div>
	<div class='tab' id='eventList'>이벤트</div>
	
	<!-- 공지사항 등록 폼 -->
	<div id="div-notice-enroll" class='div-enroll'>
		<span class="close">&times;</span>
		<form action="<%=request.getContextPath()%>/board/boardEnroll" method='post' enctype="multipart/form-data">
			<input type="hidden" name="type" value='notice' />
			공지사항
			<br />
			제목 : <input type="text" name="title" id="title" />
			<br />
			영화관 지역 정보 : 
			<input type="text" name="local" id="local" />
			<br />
			영화관 지점 정보 : 
			<input type="text" name="theater" id="theater" />
			<br />
			이미지 : <input type="file" name="up_notice_file" />
			<br />
			내용 : <textarea name="content" id="" cols="20" rows="10"></textarea>
			<br />
			<br />
			<input type="submit" value="등록" />
			<input type="reset" value="취소" />
		</form>
	</div>
	
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
						var nhtml = "<input type='button' value='등록' id='btn-notice-enroll'/>";
						var html = "<table id='notice-table'>";
						html += "<tr><th>no</th><th>지역/영화관</th><th>제목</th><th>등록일</th></tr>";
						data.sort(function(a,b){
							return b.bdid-a.bdid;
						});
						var pageBar;
						for(var index in data){
							var i = data[index];
							var d = new Date(i.regdate.replace(/ /gi, "").replace(/[^0-9]/g,"-"));
							html += "<tr>"+ "<td>" + i.bdid + "</td>";
							html += "<td>" + i.tinfo + "</td>";
							html += "<td><a href='<%=request.getContextPath()%>/board/boardDetail?bdid="+i.bdid+"'>" + i.title + "</a></td>";
							html += "<td>" + d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate() + "</td>" +"</tr>";
							pageBar = i.pageBar;
						}
						html += "</table>";
						console.log(pageBar);
						html += "<div id='pageBar'>"+pageBar+"</div>";
						
						$("#boardView").html(nhtml);
						$("div#none").html(html);
						$("#btn-notice-enroll").click(function(){
							$("#div-notice-enroll").css("display","block");
						});//btn-notice-enroll 버튼
						$(".close").click(function(){
							$(".div-enroll").css("display","none");
						});
						$("div#none").on("click","#"+<%=cPage%>, function(){
							pageBar = "<span value='"+<%=cPage-1%>+"'>"+<%=cPage-1%>+"</span><a href=/project/board/boardView?cPage="+<%=cPage%>+" id='"+<%=cPage%>+"'><span value='"+<%=cPage%>+"'>"+<%=cPage%>+"</span></a>";
							var h = "<div id='pageBar'>"+pageBar+"</div>";
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
	
	<!-- 이벤트 등록 폼 -->
	<div id="div-event-enroll" class='div-enroll'>
		<span class="close">&times;</span>
		<form action="<%=request.getContextPath()%>/board/boardEnroll"  method='post' enctype="multipart/form-data">
			<input type="hidden" name="type" value='event' />
			이벤트
			<br />
			제목 : <input type="text" name="title" id="" />
			<br />
			영화관 지역 정보 : 
			<input type="text" name="local" id="local" />
			<br />
			영화관 지점 정보 : 
			<input type="text" name="theater" id="theater" />
			<br />
			이미지 : <input type="file" name="up_event_file" />
			<br />
			내용 : <textarea name="content" id="img" cols="20" rows="10"></textarea>
			<br />
			시작:
			<input type="date" name="startterm" id="startterm" /> 시작이 끝보다 작아야한다.
			<br />
			끝:
			<input type="date" name="endterm" id="endterm" />
			<br />
			<input type="submit" value="등록" id='eventTime'/>
			<input type="reset" value="취소" />
		</form>
	</div>
	
	<!-- 이벤트 팝업창 -->
	<div id="event-popup" class='div-enroll'>
		<span class="close">&times;</span>
		
	</div>
		
	<script>
		var pPage=8;
		var lPage=8;
		$("#eventList").click(function(){
			var html = "<input type='button' value='등록' id='btn-event-enroll'/>";
			html += "<input type='radio' name='event-status' id='present' class='present' checked><label for='present'>진행 중인 이벤트</label>";
			html += "<input type='radio' name='event-status' id='last' class='last'><label for='last'>지난 이벤트</label>";			
			$("#boardView").html(html);
			fn_add_present();
			$("#boardView").on("change","[name=event-status]",function(){
				if(this.id=="present"){
					fn_add_present();	
					lPage=8;
				}
				if(this.id=="last"){
					fn_add_last();	
					pPage=8;
				}
			});
			//등록 버튼을 누르면 팝업창이 나옴.
			$("#boardView").on("click","#btn-event-enroll", function(){
				$("#div-event-enroll").css("display","block");
			});
			
			//등록 팝업창의 닫기 버튼
			$(".div-enroll").on("click",".close", function(){
				$(".div-enroll").css("display","none");
				$(".div-enroll input").val("");
			});
			
			//이벤트 등록 시작시간과 끝시간의 잘못된 설정을 막아준다.
			$("#eventTime").click(function(){
				var startterm = $("#startterm").val().split("-");
				var endterm = $("#endterm").val().split("-");
				
				//2018-5-12 ~ 2018-4-18과 같이 시간을 잘못 설정할 경우
				if(startterm[0]*1+startterm[1]/12>endterm[0]*1+endterm[1]/12){	//2018*(월/12)의 값이 시작시간이 클 경우
					alert("이벤트 기간 설정을 잘못 했습니다.");
					return false;
				}else if((startterm[0]*1+startterm[1]/12==endterm[0]*1+endterm[1]/12) && startterm[2]>endterm[2]){//2018*(월/12)의 값이 시작과 끝 시간이 같으면서 시작 일수가 클 경우
					alert("이벤트 기간 설정을 잘못 했습니다.");
					return false;
				}else{
					alert("이벤트가 등록되었습니다.");
					return true;
				}
			});	
			
		});
		
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
						if(presentEventCnt%4==3){
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
							pPage += 8;
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
								html += "<form action='<%=request.getContextPath()%>/board/boardEnroll' method='post' enctype='multipart/form-data' >";
								html += "<input type='hidden' name='type' value='updateEvent'>";
								html += "<input type='hidden' name='bdid' value='"+b.bdid+"'>"
								html += "<input type='hidden' name='old_file' value='"+b.img+"'>";
								html += "<span class='close'>&times;</span><br/>";
								html += "<h3 class='event-popup'>"+b.title+"</h3>";
								html += "<p class='update-event'>제목 : </p><input type='text' class='update-event' name='title' value='"+b.title+"'/>" ;
								html += "<p class='event-popup'>"+dsYear + "-" + dsMonth + "-" + dsDate + " ~ "  + deYear + "-" + deMonth + "-" + deDate+"</p><br/>";
								html += "<p class='update-event'>제목 : </p><input type=date class='update-event' name='startterm' value='"+dsYear + "-" + dsMonth + "-" + dsDate + "'><p class='update-event'>~</p><input type=date class='update-event' name='endterm' value='"  + deYear + "-" + deMonth + "-" + deDate+"' ><br class='update-event'/>";
								html += "<input type='button' value='수정' class='event-popup' ><hr class='event-popup'><br>";
								html += "<input type='submit' value='수정' class='update-event'><hr class='update-event'><br>";
								html += "<img src='<%=request.getContextPath()%>/upload/board/"+ b.img +"'/ class='event-popup'>";								
								html += "<input type='file' name='up-notice-file' class='update-event' />";								
								html += "</form>";
							}
						}
						$("#event-popup").html(html);
						$("#event-popup").on("click","input[type=button]",function(){
							console.log("확인");
							$(".event-popup").css("display","none");
							$(".update-event").css("display","inline-block");
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
						if(endEventCnt%4==3){
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
							lPage += 8;
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
								html += "<form action='<%=request.getContextPath()%>/board/boardEnroll' method='post' enctype='multipart/form-data' >";
								html += "<input type='hidden' name='type' value='updateEvent'>";
								html += "<input type='hidden' name='bdid' value='"+b.bdid+"'>"
								html += "<input type='hidden' name='old_file' value='"+b.img+"'>";
								html += "<span class='close'>&times;</span><br/>";
								html += "<h3 class='event-popup'>"+b.title+"</h3>";
								html += "<p class='update-event'>제목 : </p><input type='text' class='update-event' name='title' value='"+b.title+"'/>" ;
								html += "<p class='event-popup'>"+dsYear + "-" + dsMonth + "-" + dsDate + " ~ "  + deYear + "-" + deMonth + "-" + deDate+"</p><br/>";
								html += "<p class='update-event'>제목 : </p><input type=date class='update-event' name='startterm' value='"+dsYear + "-" + dsMonth + "-" + dsDate + "'><p class='update-event'>~</p><input type=date class='update-event' name='endterm' value='"  + deYear + "-" + deMonth + "-" + deDate+"' ><br class='update-event'/>";
								html += "<input type='button' value='수정' class='event-popup' ><hr class='event-popup'><br>";
								html += "<input type='submit' value='수정' class='update-event'><hr class='update-event'><br>";
								html += "<img src='<%=request.getContextPath()%>/upload/board/"+ b.img +"'/ class='event-popup'>";								
								html += "<input type='file' name='up-notice-file' class='update-event' />";								
								html += "</form>";
							}
						}
						$("#event-popup").html(html);
						$("#event-popup").on("click","input[type=button]",function(){
							console.log("확인");
							$(".event-popup").css("display","none");
							$(".update-event").css("display","inline-block");
						});
						
					});
					
				},
				error : function(){
					console.log("ajax처리 실패");
				}
			});
		}
		

	</script>
	
</body>
</html>