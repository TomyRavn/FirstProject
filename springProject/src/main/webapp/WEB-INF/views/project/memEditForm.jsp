<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보수정</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css">
</head>
<body>

	<div class="container">
		<form action="${pageContext.request.contextPath}/memEdit.do" method="post">
			<ul>
				<h1>회 원 정 보 수 정</h1>
			</ul>
			<ul class="labelCon">
				<li><label>아이디 <input type="text" name="memId" value="<c:out value='${mainVo.memId}' />" disabled></label></li>
				<li><label>비밀번호 <input type="password" name="memPassword" value="<c:out value='${mainVo.memId}' />"></label></li>
				<li><label>별명 <input type="text" name="memNickname" value="<c:out value='${mainVo.memId}' />"></label></li>
				<li class="btnCon">
					<button type="submit" id="joinBtn" class="btn btn-success btn-lg">수정</button>
					<button type="button" id="cancelBtn" class="btn btn-danger btn-lg"><a href="${pageContext.request.contextPath}/subMain.do">취소</a></button>
				</li>
			</ul>
		</form>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</body>
</html>