<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <base href="<%=request.getContextPath()+"/" %>">

    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css" />

    <table class="table table-border table-bordered table-bg">
        <thead>
            <tr>
                <th scope="col" colspan="10">用户列表</th>
            </tr>
            <tr class="text-c">
                <th width="25"><input type="checkbox"></th>
                <th width="40">ID</th>
                <th width="150">用户名</th>
                <th width="150">操作</th>
            </tr>
        </thead>
        <tbody>

            <c:forEach items="${list}" var="emp">
                <tr class="text-c">
                    <td><input type="checkbox" value="${emp.reId}" name="ids"></td>
                    <td>${emp.id}</td>
                    <td>${emp.username}</td>
                    <td class="td-manage">
                        <a title="删除" href="javascript:;" onclick="del('RootController/deleteEmp/${emp.reId}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
                    </td>
                </tr>
            </c:forEach>

        </tbody>
    </table>


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

    //删除
    function del(url){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type: 'get',
                url: url,
                dataType: 'json',
                success: function(data){
                    deleteTips(data);
                },
                error:function(data) {
                    console.log(data.msg);
                }
            });
        });
    }

    //管理删除的提示
    function deleteTips(data) {
        if(data) {
            //弹出提示
            layer.msg('操作成功！', {icon: 1,time: 1500}, function(){
                location.reload();
            });
        } else {
            layer.msg('操作失败！', {icon: 2,time: 1500}, function(){
                location.reload();
            });
        }
    }

</script>

