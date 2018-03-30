$(function () {
    $('#dataTable').bootstrapTable({
        url: 'customer/customerPageList',      //请求后台的URL（*）
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
            {field: 'customerName',title:"客户姓名", width:100},
            {field: 'customerPhone', title:"客户手机",width:100},
            {field: 'addressDetail', title:"客户住址",width:200},
            {field: 'brokerName', title:"经纪人",width:200},
            {field: 'status', title:"装修意向",width:50, formatter:statusFormatter},
            {field: 'remarks', title:"备注",width:200},
            {field: '', title: "操作", width: 100, formatter: operatorFormatter}
        ],
        onLoadSuccess: function (res) {
            $('#dataTable').bootstrapTable("load", res.data);
        }
    });
})

function statusFormatter(value) {
    if(value == 0){
        return "<span>咨询</span>";
    }else if(value == 1){
        return "<span>马上会装修</span>";
    }else if(value == 2){
        return "<span>已装修</span>";
    }else if(value == 3){
        return "<span>不装修了</span>";
    }
}

function operatorFormatter(value, rows, index) {
    var data = JSON.stringify(rows);
    return "<button onclick='auditCustomer("+rows.uid+")'>审计</button>";
}

function auditCustomer(id) {
    layer.open({
        type: 2
        ,title: '当你选择该窗体时，即会在最顶端'
        ,area: ['390px', '260px']
        ,shade: 0
        ,maxmin: true

        ,content: 'http://layer.layui.com/test/settop.html'
        ,btn: ['继续弹出', '全部关闭'] //只是为了演示
        ,yes: function(){
            $(that).click();
        }
        ,btn2: function(){
            layer.closeAll();
        }
    });
}