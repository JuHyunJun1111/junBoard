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
     <%@include file = "include/header.jsp"  %>
   </header>

<hr />
   <nav>
 	 <%@include file = "include/nav.jsp"  %>
  </nav>
<hr />

   <section id="container">
   
    <form id="form" method="post" autocomplete="off">
    	
    	<input type="hidden" id="page" name="page" value="${scri.page}" readonly="readonly" />
    	<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}" readonly="readonly" />
    	<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}" readonly="readonly" />
    	<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}" readonly="readonly" />
    
    
    
	     <p>
	      	 <label for="bno">글 번호</label><input type="text" id="bno" name="bno" value="${read.bno}" readonly="readonly" />
	     </p>
	</form>     
	     <p>
	      	 <label for="title">글 제목</label><input type="text" id="title" name="title" value="${read.title}" readonly="readonly"  />
	     </p>
	     <p>
	     	 <label for="content">글 내용</label><textarea id="content" name="content" readonly="readonly" >${read.content}</textarea>
	     </p>
	     <p>
	     	 <label for="writer">작성자</label><input type="text" id="writer" name="writer" value="${read.writer}" readonly="readonly" /><br />
	      	 <label>작성 날짜</label> <span><fmt:formatDate value="${read.regDate}" pattern="yyyy-MM-dd" /> 
	     </p>
	     <p> 
	     	 <input type='button' id = 'list_btn' value = '목록' onclick = "list_btn();" />
	     	 <input type='button' id = 'modity_btn' value = '수정' />
	     	 <input type='button' id = 'delete' value = '삭제' onclick = 'delete_btn();' />
	     </p>   
	     
    

   </section>
   
   <script>
   var formObj = $("form[id='form']");
   
   //수정페이지
   $("#modity_btn").click(function(){
		
	   formObj.attr("action", "/board/boardModify");
	   formObj.attr("method", "get");
	   formObj.submit();
	  
   });
   
   //삭제
   function delete_btn() {
	   
	   if(!confirm("삭제 하시겠습니까?")){
		   return false;
	   }else {
		   location.href="/board/boardDelete?bno=${read.bno}";
	   }
	   
	   alert("삭제 되었습니다.");
	   
   }
   
   //목록
   function list_btn() {
	   self.location = "/board/boardListSearch?"
			   + "page=${scri.page}&perPageNum=${scri.perPageNum}"
			   + "&searchType=${scri.searchType}&keyword=${srci.keyword}";
   }
   
   
   </script>

<hr />

   <footer>
     <%@include file = "include/footer.jsp"  %>  
   </footer>

</div>

</body>
</html>