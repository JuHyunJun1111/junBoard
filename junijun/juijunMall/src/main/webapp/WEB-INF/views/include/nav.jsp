<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<ul>

<c:if test="${member eq null }">
	<li>
		<a href = "/memberSignin.do">로그인</a>
	</li>
	
	<li>
		<a href = "/memberSignup.do">회원가입</a>
	</li>	
</c:if>


<c:if test="${member ne null }">
	
	<c:if test="${member.verify eq 9 }">
		<li>
			<a href ="/admin/index">관리자 화면</a>
			<input type="hidden" name="ru2" value="${member.verify}" />
		</li>
	
	</c:if>
		<li>
			${member.userName} 님 환영합니다.
		</li>
		<input type="hidden" name="ru" value="${member}" />
		
		<li>
			<a href = "/memberSignout.do">로그아웃</a>
		</li>	
</c:if>




</ul>

</html>