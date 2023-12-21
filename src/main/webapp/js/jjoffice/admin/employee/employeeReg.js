var employeeReg = {
    global : {

    },
    init : function() {

    },
    signUpAction : function() {
        var data = {
            empName:$('#empName').val(),
            empLoginId:$('#empLoginId').val(),
            empLoginPw:$('#empLoginPw').val(),
            empLoginPwChk:$('#empLoginPwChk').val(),
            empSn:$('#empSn').val(),
            empPhone:$('#empPhone').val(),
            empAddr:$('#empAddr').val(),
            empAddrDetail:$('#empAddrDetail').val(),
            empAddrZipcode:$('#empAddrZipcode').val(),
            empPhoto:$('#empPhoto').val(),
        }
        var result = customAjax.fn_customAjax2('/signUp', JSON.stringify(data));
        alert(result.rs.message);
    }
}