<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>中英文翻译</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>

<h1>中英文翻译</h1>

<form action="getTranslate" method="get">
    请输入正确的中文或英文：<input type="text" name="parameter">
    <input type="submit" value="翻译">
</form>

<c:if test="${result != null}">
    <br>
    <p>【${result}】</p>
</c:if>


</body>
</html>
