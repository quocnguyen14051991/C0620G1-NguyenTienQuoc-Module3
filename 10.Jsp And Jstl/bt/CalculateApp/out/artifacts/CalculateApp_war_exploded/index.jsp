<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CalculateApp</title>
</head>
<body>
    <form action="/calculate" method="post">
        <input type="text" name="input1"><br>
        <select name="selectInput">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
        </select><br>
        <input type="text" name="input2"><br>
        <input type="submit" value="Calculate">
    </form>
    <div>
        <h1>Result:<c:out value="${requestScope.result}"></c:out></h1>
    </div>
</body>
</html>
