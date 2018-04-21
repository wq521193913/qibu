var addBrokerPage = 0;
$(function () {

    addBrokerPage = sessionStorage.getItem("addBrokerPage");
    if(addBrokerPage == 1){
        $("#EditForm").reset;
        sessionStorage.removeItem("addBrokerPage");
    }else {
        var brokerData = sessionStorage.getItem("brokerData");
        fillData(brokerData);
    }

});

//填充数据
function fillData(data) {
    let obj = JSON.parse(data);
    var els = $("#EditForm").find("input");
    for(let i = 0; i < els.length; i++){
        let el = els[i];
        if(el.type == "text"){
            $(el).val(obj[el.name]);
        }else if(el.type == "radio"){
            $("#" + el.name + obj[el.name]).attr("checked",true);
        }
    }
}
//提交
function updateSubmit() {
    let params = $("#EditForm").formDataFormatter();
    let url = '';
    if(addBrokerPage == 1){
        //新增
        url = 'brokerUser/insertBrokerUser';
    }else{
        //修改
        url = 'brokerUser/updateBrokerUser';
    }

    $.ajaxPost({
        url: url,
        data: params,
        success: function (res) {
            if(res.success){
                layer.alert("保存成功");
            }else{
                layer.alert(res.msg || "操作失败,请重新操作");
            }
        }
    });

}

function updateCancel() {
    loadPage("brokerUser/brokerListPage");
}