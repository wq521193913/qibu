$(function () {
});

/**
 * 获取菜单
 */
function getRoleMenu() {
    $.ajax({
        url: 'roleMenu/getRoleMenus',
        type: 'POST',
        async: false,
        dataType: 'json',
        success: function (res) {
            console.log(res);
        },
        error: function (xhr) {
            console.log(xhr);
        }
    })
}

/**
 * 点击左边菜单栏，将内容显示在页签的content中。
 * @param url 访问路径
 * @param id 菜单ID
 */
function loadPage(url, id) {
    // if(!url) {
    //     $("#child_" + id).load("notFound");
    //     return;
    // }
    $("#mainContent").load(url,function(responseText,statusText){
        if (statusText != 'success'){
            $("#mainContent").load("notFound");
        }
    });
}

function addBrokerUser() {
    sessionStorage.setItem("addBrokerPage",1);
    loadPage('brokerUser/brokerEditPage')
}

function addCase() {
    sessionStorage.setItem("addCasePage",1);
    loadPage('caseShow/caseEditPage')
}