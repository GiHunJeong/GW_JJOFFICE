var sentDocBox = {
    global: {

    },
    init : function() {
        let resultTotalCnt = customAjax.fn_customAjax('/ajax/getDocListTotal');
        customPaging.init(10, resultTotalCnt.totalCount, '/ajax/getDocList', 'sentDocBoxList', 'paging',5 ,'1:doc_sn,2:doc_title:a,3:doc_form_name,4:doc_drafter_emp_name,5:reg_date');
        $(document).on('click', '#sentDocBoxList .customPaging-a', function(){
            var doc_sn = $(this).parent().prev().text();
            var url = '/sentDocReadPop?doc='+doc_sn;
            var name = 'Read Document';
            var option = 'location=no,width=800,height=600,top=0,left=0';
            window.open(url, name, option);
        });
        $("#searchKeyword").on('keypress', function(e) {
            if (e.keyCode == '13') {
                sentDocBox.searchAction();
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
        customPaging.init(10, resultTotalCnt.totalCount, '/ajax/getDocList', 'sentDocBoxList', 'paging',5 ,'1:doc_sn,2:doc_title:a,3:doc_form_name,4:doc_drafter_emp_name,5:reg_date');
    },
}