<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>历史管理</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>

<h1>历史管理</h1>
<table class="layui-table">
    <tr>
        <th>id</th>
        <th>服务类型</th>
        <th>参数</th>
        <th>结果</th>
        <th>所属用户</th>
    </tr>

    <c:forEach items="${page.list}" var="histroy">
    <tr>
        <td>${histroy.id}</td>
        <td>${histroy.type == '1' ? '手机归属地查询':'翻译'}</td>
        <td>${histroy.parameter}</td>
        <td>${histroy.result}</td>
        <td>${histroy.user.username}</td>
    </tr>
    </c:forEach>
</table>

<jsp:include page="page/page.jsp" />

</body>
</html>
