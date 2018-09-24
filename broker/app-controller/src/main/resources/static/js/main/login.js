$(function(){
    $.backstretch("/static/img/1.jpg");
});

/**
 * 登录
 * @returns {boolean}
 */
function signIn() {
    let userNo = $("#userNo").val();
    let password = $("#password").val();

    if(!userNo || !password) return false;

    $.ajax({
        url: '/login',
        type: 'POST',
        data: {'userNo':userNo, 'password': password},
        dataType: 'json',
        success: function (res) {
            if(res && res.success){
                console.log(res);
                location.href = '/main';
            }else {
                layer.alert(res.msg || "登录失败");
            }
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });

}