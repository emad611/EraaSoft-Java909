<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Form</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #667eea, #764ba2);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

form {
    background-color: #ffffff;
    padding: 30px 35px;
    border-radius: 12px;
    box-shadow: 0 12px 30px rgba(0, 0, 0, 0.2);
    width: 320px;
}

label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #333;
    font-size: 14px;
}

input[type="text"] {
    width: 100%;
    padding: 10px 12px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 14px;
    margin-bottom: 20px;
    transition: border-color 0.3s, box-shadow 0.3s;
}

input[type="text"]:focus {
    outline: none;
    border-color: #667eea;
    box-shadow: 0 0 6px rgba(102, 126, 234, 0.4);
}

input[type="submit"] {
    width: 100%;
    padding: 12px;
    background-color: #667eea;
    color: #ffffff;
    border: none;
    border-radius: 6px;
    font-size: 15px;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.2s;
}

input[type="submit"]:hover {
    background-color: #5a67d8;
    transform: translateY(-2px);
}
</style>

</head>
<body>

<form action="result.jsp" method="post">
    <label>Enter order</label>
    <input type="text" name="order">

    <input type="submit" value="Submit">
</form>

</body>
</html>
