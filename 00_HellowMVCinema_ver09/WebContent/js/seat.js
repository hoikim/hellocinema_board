var abcde = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "N", "M", "O", "P", "Q", "R", "S", "T", "U", "W", "X", "Y", "Z" ];
var selected;
var tmpSum=0;
var tmpseat;

function fn_SeatWindow(sch){
	$(".showSeat").show();
	
	var html ="";
	
	
	$sp = $(".select_person");
	
	$types = ["일반", "청소년", "어린이", "우대"];
	$types_id = ["adult", "teen", "child", "favor"]
	
	for(var i =0; i< $types.length; i++){
		
		html+="<label for='"+$types[i]+"' >"+$types[i]+"</label>"
		html +="<select name='"+$types[i]+"' id='"+$types_id[i]+"'>";
		
		for(var j=0; j<8; j++){
			html +="<option value='"+j+"'>" + j + "</option>";
		}
		html+="</select>";
	}
	
	var adult=0;
	var teen=0;
	var child=0;
	var favor=0;


	//셀렉트 처리
	$sp.on("change", "select", function(e){
		
		var sum =0;
		for(var i =0; i<$types.length; i++){
			sum += parseInt($(".select_person select").eq(i).val());
			if(sum > 8){
				$(this).find("option:selected").prop("selected", false);
				sum =0;
				return alert("인원 선택은 최대 8명까지 가능합니다.");
			}
			
			$(".cnt").text("0/"+sum);
			tmpSum = sum;
		}
		var type = $(this).attr("id");
		var val = $(this).val();
		if(type=="adult"){
			adult = val;
		}else if(type=="teen"){
			teen = val;
		}else if(type=="child"){
			child = val;
		}else if(type=="favor"){
			favor = val;
		}else{
		}
		console.log(type+" & "+ val);
	});
	
	
	$sp.html(html);
	
	fn_initSeat(sch);
	
}
function fn_showLoginBox(){
$(".loginBox").show();
	
}


function fn_reservation(sch, seat, price, grade){
	
	
	if(fn_checkId() != "null"){
		sch.usid = fn_checkId();
	}else{
		fn_showLoginBox();
		return;
	}
	
	
	
	var nseats = $(".update_seat td");
	
	var nseat = "";
	for(var i=0; i< nseats.length; i++){
			if(nseats.eq(i).attr("class") == "blank"){
				nseat += "null,null|";
			}else if(nseats.eq(i).attr("class") =="setInfo"){
			
			}else{
				nseat += nseats.eq(i).attr("seat")+","+nseats.eq(i).attr("variable")+"|";
			}
	}
	
	console.log(nseat);
	
	sch.seat=nseat;
	
	
	
	sch.adult = $("#adult").val();
	sch.child = $("#child").val();
	sch.teen = $("#teen").val();
	sch.old = $("#favor").val();
	
	sch.seatnum = $(".infor_wrap .seat").text();
	sch.price = $(".infor_wrap .price").text();
	console.log("아이디 포함 확인바꾼다음에");
	console.log(sch);
	
	
	
	var schObj = JSON.stringify(sch);
	$reservation_payment  = "";
	
	$reservation_payment += "<div class='reservation_payment'>";
	$reservation_payment += "<div class='payment_selector'>";
	$reservation_payment += "<h2>결제하기</h2>";
	$reservation_payment += "<input type='radio' id='card' name='payment' value='카드결제' checked> <label for='card'> 카드결제  </label>&nbsp;";
	$reservation_payment += "<input type='radio' id='bill' name='payment' value='카카오페이'>  <label for='bill'> 카카오페이  </label>&nbsp;";
	$reservation_payment += "<input type='radio' id='account' name='payment' value='무통장입금'> <label for='account'> 무통장입금  </label> ";
	$reservation_payment += "<div><button class='' onclick='fn_cancel();'>취소하기</button><button class='' onclick='fn_commit("+schObj+")'>결제하기</button></div>";
			
	$reservation_payment += "</div>";
	$reservation_payment += "</div>";
	$(".reservation_section").append($reservation_payment);
}


function fn_cancel(){
	$(".reservation_section").empty();
	$(".showSeat").hide();
}


