<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询手机归属地</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>
<h1>查询手机归属地</h1>

<form action="getMobileCodeInfo" method="get">
    手机号：<input type="text" name="mobileCode">
    <input type="submit" value="查询">
</form>

<c:if test="${mobileCodeInfo != null}">
    <br>
    <p>【${mobileCodeInfo}】</p>
</c:if>

</body>
</html>
