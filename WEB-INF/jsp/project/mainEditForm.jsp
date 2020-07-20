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
<form>  
    <fieldset>
        <legend><h1>Edit</h1></legend>
        <ul>
            <li>
                <label for="id">ID</label>
                <input type="text" id="id" readonly></label>
            </li>
            <li>
                <label for="pwd">Password</label>
                <input type="password" id = "pwd"></label>
            </li>
            <li>
                <label for="nick">Nickname</label>
                <input type="text" id="nick"></label>
            </li>
        </ul>
    </fieldset>
    <input type = "submit" value = "Edit">
</form>
</body>
</html>