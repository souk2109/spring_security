<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>모두를 위한 페이지</h1>
	<h2>세션값 확인하기</h2>
	<%
		Enumeration elements  = session.getAttributeNames();
		while(elements.hasMoreElements()){
			String name = elements.nextElement().toString();
			String value = session.getAttribute(name).toString();
			out.print("세션이름 : " + name +", 값 : " + value);
		}
	%>
</body>
</html>