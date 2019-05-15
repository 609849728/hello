<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/19
  Time: 19:12
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

<h1>添加用户</h1>

<form action="UserController/addUser" method="post">
    账号：<input type="text" name="username" value="qq">
    <br>
    密码：<input type="text" name="password" value="111">
    <br>
    <input type="submit" value="添加">
</form>


</body>
</html>
