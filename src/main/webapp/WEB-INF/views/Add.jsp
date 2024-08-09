<%@page import="java.util.List"%>
<%@page import="com.techno.SpringMVC.POJO.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="navbar.jsp"/>
<%
    String msg = (String) request.getAttribute("msg");
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    .container {
        width: 80%;
        margin: auto;
        padding: 20px;
    }
    form {
        margin-bottom: 20px;
    }
    form input[type="text"], form input[type="email"] {
        padding: 8px;
        margin-bottom: 10px;
        width: calc(30% - 20px);
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    form input[type="submit"] {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    form input[type="submit"]:hover {
        background-color: #45a049;
    }
    .message {
        font-size: 18px;
        color: green;
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
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    table, th, td {
        border: 1px solid #ccc;
    }
    th, td {
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Add Employee</h1>
    <form action="./Add" method="post">
        <label for="name">Name:</label><br>
        <input type="text" name="name" required><br>
        <label for="surname">Surname:</label><br>
        <input type="text" name="surname" required><br>
        <label for="email">Email:</label><br>
        <input type="email" name="email" required><br>
        <label for="designation">Designation:</label><br>
        <input type="text" name="designation" required><br>
        <input type="submit" value="Add">
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
