<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>

<body>
 <header>
    	<%@include file = "../include/header.jsp"  %> 
 </header>
<section id="content">

 <form id="form" action="" method="post">
  <div class="input_area">
   <label for="userId">아이디</label>
   <input type="email" id="userId" name="userId" required="required" />      
  </div>
  
  <div class="input_area">
   <label for="userPass">패스워드</label>
   <input type="password" id="userPass" name="userPass" required="required" />      
  </div>
  
  <button type="submit" id="signin_btn" onclick="login();" >로그인</button> 
  
  <%-- <c:if test= "${msg eq false}">
  		<p style = "color:#f00;">로그인에 실패하였습니다.</p>
  </c:if>
  
  <c:if test= "${msg eq true}">
  		<p style = "color:#f00;">아이디가 존재하지 않습니다.</p>
  </c:if> --%>
  
 </form> 
</section>


</body>

<%
	//boolean msg = (boolean)request.getAttribute("msg");

%>

 <!-- 제이쿼리 -->
 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

<script>

if (!String.prototype.trim) {
    String.prototype.trim = function () {
        return this.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, '');
    };
}

		const formObj = $("form[id='form']");
		

	   //로그인  
       function login() {
		   
    	  const msg = <%=request.getAttribute("msg")%> ;
   		  console.log("msg ::: " + msg);
		   
    	  if($('#userId').val() == "") {
    		  alert("아이디를 입력해 주세요.");
    		  $('#userId').focus();
    		  return false;
    	  } 
    	  
    	  if($('#userPass').val() == "") {
    		  alert("비밀번호를 입력해 주세요.");
    		  $('#userPass').focus();
    		  return false;
    	  }
    	  
    	  if(msg == false) {
    		 alert("로그인에 실패하였습니다.");
    		 $('#userId').focus();
    	  }
   
    	  if(msg == true) {
    		  alert("아이디가 존재하지 않습니다.");
    		  $('#userId').focus();
    		  
    	  }
    	 
    		
    	  formObj.attr({action:"/member/memberSignin", method:"post"}).submit();   
    		  //$("#form").submit();
    	  
      }

</script>


 <footer>
    	<%@include file = "../include/footer.jsp"  %>   
 </footer>  

</html>