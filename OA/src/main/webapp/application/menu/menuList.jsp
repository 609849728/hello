<%--
  Created by IntelliJ IDEA.
  User: sp
  Date: 2019/4/23
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
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



<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 菜单管理 <span class="c-gray en">&gt;</span> 菜单列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="batchDelete('MenuController/batchDelete')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="dept_add('添加菜单','application/menu/menuAdd.jsp','700','550')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加菜单</a>
        </span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="10">菜单列表</th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox"></th>
            <th width="40">ID</th>
            <th width="100">菜单名称</th>
            <th width="100">菜单描述</th>
            <th width="100">菜单类型</th>
            <th width="100">访问菜单的url</th>
            <th width="100">菜单code</th>
            <th width="100">所属目录</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${page.list}" var="leave">
            <tr class="text-c">
                <td><input type="checkbox" value="${leave.id}" name="ids"></td>
                <td>${leave.id}</td>
                <td>${leave.menuName}</td>
                <td>${leave.menuDesc}</td>
                <td>${leave.menuType == 1 ? '目录' : '菜单'}</td>
                <td>${leave.menuUrl}</td>
                <td>${leave.menuCode}</td>
                <td>${leave.menuParentName}</td>
                <td class="td-manage">
                    <a title="编辑" href="javascript:;" onclick="admin_edit('菜单编辑','MenuController/getById/${leave.id}','1','700','550')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
                    <a title="删除" href="javascript:;" onclick="del('MenuController/delete/${leave.id}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<jsp:include page="../../page/page.jsp" />

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>


<script type="text/javascript" src="/js/listUtils.js"></script>


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
    function dept_add(title,url,w,h){
        layer_show(title,url,w,h);
    }

    /*管理员-编辑*/
    function admin_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }

</script>



</body>
</html>
