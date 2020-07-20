<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/navi.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
    
</head>
<body>
    <!--<img scr="images/tetris.jpg"> -->
    <center class="cent">
    <div>
        <ul class="memName">
            <li><a href="#" class="nameLink">${loginNickname}</a> 회원님, 안녕하세요.</li>
        </ul>
        <ul class="bar">
            <a href="#"><img class="logo" src="<%=request.getContextPath()%>/images/logo.png"></a>
            <li><a href="<%=request.getContextPath()%>/ranking.do" class="button">랭킹</a></li>
            <li><a href="<%=request.getContextPath()%>/add.do" class="button">문제 출제</a></li>
            <li><a href="<%=request.getContextPath()%>/main.do" class="button">문제 리스트</a></li>
        </ul>
    </div>
        <hr>
    </center>   
    <br>
    
    <div class="sand">
        <img src="<%=request.getContextPath()%>/images/sand.png">
    </div>
    <div class="container">
        <center>
            <div id="wrap">
                <h1 id=q>문제 들어갈 곳</h1>
	<table>
                    <tr>
                        <td>${status.count}</td>
                        <td>${questionList[status.count-1].questionWord}</td>
                    </tr>
                </table>
                <input id='my' placeholder="답을 입력하세요"/>
                <br><br><br><br><br>
                <input type="hidden" id='ans' value='' />
                <button id='aaa'>다음문제</button>
            </div>
        </center>
    </div>
</body>
</html>