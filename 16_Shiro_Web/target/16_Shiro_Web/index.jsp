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
    <div class="loginDiv">
        <c:if test="${empty subject.principal}">
            <a href="login.jsp">登录</a><br>
        </c:if>
        <c:if test="${!empty subject.principal}">
            <span class="desc">你好，${subject.principal}，</span>
            <a href="doLogout">退出</a><br>
        </c:if>

        <a href="listProduct.jsp">查看产品</a><span class="desc">(登录后才可以查看)</span><br>
        <a href="deleteProduct.jsp">删除产品</a><span  class="desc">(要有产品管理员角色)</span><br>
        <a href="deleteOrder.jsp">删除订单</a><span class="desc">(要有删除订单权限)</span><br>
    </div>
</div>

</body>
</html>
