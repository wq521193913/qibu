$(function () {
    var addCasePage = sessionStorage.getItem("addCasePage");
    if(addCasePage && addCasePage == 1){
        $("#editForm").reset;
        sessionStorage.removeItem("addCasePage");
    }else {
        var caseData = sessionStorage.getItem("caseData");
        fillData(caseData);

        //获取效果图
        getSketchImgs(caseData.uid);
    }
});

function fillData(data) {
    let obj = JSON.parse(data);
    let els = $("#editForm").find("input");
    for(let i = 0; i < els.length; i++){
        let el = els[i];
        if(el.type == "text"){
            $(el).val(obj[el.name]);
        }else if(el.type == "radio"){
            $("#" + el.name + obj[el.name]).attr("checked",true);
        }
    }
    let caseImg = obj.caseImg;
    $("#caseImg").attr("src",caseImg);

}

function getSketchImgs(caseId) {
    $.ajaxGet({
        url:'caseSketch/queryCaseSketchList',
        data:{"caseId":caseId},
        success:function (result) {
            if(result.success){
                var sketchList = result.data;
                for(let i = 0; i < sketchList.length; i++){
                    let el = $("#sketchImgsTemp").templateModel(sketchList[i].imgUrl);
                    $("#sketchImgs").append(el)
                }
            }else {
                console.log(result)
            }
        }
    })
}

function selectCaseImg() {

    $("#caseImgFile").click();
}

function selectSketchImg() {
    $("#sketchImgFile").click();
}

//提交
function caseSubmit() {
    let params = $("#editForm").formDataFormatter();
    if(!params.caseTitle){
        layer.alert("请填入案例标题");
        return false;
    }
    if(!params.caseStyle){
        layer.alert("请填入案例风格");
        return false;
    }

    let caseImg = $("#caseImg").attr("src");
    if(!caseImg || (caseImg && caseImg == 'img/default.jpg')){
        layer.alert("请上传案例展示图");
        return false;
    }
    params.caseImg = caseImg;

    let imgs = "";
    let imgEl = $("#sketchImgs").find("img");
    for(let i = 0; i < imgEl.length; i++){
        imgs += $(imgEl[i]).attr("src") + ";";
    }

    params.sketchImgs = imgs;

    console.log(params);
    $.ajaxPost({
        url: 'caseShow/insertCaseShow',
        data: params,
        success: function (result) {
            console.log(result);
        }
    })
}

function caseCancel() {
    loadPage("caseShow/caseListPage");
}

//图片上传
function uploadCaseImg() {
    $.ajaxFileUpload({
        fileElementId: 'caseImgFile',
        url:'/uploadFile',
        type:'POST',
        dataType:'json',
        secureuri:false,
        async:false,
        success: function (result) {
            console.log(result);
            if(result.success){
                $("#caseImg").attr("src",result.data.path);
            }else {
                layer.alert(result.msg || "操作失败,请联系管理员");
            }
        },
        error: function (xhr, status, e) {
            console.log(e);
        }

    })
}

//图片上传
function uploadSketchImg() {
    $.ajaxFileUpload({
        fileElementId: 'sketchImgFile',
        url:'/uploadFile',
        type:'POST',
        dataType:'json',
        secureuri:false,
        async:false,
        success: function (result) {
            console.log(result);
            if(result.success){
                let path = result.data.path;
                var el = $("#sketchImgsTemp").templateModel(path);
                $("#sketchImgs").append(el)
            }else{
                layer.alert(result.msg || "操作失败,请联系管理员");
            }
        },
        error: function (xhr, status, e) {
            console.log(e);
        }

    })
}