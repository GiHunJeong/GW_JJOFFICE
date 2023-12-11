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
            console.log(rs.responseDto.data.token);
            alert(rs.responseDto.message);
        }else{
            console.log(rs.responseDto.data.token);
            console.log(rs.responseDto);
            alert(rs.responseDto.message);
            location.href = '/main';
        }
    },
}