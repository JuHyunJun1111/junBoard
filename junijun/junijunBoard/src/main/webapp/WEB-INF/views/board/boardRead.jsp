<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<head>
   <title>jun 게시판</title>
</head>

 <!-- 제이쿼리 -->
 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
 
 <!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<body>

<div id="container">
   <header>
     <%@include file = "include/header.jsp"  %>
   </header>

   <nav>
 	 <%@include file = "include/nav.jsp"  %>
  </nav>
  <hr>	
    <!-- 게시물 -->
  <section>
   
     <form id="form" method="post" autocomplete="off">
    	
    	<input type="hidden" id="page" name="page" value="${scri.page}" readonly="readonly" />
    	<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}" readonly="readonly" />
    	<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}" readonly="readonly" />
    	<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}" readonly="readonly" />
    
    
    
	     <div class="form-group">
	      	 <label for="bno" class="control-label">글 번호</label>
	      	
	      	 	<input type="text" id="bno" name="bno" style="width:500px;" class="form-control" value="${read.bno}" readonly="readonly" />
	      
	     </div>
	     
	     
	     
	 </form>
	      
	     <div class="form-group">
	      	 <label for="title" class="control-label">글 제목</label>
	      
	      	 	<input type="text" id="title" name="title" style="width:500px;" class="form-control" value="${read.title}" readonly="readonly"  />
	      	
	     </div>
	     
	     <div class="form-group">
	     	 <label for="content" class="control-label">글 내용</label>
	     	
	     	 	<textarea id="content" name="content" style="width:500px;" class="form-control" readonly="readonly"  >${read.content}</textarea>
	     
	     </div>
	     
	     <div class="form-group">
				<label for="writer"class="control-label">작성자</label>
				
					<input type="text" id="writer" name="writer" style="width:500px;" class="form-control" value="${read.writer}" readonly="readonly" />
				
		</div>
		
		 <div class="form-group">
				<label class="control-label">작성 날짜</label> 
				
					<span><fmt:formatDate value="${read.regDate}" pattern="yyyy-MM-dd" /></span>
				
		 </div>
	     
	     	<%--  <label for="writer">작성자</label>
	     	 <input type="text" id="writer" name="writer" value="${read.writer}" readonly="readonly" /><br />
	      	 <label>작성 날짜</label> 
	      	 <span><fmt:formatDate value="${read.regDate}" pattern="yyyy-MM-dd" /></span>  --%>
	      	 
	     <div class="form-group"> 
	     	 <input type='button' id = 'list_btn' class="btn btn-primary" value = '목록' onclick = "list_btn();" />
	     	 <input type='button' id = 'modity_btn' class="btn btn-warning" value = '수정' />
	     	 <input type='button' id = 'delete' class="btn btn-danger"  value = '삭제' onclick = 'delete_btn();' />
	     </div>  

    </section>
    <!-- 게시물 끝 -->
   
    <!-- 댓글 -->
    <div id="reply">
		 <ol class="replyList">
			 <c:forEach items="${replyList}" var="replyList">
			 <li>
				  <%-- <p>
				  	 작성자 : ${replyList.writer}<br />
				  	 작성날짜 :  <fmt:formatDate value="${replyList.regDate}" pattern="yyyy-MM-dd" />
				  </p> --%>
				  
				  <p>
					<span class="glyphicon glyphicon-user"></span>
						${replyList.writer}
						(<fmt:formatDate value="${replyList.regDate}" pattern="yyyy-MM-dd" />)
					</p>
					
				  <p class="bg-info" style="width:500px;">${replyList.content}</p>
				  
				<div class="form-group">	  
					  <button id="replyUpdate" class="replyUpdate btn btn-info btn-xs" data-rno="${replyList.rno}">댓글 수정</button>
					  <button id="replyDelete" class="replyDelete btn btn-danger btn-xs" data-rno="${replyList.rno}">댓글 삭제</button>
				</div>	  
			 </li>
			 </c:forEach>   
		 </ol>
		 
		<!-- 댓글 작성 --> 
		 <section class="replyForm">
			<form id="replyForm" method="post" autocomplete="off" class="form-horizontal">
			
				 <input type="hidden" id="bno" name="bno" value="${read.bno}" readonly="readonly" />
				 <input type="hidden" id="page" name="page" value="${scri.page}" readonly="readonly" />
				 <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}" readonly="readonly" />
				 <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}" readonly="readonly" />
				 <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}" readonly="readonly" />
			
				 <!-- <p><label id="writer">작성자</label><input type="text" id="writer" name="writer" /></p>
				 <p><label id="content">댓글 내용</label><textarea id="content" name="content"></textarea></p> -->
				 
				<div class="form-group">
					<label for="writer" class="col-sm-1 control-label">작성자</label>
					<div class="col-sm-10">
						<input type="text" id="writer" style="width:500px;"  name="writer" class="form-control" />
					</div>
				</div>			
			
				<div class="form-group">
					<label for="content" class="col-sm-1 control-label">댓글 내용</label>
					<div class="col-sm-10">
						<textarea id="content" style="width:500px;"  name="content" class="form-control" ></textarea>
					</div>
				</div>
				
				<!--  <p>
			  		<button type="button" class="repSubmit">작성</button>
			 	</p> -->
				
				<div class="form-group">
					 <div class="col-sm-offset-2 col-sm-10"> 
						<button type="button" class="repSubmit btn btn-success">작성</button> 
					</div>
				</div>	
				
				
			</form>
		</section>
		 
	</div>
   
   
   
   
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
		   location.href="/board/boardDelete?bno=${read.bno}"
			   + "&page=${scri.page}"
			   + "&perPageNum=${scri.perPageNum}"
			   + "&searchType=${scri.searchType}"
			   + "&keyword=${scri.keyword}"
			   
		   /* formObj.attr("action", "/board/boardDelete?bno=${read.bno}");
		   formObj.attr("method", "get");
		   formObj.submit();	 */   
	   }
	   
	   alert("삭제 되었습니다."); 
	   
   }
   
   //목록
   function list_btn() {
	   location.href = "/board/boardListSearch?"
			   + "page=${scri.page}&perPageNum=${scri.perPageNum}"
			   + "&searchType=${scri.searchType}&keyword=${scri.keyword}";
   }
   
   //댓글 입력
   var formObj = $("form[id='replyForm']");
         
   $(".repSubmit").click(function(){
    formObj.attr("action", "/board/replyWrite");
    formObj.submit();
   });
   
   //댓글 수정
   $(".replyUpdate").click(function(){
	   location.href = "/board/replyModify?bno=${read.bno}"
			    + "&page=${scri.page}"
			    + "&perPageNum=${scri.perPageNum}"
			    + "&searchType=${scri.searchType}"
			    + "&keyword=${scri.keyword}"
			    + "&rno=" + $(this).attr("data-rno"); 
		console.log("수정페이지 이동");	    
  });
  
   //댓글 삭제
  $(".replyDelete").click(function(){
	  if(!confirm("삭제 하시겠습니까?")){
		   return false;
	  }else {
		  self.location = "/board/replyDelete?bno=${read.bno}"
			    + "&page=${scri.page}"
			    + "&perPageNum=${scri.perPageNum}"
			    + "&searchType=${scri.searchType}"
			    + "&keyword=${scri.keyword}"
			    + "&rno=" + $(".replyDelete").attr("data-rno"); 
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