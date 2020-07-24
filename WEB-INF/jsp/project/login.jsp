<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LogIn</title>
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/> --%>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
</head>
<body>

<form action ="${pageContext.request.contextPath}/login.do" method ="post">  
    <fieldset>
        <legend><h1>LogIn</h1></legend>
        <ul>
            <li>
                <label for="id">ID</label>
                <label><input type="text" id="id" name="memId"></label>
            </li>
            <li>
                <label for="pwd">Password</label>
                <label><input type="password" id = "pwd" name="memPassword"></label>
            </li>
        </ul>
    </fieldset>
    <input type = "submit" value = "LogIn">
</form>
</body>
</html>