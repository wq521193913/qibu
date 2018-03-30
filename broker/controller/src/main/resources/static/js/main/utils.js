$.fn.extend({
    formDataFormatter: function () {
        var data = $(this).serializeArray();
        var ren = {};
        for(var i = data.length - 1; i >= 0; i--){
            ren[data[i].name] = data[i].value;
        }
        return ren;
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