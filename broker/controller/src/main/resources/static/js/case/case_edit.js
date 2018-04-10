$(function () {
    var addCasePage = sessionStorage.getItem("addCasePage");
    if(addCasePage && addCasePage == 1){

    }
});

function selectCaseImg() {
    $("#file").click();
}

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