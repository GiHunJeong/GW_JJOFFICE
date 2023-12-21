var employeeList = {
    global : {

    },
    init : function() {
        $(document).on('click', '.modEmp', function() {
            alert('수정버튼눌름');
        });
        $(document).on('click', '.delEmp', function() {
            if($(this).parent().parent().find('td').eq(2).text() == 'admin') {
                alert('관리자 계정은 삭제할 수 없습니다.');
                return;
            }
            if(confirm("정말 삭제하시겠습니까?")) {
                let data = {
                    empLoginId: $(this).parent().parent().find('td').eq(2).text(),
                }
                let result = customAjax.fn_customAjax('/ajax/employeeDel', data);
                employeeList.searchAction();
            }
        });
        let resultTotalCnt = customAjax.fn_customAjax('/ajax/employeeListTotal');
        customPaging.init(10, resultTotalCnt.rs, '/ajax/employeeList', 'employeeList', 'paging', 7, '1:emp_name,2:emp_sn,3:emp_login_id,4:emp_phone,5:reg_date,6:[button]:수정:btn btn-block btn-primary modEmp,7:[button]:삭제:btn btn-block btn-danger delEmp');
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
        customPaging.init(10, resultTotalCnt.rs, '/ajax/employeeList', 'employeeList', 'paging',7 ,'1:emp_name,2:emp_sn,3:emp_login_id,4:emp_phone,5:reg_date,6:[button]:수정:btn btn-block btn-primary modEmp,7:[button]:삭제:btn btn-block btn-danger delEmp');
    }
}