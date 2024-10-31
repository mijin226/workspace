<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<!--bootstrap CDN코드-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>새로운 비밀번호로 변경</title>
<link rel="stylesheet"
	href="/webapp/resources/assets/css/loginAndsign.css">
</head>

<body>

	<!--bootstrap CDN코드-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<div class="container">
		<br> <br> <br>
		<h2>마이페이지 비밀번호 확인하고 들어가기</h2>
		<!--임시 비밀번호 입력 모달창으로 가는 버튼 (28~33번라인 연결후 삭제 요망)
		메인 마이페이지 링크와 이하 1차 회원정보확인 모달창 연결 필요-->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#mypageInModal">비밀번호 확인</button>
	</div>
	<form id="checkMyPagePw" action="checkMyPagePW.do" method="Post" >
	<!-- 1차 회원정보 확인 모달창 -->
	<div class="modal" id="mypageInModal" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">개인정보 보호 비밀번호 확인 </h4>
					<button type="button" class="close" onclick="closedModal()"
						data-dismiss="modal">&times;</button>
				</div>

				<div class="modal-body">
<br>

					<!-- 1. 비밀번호 입력 -->
					<div class="form-group">
						<label for="username">비밀번호</label> <input type="password"
							class="form-control" id="password" name="password" required
							placeholder="비밀번호를 입력해주세요">
					</div>
<br><br>
					<div class="d-grid gap-2 text-center">
						<button type="submit" class="btn btn-dark">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>

</html>
