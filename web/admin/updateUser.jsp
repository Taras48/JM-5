<%--
  Created by IntelliJ IDEA.
  User: TARAZ
  Date: 04.09.2019
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<p><a href="/admin/add">Add User</a> |
    <a href="/admin/del">Delete User</a>|
    <a href="/user"> User</a>
</p>
<h3>Update User</h3>

<form method="post" action="/admin/update">
    <p>Id for delete User: <input type="number" name="testId"  disabled value="${param.id}"/>
        NewName: <input type="text" name="newName" value="${param.name}"/>
        NewMail: <input type="text" name="newMail"value="${param.mail}" /></p>
    <p>NewPassword: <input type="password" name="newPassword" value="${param.password}">
        Role:<select type="text" name="role" >
            <option value="user">User</option>
            <option value="admin">Admin</option>
        </select>
    </p>
    <button>Update User</button>
</form>

</body>
</html>
