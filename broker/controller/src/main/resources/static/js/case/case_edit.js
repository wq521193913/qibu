$(function () {
    var addCasePage = sessionStorage.getItem("addCasePage");
    if(addCasePage && addCasePage == 1){
        $("#EditForm").reset();

    }
});

function selectCaseImg() {
    $("#file").click();
}

//提交
function caseSubmit() {

}

function caseCancel() {
    loadPage("caseShow/caseListPage");
}

//图片上传
function uploadCaseImg() {
    $.ajaxFileUpload({
        fileElementId: 'file',
        url:'/uploadFile',
        type:'POST',
        dataType:'json',
        secureuri:false,
        async:false,
        success: function (result) {
            console.log(result);
            if(result.success){
                let path = result.data.path;
                var el = $("#caseImgsTemp").templateModel(path);
                console.log(el)
                $("#caseImgs").append(el)
            }
        },
        error: function (xhr, status, e) {
            console.log(e);
        }

    })
}