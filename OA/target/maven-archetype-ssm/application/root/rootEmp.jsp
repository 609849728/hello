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



<div class="page-container">

    <div class="text-c">
        <button type="button" class="btn btn-success" onclick="batchRoot('RootController/batchRoot')">
            <i class="Hui-iconfont">&#xe600;</i> 添加授权
        </button>
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
            </tr>
        </thead>
        <tbody>

            <c:forEach items="${page.list}" var="emp">
                <tr class="text-c">
                    <td><input type="checkbox" value="${emp.id}" name="ids"></td>
                    <td>${emp.id}</td>
                    <td>${emp.username}</td>
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
<script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>


<script type="text/javascript">

    function batchRoot(url) {
        //创建一个数组
        var ids = new Array();

        //遍历所有选中的元素，index代表下标从0开始，item代表当前循环的对象
        $(":checkbox:checked").each(function(index,item) {
            if(item.value != 'on') {
                ids.push(item.value);  //存进数组中
            }
        });

        if(ids.length == 0) {
            alert("你还没有选择要授权的人员！");
            return;
        }

        debugger;
        var roleId = "${roleId}"

        layer.confirm('确认要授权吗？',function(index){
            $.ajax({
                url : url,
                type : "post",
                data : {"roleId":roleId,ids:ids},
                traditional : true,
                success : function(data) {
                    deleteTips(data);
                }
            });
        });

    }


    //管理删除的提示
    function deleteTips(data) {
        if(data) {
            //弹出提示
            layer.msg('授权成功！', {icon: 1,time: 1500}, function(){
                location.reload();
            });
        } else {
            layer.msg('授权失败！', {icon: 2,time: 1500}, function(){
                location.reload();
            });
        }
    }

</script>


</body>
</html>
