<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JOIN</title>
    <!-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/> -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css">
</head>
<body>
<form>  
    <fieldset>
        <legend><h1>JOIN</h1></legend>
        <ul>
            <li>
                <label for="id">ID</label>
                <input type="text" id="id" name="memId"></label>
            </li>
            <li>
                <label for="pwd">Password</label>
                <input type="password" id = "pwd" name="memPass"></label>
            </li>
            <li>
                <label for="nick">Nickname</label>
                <input type="text" id="nick" name="memNickname"></label>
            </li>
        </ul>
    </fieldset>
    <input type = "submit" value = "Join">
</form>
</body>
</html>