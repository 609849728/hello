<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加用户</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>

<h1>添加用户</h1>
<form action="userController/addUser" method="post">
    用户名：<input type="text" name="username" value="admin">
    <br>
    密码：<input type="text" name="password" value="admin">
    <br>
    性别：
    <input type="radio" name="sex" value="1" checked>男
    <input type="radio" name="sex" value="0">女
    <br>
    年龄：<input type="text" name="age" value="20">
    <br>
    生日：<input type="date" name="birthday">
    <br>
    <input type="submit" value="添加">
</form>


</body>
</html>
