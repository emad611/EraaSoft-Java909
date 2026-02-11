<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#f4f6f9;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

/* card */
.container{
    background:white;
    padding:30px;
    width:350px;
    border-radius:10px;
    box-shadow:0 0 10px rgba(0,0,0,0.1);
}

/* title */
h2{
    text-align:center;
    margin-bottom:20px;
}

/* input fields */
input{
    width:100%;
    padding:10px;
    margin:10px 0;
    border-radius:5px;
    border:1px solid #ccc;
}

/* button */
button{
    width:100%;
    padding:10px;
    border:none;
    border-radius:5px;
    background:#007bff;
    color:white;
    font-size:16px;
    cursor:pointer;
}

button:hover{
    background:#0056b3;
}

</style>
</head>

<body>

<div class="container">

<h2>Add New Item</h2>

<form action="${pageContext.request.contextPath}/itemcontroller" method="post">

    <label>Item Name</label>
    <input type="text" name="name" required>

    <label>Price</label>
    <input type="number" step="0.01" name="price" required>

    <input type="hidden" name="action" value="add_item">

    <button type="submit">Add Item</button>

</form>

</div>

</body>
</html>