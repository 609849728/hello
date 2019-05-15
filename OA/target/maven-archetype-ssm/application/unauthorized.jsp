<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/30
  Time: 10:00
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

<h1>权限不足,具体原因：${e.message}</h1>

</body>
</html>
