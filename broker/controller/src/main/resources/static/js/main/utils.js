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
    templateModelByName:function () {
        var returnHtml = "";
        var args = arguments;
        var result = $(this).html();
        if(args.length <= 0) return result;
        var data = args[0];
        var reg = /\{.*\}/ig;
        result = result.replace(/<!--.*-->/g,'');
        if(!data) return "";
        var name;
        if(Object.prototype.toString.call(data) === '[object Array]'){
            var templateHtml = result;
            var value = "";
            for(var i = 0;i<data.length;i++){
                var match;
                while(match = reg.exec(templateHtml)){
                    name = match[0].replace("{","").replace("}","");
                    if(data && data[i][name] != undefined && data[i][name].toString() != "") {
                        value = data[i][name];
                    }
                    templateHtml = templateHtml.replace(match,value);
                    value = "";
                }
                returnHtml += templateHtml;
                templateHtml = result
            }
        }else{
            var match;
            var value = "";
            while(match = reg.exec(result)) {
                name = match[0];
                name = name.replace("{","").replace("}","");
                if(data && data[name]) {
                    value = data[name];
                }
                result = result.replace(match,value);
                value = "";
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
            success: success,
            error: error
        });
    },
    ajaxGet: function (options) {
        let url = options.url || '';
        let type = 'GET';
        let data = options.data || {};
        let async = options.async || true;
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