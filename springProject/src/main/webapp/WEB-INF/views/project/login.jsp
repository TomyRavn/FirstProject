<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>

    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" />
</head>

<body>

	<div class="container">
        <img class="logo" src="<%=request.getContextPath()%>/images/logo.png">
        <div class="innerLeftCon"></div>

        <div class="innerCenterCon">
            <div class="loginBox">
                <fieldset>
              <form id="loginForm">  
                    <ul><p class="loginTitle">로그인</p></ul>
                    <ul>
                        <div class="imgBox"></div>

                        <label class="textLabel">
                            <li>ID <input type="text" id="id" name="memId" class="textBox" /> </li>
                            <li>PassWord <input type="password" id="pw" name="memPassword" class="textBox" /> </li>
                        </label>
                        <div id="alert" class="alert alert-danger fade in" style="display:none;">
                         	<p class="failMessage">로그인이 실패하였습니다</p>
                        </div>
                    </ul>
               </form>
                    <button id="loginBtn" class="btn btn-warning" type="button" onclick="check()">로그인</button>
                    <button id="joinBtn" class="btn btn-danger" onclick="location.href='./memAdd.do'">회원가입</button>
                </fieldset>
            </div>
        </div>

        <div class="innerRightCon"></div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
    <script>
    	let isSuccess = false;
    	
    	function check(){
    		$.ajax({
				url : "${pageContext.request.contextPath}/loginajax.do",
				data : $('#loginForm').serialize(),
				dataType : "json"
			}).done(function(data) {
				if(data.loginVo != null){
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