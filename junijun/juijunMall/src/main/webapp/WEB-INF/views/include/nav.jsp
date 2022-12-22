<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<ul>

<c:if test="${member eq null }">
	<li>
		<a href = "/member/memberSignin">로그인</a>
	</li>
	
	<li>
		<a href = "/member/memberSignup">회원가입</a>
	</li>	
</c:if>


<c:if test="${member ne null }">
	<li>
		${member.userName} 님 환영합니다.
	</li>
	
	<li>
		<a href = "/member/memberSignout">로그아웃</a>
	</li>	
</c:if>


</ul>

</html>