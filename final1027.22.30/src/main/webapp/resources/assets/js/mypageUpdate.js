/*
1. 이메일 중복검사 및 닉네임 중복검사해야만 수정완료 버튼 작용
*/

// 파일 입력 필드에서 파일이 선택되었을 때 호출되는 함수
function previewImage(event) {
	// 선택된 파일을 가져옴
	const file = event.target.files[0];
	// 파일이 선택되지 않았으면 함수 종료
	if (!file) {
		return;
	}
	// FileReader 객체를 생성
	const reader = new FileReader();
	// 파일이 로드되었을 때 실행되는 이벤트 핸들러
	reader.onload = function(e) {
		// 미리보기 이미지 태그의 src 속성을 선택된 파일의 데이터로 설정
		const previewImage = document.getElementById('previewImage');
		previewImage.src = e.target.result; // 파일의 데이터 URL
		previewImage.style.display = 'block'; // 이미지 태그를 보이도록 설정
	};
	// 파일 읽기 시작
	reader.readAsDataURL(file);
}
var isNickNameChecked = false; // 닉네임 중복 확인 여부
var isEmailChecked = false; // 이메일 중복 확인 여부

// 닉네임 중복 확인 함수
function checkNickNameFunction() {
	console.log("로그 : 닉네임 중복확인 시작");
	var nickName = $('#nickName').val();
	$.ajax({
		url: 'checkNickName.do',
		method: 'POST',
		data: {
			nickName: nickName
		},
		success: function(data) {
			console.log("[" + data + "]");
			if (data === 'true') {
				$("#checkNickNameMsg")
					.text("사용가능한 닉네임입니다.").css('color',
						'green');
				isNickNameChecked = true; // 중복 확인 성공 시 true로 설정
			} else {
				$("#checkNickNameMsg").text(
					"이미 사용중인 닉네임입니다.").css('color',
						'red');
				$('#nickName').val('').focus();
			}
			console.log("로그 : 닉네임 중복확인 종료");
		},
		error: function() {
			alert('닉네임 중복 확인 중 오류가 발생했습니다.');
			console.log("로그 : 닉네임 중복확인 종료(오류발생)");
		}
	});
}

// 이메일 중복 확인 함수
function checkEmailFunction() {
	console.log("로그 : 이메일 중복확인 시작");
	var email = $('#email').val();
	$.ajax({
		url: 'checkEmail.do',
		method: 'POST',
		data: {
			email: email
		},
		success: function(data) {
			console.log("[" + data + "]");
			if (data === 'true') {
				$("#checkEmailMsg").text("사용 가능한 이메일입니다.")
					.css('color', 'green');
				isEmailChecked = true; // 중복 확인 성공 시 true로 설정
			} else {
				$("#checkEmailMsg").text("이미 사용중인 이메일입니다.")
					.css('color', 'red');
				$('#email').val('').focus();
			}
			console.log("로그 : 이메일 중복확인 종료");
		},
		error: function() {
			alert('이메일 중복 확인 중 오류가 발생했습니다.');
			console.log("로그 : 이메일 중복확인 종료(오류발생)");
		}
	});
}

// 닉네임 중복 확인 버튼 클릭
var nick = "${member.memberNickname}";
$('#checkNicknameBtn').on('click', function() {
	if ($('#nickname').val() !== '') {
		if ($('#nickname').val() === nick) {
			$("#checkNicknameMsg").text("기존의 닉네임과 동일한 닉네임입니다.").css('color', 'red');
			isNicknameChecked = true; // 중복 확인 성공 시 true로 설정
		} else {
			checkNicknameFunction();
		}
	} else {
		alert('닉네임을 입력해주세요.');
	}
});

// 이메일 중복 확인 버튼 클릭
var email = "${member.memberEmail}";
$('#checkEmailBtn').on('click', function() {
	if ($('#email').val() !== '') {
		if ($('#email').val() === email) {
			$("#checkEmailMsg").text("기존의 이메일과 동일한 이메일입니다.").css('color', 'red');
			isEmailChecked = true; // 중복 확인 성공 시 true로 설정
		} else {
			checkEmailFunction();
		}
	} else {
		alert('이메일을 입력해주세요.');
	}
});

// 폼 제출 시 중복 확인 여부 검사
$('#submitBtn').on('click', function(event) {
	if (!isNicknameChecked) {
		alert('닉네임 중복 확인을 해주세요.');
		event.preventDefault(); // 폼 제출 막기
		return false;
	}
	if (!isEmailChecked) {
		alert('이메일 중복 확인을 해주세요.');
		event.preventDefault(); // 폼 제출 막기
		return false;
	}
});