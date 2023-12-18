var sentDocBox = {
    global: {

    },
    init : function() {
        let resultTotalCnt = customAjax.fn_customAjax('/ajax/getDocListTotal');
        customPaging.init(10, resultTotalCnt.totalCount, '/ajax/getDocList', 'docBoxList', 'paging',5 ,'1:doc_sn,2:doc_title:a,3:doc_form_name,4:doc_drafter_emp_name,5:reg_date');
        $("#searchKeyword").on('keypress', function(e) {
            if (e.keyCode == '13') {
                searchAction();
            }
        });
    },
    searchAction : function() {
        let searchCol = '';
        if($('#searchCol option:checked').val() == 'default') {
            alert('검색할 대상 목록을 선택하세요.');
            return;
        }else {
            searchCol = $('#searchCol option:checked').val();
        }
        let data = {
            searchKeyword: $('#searchKeyword').val(),
            searchCol: searchCol,
        }
        let resultTotalCnt = customAjax.fn_customAjax('/ajax/getDocListTotal', data);
        customPaging.init(10, resultTotalCnt.totalCount, '/ajax/getDocList', 'docBoxList', 'paging',5 ,'1:doc_sn,2:doc_title:a,3:doc_form_name,4:doc_drafter_emp_name,5:reg_date');
    },
}