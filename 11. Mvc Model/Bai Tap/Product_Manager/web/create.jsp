<%--
  Created by IntelliJ IDEA.
  User: HK
  Date: 29/9/2020
  Time: 3:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>createProduct</title>
</head>
<body>
<p>${message}</p>
<form method="post">
    <input type="hidden" name="actionProduct" value="create" >
    <a href="/listProduct">Back to home </a>
    <p>Id Product</p>
    <input type="text" name="idProduct" >
    <p>name Product</p>
    <input type="text" name="nameProduct">
    <p>inventory Product</p>
    <input type="text" name="inventoryProduct">
    <br>
    <br>
    <input type="submit" value="Save">
</form>

</body>
</html>
