$(function () {
    var addCasePage = sessionStorage.getItem("addCasePage");
    if(addCasePage && addCasePage == 1){

    }
});

function selectCaseImg() {
    $("#file").click();
}

function uploadCaseImg() {
    console.log($("#caseImg").val());

    $.ajaxFileUpload({
        fileElementId: 'file',
        url:'/uploadFile',
        type:'POST',
        dataType:'JSON',
        secureuri:false,
        async:false,
        success: function (result) {
            console.log(result);
        },
        error: function (xhr, status, e) {
            console.log(e);
        }

    })
}