<%@page import="com.techno.SpringMVC.POJO.Employee"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="navbar.jsp"/>
<%  String msg = (String) request.getAttribute("msg");
List<Employee> employees=(List<Employee>)request.getAttribute("employees"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            width: 50%;
            margin: 0 auto;
        }
        form {
            margin-top: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
        }
        .form-group input {
            width: 300px;
            padding: 5px;
        }
         table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    table, th, td {
        border: 1px solid black;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    .error {
        font-size: 18px;
        color: red;
    }
    .slide-down {
        animation: slide-down 2s ease-in-out;
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
        .form-group button {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .msg {
            margin-top: 10px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        

        
            <form action="./Update" method="post">
            <div>
            <div class="form-group">
           <label for="id">Id:</label>
                <input type="text" name="id" >
                </div>
                </div>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text"  name="name"  required>
                </div> 
                <div class="form-group">
                    <label for="surname">Surname:</label>
                    <input type="text" id="surname" name="surname" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email"  required>
                </div>
                <div class="form-group">
                    <label for="designation">Designation:</label>
                    <input type="text" id="designation" name="designation" required>
                </div>
                <button type="submit">Update</button>
            </form>
             <% if (employees != null) { %>
        <div class="slide-down">
            <h2>Employee Details</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Email</th>
                        <th>Designation</th>
                    </tr>
                </thead>
                <tbody>
                <% for (Employee pojo : employees) { %>
                    <tr>
                        <td><%= pojo.getId() %></td>
                        <td><%= pojo.getName() %></td>
                        <td><%= pojo.getSurname() %></td>
                        <td><%= pojo.getEmail() %></td>
                        <td><%= pojo.getDesignation() %></td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    <% } %>
    
    <% if (msg != null) { %>
        <h1 class="<%= msg.contains("not") ? "error" : "message" %>"><%= msg %></h1>
    <% } %>
        
  
    </div>
</body>
</html>
