<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

</head>

 <!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<body>

   <header>
     <%@include file = "include/header.jsp"  %>
   </header>

   <nav>
 	 <%@include file = "include/nav.jsp"  %>
  </nav>
  <hr>	
	
<div id="container">	 
	   <section id="container">
	   
	   <c:if test = "${msg eq null}">
	    <form role="form" method="post" autocomplete="off">
	    
		     <div class="form-group">
		      	<label for="title">글 제목</label>
		      	<input type="text" id="title" name="title" class="form-control" style="width:500px;"/>
		     </div>
		     
		     <div class="form-group">
		     	 <label for="content">글 내용</label>
		     	 <textarea id="content" name="content" class="form-control" style="width:500px;"></textarea>
		     </div>
		     
		     <div class="form-group">
		     	 <label for="writer">작성자</label>
		     	 <input type="text" id="writer" name="writer" class="form-control" style="width:500px;" 
		     	 				value="${member.userName}" readonly="readonly" />
		     </div>
		     
		     <div class="form-group">
		   		 <button type="submit" class="btn btn-success">작성</button>
		     </div>   
	    </form>
	   </c:if>
	   </section>
		
		<c:if test = "${msg eq false}">
			<p>로그인을 해야 글을 작성할 수 있습니다.</p>
			<p><a href="/home">홈으로</a>
		</c:if>
	<hr />
	
	   <footer>
	    <p>만든이 : hyunjun</p>    
	   </footer>
	
</div>

</body>
</html>