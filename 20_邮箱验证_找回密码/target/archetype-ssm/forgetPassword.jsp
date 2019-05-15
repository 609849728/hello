<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>忘记密码</title>
    <base href="<%=request.getContextPath()+"/" %>">
</head>
<body>

请输入账号：<input type="text" name="username" id="username"><font id="tips"></font>
<br>
<input type="button" value="找回密码" onclick="forget()">

<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script>

    function forget() {
        //获取账号
        var username = $("#username").val();

        $.post("userController/forgetPassword",{"username":username},function(result){
            debugger;
            if(result == "false") {
                $("#tips").attr("color","red");
                $("#tips").html("该账号不存在！");
            } else if (result == "true") {
                $("#tips").attr("color","green");
                $("#tips").html("邮件发送成功，请去邮箱查看！");
            }
        });
    }
    
</script>
</body>
</html>
