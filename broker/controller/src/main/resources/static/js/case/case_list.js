$(function () {
    $('#dataTable').bootstrapTable({
        url: 'caseShow/caseShowPageList',      //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        // toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        queryParamsType : "undefined",
        queryParams: function queryParams(params){
            var param = {
                page: params.pageNumber,
                rows: params.pageSize,
            };
            return param;
        },//传递参数（*）
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 20, 50, 100],        //可供选择的每页的行数（*）
        // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        // showColumns: true,                  //是否显示所有的列
        // showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        // height: 600,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "uid",                     //每一行的唯一标识，一般为主键列
        // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
        // cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
        columns: [
            {field: '', align: 'center', title: '选择',radio:true,width:5},
            {field: 'caseTitle',title:"标题", width:100},
            {field: 'caseStyle', title:"风格",width:100},
            {field: 'caseDesc', title:"描述",width:200},
            {field: '', title: "操作", width: 100, formatter: operatorFormatter}
        ],
        onLoadSuccess: function (res) {
            $('#dataTable').bootstrapTable("load", res.data);
        }
    });
})

function operatorFormatter(value, rows, index) {
    var data = JSON.stringify(rows);
    return "<button onclick='auditCustomer("+rows.uid+"," + rows.audit + ", " + rows.auditRemarks + ")'>修改</button>";
}

function auditCustomer(id, audit,auditRemarks) {
    if(!id) return false;
    $("#audit"+audit).attr("checked",true);
    $("#auditRemarks").val(auditRemarks);
    layer.open({
        type: 1
        ,area: ['390px', '260px']
        ,shade:  [0.8, '#393D49']
        ,shadeClose:true
        // ,maxmin: true
        ,content: $("#auditView")
        ,btn: ['确定', '取消']
        ,btn1: function(){
            let audit = $("#auditView").find("input:radio[name='audit']:checked").val();
            let auditRemarks = $("#auditRemarks").val();
            if(!audit) return false;
            $.ajaxPost({
                url:'customer/auditCustomer',
                data:{'id':id, 'audit': audit, 'auditRemarks': auditRemarks},
                success: function (res) {
                    if(res.success){
                        $('#dataTable').bootstrapTable("refresh");
                        layer.closeAll();
                    }else {
                        layer.alert(res.msg || "操作失败");
                    }
                }
            })
        }
        ,btn2: function(){
            layer.closeAll();
        }
    });
}