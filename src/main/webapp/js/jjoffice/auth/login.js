var login = {
    global: {

    },
    init : function() {
        $("#empLoginId,#empLoginPw").on('keypress', function(e) {
            if (e.keyCode == '13') {
                login.signInAction();
            }
        });
    },
    signInAction : function() {
        var data = {
            empLoginId: $("#empLoginId").val(),
            empLoginPw: $("#empLoginPw").val(),
        }
        var rs = customAjax.fn_customAjax2('/signIn' ,JSON.stringify(data));
        if(!rs.responseDto.result) {
            alert(rs.responseDto.message);
        }else{
            alert(rs.responseDto.message);
            location.href = '/main';
        }
    },
}