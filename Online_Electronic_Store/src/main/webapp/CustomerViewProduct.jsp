<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.pack1.ProductBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Available Products</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap 5 CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background: #f8f9fa;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    .container {
      margin-top: 40px;
      max-width: 1000px;
    }
    h2 {
      color: #343a40;
      margin-bottom: 30px;
      text-align: center;
    }
    .table thead th {
      background-color: #0d6efd;
      color: white;
    }
    .btn-buy {
      background-color: #198754;
      color: white;
      border-radius: 5px;
      padding: 6px 12px;
      text-decoration: none;
    }
    .btn-buy:hover {
      background-color: #157347;
      color: white;
    }
    .logout-link {
      display: block;
      margin: 30px auto 0;
      max-width: 100px;
      text-align: center;
      font-weight: 600;
      color: #dc3545;
      text-decoration: none;
      border: 2px solid #dc3545;
      padding: 8px 15px;
      border-radius: 8px;
      transition: background-color 0.3s ease, color 0.3s ease;
    }
    .logout-link:hover {
      background-color: #dc3545;
      color: white;
      text-decoration: none;
    }
    .alert-warning {
      max-width: 900px;
      margin: 20px auto;
      text-align: center;
    }
  </style>
</head>
<body>

<div class="container">
  <%
    CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");
    ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("ProductsList");

    if (cbean == null) {
  %>
      <div class="alert alert-warning" role="alert">
        Session expired or user not found. Please <a href="CustomerLogin.html" class="alert-link">login</a> again.
      </div>
  <%
      return;
    }
    
    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
  %>

  <h2>Hello <%= cbean.getFname() %>, these are the available product details:</h2>

  <%
    if (al == null || al.isEmpty()) {
  %>
      <div class="alert alert-info text-center" role="alert">
        Oops! There are no products available right now.
      </div>
  <%
    } else {
  %>

    <div class="table-responsive">
      <table class="table table-striped table-bordered align-middle">
        <thead>
          <tr>
            <th>Product Code</th>
            <th>Product Name</th>
            <th>Product Company</th>
            <th>Product Price</th>
            <th>Product Quantity</th>
            <th>Purchase</th>
          </tr>
        </thead>
        <tbody>
          <%
            Iterator<ProductBean> i = al.iterator();
            while (i.hasNext()) {
              ProductBean pbean = i.next();
              double price = Double.parseDouble(pbean.getpPrice());
              String formattedPrice = formatter.format(price); // e.g. ₹35,000.00
          %>
            <tr>
              <td><%= pbean.getpCode() %></td>
              <td><%= pbean.getpName() %></td>
              <td><%= pbean.getpCompany() %></td>
              <td><%= formattedPrice %></td>
              <td><%= pbean.getpQuantity() %></td>
              <td><a href="buy?pcode=<%= pbean.getpCode() %>" class="btn-buy">Buy</a></td>
            </tr>
          <%
            }
          %>
        </tbody>
      </table>
    </div>

  <%
    }
  %>

  <a href="logout" class="logout-link">Logout</a>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
