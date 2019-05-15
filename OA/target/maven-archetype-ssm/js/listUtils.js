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
            },
        });
    });
}




//批量删除
function batchDelete(url) {

    //创建一个数组
    var ids = new Array();

    //遍历所有选中的元素，index代表下标从0开始，item代表当前循环的对象
    $(":checkbox:checked").each(function(index,item) {
        if(item.value != 'on') {
            ids.push(item.value);  //存进数组中
        }
    });

    if(ids.length == 0) {
        alert("你还没有选择要删除的数据！");
        return;
    }

    layer.confirm('确认要删除吗？',function(index){
        $.ajax({
            url : url,
            type : "post",
            data : {ids:ids},
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
        layer.msg('删除成功！', {icon: 1,time: 1500}, function(){
            location.reload();
        });
    } else {
        layer.msg('删除失败！', {icon: 2,time: 1500}, function(){
            location.reload();
        });
    }
}