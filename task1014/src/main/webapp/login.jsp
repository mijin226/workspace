<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

<form action="login.do" method="POST">
<table border="1">
	<tr>
		<td>아이디</td><!-- 1행 아이디 입력 -->
		<td><input type="text" name="mid" required></td>
	</tr>
	<tr>
		<td>비밀번호</td><!-- 2행 비밀번호 입력 -->
		<td><input type="password" name="password" required></td>
	</tr>
	<tr><!-- 회원 조회 -->
		<td colspan="2" align="right"><input type="submit" value="로그인"></td>
	</tr>
</table>
</form>

</body>
</html>