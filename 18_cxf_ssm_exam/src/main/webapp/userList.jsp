<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户管理</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>

<h1>用户管理</h1>
<a href="userAdd.jsp">添加</a>
<table class="layui-table">
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>生日</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${page.list}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.sex == '1' ? '男':'女'}</td>
        <td>${user.age}</td>
        <td>
            <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />
        </td>
        <td>
            <a href="userController/getUserById/${user.id}">编辑</a>
            <a href="userController/deleteUser/${user.id}">删除</a>
        </td>
    </tr>
    </c:forEach>
</table>

<jsp:include page="page/page.jsp" />

</body>
</html>
