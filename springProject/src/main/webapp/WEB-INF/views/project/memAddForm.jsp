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
			<ul>
				<h1>회 원 가 입</h1>
			</ul>
			<ul class="labelCon">
		<form id="memAddForm">
				<li><label>아이디 <input type="text" name="memId"></label></li>
				<li><label>비밀번호 <input type="password" name="memPassword"></label></li>
				<li><label>별명 <input type="text" name="memNickname"></label></li>
		</form>
				<li class="btnCon">
					<button type="button" id="joinBtn" class="btn btn-success btn-lg" onclick="check()">가입</button>
					<button type="button" id="cancelBtn" class="btn btn-danger btn-lg"><a href="${pageContext.request.contextPath}/login.do">취소</a></button>
				</li>
				<div id="alert" class="alert alert-danger fade in" style="display:none;">
                    <p class="failMessage">가입 실패 : 공백을 입력하였거나 글자수가 맞지 않습니다.</p>
                </div>	
			</ul>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
	 <script>
    	let isSuccess = false;
    	
    	function check(){
    		$.ajax({
				url : "${pageContext.request.contextPath}/memAddajax.do",
				data : $('#memAddForm').serialize(),
				dataType : "json"
			}).done(function(data) {
				if(data.mainVo != null){
					isSuccess = true;	
				}else{
    				isSuccess = false;
				}
    			if(!isSuccess) $('#alert').show();
    			else location.href='./login.do';
			}).fail(function(jqXHR, textStatus) {
				alert("Request failed: " + textStatus);
			});
    		
    	}
    </script>
</body>
</html>