<%--
  Created by IntelliJ IDEA.
  User: HK
  Date: 29/9/2020
  Time: 5:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${message}</p>
<input type="hidden" value="edit" name="actionProduct">
<a href="/listProduct">back to list product</a>
<form method="post">

    <table>
        <tr>
            <td>Id Product</td>
            <td><input type="text" name="idProduct" value="${product.getIdProduct()}"></td>
        </tr>
        <tr>
            <td>Name Product</td>
            <td><input type="text" name="nameProduct" value="${product.getNameProduct()}"></td>
        </tr>
        <tr>
            <td>inventory Product;</td>
            <td><input type="text" name="inventoryProduct" value="${product.getInventoryProduct()}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update Product"></td>
        </tr>
    </table>
</form>
</body>
</html>
