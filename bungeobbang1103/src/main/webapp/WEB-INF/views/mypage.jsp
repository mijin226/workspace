<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
	<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			crossorigin="anonymous">

	<meta charset="UTF-8">
	<title>마이 페이지</title>
	<style type="text/css">
		.table td:nth-child(2) {
			border: none; /* 두 번째 열의 테두리 없애기 */
		}
	</style>
	<link rel="stylesheet" href="${path}/resources/assets/css/main.css">
	<link rel="stylesheet" href="${path}/resources/assets/css/header.css">
	<link rel="stylesheet" href="${path}/resources/assets/css/myPage.css">

</head>

<body>
<custom:header />
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

<!--
1. 기존 정보 불러와 input값으로 세팅
2. image 정보 없으면 default.jpg로
3. 주소 정보 없으면 해당 행을 제거.
4. 이미지 변경 버튼 실행 시, 화면에 미리 변경할 이미지 띄우기
5. 실질적인 변경은 이뤄지지 않음.
 -->



<div class="container text-center">
	<br> <br> <br>
	<h2>마이 페이지</h2>
	<br> <br>
	<!-- 개인정보&사이드바 행 -->
	<div class="row align-items-start">
		<br> <br>
		<!-- 1열 붕어빵 이미지 및 프로필 수정버튼 -->
		<div class="col-md-4" style="text-align: center;">
				<span class="col-2"> <br> <br> 
				<img src="${path}/uploads/${member.memberProfileWay}" alt="회원 프로필사진" class="signupimg">
				</span> <br> <br>
			<div>
				<h4>Point : ${userPoint}점</h4>
				<br> <a href="pointRecharge.do" class="btn btn-primary" id="pointCharge">포인트 충전</a> <br>
				<br> <a href="updateMypage.do" class="btn btn-danger" id="updateProfile">프로필 수정</a> <br>
				<%--TODO 회원탈퇴 경고 및 확인 창....추가해주세요.--%>
				<br> <a href="deleteMember.do" class="btn btn-warning btn-lg" role="button" id="signOutPage"> 회원탈퇴 </a> <br>
			</div>
		</div>
		<!-- 회원정보 테이블 -->
		<div class="col-md-4">
			<br> <br> <br> <br>
			<table class="table">
				<tr>
					<td class="underline">닉네임</td>
					<td>${member.memberNickname}</td>
				</tr>
				<tr>
					<td class="underline">이름</td>
					<td>${member.memberName}</td>
				</tr>
				<tr>
					<td class="underline">이메일</td>
					<td>${member.memberEmail}</td>
				</tr>
				<tr>
					<td class="underline">전화번호</td>
					<td>${member.memberPhone}</td>
				</tr>
			</table>
		</div>

		<!-- 3열 사이드바 -->
		<div class="col-md-4 align-center">
			<!-- 수직 중앙 정렬을 위한 클래스 추가 -->
			<div class="sidebar">
				<custom:boardSideBar />
			</div>
		</div>
	</div>
</div>
<div>
	<br> <br> <br>
	<custom:footer />
</div>
</body>

</html>
