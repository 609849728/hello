<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/" %>">

    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css" />

    <%--引入树的css--%>
    <link rel="stylesheet" type="text/css" href="/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" />

    <%--日期--%>
    <link rel="stylesheet" type="text/css" href="/lib/My97DatePicker/4.8/skin/default/datepicker.css" />

</head>
<body>


<article class="page-container">
    <form class="form form-horizontal" id="form-admin-add">

        <%--用户名--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" id="username" name="username">
            </div>
        </div>

        <%--密码--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" id="password" name="password">
            </div>
        </div>

        <%--确认密码--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" id="repassword" name="repassword">
            </div>
        </div>

        <%--性别--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <div class="radio-box">
                    <input name="sex" type="radio" id="sex-1" value="1" checked>
                    <label for="sex-1">男</label>
                </div>
                <div class="radio-box">
                    <input name="sex" type="radio" id="sex-2" value="0">
                    <label for="sex-2">女</label>
                </div>
            </div>
        </div>

        <%--邮箱--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" id="email" name="email">
            </div>
        </div>

        <%--手机--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" id="phone" name="phone">
            </div>
        </div>

        <%--入职日期--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>入职日期：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="hiredate" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemin\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;">
            </div>
        </div>

        <%--所在部门--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>部门名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="hidden" name="dept.id" id="deptParentId" />
                <input type="text" class="input-text" placeholder="" id="deptParentName" name="dept.deptName" readonly required>
                <input type="button" class="btn btn-default" value="选择部门" onclick="selectParentDept()" />
            </div>
        </div>

        <%--提交--%>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="/lib/jquery.validation/1.14.0/messages_zh.js"></script>

<script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/lib/My97DatePicker/4.8/lang/zh-cn.js"></script>

<%--引入树的js--%>
<script type="text/javascript" src="/lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>

<script type="text/javascript" src="/js/utils.js"></script>


<script type="text/javascript">


    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-admin-add").validate({
            rules:{
                username:{
                    required: true,
                    minlength:2,
                    maxlength:8
                },
                password:{
                    required: true
                },
                repassword:{
                    required: true,
                    equalTo: "#password"
                },
                email:{
                    required: true,
                    email: true
                },
                phone:{
                    required: true,
                    number: true
                },
                hiredate:{
                    required: true,
                }
            },
            onkeyup:false,
            focusInvalid:true,
            success:"valid",
            submitHandler:function(form){
                $(form).ajaxSubmit({
                    type: 'post',
                    url: "EmpController/addEmp",
                    dataType: "json",
                    success: function(data){
                        //处理结果
                        handleData(data);
                    },
                    error: function(XmlHttpRequest, textStatus, errorThrown){
                        layer.msg('error!',{icon:1,time:1000});
                    }
                });

            }
        });
    });


</script>
<!--/请在上方写此页面业务相关的脚本-->





</body>
</html>
