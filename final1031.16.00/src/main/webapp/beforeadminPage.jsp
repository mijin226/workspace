<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <meta charset="UTF-8">
    <title>관리자 페이지</title>
    <link rel="stylesheet" href="/webapp/resources/assets/css/loginAndsign.css">
</head>

<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<custom:header/>
    <div class="container text-center">
        <br><br><br>
        <h2>관리자 페이지</h2>
        <br><br>
        <div class="row align-items-start">
            <!--1열 붕어빵 이미지 및 프로필 수정버튼-->
            <div class="col-6" style="text-align: center;">
                <br><br>
				<img src="/images/breadfishProfile.jpg" class="signupimg">
                <br><br>
                <h4>Point &nbsp; &nbsp; &nbsp; 123</h4>
                <br>
                <button type="button" class="btn btn-primary">프로필 수정</button>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <br><br>
                <button class="btn btn-warning btn-lg" type="button">회원탈퇴</button>
            </div>

            <!--2열 : 관리자정보 항목-->
            <div class="col-2">
                <br>
                <br><br><br>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">이름</th>
                        </tr>
                        <tr>
                            <th scope="col">이메일</th>
                        </tr>
                        <tr>
                            <th scope="col">전화번호</th>
                        </tr>
                        <tr>
                            <th scope="col">주소</th>
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="col-4">
                <br><br><br><br>
                <table class="table table-borderless">
                    <td scope="col">관리자</td>
                    <tr> </tr>
                    <td>admin@academy.com</td>
                    <tr></tr>
                    <td scope="col">010-1234-5678</td>
                    <tr></tr>
                    <td>강남구 테헤란로</td>
                </table>
            </div>
        </div>
    </div>
</body>

</html>