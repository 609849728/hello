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

<h1>添加书籍</h1>
<form action="BookController/addBook" method="post">
    书名：<input type="text" name="bookName">
    <br>
    价格：<input type="text" name="price">
    <br>
    作者：
    <select name="user.id">
        <c:forEach items="${userList}" var="user">
            <option value="${user.id}">${user.name}</option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" value="添加">
</form>


</body>
</html>
