<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ranking_Score</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/navi.css"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/result.css"/>
</head>
<body>
    <center class="cent">
        <ul class="bar">
            <a href="#"><img class="logo" src="<%=request.getContextPath()%>/images/logo.png"></a>
            <li><a href="#" class="button">랭킹</a></li>
            <li><a href="#" class="button">문제 출제</a></li>
            <li><a href="#" class="button">문제 리스트</a></li>
            <li><a href="#" class="flat button">(회원 님)</a></li>
            <hr>
        </ul>
    </center>
    <center>
    <div id="container">
       
        <div class = "div3" id = "score">
           
            <table class="box1">
            <tr>
                <th><h1>SCORE : </h1></th>
                <td><h1> XX점 </h1></td>
            </tr>
            </table>
        </div>

        <div class="div1">
            <br/><br/>
            <table id = "p">
                <th><h1>당신은 상위 XX%의 지식인입니다.</h1></th>
            </table>
        </div>

        <div class="div2" id="rank">
            <table class="box2">
                <tr>
                    <td colspan=3 class="inputTi"><h1>RANKING</h1></td>
                </tr>
                <tr>
                    <th class="inputRk2"><b>Ranking</b></th>
                    <th class="inputId2"><b>ID</b></th>
                    <th class="inputSc2"><b>SCORE</b></th>
                </tr>
                <tr>
                    <td class="inputRk"><b>1</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
                <tr>
                    <td class="inputRk"><b>2</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
                <tr>
                    <td class="inputRk"><b>3</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
                <tr>
                    <td class="inputRk"><b>4</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
                <tr>
                    <td class="inputRk"><b>5</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
                <tr>
                    <td class="inputRk"><b>6</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
                <tr>
                    <td class="inputRk"><b>7</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
                <tr>
                    <td class="inputRk"><b>8</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
                <tr>
                    <td class="inputRk"><b>9</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
                <tr>
                    <td class="inputRk"><b>10</b></td>
                    <td class="inputId"><b>ID</b></td>
                    <td class="inputSc"><b>Score</b></td>
                </tr>
            </table>
    </div>
</center>
    </div>
    
</body>
</html>