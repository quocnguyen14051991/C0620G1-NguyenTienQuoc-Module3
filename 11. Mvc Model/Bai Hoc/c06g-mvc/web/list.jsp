<%--<%@ page import="model.Student" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <a href="/listStudent?actionUser=create">Create student</a>

    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Ranking</th>
            <th>Gender</th>
        </tr>
<%--    <%--%>
<%--        List<Student> studentList = (ArrayList<Student>) request.getAttribute("abcList");--%>

<%--        for (Student student : studentList) {--%>
<%--    %>--%>
<%--        <tr>--%>
<%--            <td><%=student.getId()%></td>--%>
<%--            <td><%=student.getName()%></td>--%>
<%--            <td><%=student.getDateOfBirth()%></td>--%>
<%--        </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
        <c:forEach var="student" items="${abcList}">
            <tr>
                <td>${student.id}</td>
                <td><c:out value="${student.name}"></c:out></td>
                <td>${student.dateOfBirth}</td>
                <td>
                    <c:choose>
                        <c:when test="${student.mark > 5}">
                            Good
                        </c:when>
                        <c:when test="${student.mark == 5}">
                            Normal
                        </c:when>
                        <c:otherwise>
                            Bad
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${student.gender == 0}">
                        Female
                    </c:if>
                    <c:if test="${student.gender == 1}">
                        Male
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><br>

<%--    ${testVariable}--%>
<%--    <c:out value="${testVariable}" />--%>
</body>
</html>
