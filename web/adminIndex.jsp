<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>UserTable</title>
</head>
<body>
<p>
    <a href="/add">Add User</a> |
    <a href="/update">Update User</a> |
    <a href="/del">Delete User</a>|
    <a href="/user"> User</a>
</p>
<h3>User Table for Admin</h3>
<c:if test="${list.size() > 0}">
    <table border="1px solid black">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Mail</td>
            <td>Role</td>
            <td>Password</td>
        </tr>
        <c:forEach var="user" items="${list}">
            <tr>
                <td><c:out value="${user.getId()}"/></td>
                <td><c:out value="${user.getName()}"/></td>
                <td><c:out value="${user.getMail()}"/></td>
                <td><c:out value="${user.getRole()}"/></td>
                <td><c:out value="${user.getPassword()}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${list.size() == 0}">
    <c:out value="${qwe}" default="Table is empty"/>
</c:if>

</body>
</html>
