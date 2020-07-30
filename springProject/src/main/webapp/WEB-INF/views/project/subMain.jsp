<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문제 풀기</title>

    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/navi.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
</head>
<body>
    <center class="cent">
    <div>
        <ul class="memName">
            <li><a href="<%=request.getContextPath()%>/memEdit.do" class="nameLink"><c:out value="${loginVo.memNickname}" /></a> 회원님, 안녕하세요.</li>
            <li><button class="btn btn-primary" type="button" onclick="location.href='./logout.do'">로그아웃</button>
        </ul>
        <ul class="bar">
            <a href="<%=request.getContextPath()%>/subMain.do"><img class="logo" src="<%=request.getContextPath()%>/images/logo.png"></a>
            <li><a href="<%=request.getContextPath()%>/ranking.do" class="button">랭킹</a></li>
            <li><a href="<%=request.getContextPath()%>/add.do" class="button">문제 출제</a></li>
            <li><a href="<%=request.getContextPath()%>/subMain.do" class="button">문제 리스트</a></li>
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
               
               	<form action="${pageContext.request.contextPath}/subMain.do" method=post>
                	<button id='bbb'>문 제 풀 기</button>
                </form>
                
                <p><span style="color: red;">제한 시간</span> 내에 최대한 <span style="color: red;">많은 문제</span>를 풀어야 합니다.</p>
                <p>문제는 <span style="color: blue;">단어와 설명으로 구성</span>되어 있으며, 설명을 읽고, 연상되는 단어를 맞추면 됩니다.</p>

                <div class="imgCon"></div>

                <p style="color: red; font-weight: bold;">※ 주의 : 단어를 적지 않고 넘겼을 경우에도 오답으로 책정됩니다.</p>

			</div>
        </center>
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</body>
</html>