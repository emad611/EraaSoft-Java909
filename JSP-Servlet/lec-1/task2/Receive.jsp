<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Received Data</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f0f2f5;
        display: flex;
        justify-content: center;
        align-items: flex-start;
        min-height: 100vh;
        padding-top: 50px;
    }
    .container {
        background: #fff;
        padding: 30px 40px;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.15);
    }
    h2 {
        color: #333;
        margin-top: 0;
    }
    p {
        font-size: 1.1em;
        color: #555;
    }
</style>
</head>
<body>

<div class="container">
    <h2>Form Data Received</h2>

<%
    // Receive parameters from form
    String fullName = request.getParameter("fullName");
    String password = request.getParameter("password");
    String ageStr = request.getParameter("age");
    String addressRadio = request.getParameter("addressRadio");
    String addressSelect = request.getParameter("addressSelect");

    int age = 0;
    if(ageStr != null) {
        try {
            age = Integer.parseInt(ageStr);
        } catch(Exception e) { }
    }

%>

<p><strong>Full Name:</strong> <%= fullName %></p>
<p><strong>Password:</strong> <%= password %></p>
<p><strong>Age:</strong> <%= age %></p>
<p><strong>Address (Radio Button):</strong> <%= addressRadio %></p>
<p><strong>Address (Select Dropdown):</strong> <%= addressSelect %></p>

</div>

</body>
</html>
