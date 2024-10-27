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
<link rel="stylesheet" href="/webapp/resources/assets/css/modal.css">
</head>

<body>

	<!--bootstrap CDN코드-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<div class="container">
		<br> <br> <br>
		<h2>새로운 비밀번호로 변경</h2>
		<!-- 비밀번호 변경 버튼 -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#setPwModal">비밀번호 변경</button>

<!-- 2차 새비밀번호로 변경 모달창 -->
	<div class="modal" id="setPwModal" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">새로운 비밀번호로 변경</h4>
					<button type="button" class="close" onclick="closedModal()"
						data-dismiss="modal">&times;</button>
				</div>

				<!-- 새 비밀번호 입력 및 변경 완료 내용 -->
				<div class="modal-body">
					<!-- 1. 신규 비밀번호 입력 -->
					<div class="form-group">
						<br> <label for="newPassword" class="text-start">신규
							비밀번호</label> <input type="password" class="form-control" id="password"
							name="password" required placeholder="변경할 비밀번호를 입력해주세요">
						<br>
					</div>

					<!-- 2. 비밀번호 재확인차 입력 -->
					<div class="form-group">
						<label for="passwordCheck" class="text-start">비밀번호 확인</label> <input
							type="password" class="form-control" id="passwordCheck"
							name="passwordCheck" required placeholder="비밀번호를 확인해주세요">
						<br> <br>
					</div>

					<div class="d-grid gap-2">
						<!-- text-center 제거 -->
						<button type="submit" class="btn btn-dark" id="completePw"
							name="completePw" onclick="closedModal()">비밀번호 변경하기</button>
					</div>

					<div class="text-center mt-3">
						<a href="main.do">메인으로 돌아가기</a> <br>
					</div>
				</div>
			</div>
		</div>
	</div></div>
</body>

</html>
