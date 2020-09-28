<%--
  Created by IntelliJ IDEA.
  User: HK
  Date: 24/7/2020
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style type="text/css">
        .login{
            height:180px; width:230px;
            margin:0;
            padding:10px;
            border:1px #CCC solid;
        }

    </style>
</head>
<body>
<form action="login" method="get">
    <div class="login">
        <h2>login</h2>
        <input type="text" name="username" size="30" placeholder="username"/>
        <input type="password" name="password" size="30" placeholder="password"/>
        <input type="submit" value="Sign in"/>
    </div>
</form>
</body>
</html>
