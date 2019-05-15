<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>
${msg}
<form action="userController/login" method="post">
    账号：<input type="text" name="username">
    <br>
    密码：<input type="text" name="password">
    <br>
    <input type="submit" value="登录">
</form>

</body>
</html>
