<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인 페이지</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
//두번째 모달로 이동
	function openPasswordReset() {
		document.getElementById('loginModal').style.display = 'none';
		document.getElementById('passwordResetModal').style.display = 'block';
	}
//
	function closedModal() {
		document.getElementById('loginModal').style.display = 'block';
		document.getElementById('passwordResetModal').style.display = 'none';
	}
</script>
</head>
<body>
	<script src="resetPw.js"></script>
	<script src="sendEmail.js"></script>
	<div class="container">
		<!-- 로그인 페이지 -->
		<div class="container text-center">
			<br> <br> <br>
			<h2>로그인</h2>
			<br> <br>
			<div class="row align-items-start">
				<div class="col" style="text-align: center;">
					<img src="\resources\assets\images\breadfishmiddle.jpg" class="img">
				</div>

				<!-- 로그인 폼태그 -->
				<form id="login" action="login.do" method="POST">
					<div class="col" style="text-align: left;">
						<div class="input-container">

							<!-- 1. 이메일 입력 안내 -->
							<span class="label">이메일</span>
							<div class="input-containerbox">

								<!-- 우편 모양 아이콘 -->
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
                            <path
										d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z" />
                        </svg>

								<!-- 이메일 입력란 -->
								<input type="email" class="inputbox" name="email"
									placeholder="이메일을 입력해주세요" required>
							</div>

							<!-- 2. 비밀번호 입력 안내 -->
							<br> <span class="label">비밀번호</span>
							<div class="input-containerbox">

								<!-- 자물쇠 아이콘 -->
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
                            <path
										d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2m3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2M5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1" />
                        </svg>

								<!-- 비밀번호 입력란 -->
								<input type="password" class="inputbox"
									placeholder="비밀번호를 입력해주세요" required>
							</div>
							<div>
								<button class="btn btn-primary.text-nowrap" data-toggle="modal"
									data-target="#forgetModal">비밀번호를 잊어버리셨나요?</button>
							</div>
						</div>
						<br>
						<div class="d-grid gap-2 col-mx-auto">
							<button class="btn btn-warning" type="button">로그인</button>
						</div>
						<div>
							<br>
							<%-- 구글 로그인 버튼 시작 : ** client_id를 변경해 사용 --%>
							<div id="g_id_onload"
								data-client_id="730285026476-3dh5pad8cclbr7gsvi75rrmejnemf58l.apps.googleusercontent.com"
								data-context="signin" data-ux_mode="popup"
								data-callback="handleCredentialResponse"
								data-auto_prompt="false"></div>

							<div class="g_id_signin" data-type="icon" data-shape="circle"
								data-theme="outline" data-text="signin_with" data-size="large">
							</div>
							</dive>
							<%--구글 로그인 버튼 끝 --%>
						</div>
						<br>
						<div>
							아직 회원이 아니신가요? <a href="signUp.do">회원가입</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 1차 회원정보 확인 모달창 -->
	<div class="modal" id="forgetModal" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">비밀번호를 잊어버리셨나요?</h4>
					<button type="button" class="close" onclick="closedModal()"
						data-dismiss="modal">&times;</button>
				</div>

				<!-- 회원여부확인 내용 -->
				<div class="modal-body">

					<!-- 회원여부 확인 후 비밀번호 재설정 버튼 누를 시 작동 -->

					<!-- 1. 이름 입력 -->
					<div class="form-group">
						<label for="username">이름</label> <input type="text"
							class="form-control" id="name" name="name" required
							placeholder="이름을 입력해주세요">
					</div>

					<!-- 2. 이메일 입력 -->
					<div class="form-group">
						<label for="email">이메일</label> <input type="email"
							class="form-control" id="email" name="email" required
							placeholder="이메일을 입력해주세요">

					</div>
					<div style="text-align: right">
						<br>
						<button type="button" class="btn btn-secondary" id="sendNum">메일로
							인증번호 보내기</button>
					</div>
					<br>

					<!-- 3. 수신한 인증번호 입력 -->
					<span id="sendEmailMsg" class="label">인증번호 확인</span>
					<div class="input-containerbox mb-3">
						<div class="d-flex align-items-center border rounded">
							<input type="text" class="form-control ms-2 border-0"
								id="checkNumMsg" placeholder="인증번호를 입력해주세요"
								requeired="requeired"
								style="margin: 0; padding: 0.375rem 0.75rem;">
						</div>
						<br>
					</div>
					<!-- 인증번호가 일치할 경우, 비밀번호 재설정 버튼 open / 인증번호 빈칸 혹은 입력값 틀렸다면 hidden처리 -->
					<div class="d-grid gap-2 text-center">
						<button type="submit" class="btn btn-dark" id="resetPw"
							name="resetPw" data-bs-target="#setPwModal"
							data-bs-toggle="modal" onclick="closedModal()">비밀번호
							재설정하러 가기</button>
					</div>
					<div class="text-center mt-3">
						<a href="main.do">메인으로 돌아가기</a> <br>
					</div>
					<div>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 비밀번호 찾기 모달 -->
	<div class="modal" id="passwordResetModal" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
			
			<!-- 모달 제목 및 닫기버튼 -->
				<div class="modal-header">
					<h5 class="modal-title" id="setModalLabel">비밀번호 변경</h5>
					<button type="button" class="close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				
				<!-- 비밀번호 찾기 내용 -->
				<div class="modal-body">
					<div class="input-container">
						<span class="label">신규 비밀번호</span>
						<div class="input-containerbox">
							<input type="password" class="inputbox"
								placeholder="신규비밀번호를 입력해주세요">
						</div>
						<!-- 비동기 추가 예정-->
						<br> <span class="label">비밀번호 확인</span>
						<div class="input-containerbox">
							<input type="password" class="inputbox"
								placeholder="비밀번호를 확인해주세요">
						</div>
						<br>
						<div class="d-grid gap-2">
							<button type="button" class="btn btn-dark">비밀번호 변경완료</button>
						</div>
						<a href="login.do" style="text-align: center">로그인페이지로 돌아가기</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$('#loginModal').modal('show');
		});
	</script>

</body>
</html>
