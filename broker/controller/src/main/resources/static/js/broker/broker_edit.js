$(function () {
    var brokerData = sessionStorage.getItem("brokerData");
    fullData(brokerData);
});

//填充数据
function fullData(data) {
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
    var params = $("#EditForm").serializeArray();
    console.log(params);
}

function updateCancel() {
    loadPage("brokerUser/brokerListPage");
}