// 모달 외부 클릭 시 닫기를 위한 요소 
const modalElement = document.getElementById('setPW');

// [부트스트랩 활용] 모달창 생성
const modal = new bootstrap.Modal(modalElement);

// 비밀번호 재설정하기 버튼 클릭 이벤트
document.getElementById('setPW').addEventListener('click', function() {
    // 모달을 보여줍니다.
    modal.show();
});

// 비밀번호 재설정 버튼 클릭 이벤트
document.getElementById('setPW').addEventListener('click', function() {
    // 모달 내용을 비밀번호 변경으로 변경
    document.getElementById('forgetModalLabel').innerText = '비밀번호 변경'; // 변경된 ID
    document.getElementById('modalBody').innerHTML = `
	<div class="container text-center" id="setPwContainer"
			style="display: none;">
			<br> <br> <br>
			<h2>새로운 비밀번호로 변경</h2>
			<button type="button" class="close" data-bs-dismiss="modal"
								aria-label="Close"></button>
			<!-- 비밀번호 변경 버튼 -->
			<button type="button" class="btn btn-primary" id="setPwBtn"
				data-bs-toggle="modal" data-bs-target="#setModal">비밀번호 변경</button>

			<div class="modal fade" id="setModal" tabindex="-1"
				aria-labelledby="setModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered"
					style="max-width: 500px;">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="setModalLabel">비밀번호 변경</h5>
							<button type="button" class="close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<div class="input-container">
								<span class="label">신규 비밀번호</span>
								<div class="input-containerbox">
									<input type="password" id="newPassword" name="password" class="inputbox" 
										placeholder="신규비밀번호를 입력해주세요" required>
								</div>
								<br> <span class="label">비밀번호 확인</span>
								<div class="input-containerbox">
									<input type="password" id="confirmPassword" class="inputbox" 
										placeholder="비밀번호를 확인해주세요">
								</div>
								<br>
								<br>
								<br>
								<br>
								<!-- 여백 추가 -->
								<div class="d-grid gap-2">
									<button type="button" class="btn btn-dark" id="completeChangeBtn">비밀번호 변경완료</button>
								</div>
								<br>
								<br>
								<br>
								<br>
								<!-- 여백 추가 -->
								<a href="login.do" style="text-align: center">로그인페이지로 돌아가기</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
    `;
});

// 모달 외부 클릭 시 닫기
modalElement.addEventListener('click', function(event) {
    if (event.target === modalElement) {
        modal.hide();
    }
});
