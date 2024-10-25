<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모달창 테스트용</title>
</head>
<body>
<!-- 부트스트랩 CSS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
		
<a href="#" style="text-align: right">로그인페이지로 돌아가기</a>

	<script>
    // 모달 요소
    var modal = document.getElementById("forgetModal");

    // 링크 클릭 시 모달 열기
    document.getElementById("forgetModal").onclick = function (event) {
    event.preventDefault(); // 기본 링크 동작 방지
    modal.style.display = "block";
    }

    // 모달 닫기
    document.getElementsByClassName("close")[0].onclick = function () {
    modal.style.display = "none";
    }

    // 모달 외부 클릭 시 닫기
    window.onclick = function (event) {
    	if (event.target == modal) {
    	modal.style.display = "none";
</body>
</html>