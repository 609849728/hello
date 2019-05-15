<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/20
  Time: 14:19
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
    姓名：<input type="text" name="name">
    <br>
    年龄：<input type="text" name="age">
    <br>
    密码：<input type="text" name="password">
    <br>
    <input type="submit" value="添加">
</form>


</body>
</html>
