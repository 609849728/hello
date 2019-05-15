<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>
    <h1>用户注册</h1>
    <form action="userController/addUser" method="post">
        账号：<input type="text" name="username" value="qq"><br>
        密码：<input type="text" name="password" value="qq"><br>
        邮箱：<input type="text" id="email" name="email" value="1318591505@qq.com"><button onclick="sendCode()">发送验证码</button><br>
        验证码：<input type="text" name="code" required><br>
        <input type="submit" value="注册">
    </form>
</body>


<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
    //发送验证码到邮箱
    function sendCode() {
        //获取邮箱
        var email = $("#email").val();

        //发送
        var data = {"email":email};
        $.post("userController/sendCode",data);
    }
</script>
</html>
