<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>

<c:if test="${USER_SESSION.username == null}">
    <a href="login.jsp">登录</a>
</c:if>
<c:if test="${USER_SESSION.username != null}">
    <font color="red">【${USER_SESSION.username}】</font>你好！<a href="userController/logout">退出</a>
</c:if>

<br>
<a href="toMobileCodeInfo">查询手机归属地</a>
<br>
<a href="toTranslate">中英文翻译</a>
<br>
<a href="getHistoryPageInfo">查询历史</a>
<br>
<a href="userController/getUserPageInfo">用户管理系统</a>


</body>
</html>
