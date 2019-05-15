<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <base href="<%=request.getContextPath()+"/" %>">
    <link rel="stylesheet" href="static/css/style.css">
</head>
<body>

<div class="workingroom">
    <div class="loginDiv">

        <shiro:guest>
            <label>游客您好！<a href="login">请登录</a></label><br>
        </shiro:guest>

        <shiro:user>
            <label>欢迎【<shiro:principal />】<a href="doLogout">退出</a></label><br>
        </shiro:user>

        <a href="listProduct">查看产品</a><span class="desc">(登录后才可以查看)</span><br>
        <a href="deleteProduct">删除产品</a><span  class="desc">(要有产品管理员角色)</span><br>
        <a href="deleteOrder">删除订单</a><span class="desc">(要有删除订单权限)</span><br>
    </div>
</div>

</body>
</html>
