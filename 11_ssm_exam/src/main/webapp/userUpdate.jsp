<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/20
  Time: 14:25
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

<h1>修改用户</h1>
<form action="UserController/updateUser" method="post">
    <input type="hidden" name="id" value="${user.id}">
    姓名：<input type="text" name="name" value="${user.name}">
    <br>
    年龄：<input type="text" name="age" value="${user.age}">
    <br>
    密码：<input type="text" name="password" value="${user.password}">
    <br>
    <input type="submit" value="修改">
</form>


</body>
</html>
