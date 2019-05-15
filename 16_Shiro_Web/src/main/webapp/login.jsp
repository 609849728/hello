<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/29
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=request.getContextPath()+"/" %>">
    <link rel="stylesheet" href="static/css/style.css">
</head>
<body>

<div class="workingroom">

    <div class="errorInfo">${msg}</div>

    <form action="login" method="post">
        账号： <input type="text" name="username"> <br>
        密码： <input type="password" name="password"> <br>
        <br>
        <input type="submit" value="登录">
    </form>

</div>

</body>
</html>
