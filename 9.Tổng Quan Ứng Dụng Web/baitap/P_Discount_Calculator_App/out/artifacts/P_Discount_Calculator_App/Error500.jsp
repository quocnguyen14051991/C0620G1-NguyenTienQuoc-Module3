<%@ page language="java" %>
<html>
<head>
    <title>
        This is a test error JSP
    </title>
</head>
<body>
<h1>An Application error has occurred</h1>
<p>
    <b>The status code is:</b> <%= request.getAttribute("javax.servlet.error.status_code") %><br>
    <b>The error message again is:</b> <%= request.getAttribute("javax.servlet.error.message") %><br>
</p>
</body>
</html>