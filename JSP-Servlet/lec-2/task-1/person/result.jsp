<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String full_name=request.getParameter("full name");

Integer age=Integer.parseInt(request.getParameter("age"));

%>
<%= full_name %>
<br>
<%=  age %>
</body>
</html>