function fn_commit(sch){

	
	sch.etc =$("[name=payment]:checked").val();
	
	
	var objData = JSON.stringify(sch);
	//jQuery.ajaxSettings.traditional = true;
	
	
	var arr = $.map(sch, function(el) { return el });
	console.log(arr);
	
	$.ajax({
		url : "/cinema/ticketing",
		dataType:"json",
		type : "post",
		data :{val : arr, obj : objData},
		success:function(data){
		
		
		}
	});
	
	
	
}


function fn_initSeat(sch){
	var shape = sch.seat;
	
	
	shape = shape.split("|");
	var sview = $(".seatWrap");
	var infor = $(".info_section");
	html = "<table class='update_seat'>";
	var j=0;
	var k=0;
	
	
	var schObj = JSON.stringify(sch);
	
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
 	
	
	html += "</table>";
	html += "<div class='cnt_section'><span>좌석 선택인원</span><span class='cnt'>0/0</span></div>";
	
	sview.empty();
	sview.html(html);
	fn_checked();
	
	console.log()
	
	
	var ihtml = "";
	
	
	infor.find(".img_sector").html("");
	
	
	ihtml += "";
	                                                
	ihtml += "<div class='img_sector'><img src='/cinema/upload/movie/"+sch.poster+"' /></div>";      
	ihtml += "<div class='infor_wrap'>";                  
	ihtml += "<div class='movie'><span>"+sch.grade+"</span><span>"+sch.mname+"</span>";                  
	ihtml += "</div>"; 
	ihtml += "<div class='infor'>";                  
	ihtml += 	"<div>"+ sch.name + ", "+sch.rtype;                                
	ihtml += 	"</div>";                               
	ihtml += 	"<div>"+ sch.rname;                               
	ihtml += 	"</div>";                               
	ihtml += 	"<div>"+ sch.stime;                               
	ihtml += 	"</div>";                               
	ihtml += "</div>";                               
	ihtml += "<div class='seat'>";                   
	ihtml += "</div>";		                        
	ihtml += "<div class='price'>";                   
	ihtml += "</div>";                                
	ihtml += "<div>";                                 
	ihtml += "<button class='next' onclick='fn_reservation("+schObj+")' >다음</button>";    
	ihtml += "</div>";                                
	ihtml += "</div>";                                
	
	
	infor.html(ihtml);
	
	
	
	
	
	$(".update_seat .seats[variable=1]").click(function(){
		
		if(tmpSum == 0){
			return alert("인원수를 먼저 선택해주세요");
		}
		
		if($(".select").length+1 == tmpSum ){
			
			$sp = $(".select_person select");
			
			var arraySp=[];
			
			for(var i =0; i< $sp.length; i++){
				arraySp.push($sp.eq(i).val());
			}
			
			console.log("인원배열"+arraySp);
			console.log("타입"+sch.rtype);
			$("#adult").val();
			
			$.ajax({
				url : "/cinema/priceFront",
				dataType:"json",
				type : "post",
				data :{type:"kind", kind : sch.rtype, persons : arraySp},
				success:function(data){
					sch.price = data;
				 
					
					$(".price").html(data);
				}
			});
		}
		
		
		if($(".select").length >= tmpSum ){
			return alert("좌석선택이 완료되었습니다.");
		}
		
		var seat = $(this).attr("seat");
		
		if($(".seat").text()!=""){
			$(".seat").text($(".seat").text() +","+ seat);
		}else{
			$(".seat").text(seat);
		}
		$(".cnt").text(($(".select").length+1)+"/"+tmpSum);
		
		$(this).attr("variable", $(this).attr("variable") == 1 ? -1 : 1);
		$(this).toggleClass("select");
		var seatNo= $(this).attr("seat").substring(1,4);
		//console.log(var seatNo= $(this).attr("seat").substring(1,4));
		$(this).text($(this).attr("variable") == 0 ? "" : seatNo);
		
		
	});
	
	
}

function fn_checked(){
	$("#sviewSeat table .seats").each(function(){
		if($(this).attr("variable")!=1){
			$(this).toggleClass("select");
			$(this).text("");
		}
		
	});
}



