<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit</title>
    <!-- <link rel="stylesheet" href="css/bootstrap.css"/> -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css">
</head>
<body>
<form action ="${pageContext.request.contextPath}/memEdit.do" method ="post">  
    <fieldset>
        <legend><h1>Edit</h1></legend>
        <ul>
            <li>
                <label for="id">ID</label>
                <label><input type="text" id="id" name="memId" value="${mainVo.memId}" disabled></label>
            </li>
            <li>
                <label for="pwd">Password</label>
                <label><input type="password" id = "pwd" name = "memPassword" value="${mainVo.memPassword}"></label>
            </li>
            <li>
                <label for="nick">Nickname</label>
                <label><input type="text" id="nick" name = "memNickname" value="${mainVo.memNickname}"></label>
            </li>
        </ul>
    </fieldset>
    <input type = "submit" value = "Edit">
</form>
</body>
</html>