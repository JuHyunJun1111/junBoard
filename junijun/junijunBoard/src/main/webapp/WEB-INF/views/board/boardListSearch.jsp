<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<!-- 제이쿼리 -->
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

<div id="container">
   <header>
    	<%@include file = "include/header.jsp"  %> 
   </header>
   <nav>
  		<%@include file = "include/nav.jsp"  %> 
   </nav>
<hr />
   <section id="container">
    <h2>글 목록</h2>
    
    <div class="search row">
    	<div class="col-xs-2 col-sm-2">
		 	<select name="searchType" class="form-control">
				  <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
				  <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
				  <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
				  <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
				  <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
			  
		 	</select>
		</div>	
		
		<div class="col-xs-2 col-sm-2">	
			<div class = "input-group">
	 			<input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" class="form-control"/>
	 			
	 			<span class="input-group-btn">
	 			<button id="searchBtn" class="btn btn-default">검색</button>
	 			</span>
	 		</div>
	 	</div>
	</div>

    <table class="table table-hover">
    <thead>
     <tr><th>글 번호</th><th>글 제목</th><th>작성자</th><th>작성일자</th></tr>
    </thead> 
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
    
    <!-- 페이징 -->
    <div class="col-md-offset-3">
		 <ul class="pagination">
			  <c:if test="${pageMaker.prev}">
			   		<li><a href="boardListSearch${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
			  </c:if> 
			  
			  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			  		 <li <c:out value="${pageMaker.cri.page == idx ? 'class=active' : ''}"/>>
			  		 <a href="boardListSearch${pageMaker.makeSearch(idx)}">${idx}</a></li>
			  </c:forEach>
			    
			  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			  		 <li><a href="boardListSearch${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
			  </c:if>
		  </ul>
	</div>
	<!-- 페이징 끝 -->
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