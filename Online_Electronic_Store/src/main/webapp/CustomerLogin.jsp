<%@page import="com.pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
  body {
    background: linear-gradient(135deg, #667eea, #764ba2);
    height: 100vh;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    color: white;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .dashboard-container {
    background: rgba(255, 255, 255, 0.15);
    padding: 40px 50px;
    border-radius: 15px;
    box-shadow: 0 8px 25px rgba(0,0,0,0.3);
    max-width: 450px;
    width: 90%;
    text-align: center;
  }
  .dashboard-container h2 {
    margin-bottom: 30px;
  }
  .btn-custom {
    margin: 10px 0;
    width: 100%;
    padding: 12px;
    font-size: 1.1rem;
    border-radius: 8px;
    transition: background-color 0.3s ease;
  }
  .btn-view {
    background-color: #28a745;
    color: white;
  }
  .btn-view:hover {
    background-color: #218838;
    color: white;
  }
  .btn-logout {
    background-color: #dc3545;
    color: white;
  }
  .btn-logout:hover {
    background-color: #c82333;
    color: white;
  }
  a {
    text-decoration: none;
  }
</style>

</head>
<body>

<div class="dashboard-container">
    <h2>
    <%
       CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");
       if (cbean != null) {
           out.println("Welcome "+cbean.getFname()+"..!!<br><br>");
       } else {
           out.println("Session expired or user not logged in. Please <a href='CustomerLogin.html' class='text-warning'>login</a> again.");
           return;
       }
    %>
    </h2>

    <a href="view2" class="btn btn-custom btn-view">View Products</a>
    <a href="logout" class="btn btn-custom btn-logout">Logout</a>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
