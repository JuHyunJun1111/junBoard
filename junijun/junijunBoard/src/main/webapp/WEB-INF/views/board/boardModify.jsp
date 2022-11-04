<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<head>
   <title>jun 게시판</title>
</head>

 <!-- 제이쿼리 -->
 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>


<body>

<div id="root">
   <header>
    	<h1>수정화면</h1>
   </header>

<hr />
   
   <nav>
  		<%@include file = "include/nav.jsp"  %>
   </nav>

<hr />

   <section id="container">
   
    <form id="form" method="post" autocomplete="off">
	     <p>
	      	 <label for="bno">글 번호</label><input type="text" id="bno" name="bno" value="${modify.bno}" readonly="readonly" />
	     </p>
	     
	     <p>
	      	 <label for="title">글 제목</label>
	      	 <input type="text" id="title" name="title" value="${modify.title}" />
	     </p>
	     <p>
	     	 <label for="content">글 내용</label>
	     	 <textarea id="content" name="content">${modify.content}</textarea>
	     </p>
	     <p>
	     	 <label for="writer">작성자</label><input type="text" id="writer" name="writer" value="${modify.writer}" /><br />
	      	 <label>작성 날짜</label> <span><fmt:formatDate value="${modify.regDate}" pattern="yyyy-MM-dd" /> 
	     </p>
	     <p> 
	     	 <button id = "submit">수정</button>
	     	 <button id = "cancel_btn">취소</button>
	     </p>    
    </form>

   </section>
   
   <script>
   var formObj = $("form[id='form']");
    
   //취소 
   $("#cancel_btn").click(function(){
	  
	   if(!confirm("취소 하시겠습니까?")){
		   return false;
	   }else{ 
		   self.location = "/board/boardRead?bno=${readReply.bno}"
			   + "&page=${scri.page}"
			   + "&perPageNum=${scri.perPageNum}"
			   + "&searchType=${scri.searchType}"
			   + "&keyword=${scri.keyword}"
	   }
   });
   
   
   
   
   </script>

<hr />

   <footer>
    	<%@include file = "include/footer.jsp"  %> 
   </footer>

</div>

</body>
</html>