<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 09/28/2020
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create student</title>
</head>
<body>
    <p style="color: red">${message}</p>
    <form method="post">
        <input type="hidden" name="actionUser" value="create" />
        <p>Name: </p>
        <input type="text" name="nameStudent" />
        <p>Date of birth: </p>
        <input type="date" name="dateOfBirth" />
        <input type="submit" value="Save" />
    </form>
</body>
</html>
