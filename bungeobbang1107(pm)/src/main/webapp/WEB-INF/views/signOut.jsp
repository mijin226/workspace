<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
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
<title>회원탈퇴</title>
<!-- 파비콘 -->
<link rel="icon" href="${path}/resources/assets/images/logo.png"
	type="image/x-icon" />

<!-- CSS -->
<link rel="stylesheet"
	href="${path}/resources/assets/css/member/loginAndSign.css">

<!-- 스위트알랏2 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>

<body>
	<custom:header />
	<!--bootstrap CDN-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>


	<form id="deleteMember" action="deleteMember.do" method="POST">
		<input type="hidden" name="memberNum" value="${userPK}">
		<!--전체 컨테이너 시작-->
		<div class="container text-center">
			<br> <br> <br>
			<!--제목 : 회원탈퇴-->
			<h2>회원탈퇴</h2>
			<br> <br>

			<!-- 붕어빵 이미지-->
			<div class="col" style="text-align: center">
				<img src="${path}/resources/assets/images/breadfishCat.jpg"
					class="breadfishCat">
				<!-- 회원탈퇴 시 개인정보 관련 안내-->
				<div class="input-container">
					${userNickname}님 정말 회원탈퇴하시겠어요?<br> <br> '회원탈퇴'를 입력 후
					탈퇴버튼을 누르면<br> 적립한 포인트 등 개인정보가 모두 삭제됩니다<br> <br>
					개인정보를 다시 복구할 수 없으니 신중히 고려해주세요<br> 탈퇴 후 작성한 게시물과 댓글은 남아있으며, 삭제
					불가합니다.<br> <br>

					<!-- 회원탈퇴 문구 작성 및 탈퇴 요청버튼-->
					<div class="input-containerbox">
						<input type="text" class="inputbox" id="signOutText"
							placeholder="회원탈퇴">
					</div>
					<div>
						<br>
						<button type="button" class="btn btn-warning btn-lg" id="signOut">회원탈퇴
							요청</button>
					</div>
					<!-- 회원탈퇴 문구 작성 및 탈퇴 요청버튼 끝-->
					<br>
				</div>
				<!-- 회원탈퇴 시 개인정보 관련 안내 끝-->
				<br>
			</div>
			<!-- 붕어빵 이미지 끝 -->
			<br> <br> <br> <br> <br>
		</div>
	</form>
	<!--전체 컨테이너 끝-->
	<custom:footer />
</body>
<script>
$('#signOut').on('click', function() {
	console.log("log: signOut.js start")
	const signOutText = document.getElementById('signOutText').value;// 값 가져오기

	//정확한 문구 입력시
	if (signOutText === '회원탈퇴') {
	
		Swal.fire({
			title: '회원 탈퇴 확인',
			text: "정말 탈퇴하시겠습니까? '확인'을 누르면 회원탈퇴가 마무리됩니다.",
			icon: 'warning',
			showCancelButton: true,//취소 버튼 생성
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if(result.isConfirmed){
				$('#deleteMember').submit();
				console.log('log : 탈퇴 완료');
			}
		});	
	}
	else {
		//문구가 올바르지 않을 경우
		console.log("log: not ready to signOut");
		Swal.fire({
			title: '회원 탈퇴 확인',
			text: "'회원탈퇴'를 올바르게 입력 바랍니다.",
			icon: 'info',
			confirmButtonText: '확인'
		});
	}
});
</script>
</html>