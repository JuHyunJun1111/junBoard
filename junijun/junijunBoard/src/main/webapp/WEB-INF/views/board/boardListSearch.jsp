<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<!-- 제이쿼리 -->
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
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
    <h2>글 목록</h2>
    
    <div class="search">
		 	<select name="searchType">
				  <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
				  <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
				  <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
				  <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
				  <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
		 	</select>

	 		<input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>
	 	<button id="searchBtn">검색</button>
	</div>

    <table>
     <tr><th>글 번호</th><th>글 제목</th><th>작성자</th><th>작성일자</th></tr>
     
     <!-- 목록 시작 -->
     <c:forEach items="${list}" var="list">
	     <tr>
	      	<td>${list.bno}</td>
	      	<td><a href = "/board/boardRead?bno=${list.bno}&page=${scri.page}&perPageNum=${scri.perPageNum}&searchType=${scri.searchType}&keyword=${scri.keyword}">${list.title}</a></td>
	      	<td>${list.writer}</td>
	      	<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" /></td>
	     </tr>
     </c:forEach>
     <!-- 목록 끝 -->
     
    </table>
    
    <div>
		 <ul>
			  <c:if test="${pageMaker.prev}">
			   		<li><a href="boardListSearch${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
			  </c:if> 
			  
			  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			  		 <li><a href="boardListSearch${pageMaker.makeSearch(idx)}">${idx}</a></li>
			  </c:forEach>
			    
			  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			  		 <li><a href="boardListSearch${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
			  </c:if>
		  </ul>
	</div>

   </section>

<hr />

   <footer>
    	<%@include file = "include/footer.jsp"  %>   
   </footer>

</div>

</body>

 <script>
	 $(function(){
	 	 $('#searchBtn').click(function() {
		   self.location = "boardListSearch"
		     + '${pageMaker.makeQuery(1)}'
		     + "&searchType="
		     + $("select option:selected").val()
		     + "&keyword="
		     + encodeURIComponent($('#keywordInput').val());
	   	 });
	 });   
	 </script>
</html>