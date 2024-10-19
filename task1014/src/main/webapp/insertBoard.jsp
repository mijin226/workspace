<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>

<form action="insertBoard.do" method="POST">
	작성자 <input type="text" name="writer" value="${userID}" readonly> <br>
	내용 <input type="text" name="content" required> <br>
	<input type="submit" value="글 작성">
</form>

<hr>

<a href="main.do">메인으로 이동</a>

</body>
</html>