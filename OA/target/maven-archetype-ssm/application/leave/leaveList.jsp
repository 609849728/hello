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
            <a href="javascript:;" onclick="dept_add('申请请假','application/leave/leaveAdd.jsp','500','350')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 申请请假</a>
        </span>
    </div>

    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th width="40">ID</th>
            <th width="150">请假原因</th>
            <th width="80">请假天数</th>
            <th width="80">申请时间</th>
            <th width="80">请假状态</th>
            <th width="80">请假人</th>
            <th width="80">操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${page.list}" var="leave">
            <tr class="text-c">
                <td>${leave.id}</td>
                <td>${leave.reason}</td>
                <td>${leave.days}</td>
                <td><f:formatDate value="${leave.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                <td>
                    <c:if test="${leave.state == 0}">
                        初始录入
                    </c:if>
                    <c:if test="${leave.state == 1}">
                        审核中
                    </c:if>
                    <c:if test="${leave.state == 2}">
                        审核完成
                    </c:if>
                </td>
                <td>${leave.emp.username}</td>
                <td class="td-manage">
                    <c:if test="${leave.state == 0}">
                        <a title="提交申请" href="" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe601;</i></a>
                    </c:if>
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

<script type="text/javascript">
    function dept_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
</script>

</body>
</html>
