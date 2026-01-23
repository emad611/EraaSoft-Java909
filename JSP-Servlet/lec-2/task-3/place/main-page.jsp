<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Cookie</title>
</head>
<body>

<%
Cookie[] cookies = request.getCookies();
String favPlace = null;

if (cookies != null) {
    for (Cookie cookie : cookies) {
        if ("fav_place".equals(cookie.getName())) {
            favPlace = cookie.getValue();
            break;
        }
    }
}
%>

<h2>Your Favorite Place:</h2>
<% if (favPlace != null) { %>
    <p><%= favPlace %></p>
<% } else { %>
    <p>No favorite place selected yet.</p>
<% } %>

</body>
</html>
