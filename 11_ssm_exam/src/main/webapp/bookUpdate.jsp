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

<h1>修改书籍</h1>
<form action="BookController/updateBook" method="post">
    <input type="hidden" name="id" value="${book.id}">
    书名：<input type="text" name="bookName" value="${book.bookName}">
    <br>
    价格：<input type="text" name="price" value="${book.price}">
    <br>
    <input type="hidden" name="user.id" value="${book.user.id}">
    作者：${book.user.name}
    <br>
    <input type="submit" value="修改">
</form>


</body>
</html>
