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



<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 员工管理 <span class="c-gray en">&gt;</span> 员工列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">


    <div class="text-c">
        <form action="EmpController/getPageInfo" method="get">
            名称：<input type="text" class="input-text" style="width:250px" name="username" value="${emp.username}">
            邮箱：<input type="text" class="input-text" style="width:250px" name="email" value="${emp.email}">
            手机号：<input type="text" class="input-text" style="width:250px" name="phone" value="${emp.phone}">
            <button type="submit" class="btn btn-success"><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
        </form>
    </div>


    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="batchDelete('EmpController/batchDelete')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="dept_add('添加员工','application/emp/empAdd.jsp','700','570')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加员工</a>
        </span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="10">员工列表</th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox"></th>
            <th width="40">ID</th>
            <th width="150">用户名</th>
            <th width="90">密码</th>
            <th width="100">性别</th>
            <th width="100">邮箱</th>
            <th width="100">电话</th>
            <th width="150">入职时间</th>
            <th width="150">所在部门</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${page.list}" var="emp">
            <tr class="text-c">
                <td><input type="checkbox" value="${emp.id}" name="ids"></td>
                <td>${emp.id}</td>
                <td>${emp.username}</td>
                <td>${emp.password}</td>
                <td>${emp.sex==1 ? '男':'女'}</td>
                <td>${emp.email}</td>
                <td>${emp.phone}</td>
                <td><f:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd" /></td>
                <td>${emp.dept.deptName}</td>
                <td class="td-manage">
                    <a title="编辑" href="javascript:;" onclick="admin_edit('部门编辑','EmpController/getById/${emp.id}','1','700','470')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
                    <a title="修改密码" href="javascript:;" onclick="admin_edit('修改密码','EmpController/getEmpById/${emp.id}','1','500','300')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe60c;</i></a>
                    <a title="删除" href="javascript:;" onclick="del('EmpController/delete/${emp.id}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<jsp:include page="../../page/page.jsp" />

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>

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
