<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="<%=request.getContextPath()+"/" %>">

    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css" />

</head>
<body>



<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 授权管理 <span class="c-gray en">&gt;</span> 授权列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">


    <div class="text-c">
            <span class="select-box inline">
                角色名称：
                <select name="" class="select" id="role">
                    <option value="0">请选择</option>
                    <c:forEach items="${list}" var="role">
                        <option value="${role.id}">${role.roleName}</option>
                    </c:forEach>
                </select>
            </span>

            <span class="select-box inline">
                授权类型：
                <select id="queryType" class="select">
                    <option value="1">用户</option>
                    <option value="2">菜单</option>
                </select>
            </span>
            <button type="button" onclick="queryRoot()" class="btn btn-success"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
    </div>


    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="rootEmp('授权人员','RootController/getEmpPageInfo','700','570')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 授权人员</a>
            <a href="javascript:;" onclick="rootMenu()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 授权菜单</a>
        </span>
    </div>


    <table id="tableList" class="table table-border table-bordered table-bg">

    </table>



</div>

<jsp:include page="/page/page.jsp" />

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>

<script type="text/javascript">
    /*
        参数解释：
        title	标题
        url		请求的url
        id		需要操作的数据id
        w		弹出层宽度（缺省调默认值）
        h		弹出层高度（缺省调默认值）
    */
    /*部门-增加*/
    function rootEmp(title,url,w,h){
        var role = $("#role").val();
        if(role == "0") {
            alert("你还没有选择角色！");
            return false;
        }

        url = url+"/"+role;

        layer_show(title,url,w,h);
    }
    
    
    function rootMenu() {
        var role = $("#role").val();
        if(role == "0") {
            alert("你还没有选择角色！");
            return false;
        }

        //打开一个页面弹框
        layer.open({
            type : 2,
            title : false,
            closeBtn : 2,
            area : ['400px','500px'],
            shadeClose : true,
            skin : 'yourclass',
            content : 'RootController/showMenuTree/'+role   //传入角色的id
        });

    }

    /*管理员-编辑*/
    function admin_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }


    function queryRoot() {
        //1.获取角色id
        var roleId = $("#role").val();

        //2.获取查询类型
        var queryType = $("#queryType").val();

        //3.判断是否选中
        if(roleId == "0") {
            alert("你还没有选择角色！");
            return false;
        }

        //4.判断查询类型，1为用户，2为菜单
        if(queryType == "1") {
            $("#tableList").load('RootController/getEmpPageInfoByRoleId/'+roleId);
        } else {
            $("#tableList").load('RootController/getMenuPageInfoByRoleId/'+roleId);
        }



    }

</script>


</body>
</html>
