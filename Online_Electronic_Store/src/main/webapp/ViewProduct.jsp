<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.AdminBean"%>
<%@page import="com.pack1.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="center-box">
<%
     AdminBean abean=(AdminBean)session.getAttribute("abean");
     ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
%>
    <h1>
        Hello <%= abean.getaFname() %>, These are your Product Details
    </h1>
    <% if(al.size()==0) { %>
        <div class="alert alert-warning" role="alert">
            Products are NOT available!
        </div>
    <% } else { %>
        <table class="table table-bordered table-hover align-middle">
            <thead>
                <tr>
                    <th>Product Code</th>
                    <th>Name</th>
                    <th>Company</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <% 
                Iterator<ProductBean> i=al.iterator();
                while(i.hasNext()) {
                    ProductBean pb=i.next();
            %>
                <tr>
                    <td><%= pb.getpCode() %></td>
                    <td><%= pb.getpName() %></td>
                    <td><%= pb.getpCompany() %></td>
                    <td>&#8377; <%= pb.getpPrice() %></td>
                    <td><%= pb.getpQuantity() %></td>
                    <td>
                        <a href="edit?pcode=<%= pb.getpCode() %>" class="btn btn-sm btn-primary">Edit</a>
                        <a href="delete?pcode=<%= pb.getpCode() %>" class="btn btn-sm btn-danger">Delete</a>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
    <% } %>
    <a href="logout" class="logout-btn">Logout</a>
</div>
<!-- Bootstrap JS Bundle (optional if you want dropdowns, etc.) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>