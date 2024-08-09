<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>


<nav class="navbar  bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./Add">Add</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./search">search</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./Update">Update</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./Delete" >Delete</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="./Logout" >Logout</a>            
        </li>
      </ul>
    </div>
  </div>                                       
</nav>
</body>           
</html>