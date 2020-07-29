<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css">
</head>
<body>

	<div class="container">
		<form action="${pageContext.request.contextPath}/memAdd.do" method="post">
			<ul>
				<h1>회 원 가 입</h1>
			</ul>
			<ul class="labelCon">
				<li><label>아이디 <input type="text" name="memId"></label></li>
				<li><label>비밀번호 <input type="password" name="memPassword"></label></li>
				<li><label>별명 <input type="text" name="memNickname"></label></li>
				<li class="btnCon">
					<button type="submit" id="joinBtn" class="btn btn-success btn-lg">가입</button>
					<button type="button" id="cancelBtn" class="btn btn-danger btn-lg"><a href="${pageContext.request.contextPath}/login.do">취소</a></button>
				</li>
			</ul>
		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</body>
</html>