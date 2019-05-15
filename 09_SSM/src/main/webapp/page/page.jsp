<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<base href="<%=request.getContextPath()+"/" %>">
<link rel="stylesheet" href="/layui/css/layui.css"  media="all">

<div id="page"></div>

<script src="/layui/layui.js"></script>
<script>
    layui.use(['laypage', 'layer'], function(){
        var laypage = layui.laypage
            ,layer = layui.layer;

        //完整功能
        laypage.render({
            elem: 'page'
            ,limit: "${page.pageSize}"
            ,count: "${page.total}"
            ,curr: "${page.pageNum}"
            ,layout: ['prev', 'page', 'next', 'skip', 'count']
            ,jump: function(obj,first){
                //obj包含了当前分页的所有参数，比如：
                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                console.log(obj.limit); //得到每页显示的条数

                //首次不执行
                if(!first){
                    location.href="${pageUrl}/"+obj.curr;
                }
            }
        });

    });
</script>



