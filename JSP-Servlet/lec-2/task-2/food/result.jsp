<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #141e30, #243b55);
    min-height: 100vh;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
}

.container {
    background: #ffffff;
    padding: 30px 35px;
    border-radius: 14px;
    box-shadow: 0 15px 40px rgba(0,0,0,0.35);
    width: 360px;
}

h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #243b55;
}

ul {
    list-style: none;
    padding: 0;
    margin: 0;
}

.order_value {
    background: linear-gradient(135deg, #667eea, #764ba2);
    color: white;
    padding: 12px 15px;
    margin-bottom: 10px;
    border-radius: 8px;
    font-weight: bold;
    text-align: center;
    box-shadow: 0 6px 15px rgba(0,0,0,0.2);
    transition: transform 0.2s;
}

.order_value:hover {
    transform: scale(1.05);
}

.empty {
    text-align: center;
    color: #999;
    font-style: italic;
}
</style>
</head>

<body>

<%
    List<String> allorders = (List<String>) session.getAttribute("allorders");

    if (allorders == null) {
        allorders = new ArrayList<>();
    }

    String order = request.getParameter("order");

    if (order != null && !order.trim().isEmpty()) {
        allorders.add(order);
    }

    session.setAttribute("allorders", allorders);
%>

<div class="container">
    <h2>Selected Orders</h2>

    <% if (allorders.isEmpty()) { %>
        <p class="empty">No orders yet</p>
    <% } else { %>
        <ul>
        <% for (String o : allorders) { %>
            <li class="order_value"><%= o %></li>
        <% } %>
        </ul>
    <% } %>
</div>

</body>
</html>
