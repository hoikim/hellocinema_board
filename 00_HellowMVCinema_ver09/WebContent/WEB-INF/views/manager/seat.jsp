<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/manager_header.jsp" %>
    <%
    
    String localPath = request.getContextPath()+"/manager/local";
    %>
<script src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<style>
table{}
table th{background:#333; color:#fff; padding:20px; font-weight:normal;}
table td input{width:100%; font-size:18px;}
table td button{width:100%;}

#viewSeat{position:relative; overflow:hidden;}
#viewSeat table{border-collapse: separate; border-spacing:1px; float:left;}
#viewSeat .seat{width:60%}
#viewSeat table td{padding:2px 1px; overflow:hidden; position:relative;background:#333; color:#fff; text-align:center; min-width:15px; max-width:15px; height:15px;  cursor:pointer; font-size:11px;}
#viewSeat table td:hover{background:#fff; color:#333}
#viewSeat table .select{background:#333; color:#333; background:#ececec;}
#viewSeat table .select:after{content:""; position:absolute; border-top:2px solid white; width:20px; transform : rotate(45deg); transform-origin: 0% 0%; top:5px; left:5px; }
#viewSeat table .select:before{content:""; position:absolute; border-top:2px solid white; width:20px; transform : rotate(-45deg); transform-origin: 0% 0%; bottom:4px; left:3px; }

#viewSeat table .blank{background:#fff; border:none; padding:0px; margin:-2px;  width:20px; height:21px;  }
#viewSeat table .blank:hover{cursor:default;}
#viewSeat table{}


#sviewSeat{margin-top:100px;}
#sviewSeat table{border-collapse: separate; border-spacing:1px; width:60%}

#sviewSeat table td{padding:2px 1px; overflow:hidden; position:relative;background:#333; color:#fff; text-align:center; min-width:15px; max-width:15px; height:15px;  cursor:pointer; font-size:11px;}
#sviewSeat table .seats:hover{background:#fff; color:#333}
#sviewSeat table .select{background:#333; color:#333; background:#ececec;}
#sviewSeat table .select:after{content:""; position:absolute; border-top:2px solid white; width:20px; transform : rotate(45deg); transform-origin: 0% 0%; top:5px; left:5px; }
#sviewSeat table .select:before{content:""; position:absolute; border-top:2px solid white; width:20px; transform : rotate(-45deg); transform-origin: 0% 0%; bottom:4px; left:3px; }

#sviewSeat table .blank{background:#fff; border:none; padding:0px; margin:-2px;  width:20px; height:15px;  }
#sviewSeat table .blank:hover{cursor:default;}
#sviewSeat table{}
#sviewSeat table .setInfo{background:#ececec; color:#333; margin-right:10px; cursor:default;}


#room{ font-size:25px; padding:10px;}
#viewSeat .seat .setInfo{background:#ececec; color:#333; margin-right:10px; cursor:default;}
.view_pot{padding:10px; height:74px; overflow:hidden; vertical-align:top; display: table;}
.view_pot input{display:inline-block; height:100%; margin:0px; font-size: 15px; width:250px;}
.view_pot{display:inline-block;}

</style>



<div class="view_pot">
<span>관 이름 </span> <input type="text" id="name"/>   <button class="btn_check">확인</button>
</div>
<!-- 
컬럼설정 <input type="number" min=1 max=30 id="colset" />
행설정 <input type="text" min=1 max=30 id="rowset"/>
<button id="setBlank">설정</button> -->
<script>
$(function(){
	
	
})
$("#setBlank").click(function(){
	;
	console.log($("#colset").val());	
	console.log($("#rowset").val());
	
});
</script>



<div id="viewList">
</div>

<div id="viewSeat">
</div>





<select name="" id="room"></select>
<div id="sviewSeat"></div>
업데이트관 이름 <input type="text" id="upname"/>
<button class="btn_update">업데이트</button>
<script>
var list = null;
var rowArr = [5, 16];

var colArr = [5, 20];


function fn_seatList(){
$("#room").empty();
$.ajax({
	url : "<%=seat %>",
	dataType:"json",
	type: "post",
	data : { type : "seatList"},
	success:function(data){
		console.log(data[0].name);
		list = data;
		for(key in data){
			$("#room").append("<option value='"+key+"' sid='"+list[key].sid+"'>"+list[key].name+"</option>");
		}
	}, 	error : function(jqxhr, textStatus, errorThrown){
		console.log("ajax처리실패!!");
		console.log(jqxhr);
		console.log(textStatus);
		console.log(errorThrown);
}, complete : function(){
}

});	

}


$("#room").change(function(){
	fn_getSeatList($(this).val());
	$(this).attr("upval", new Number($(this).val())+1);
	console.log("셀렉티이드"+$(this).find("option:selected").text());
	
	$("#upname").val($(this).find("option:selected").text());
});

///////////////////////////////////////////확인용/////////////////////////////////
function fn_getSeatList(room){
	console.log(list[room].sid);
	shape = list[room].shape;
	shape = shape.split("|");
	var sview = $("#sviewSeat");
	html = "<table class='update_seat'>";
	var j=0;
	var k=0;
	
	
	for(i in shape){
		if(i==0 && i%27==1){
			html +="<tr>";
		}
		if(i!=0 && i%27==0){

			html+="</tr>";
			j=0;
		}
		
		if((shape.length-1) != i){
			if(shape[i].split(",")[0]=="null"){

				html += "<td class='blank'></td>"; 

			}else{
				if( i%27==0){
					html+="<td class='setInfo'>"+abcde[k++]+"</td>";
				}
				html += "<td class='seats' seat='"+shape[i].split(",")[0]+"' variable='"+shape[i].split(",")[1]+"'>"+j+"</td>"; 
				j++;
			}
		}

 	}
 	
	sview.empty();
	sview.append(html);
	fn_checked();
}


function fn_checked(){
		$("#sviewSeat table .seats").each(function(){
			if($(this).attr("variable")!=1){
				$(this).toggleClass("select");
				$(this).text("");
			}
			
		});
}

var abcde = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "N", "M", "O", "P", "Q", "R", "S", "T", "U", "W", "X", "Y", "Z" ];
////////////////////////////////인서트용//////////////////////////////
$(".btn_check").click(function(){
	var seatTotal = new Array();

	var allSeat = $(".seat").find("td");
	var allSeatLength = allSeat.length;
	var seatName = $("#name").val();
	console.log($(".seat").find("td").attr("seat"));
	console.log(allSeatLength);
	
	
	for(var i = 0; i < allSeatLength; i++){
		//if($(".seat td")[i].getAttribute("class") != "blank"){
		if($(".seat td")[i].getAttribute("class") != "setInfo"){
			seatTotal.push($(".seat td")[i].getAttribute("seat") + ","+ $(".seat td")[i].getAttribute("variable"));
		}
		//}
	}
	
	
	$.ajax({
		url : "<%=seat %>",
		dataType:"html",
		type: "post",
		data : { type : "seatSeting" , seatTotal : seatTotal, name : seatName },
		success:function(data){
			console.log(data);
			fn_seatList();
			
		}, 	error : function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
	}, complete : function(){
	}

	});	
	
	
});

