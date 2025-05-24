<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(135deg, #667eea, #764ba2);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        color: white;
        text-align: center;
    }
    .logout-container {
        background: rgba(255, 255, 255, 0.15);
        padding: 40px 50px;
        border-radius: 15px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.3);
    }
    a.btn-logout {
        margin-top: 20px;
        padding: 12px 30px;
        font-size: 1.1rem;
        border-radius: 8px;
        transition: all 0.3s ease;
    }
    a.btn-logout:hover {
        background-color: #ffffffcc;
        color: #764ba2;
        text-decoration: none;
    }
</style>

</head>
<body>

    <div class="logout-container">
    <h1>
    <%
        session.invalidate();
        out.println("Logged out Successfully!");
    %>
    </h1>
    <a href="index.html" class="btn btn-light btn-logout">Go to Login Page</a>
    </div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
