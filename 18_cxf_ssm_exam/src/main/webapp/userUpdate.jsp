<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改用户</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>

<h1>修改用户</h1>
<form action="userController/updateUser" method="post">
    <input type="hidden" name="id" value="${user.id}">
    用户名：<input type="text" name="username" value="${user.username}">
    <br>
    密码：<input type="text" name="password" value="${user.password}">
    <br>
    性别：
    <input type="radio" name="sex" value="1" id="sex-1">男
    <input type="radio" name="sex" value="0" id="sex-2">女
    <br>
    年龄：<input type="text" name="age" value="${user.age}">
    <br>
    生日：<input type="date" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />">
    <br>
    <input type="submit" value="修改">
</form>


<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
    $(function(){
        var a = "${user.sex}";

        if(a == '1') {
            $("#sex-1").attr("checked",true);
        } else {
            $("#sex-2").attr("checked",true);
        }
    });
</script>
</body>
</html>
