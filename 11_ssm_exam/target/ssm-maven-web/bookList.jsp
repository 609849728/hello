<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/20
  Time: 14:15
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
<h1 style="color: red">${u.name}你好！</h1>
<h2>书籍管理系统</h2>

<a href="BookController/getAllUser">添加书籍</a>
<br>

<table class="layui-table">
    <tr>
        <th>id</th>
        <th>书名</th>
        <th>价格</th>
        <th>作者</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${page.list}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.bookName}</td>
            <td>${book.price}</td>
            <td>${book.user.name}</td>
            <td>
                <a href="BookController/getBookById/${book.id}">编辑</a>
                <a href="BookController/deleteBook/${book.id}">删除</a>
            </td>
        </tr>

    </c:forEach>

</table>

<jsp:include page="page/page.jsp" />

</body>
</html>
