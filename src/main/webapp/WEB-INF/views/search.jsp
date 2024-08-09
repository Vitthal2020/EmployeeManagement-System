<%@ page import="com.techno.SpringMVC.POJO.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="navbar.jsp"/>
<% 
    String msg = (String) request.getAttribute("msg");
    Employee emp = (Employee) request.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Search</title>
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
    form input[type="text"] {
        padding: 8px;
        margin-bottom: 10px;
        width: calc(100% - 20px);
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
</style>
</head>
<body>
<div class="container">
    <h1>Search for Employee</h1>
    <form action="./search" method="post">
        <label for="id">Search by ID:</label><br>
        <input type="text" name="id" required><br>
        <input type="submit" value="Search">
    </form>
    <% if (msg != null) { %>
        <h2><%= msg %></h2>
    <% } %>
    <% if (emp != null) { %>
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
                    <tr>
                        <td><%= emp.getId() %></td>
                        <td><%= emp.getName() %></td>
                        <td><%= emp.getSurname() %></td>
                        <td><%= emp.getEmail() %></td>
                        <td><%= emp.getDesignation() %></td>
                    </tr>
                </tbody>
            </table>
        </div>
    <% } %>
</div>
</body>
</html>
