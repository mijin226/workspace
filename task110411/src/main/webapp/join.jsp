<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<!-- JQuery import -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/checkedMID.js"></script>
<script src="js/checkedPW.js"></script>
</head>
<body>

<form action="joinInsert.do" method="POST">
<table border="1">
	<tr><!-- 1행 : 아이디 입력-->
		<td>아이디</td>
		<td><input type="text" id="mid" name="mid" required placeholder="아이디를 입력해주세요."><br><span id="resultMID"></span></td>
	</tr>
	<tr><!-- 2행 : 비밀번호 입력 -->
		<td>비밀번호</td>
		<td><input type="password" id="password" name="password" required placeholder="비밀번호를 입력해주세요."></td>
	</tr>
	<tr><!-- 3행 : 비밀번호 재확인 -->
		<td>비밀번호 재확인</td>
		<td><input type="password" id="doublePassword" name="doublePassword" required placeholder="비밀번호를 확인해주세요."><br><span id="resultPW"></span></td>
	</tr>
	<tr><!-- 4행 : 이름 입력 -->
		<td>이름</td>
		<td><input type="text" id="name" name="name" required placeholder="이름을 입력해주세요."></td>
	</tr>
	<tr><!-- 5행 : 회원 정보(아이디, 비번) 확인 -->
		<td colspan="2" align="right"><input type="submit" value="회원가입신청"></td>
	</tr>
</table>
</form>

</body>
</html>