<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>문제 출제</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/navi.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/input.css" />
</head>

<body>
	<center class="cent">
    <div>
        <ul class="memName">
            <li><a href="<%=request.getContextPath()%>/memEdit.do" class="nameLink"><c:out value="${loginVo.memNickname}" /></a> 회원님, 안녕하세요.</li>
            <li><button class="btn btn-primary" type="button" onclick="location.href='./logout.do'" style="color: white; margin-top: 0px;">로그아웃</button>
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
	<div class="total">
		<div class="container3">
		
			<audio id="myAudio" controls autoplay>
                <source id="main">
                <source type="audio/mp3" src="<%=request.getContextPath()%>/media/bgm1.mp3">
                <source type="audio/mp3" src="<%=request.getContextPath()%>/media/bgm2.mp3">
                <source type="audio/mp3" src="<%=request.getContextPath()%>/media/bgm3.mp3">
                <source type="audio/mp3" src="<%=request.getContextPath()%>/media/bgm4.mp3">
                <source type="audio/mp3" src="<%=request.getContextPath()%>/media/bgm5.mp3">                    
            </audio>
            <button class="btn-info" id="playNext" type="submit">다음 곡 재생</button>

			<div class="container4">
				<br>
				<br>
				<h1 class="search">사전 검색</h1>
				<label><input id="search" type="text"
					placeholder="뜻을 검색할 단어를 입력하세요." /></label>
				<button id="buttonSearch" class="btn btn-primary" type="submit">
					<img class="buttonSearch"
						src="<%=request.getContextPath()%>/images/search.png">
				</button>
				<div class="ans"><a href="https://namuwiki.com"><img class="wikiImg" src="<%=request.getContextPath()%>/images/namuWiki.png"/></a></div>
			</div>
			
			
		</div>
		<img class="character"
			src="<%=request.getContextPath()%>/images/character.png">
		<div class="container">
			<form action="${pageContext.request.contextPath}/add.do" method=post>
				<div class="askCon">
					<img class="askImg"
						src="<%=request.getContextPath()%>/images/askTitle.png">
				</div>

				<div>
					<label><input id="word" name="questionWord"
						class="text text-success" type="text"
						placeholder="단어를 입력하세요. (예 : 나비)" /></label>
				</div>

				<div>
					<label><textarea id="explain" name="questionExplain"
							class="text text-success" placeholder="단어에 대한 설명을 입력하세요."></textarea></label>
				</div>

				<button class="btn btn-success btn-lg" type="submit">등록</button>
				<button class="btn btn-danger btn-lg" type="button" ><a href="${pageContext.request.contextPath}/add.do">취소</a></button>
			</form>
		</div>

		<div class="container2">
			<h2 id="recent">최근 등록한 문제</h2>
			<hr>
			<table>
				<tr>
					<td class="num" id="askNum">번호</td>
					<td><p id="askTitle">문제</p></td>
				</tr>
				<c:forEach begin="0" end="9" varStatus="status">
					<tr>
						<td><c:out value="${status.count}" /></td>
						<td><c:out value="${questionList[status.count-1].questionWord}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/search.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/audio.js"></script>
</body>
</html>