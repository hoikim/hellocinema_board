<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<script>
function fn_checkIdDuplicate(){
	var userId = $("#user_Id").val().trim();
	if(userId.length<4){
		alert("아이디는 4글자 이상 가능합니다.");
		return;
	}
	var url = "<%= request.getContextPath() %>/user/checkIdDuplicate";
	var title = "checkIdDuplicate";
	var status = "left=350px, top=100px, width=300px, height=200px";
	//window.open(url,title,status);
	var popup = window.open(url, title, status);
	
	var checkIdDuplicateFrm = document.checkIdDuplicateFrm;
	checkIdDuplicateFrm.userId.value=userId;
	
	//팝업과 form연결
	
	checkIdDuplicateFrm.target = title;
	checkIdDuplicateFrm.action = url;
	checkIdDuplicateFrm.submit();
}

function fn_enrollValidate(){
    
	$userId = $("#user_Id");
	$passWord = $("#pass_Word");
	$passWordChk = $("#pass_WordChk");
	$userName = $("#userName");
	$age = $("#age");
	$email = $("#email");
	$phone = $("#phone");
	$address =$("#address");
	$gender =$("input[name=gender]");
	$hobby = $("input[name=hobby]");
	//빈객체 체크
	
	
	if($userName.val() ==""){
		console.log("이름을 입력해주세요");
		$userName.focus();
		return false;		
	}
	
	if($phone.val() == ""){
		console.log("전화번호를 입력해주세요.")
		$phone.focus();
		return false;
	}
	
	if($address.val() == ""){
		console.log("주소를 입력해주세요.")
		$phone.focus();
		return false;
	}	
	
	
	
	
	
}

function regExpVaildation(regExp, el, msg) {
    if(regExp.test(el.val())){
        return;
    }else{
	    console.log(msg);
        console.log(el.val());
        console.log(regExp.test(el.val()));
    }
}



$(function(){
    var regType = /^[A-Za-z0-9]{6,12}$/g;
	$userId = $("#user_Id");
	$passWord = $("#pass_Word");
	$passWordChk = $("#pass_WordChk");
	$userName = $("#userName");
	$age = $("#age");
	$email = $("#email");
	$phone = $("#phone");
	$address =$("#address");
	$gender =$("input[name=gender]");
	$hobby = $("input[name=hobby]");
	
	
	
	$passWord.keyup(function(e){
		regExpVaildation(regType, $passWord, "영문 숫자만 허용 6~12자리");
	});
	//패스워드 체크
	$passWordChk.keyup(function(e){
		$pw_val = $("#pass_Word").val();
		$pwchk_val = $("#pass_WordChk").val();
		

		if(($pwchk_val=="")||($pw_val != $pwchk_val)){
			console.log("맞지않아");
		}else{
			console.log("맞아부렁");
		}
	});
 
})


</script>
<!-- 아이디중복체크폼 -->
<form name="checkIdDuplicateFrm" method="post">
	<input type="hidden" name="userId" />
</form>



<style>
#cinema_container *{box-sizing: border-box; outline:none;}
#cinema_container{background:#fff; padding:0px;}
#cinema_container table{border-collapse: collapse; padding:0p; border-top:3px solid #1986ff; background:#fff;}
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

<% if(userSession != null){ %>
<div>
	<span onclick="location.href='/cinema/users?type=viewInfo'">내정보보기/수정</span>
	
	<span onclick="location.href='/cinema/users?type=viewTicket'">예매확인/취소</span>

</div>
<section id="cinema_container">
	<form action="<%= request.getContextPath() %>/user/joinend" method="post" onsubmit="return sValidation();">
	<input type="hidden" name="phone" />
	<input type="hidden" name="birth" />
		<table>
			<tr>
				<th>아이디</th>
				<td colspan="6"><input type="text" name="id" value="<%= userSession.getId() %>" readonly="readonly"/> </td>
			</tr>		
			<tr>
				<th>이름</th>
				<td colspan="6"><input type="text" name="name" value="<%= userSession.getName() %>"/> </td>
			</tr>	
			<tr class="birth_tr">
				<th>생년월일</th> 
				<td class="birth"><input type="number"  min=0  placeholder="1960" value="<%= userSession.getBirth().substring(0, 4) %>"/></td>
				<td>-</td>
				<td class="birth"><input type="number" min=0 placeholder="12" value ="<%= userSession.getBirth().substring(4, 6) %>"/></td>
				<td>-</td>
				<td class="birth"><input type="number" min=0 placeholder="01" value="<%= userSession.getBirth().substring(6, 8) %>"/></td>
			</tr>			
			<tr class="phone_tr">
				<th>휴대폰</th>
				<td class="phone"><input type="number"  min=0 placeholder="010" value="<%= userSession.getPhone().substring(0, 3) %>" /></td>
				<td>-</td>
				<td class="phone"><input type="number" min=0 placeholder="1234" value="<%= userSession.getPhone().substring(3, 7) %>"/></td>
				<td>-</td>
				<td class="phone"><input type="number" min=0 placeholder="5678" value="<%= userSession.getPhone().substring(7, 10) %>"/></td>
			</tr>	
			<tr>
				<th>이메일</th>
				<td colspan="6"><input type="email" name="email" value="<%= userSession.getEmail() %>" /> </td>
			</tr>
			
			<tr class="submit_tr">
				<td colspan="9" style="text-align:center">
					<button class="cancle_btn">취소하기</button>
					<input type="submit" class="submit_btn" value="수정하기">
				</td>
			
			</tr>
		</table>
	</form>
	

</section>


<% }else{
	
	
	
}%>


<script>
 
</script>




<%@ include file="/WEB-INF/views/common/footer.jsp" %>