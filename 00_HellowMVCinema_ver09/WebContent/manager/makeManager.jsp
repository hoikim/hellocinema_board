<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="<%=request.getContextPath() %>/manager/managerReg" method="POST">
	아이디 <input type="text" name="id"/>
	비번<input type="password" name="pw"/>
	담당자 이름<input type="text" name="name"/>
	영화관 코드<input type="text" name="tcode"/>
	담당자사진<input type="text" name="photo"/>
	<input type="text" name="mcode"/>
	<button type="submit">접속</button>
</form>
