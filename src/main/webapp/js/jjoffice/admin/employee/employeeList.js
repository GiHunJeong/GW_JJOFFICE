var employeeList = {
    global : {

    },
    init : function() {
        let resultTotalCnt = customAjax.fn_customAjax('/ajax/employeeListTotal');
        customPaging.init(10, resultTotalCnt.rs, '/ajax/employeeList', 'employeeList', 'paging', 7, '1:emp_name,2:emp_sn,3:emp_login_id,4:emp_phone,5:reg_date,6:[button]:수정:btn btn-block btn-primary,7:[button]:삭제:btn btn-block btn-danger');
        $("#searchKeyword").on('keypress', function(e) {
            if (e.keyCode == '13') {
                employeeList.searchAction();
            }
        });
    },
    searchAction : function() {
        var data = {
            searchKeyword: $('#searchKeyword').val(),
        }
        var resultTotalCnt = customAjax.fn_customAjax('/ajax/employeeListTotal', data);
        customPaging.init(10, resultTotalCnt.rs, '/ajax/employeeList', 'employeeList', 'paging',7 ,'1:emp_name,2:emp_sn,3:emp_login_id,4:emp_phone,5:reg_date,6:[button]:수정:btn btn-block btn-primary,7:[button]:삭제:btn btn-block btn-danger');
    }
}