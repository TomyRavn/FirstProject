<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<ul>
				<h1>회 원 정 보 수 정</h1>
			</ul>
			<ul class="labelCon">
		<form id="memEditForm">
				<li><label>아이디 <input type="text" name="memId" value="<c:out value='${mainVo.memId}' />" disabled /></label></li>
				<li><label>비밀번호 <input type="password" name="memPassword" value="<c:out value='${mainVo.memPassword}' />" /></label></li>
				<li><label>별명 <input type="text" name="memNickname" value="<c:out value='${mainVo.memNickname}' />" /></label></li>
		</form>
				<li class="btnCon">
					<button type="button" id="joinBtn" class="btn btn-success btn-lg" onclick="check()">수정</button>
					<button type="button" id="cancelBtn" class="btn btn-danger btn-lg"><a href="${pageContext.request.contextPath}/subMain.do">취소</a></button>
				</li>
				<div id="alert" class="alert alert-danger fade in" style="display:none;">
                    <p class="failMessage">수정 실패 : 공백을 입력하였거나 글자수가 맞지 않습니다.</p>
                </div>	
			</ul>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script>
    	let isSuccess = false;
    	
    	function check(){
    		$.ajax({
				url : "${pageContext.request.contextPath}/memEditajax.do",
				data : $('#memEditForm').serialize(),
				dataType : "json"
			}).done(function(data) {
				if(data.memVo != null){
					isSuccess = true;	
				}else{
    				isSuccess = false;
				}
    			if(!isSuccess) $('#alert').show();
    			else location.href='./subMain.do';
			}).fail(function(jqXHR, textStatus) {
				alert("Request failed: " + textStatus);
			});
    		
    	}
    </script>
</body>
</html>