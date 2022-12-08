<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<h2>회원탈퇴</h2>

	<form id="form" method="post" autocomplete="off">
		 <p>
		  <label for="userId">아이디</label>
		  <input type="text" id="userId" name="userId" value="${member.userId}" readonly/>
		 </p>  
		 
		 <p>
		  <label for="userPass">패스워드</label>
		  <input type="password" id="userPass" name="userPass" />
		 </p>
		 
		 <p>
		   <button type="submit">탈퇴</button>  
		 </p>
		 
		 <p>
		  <a href="/home">처음으로</a>
		 </p>
	</form>	 
	
	<input type="hidden"  value="${member}">
	
	<c:if test = "${msg eq false}">
		<p style="color:#f00;">비밀번호가 맞지 않습니다.</p>
	</c:if>

</body>
</html>