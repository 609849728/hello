<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>
    <h1>用户登录</h1>
    <form action="userController/login" method="post">
        账号：<input type="text" name="username" value="qq"><br><br>
        密码：<input type="text" name="password" value="qq"><br><br>
        <a href="forgetPassword.jsp">忘记密码?</a><br><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
