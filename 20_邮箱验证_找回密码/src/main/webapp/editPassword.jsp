<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>设置新密码</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>

<form action="userController/editPassword" method="post">
    <input type="hidden" name="id" value="${id}">
    新密码：<input type="text" name="password" required>
    <br>
    <input type="submit" name="确认修改">
</form>

</body>
</html>
