<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/20
  Time: 15:59
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

<h1>${user.name}的书籍：</h1>


<table class="layui-table">
    <tr>
        <th>id</th>
        <th>书名</th>
        <th>价格</th>
    </tr>

    <c:forEach items="${user.bookList}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.bookName}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
