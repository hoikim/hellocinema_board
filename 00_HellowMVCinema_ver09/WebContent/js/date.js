function func(mYear, mMonth, mDay) {
     var now = new Date();
     var year = (mYear - now.getFullYear())+now.getFullYear();
     var month = (mMonth - now.getMonth()-1)+now.getMonth();
     var day = now.getDate();
     //alert(year + "." + month + 1 + "." + day); // month는 0부터 시작하기 때문에 +1을 해야됨
     
     //해당 달의 1일은 무슨 요일이냐
     var setDate = new Date(year, month, 1);
     var firstDay = setDate.getDate();
     var yoil = setDate.getDay();
     //alert(yoil); // 일:0, 월:1 ~ 토:6
     
     var nalsu = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
     
     //2월은 윤년 체크
     if(year % 4 === 0 % year % 100 !== 0 || year % 400 === 0 ){
          nalsu[1] = 28;
     }
     
     makeCalendar(yoil, nalsu[month+1], nalsu[month], nalsu[month+1], year, month+1, day)
     
     
     console.log("nalsu"+nalsu);
     console.log("month"+month);
     
     
     // 버튼 보이기
     //document.getElementById("etc").style.display = "";
     
}
var str= "";
function makeCalendar(yoil, nalsu, nalsuPlus, nalsuMulti, year, month, day) {
str= "";
/*     str += "<tr>";
     var week = new Array("일", "월", "화", "수", "목", "금", "토");
     for(var i = 0; i < week.length; i++){
          str += "<th>" + week[i] + "</th>";
     }
     str += "</tr>";
 */    
     // 날 수 채우기
     var no = day;
     var currentCell = 0;
     var ju = Math.ceil(((nalsu-day) + yoil) / 7);
     console.log(day);
     console.log(nalsu);
     //alert("이번달은 " + ju + " 주 동안 계속됩니다");
     str += "<ul class='datepicker_min'>";
     for(var r=0; r < ju; r++){

          for(var col=0; col < 7; col++){
              if(currentCell < yoil || no > nalsu){
                   currentCell++;
              }else{
                   str += "<li date='"+(month-1)+"' fulldate='"+ (year < 10 ? ("0"+year) : year) +"-"+((month-1) < 10 ? ("0"+(month-1)) : (month-1))+"-"+(no < 10 ? ("0"+no) : no)+"'>" + no + "</li>";
                   no++;
              }
              
          }
     }
     
     for(var i=1; i <= nalsuPlus; i++ ){
    	 str += "<li date='"+(month)+"' fulldate='"+ (year < 10 ? ("0"+year) : year) +"-"+(month < 10 ? ("0"+month) : month)+"-"+(i < 10 ? ("0"+i) : i)+"'>" + month+"/"+i + "</li>";
     }
     
     for(var i=1; i <= nalsuMulti; i++ ){
    	 str += "<li date='"+(month+1)+"' fulldate='"+year+"-"+(month+1)+"-"+i+"'>" + (month+1 < 10 ? ("0"+(month+1)) : month+1)+"/"+(i < 10 ? ("0"+i) : i)+ "</li>";
     }
     
     str += "</ul>";
    // document.getElementById("disp").innerHTML = str;
}
//--------------
function func1() {
     var now = new Date();
     var year = now.getFullYear();
     var month = now.getMonth();
     var day = now.getDate();
     //alert(year + "." + month + 1 + "." + day); // month는 0부터 시작하기 때문에 +1을 해야됨
     
     //해당 달의 1일은 무슨 요일이냐
     var setDate = new Date(year, month, 1);
     var firstDay = setDate.getDate();
     var yoil = setDate.getDay();
     //alert(yoil); // 일:0, 월:1 ~ 토:6
     
     var nalsu = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
     
     //2월은 윤년 체크
     if(year % 4 === 0 % year % 100 !== 0 || year % 400 === 0 ){
          nalsu[1] = 28;
     }
     
     makeCalendar(yoil, nalsu[month],year,month+1, day)
     document.getElementById("disp").innerHTML = str;
     
     // 버튼 보이기
     document.getElementById("etc").style.display = "";
     
}
var str= "";
function makeCalendars(yoil, nalsu, year, month, day) {
     str = "<table border ='0'>";
     str += "<tr><th colspan='7' width='400'>" + year + "년" + month + "월</th></tr>";
     str += "<tr>";
     var week = new Array("일", "월", "화", "수", "목", "금", "토");
     for(var i = 0; i < week.length; i++){
          str += "<th>" + week[i] + "</th>";
     }
     str += "</tr>";
     
     // 날 수 채우기
     var no = 1;
     var currentCell = 0;
     var ju = Math.ceil((nalsu + yoil) / 7);
     //alert("이번달은 " + ju + " 주 동안 계속됩니다");
     for(var r=0; r < ju; r++){
          str += "<tr style='text-align:center'>";
          for(var col=0; col < 7; col++){
              if(currentCell < yoil || no > nalsu){
                   str += "<td>&nbsp;</td>";
                   currentCell++;
              }else{
                   str += "<td>" + no + "</td>";
                   no++;
              }
              
          }
          str += "<td>&nbsp;</td>";
          
          str += "</tr>";
     }
     
     str += "</table>";
}
