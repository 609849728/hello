//选择父部门
function selectParentDept(){
    //打开一个弹框
    layer.open({
        type : 1,
        title : false,
        closeBtn : 2,
        shadeClose : true,
        skin : 'yourclass',
        content : getParentZTree()
    });

    //初始化树
    init();
}



function getParentZTree(){
    var htmlStr = "";
    htmlStr += '<div style="width:200px;height:200px" >';
    htmlStr += '<div style=" line-height:30px; text-indent:10px; margin-bottom:20px; background-color:#eee; position:relative;">部门</div>';
    htmlStr += '<div style="display:block; padding-bottom:5px;" align="center" >';
    htmlStr += '<div><table><tr><td><input type="hidden" id="id" width="50px"/><input type="text" id="name" width="50px"><button onclick="SetQueryDeptTreeParam();">确定</button></td></tr></table></div>';
    htmlStr += '<div id="queryParent" class="ztree"></div>';
    htmlStr += '</div>';
    htmlStr += '</div>';
    return htmlStr;
}


//初始化树
function init() {

    var setting = {
        data : {
            simpleData : {
                enable : true  //使用简单JSON数据，false代表不使用
            }
        },

        async: {
            enable: true,  //true表示开启异步加载模式
            url: "DeptController/getDeptTree",  //访问的url
            autoParam: ["id"],  //参数
            dataType: "json",  //数据格式，默认为text
            type: "get" //请求方式
        },

        callback: {  //回调函数，点击节点的时候调用
            onClick : clickNode
        }
    };
    //加载到指定id的div上
    $.fn.zTree.init($("#queryParent"), setting);
}


//点击节点，给文本框赋值
function clickNode(event,treeId,treeNode,clickFlag) {
    $("#id").val(treeNode.id);
    $("#name").val(treeNode.name);
}


//点击确定，给添加表单的文本框赋值
function SetQueryDeptTreeParam() {
    $("#deptParentName").val($("#name").val());
    $("#deptParentId").val($("#id").val());

    //关闭选择树的窗口
    layer.close(layer.index);
}


//处理结果，并弹出提示是否操作成功
function handleData(data) {
    if(data.flag) {
        //弹出提示
        layer.msg(data.msg, {icon: 1,time: 1500}, function(){
            //关闭添加的窗口
            var index = parent.layer.getFrameIndex(window.name);
            //parent.$('.btn-refresh').click();
            parent.layer.close(index);
        });
    } else {
        layer.msg(data.msg, {icon: 2,time: 1500});
    }
}


