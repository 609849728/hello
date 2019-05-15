<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/20
  Time: 16:21
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
<font color="red">${msg}</font>
<form action="UserController/login" method="post">
    账号：<input type="text" name="name">
    <br>
    密码：<input type="password" name="password">
    <br>
    <input type="submit" value="登录">
</form>

</body>
</html>
