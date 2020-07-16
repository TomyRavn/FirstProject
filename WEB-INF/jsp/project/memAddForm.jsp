<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>회원 추가</h1>
		<form action="${pageContext.request.contextPath }/member/add.do" method="post">
		아이디 : <input type= "text" name="memId" /> <br />
		비밀번호 : <input type= "text" name="memPassword" /> <br />
		닉네임 : <input type= "text" name="memNickname" /> <br />
		<input type= "submit" value="저장" />
</body>
</html>