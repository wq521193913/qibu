$.fn.extend({
    formDataFormatter: function () {
        var data = $(this).serializeArray();
        var ren = {};
        for(var i = data.length - 1; i >= 0; i--){
            ren[data[i].name] = data[i].value;
        }
        return ren;
    },

    templateModel:function () {
        var args = arguments;
        if(args.length <= 0) return;
        var reg = /\{[\{\d\}]\}/;
        var result = $(this).html();
        result = result.replace(/<!--.*-->/g,'');
        var i = 0;
        for(; i<args.length;i++){
            if(args[i] || args[i]==0){
                result = result.replace(reg,args[i]);
            }else{
                result = result.replace(reg,"");
            }
        }
        return result;
    },
    templateModelByName:function (data) {
        var returnHtml = "";
        var result = $(this).html();
        if(!data) return "";
        result = result.replace(/<!--.*-->/g,'');
        if(Object.prototype.toString.call(data) === '[object Array]'){
            var templateHtml = result;
            var value = "";
            var name = "";
            var b = false;
            var c = false;
            var names =[];
            let htmlChar = "";
            for(let i = 0; i < templateHtml.length; i++){
                htmlChar = templateHtml.substring(i,i+1);
                if(!htmlChar) continue;
                if(htmlChar == "{"){
                    b = true
                }else if(htmlChar == "}"){
                    b = false
                    c = true;
                }
                if(b){
                    if(htmlChar == "{") continue;
                    name += htmlChar;
                }
                if(c){
                    names.push(name);
                    c = false;
                    name = "";
                }
                continue;
            }
            for(var i = 0;i<data.length;i++){
                for(let j in names){
                    value = data[i][names[j]];
                    if(value){
                        templateHtml = templateHtml.replace("{" + names[j] + "}",value);
                    }
                }
                returnHtml += templateHtml;
                templateHtml = result
            }
        }else{
            var name = "";
            var b = false;
            var c = false;
            let htmlChar = "";
            for(let i = 0; i < result.length; i++){
                htmlChar = result.substring(i,i+1);
                if(htmlChar == "{"){
                    b = true
                }else if(htmlChar == "}"){
                    b = false;
                    c = true;
                }
                if(b){
                    if(htmlChar == "{") continue;
                    name += htmlChar;
                }
                if(c){
                    result = result.replace("{" + name + "}", data[name])
                    name = "";
                    c = false;
                }
                continue;
            }
            returnHtml = result;
        }
        return returnHtml;
    }
});

$.extend({
    ajaxPost: function (options) {
        let url = options.url || '';
        let type = 'POST';
        let data = options.data || {};
        let async = options.async || true;
        let dataType = options.dataType || 'json';
        let contentType = options.contentType || 'application/x-www-form-urlencoded';
        let success = options.success || function () {};
        let error = options.error || function (xhr) {
            console.log(xhr)
        }

        $.ajax({
            url: url,
            type: type,
            data: data,
            async: async,
            contentType: contentType,
            dataType: dataType,
            success: success,
            error: error
        });
    },
    ajaxGet: function (options) {
        let url = options.url || '';
        let type = 'GET';
        let data = options.data || {};
        let async = options.async || true;
        let dataType = options.dataType || 'json';
        let contentType = options.contentType || 'application/x-www-form-urlencoded';
        let success = options.success || function () {};
        let error = options.error || function (xhr) {
            console.log(xhr)
        }

        $.ajax({
            url: url,
            type: type,
            data: data,
            async: async,
            contentType: contentType,
            dataType: dataType,
            success: success,
            error: error
        });
    }
})

function strFormat() {
    var args = arguments;
    if(args.length <= 1) return;
    var reg = /\{[\{\d\}]\}/;
    var result = args[0];
    var i = 1;
    for(; i<args.length;i++){
        result = result.replace(reg,args[i]);
    }
    return result;
}