<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.slf4j.Logger" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/searchBoardList.js"></script>

	<h1>${userID}님,안녕하세요!:D</h1>
	${boardDTO} | ${boardDTO.bid} | ${boardDTO.content}

	<hr>
	<h3>게시글 검색</h3>
	<br>
	<!-- 글 검색창 -->
		<select name="condition" id=condition>
			<option value="CONTENT">내용 검색</option>
			<option value="WRITER">작성자 검색</option>
		</select> <input type="text" id=searchContent name="searchContent" required
			placeholder="검색어를 입력해주세요."> <button id="btn">내용 검색</button>

	<h3>조회된 글목록</h3>
	<ul id="boardSearchList">
		<c:if test="${not empty datas}">
			<c:forEach var="data" items="${datas}">
				<li><a href="detailBoard.do?bid=${data.bid}">번호: ${data.bid}, 작성자 : ${data.writer}, 내용 : ${data.content}</a></li><!-- 컨트롤러에서 새페이지 생성 시 작동 -->
			</c:forEach>
		</c:if>
		<c:if test="${empty datas}">
			<li>검색한 결과가 없습니다.</li>
		</c:if>
	</ul>
	
	<a href="logout.do">로그아웃</a>

	<a href="insertBoard.do">글 작성</a>

</body>
</html>