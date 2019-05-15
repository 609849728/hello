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

    <%--引入数的css--%>
    <link rel="stylesheet" type="text/css" href="/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" />

</head>
<body>


<article class="page-container">
    <form class="form form-horizontal" id="form-admin-add">

        <input type="hidden" name="id" value="${menu.id}">

        <%--菜单名称--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜单名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" id="menuName" name="menuName" value="${menu.menuName}">
            </div>
        </div>

        <%--菜单描述--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜单描述：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="menuDesc" class="textarea" placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="$.Huitextarealength(this,100)">${menu.menuDesc}</textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
            </div>
        </div>

        <%--类型--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型：</label>
                <input name="menuType" type="radio" id="sex-1" value="1">目录
                <input name="menuType" type="radio" id="sex-2" value="0">菜单
        </div>

        <%--URL--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>URL：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" autocomplete="off" id="menuUrl" name="menuUrl" value="${menu.menuUrl}">
            </div>
        </div>

        <%--Code--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Code：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" autocomplete="off" id="menuCode" name="menuCode" value="${menu.menuCode}">
            </div>
        </div>

        <%--所属目录--%>
        <div class="row cl" id="menu">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>所属目录：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="hidden" name="menuParentId" id="menuParentId" value="${menu.menuParentId}" />
                <input type="text" class="input-text" id="menuParentName" name="menuParentName" value="${menu.menuParentName}" required readonly>
                <input type="button" class="btn btn-default" value="选择目录" onclick="selectMenu();" />
            </div>
        </div>

        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>

    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>


<%--引入数的js--%>
<script type="text/javascript" src="/lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>

<script type="text/javascript" src="/js/utils.js"></script>

<script type="text/javascript">


    $(function(){

        //给类型 选上勾
        var menuType = "${menu.menuType}";
        if(menuType == "1") {
            $("#sex-1").attr("checked",true);
            //隐藏选择目录的文本
            $("#menu").hide();
        } else {
            $("#sex-2").attr("checked",true);
        }

        var menuParentId = "${menu.menuParentId}";
        var menuParentName = "${menu.menuParentName}";

        //如果点击了目录，就隐藏选择目录的文本
        $("#sex-1").click(function(){
            $("#menu").hide();
        });

        //如果点击了菜单，就显示选择目录的文本
        $("#sex-2").click(function(){
            $("#menu").show();
        });


        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-admin-add").validate({
            rules:{
                menuName:{
                    required:true,
                    minlength:2,
                    maxlength:8
                },
                menuDesc:{
                    required:true
                }
            },
            onkeyup:false,
            focusInvalid:true,
            success:"valid",
            submitHandler:function(form) {
                //获取到类型的值
                var t = $(":radio:checked").val();
                //如果选的是目录
                if(t == "1") {
                    //就将父id变成0，然后在提交
                    $("#menuParentId").val("0");
                    $("#menuParentName").val("");
                }

                $(form).ajaxSubmit({
                    type: 'post',
                    url: "MenuController/update",
                    dataType: "json",
                    success: function(data){
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
