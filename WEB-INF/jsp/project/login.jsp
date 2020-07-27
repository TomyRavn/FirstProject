<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
              <form action ="${pageContext.request.contextPath}/login.do" method ="post">  
                    <ul><p class="loginTitle">로그인</p></ul>
                    <ul>
                        <div class="imgBox"></div>

                        <label class="textLabel">
                            <li>ID <input type="text" id="id" name="memId" class="textBox" /> </li>
                            <li>PassWord <input type="password" id="pw" name="memPassword" class="textBox" /> </li>
                        </label>
                    </ul>
                    <button id="loginBtn" class="btn btn-warning" type="submit">로그인</button>
               </form>
                    <button id="joinBtn" class="btn btn-danger" onclick="location.href='./memAdd.do'">회원가입</button>
                </fieldset>
            </div>
        </div>

        <div class="innerRightCon"></div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

</body>
</html>