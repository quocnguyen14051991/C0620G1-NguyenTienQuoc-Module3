<%--
  Created by IntelliJ IDEA.
  User: HK
  Date: 29/9/2020
  Time: 6:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete Product</h1>
<%--<input type="hidden" value="delete" name="actionProduct">--%>
<p><a href="/listProduct">back to home</a></p>
<p>${message}</p>
<form method="post">
    <table>
        <h3>Are You sure</h3>
        <tr>
            <td>Id Product</td>
            <td>${product.getIdProduct()}</td>
        </tr>
        <tr>
            <td>Name Product</td>
            <td>${product.getNameProduct()}</td>
        </tr>
        <tr>
            <td>Inventory Product</td>
            <td>${product.getInventoryProduct()}</td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete Product"></td>
            <td><a href="/listProduct">Back to home</a></td>
        </tr>
    </table>
</form>
</body>
</html>
