<%@ page import="com.pack1.AdminBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Dashboard</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">

    <div class="card p-5 shadow" style="width: 100%; max-width: 400px;">
        <%
            AdminBean abean = (AdminBean) session.getAttribute("abean");
            if (abean != null) {
        %>
        <h3 class="text-center text-primary mb-4">
            Welcome Mr. <%= abean.getaFname() %>!!!
        </h3>

        <div class="d-grid gap-3">
            <a href="Addproduct.html" class="btn btn-outline-primary">Add Product</a>
            <a href="View1" class="btn btn-outline-success">View Products</a>
            <a href="logout" class="btn btn-outline-danger">Logout</a>
        </div>
        <%
            } else {
        %>
        <h4 class="text-danger text-center">Session expired. Please log in again.</h4>
        <div class="text-center mt-3">
            <a href="login.html" class="btn btn-primary">Go to Login</a>
        </div>
        <%
            }
        %>
    </div>

    <!-- Bootstrap 5 JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
