<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>jun 게시판</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<!--  <a href="/board/boardListSearch">글 작성</a></br>
 <a href="/board/boardListSearch">글 목록</a> -->
 

 <form role="form" method="post" autocomplete="off">
	   <p>
		    <label for="userId">아이디</label>
		    <input type="text" id="userId" name="userId" />
	   </p>
	   <p>
		    <label for="userPass">비밀번호</label>
		    <input type="password" id="userPass" name="userPass" />
	   </p>
	   
	   <p><button type="submit">로그인</button></p>
	   
	   <p><a href="/member/register">회원가입</a></p>
</form>

</body>
</html>
