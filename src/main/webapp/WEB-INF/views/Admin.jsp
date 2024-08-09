<%@page import="com.techno.SpringMVC.POJO.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        
        margin-left: 10%;  
    }
    .container {
        background-color: #fff;
        padding: 40px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        max-width: 500px;
        width: 100%;
        animation: slide-down 0.5s ease-in-out;
    }
    @keyframes slide-down {
        0% {
            opacity: 0;
            transform: translateY(-30%);
        }
        100% {
            opacity: 1;
            transform: translateY(0);
        }
    }
    .container h2 {
        margin-bottom: 20px;
        font-size: 24px;
        text-align: center;
    }
    .input-field {
        position: relative;
        margin-bottom: 20px;
    }
    .input-field i {
        background: #eaeaea;
            margin: 15px 0;
            border-radius: 3px;
            display: flex;
            align-items: center;
            max-height: 65px;
            transition: max-height 0.2s;
    }
    .input-field input {
         width: 90%;
            font-size: 20px;
            background: #eaeaea;
            border: 0;
            outline: 0;
            padding: 18px 15px;
            margin-left: 2px;
    }
    .input-field input:focus {
        border-color: #4CAF50;
        outline: none;
    }
    .btn-field {
        text-align: center;
    }
    .btn-field button {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    .btn-field button:hover {
        background-color: #45a049;
    }
    .btn-field i {
        margin-right: 8px;
    }
    .div{
    color: green;
    margin-right: 30%;
    font-size:20px;
    }
</style>
</head>
<body>
<div class="container">
    <h2>Create Account</h2>
    <form action="./create" method="post">
        <div class="input-field">
            <i class="fa-solid fa-envelope"></i>
            <input type="text" name="username" placeholder="Username" required>
        </div>
        <div class="input-field">
            <i class="fa-solid fa-lock"></i>
            <input type="password" name="password" placeholder="Password" required>
        </div>
        <div class="btn-field">
            <button type="submit"><i class="fa-solid fa-right-from-bracket"></i> Create Account</button>
        </div>
    </form>
    
     <% if (msg != null) { %>
     <h1 class="div"><%=msg %></h1>
       
       <%} %>
    
</div>
   
 
    
</body>
</html>
