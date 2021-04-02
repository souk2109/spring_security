<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sec:authorize access="isAnonymous()">
		<form action="/doLogin" method="post">
			아이디 : <input type="text" name="id">	<br>
			비밀번호 : <input type="password" name="pwd">	<br>
			<input type="submit" value="전송">
		</form>
		<br>
		<div>
			<a href="/user/register">회원가입</a>
		</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<% response.sendRedirect("/"); %>
	</sec:authorize>
	${name }
	${msg }
	 
	<!-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	 -->
</body>
</html>