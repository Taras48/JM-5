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
<p><a href="/add">Add User</a> |
    <a href="/del">Delete User</a></p>
<h3>Update User</h3>

<form method="post" action="/update">
    <p>Id for delete User: <input type="number" name="testId">
        NewName: <input type="text" name="newName">
        NewMail: <input type="text" name="newMail"></p>
    <p>NewPassword: <input type="password" name="newPassword">
        NewRole: <input type="text" name="newRole"></p>
    <button >Update User</button>
</form>

</body>
</html>
