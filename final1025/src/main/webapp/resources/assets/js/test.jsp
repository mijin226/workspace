<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        function openPasswordReset() {
            document.getElementById('loginModal').style.display = 'none';
            document.getElementById('passwordResetModal').style.display = 'block';
        }

        function openLoginModal() {
            document.getElementById('loginModal').style.display = 'block';
            document.getElementById('passwordResetModal').style.display = 'none';
        }
    </script>
</head>
<body>

<div class="container">
    <h2>환영합니다!</h2>
    <button class="btn btn-primary" data-toggle="modal" data-target="#loginModal">로그인</button>
</div>

<!-- 로그인 모달 -->
<div class="modal" id="loginModal" style="display:none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">로그인</h4>
                <button type="button" class="close" onclick="openLoginModal()" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="username">아이디:</label>
                        <input type="text" class="form-control" id="username" required>
                    </div>
                    <div class="form-group">
                        <label for="password">비밀번호:</label>
                        <input type="password" class="form-control" id="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">로그인</button>
                </form>
                <button class="btn btn-link" onclick="openPasswordReset()">비밀번호 찾기</button>
            </div>
        </div>
    </div>
</div>

<!-- 비밀번호 찾기 모달 -->
<div class="modal" id="passwordResetModal" style="display:none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">비밀번호 찾기</h4>
                <button type="button" class="close" onclick="openLoginModal()" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="resetUsername">아이디:</label>
                        <input type="text" class="form-control" id="resetUsername" required>
                    </div>
                    <button type="submit" class="btn btn-primary">비밀번호 재설정 요청</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){
        $('#loginModal').modal('show');
    });
</script>

</body>
</html>