////////////////////////////////업데이트용//////////////////////////////
$(".btn_update").click(function(){
	var seatTotal = new Array();

	var allSeat = $(".update_seat").find("td");
	var allSeatLength = allSeat.length;
	var seatName = $("#upname").val();
	console.log($(".update_seat").find("td").attr("seat"));
	console.log(allSeatLength);
	
	
	for(var i = 0; i < allSeatLength; i++){
		//if($(".seat td")[i].getAttribute("class") != "blank"){
		if($(".update_seat td")[i].getAttribute("class") != "setInfo"){
			seatTotal.push($(".update_seat td")[i].getAttribute("seat") + ","+ $(".update_seat td")[i].getAttribute("variable"));
		}
		//}
	}
	
 	$.ajax({
		url : "<%=seat %>",
		dataType:"html",
		type: "post",
		data : { type : "updateSeatSeting" , seatTotal : seatTotal, name : seatName, sid : $("#room").find("option:selected").attr("sid")},
		success:function(data){
			console.log(data);
			fn_seatList();
			
		}, 	error : function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
	}, complete : function(){
	}

	});	 
	
	
});


$(".uploadSeat").click(function(){
	console.log(seatTotal);

	
});


$(function(){
	$(".seat .seats").click(function(){
		$(this).attr("variable", $(this).attr("variable") == 1 ? 0 : 1);
		$(this).toggleClass("select");
		var seatNo= $(this).attr("seat").substring(1,4);
		//console.log(var seatNo= $(this).attr("seat").substring(1,4));
		$(this).text($(this).attr("variable") == 0 ? "" : seatNo);
	});
	
	$("#sviewSeat").on("click",".seats", function(){
		console.log("test");
		$(this).attr("variable", $(this).attr("variable") == 1 ? 0 : 1);
		$(this).toggleClass("select");
		var seatNo= $(this).attr("seat").substring(1,4);
		//console.log(var seatNo= $(this).attr("seat").substring(1,4));
		$(this).text($(this).attr("variable") == 0 ? "" : seatNo);
	});
 
});


//칼럼 로우 설정
$("#setBlank").click(function(){
	var colset = $("#colset").val();
	var rowset = $("#rowset").val();
	console.log(colset.split(","));
	console.log(rowset.split(","));
	
});


//좌석을 그리자~
function fn_initSeat(viewSeat, col, row){
	var col_infor_table = $("#col_info");
	var col_infor_html ="";
	
	var html ="<table class='seat'>";
	
	
	
	for(var i=0; i<row; i++){

		for(var l=0; l<rowArr.length; l++){
			if(i==rowArr[l]){
				html+= "<tr>";

				for(var m =0; m < col+rowArr.length; m++){
					html+="<td class='blank'></td>";
				}
				col_infor_html += "<tr><td class='blank'>"+abcde[i]+"</td></tr>";
				html+="</tr>";
			}
		}
		
		
		html +="<tr>"
		
		for(var j=0; j<col; j++){
			for(var k=0; k<colArr.length; k++){
				if(j==colArr[k]){
					html+= "<td class='blank'></td>";
				}
			}
			if(j==0){
				html+="<td class='setInfo'>"+abcde[i]+" </td>";
				
			}
				html+= "<td class='seats' seat='"+(abcde[i]+j)+"' variable='"+1+"'>"+j+"</td>";		

		}
		html +="</tr>";
		
	 	//col_infor_html += "<tr><td>"+abcde[i]+"</td></tr>";
	}
	
	
	
	viewSeat.append(html);
	col_infor_table.append(col_infor_html);
	
}


var viewSeat = $("#viewSeat");


fn_initSeat(viewSeat, 25, 19);

function fn_delete(localCode, name){
	console.log(name);
	$.ajax({
		url : "<%=localPath %>",
		dataType:"html",
		type: "post",
		data : { type : "delete", localCode : localCode},
		success:function(data){
	 	console.log(data);
		fn_showList();
		}, 	error : function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
	}, complete : function(){
	}

	});	
	
}
 
 
fn_seatList() 
 
 
</script>
</body>
</html>