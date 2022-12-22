<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	 <link rel="stylesheet" href="/css/errorStyle.css">

</head>
<body>

<section class="error-page section">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 offset-lg-3 col-12">
				<!-- Error Inner -->
				<div class="error-inner">
					<h3> 
						<c:out value = "${msg}" /> 
						<span>Oop's  sorry we can't find that page!</span>
					</h3>
					<p>Aenean eget sollicitudin lorem, et pretium felis. Nullam euismod diam libero, sed dapibus leo laoreet ut. Suspendisse potenti. Phasellus urna lacus</p>
					<form class="search-form">
						<button class="btn" type="button" onclick="location.href = '/home'" >뒤로가기</button>
					</form>
				</div>
				<!--/ End Error Inner -->
			</div>
		</div>
	</div>
</section>

</body>
</html>