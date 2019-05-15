<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/20
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/" %>">
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>

<h1>用户管理系统</h1>

<a href="userAdd.jsp">添加用户</a>
<br>

<table class="layui-table">

    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${page.list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <a href="UserController/getUserById/${user.id}">编辑</a>
                <a href="UserController/deleteUser/${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>

<jsp:include page="page/page.jsp" />



</body>
</html>
