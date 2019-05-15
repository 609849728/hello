<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<base href="<%=request.getContextPath()+"/" %>">

<%--引入树的css--%>
<link rel="stylesheet" type="text/css" href="/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" />

<%--存放树的位置 --%>
<div id="treeMenu" class="ztree"></div>
<input type="button" onclick="root()" value="授权">

<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<%--引入树的js--%>
<script type="text/javascript" src="/lib/zTree/v3/js/jquery.ztree.all-3.5.js"></script>


<script type="text/javascript">

    //传过来的角色id
    var roleId = "${roleId}";

    //jquery的入口函数
    $(function(){
        init();
    });


    //初始化树
    function init() {

        var setting = {
            //复选框
            check : {
                enable : true,
                chkStyle : "checkbox",
                chkboxType : {"Y":"ps","N":"ps"}
            }
        };

        $.get("RootController/getMenuTree/"+roleId,"",function(data){ // data是简单JSON数据

            // 1.把简单JSON数据转成标准JSON数组
            var zNodes = formatJSON(data);
            $.fn.zTree.init($("#treeMenu"), setting,zNodes);
        },"JSON");

    }

    //将简单JSON转换成标准JSON
    function formatJSON(json){
        var ret = [], o = {};

        function add(arr, data){
            var obj = {
                "id": data.id,
                "pId": data.pId,
                "name":data.name,
                "type":data.type,
                "open":true,
                "children": [],
                "checked":data.checked
            };
            o[data.id] = obj;
            arr.push(obj);
        }

        json.forEach(x => {
            if(o[x.pId]){
            add(o[x.pId].children, x);
        }else{
            add(ret, x);
        }
    });
        return ret;
    }


    //点击授权按钮
    function root() {
        //1.获取角色id

        //2.获取选中的菜单id
        debugger;
        var treeObj = $.fn.zTree.getZTreeObj("treeMenu");
        var nodes = treeObj.getCheckedNodes(true);
        debugger;

        //创建一个数组
        var ids = new Array();

        //遍历所有选中的元素，index代表下标从0开始，item代表当前循环的对象
        for(var index in nodes) {
            ids.push(nodes[index].id);
        }

        if(ids.length == 0) {
            alert("你还没有选择要授权的菜单！");
            return;
        }


        layer.confirm('确认要授权吗？',function(index){
            $.ajax({
                url : 'RootController/batchRootMenu',
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
            layer.msg('授权成功！', {icon: 1,time: 1500}, function() {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
            });
        } else {
            layer.msg('授权失败！', {icon: 2,time: 1500}, function(){
                location.reload();
            });
        }
    }



</script>