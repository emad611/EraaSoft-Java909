<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
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
    .form-container {
        background: #fff;
        padding: 30px 40px;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.15);
    }
    .form-group {
        margin: 15px 0;
    }
    label {
        margin-right: 10px;
    }
    input[type="text"], input[type="number"], select {
        padding: 8px;
        border-radius: 5px;
        border: 1px solid #ccc;
        width: 100%;
        box-sizing: border-box;
        margin-top: 5px;
    }
    input[type="submit"] {
        padding: 10px 20px;
        background: #6C63FF;
        color: #fff;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        margin-top: 10px;
    }
    input[type="submit"]:hover {
        background: #5750d4;
    }
</style>
</head>
<body>

<div class="form-container">
    <h2>User Registration Form</h2>
    <!-- Form with POST method -->
    <form action="ReceiveData.jsp" method="post">
        <!-- Full Name -->
        <div class="form-group">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required>
        </div>

        <!-- Password -->
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="text" id="password" name="password" required>
        </div>

        <!-- Age -->
        <div class="form-group">
            <label for="age">Age:</label>
            <input type="number" id="age" name="age" required>
        </div>

        <!-- Address (Radio Buttons) -->
        <div class="form-group">
            <p><strong>Address (Radio Buttons):</strong></p>
            <input type="radio" id="cairo" name="addressRadio" value="Cairo" required>
            <label for="cairo">Cairo</label>

            <input type="radio" id="alex" name="addressRadio" value="Alex">
            <label for="alex">Alex</label>

            <input type="radio" id="menofia" name="addressRadio" value="Menofia">
            <label for="menofia">Menofia</label>
        </div>

        <!-- Address (Select Dropdown) -->
        <div class="form-group">
            <label for="addressSelect"><strong>Address (Select Dropdown):</strong></label>
            <select id="addressSelect" name="addressSelect" required>
                <option value="Cairo">Cairo</option>
                <option value="Alex">Alex</option>
                <option value="Menofia">Menofia</option>
            </select>
        </div>

        <!-- Submit Button -->
        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>
