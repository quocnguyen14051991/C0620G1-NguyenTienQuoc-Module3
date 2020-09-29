<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HK
  Date: 29/9/2020
  Time: 3:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>listProduct</title>
</head>
<body>
<a href="/listProduct?actionProduct=create">Create Product</a>
<form action="/listProduct"  >
    <label for="search">Search</label>
    <input type="text" name="Search" id="search">
    <input type="submit" value="search" name="actionProduct">
</form>
<p>${message}</p>
<table border="1">
    <tr>
        <th>Id Product</th>
        <th>Name Product</th>
        <th>Inventory Product</th>
        <th>Edit Product</th>
        <th>Delete Product</th>
    </tr>
    <c:forEach var="Product" items="${listProduct}">
        <tr>
            <td>${Product.idProduct}</td>
            <td>${Product.nameProduct}</td>
            <td>${Product.inventoryProduct}</td>
            <td ><a href="/listProduct?actionProduct=edit&id=${Product.getIdProduct()}">edit</a></td>
            <td><a href="/listProduct?actionProduct=delete&id=${Product.getIdProduct()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
