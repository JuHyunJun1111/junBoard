<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

</head>
<body>
	<h2>회원가입</h2>

	<form role="form" method="post" autocomplete="off">
		 <p>
		  <label for="userId">아이디</label>
		  <input type="text" id="userId" name="userId" />
		  <button type="button" id="idChk">중복체크</button>
		 </p>  
		 
		 
		 <p id="result">
		 	<span class="msg">아이디를 확인하세요.</span>
		 </p>
		 
		 <p>
		  <label for="userPass">패스워드</label>
		  <input type="password" id="userPass" name="userPass" />
		 </p>
		 
		 <p>
		  <label for="userName">닉네임</label>
		  <input type="text" id="userName" name="userName" />
		 </p>
		 
		 <p>
		   <button type="submit" id="submit" disabled="disabled" >가입</button>  
		 </p>
		 
		 <p>
		  <a href="/home">처음으로</a>
		 </p>
	</form>	 

</body>

<script>
$("#idChk").click(function(){
	var param = {userId : $("#userId").val()};
	
	const json = JSON.stringify(param);
	
	console.log("param ::: " + json);
	
	$.ajax({
		url : "/member/idChk" ,
		type : "post",
		data : param, 
		success : function(data) {
			
			if(data == 1) {
				$("#result .msg").text("사용불가"); 
				$("#result .msg").attr("style", "color:#f00")
				
				$("#submit").attr("disabled", true);
			}else {
				$("#result .msg").text("사용가능");
			    $("#result .msg").attr("style", "color:#00f");
			    
			    $("#submit").attr("disabled", false);
			}
		}		
	});
	
});

$("#userId").keyup(function(){
	 $("#result .msg").text("아이디를 확인해주십시오.");
	 $("#result .msg").attr("style", "color:#000");
	 
	 $("#submit").attr("disabled", "disabled");
	 
	});




</script>
</html>