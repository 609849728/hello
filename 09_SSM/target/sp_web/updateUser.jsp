<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/19
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>

<h1>修改用户信息</h1>

<form action="UserController/updateUser">
    <input type="hidden" name="id" value="${user.id}">

    账号：<input type="text" name="username" value="${user.username}">
    <br>
    密码：<input type="text" name="password" value="${user.password}">
    <br>
    <input type="submit" value="修改">

</form>

</body>
</html>
