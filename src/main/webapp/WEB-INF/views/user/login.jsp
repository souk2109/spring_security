<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${msg }
	<form action="/controller/login" method="post">
		아이디 : <input type="text" name="id">
		비밀번호 : <input type="password" name="pwd">
		<input type="submit" value="전송">
	</form>
	
	<!-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	 -->
</body>
</html>