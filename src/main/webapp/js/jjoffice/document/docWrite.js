var docWrite = {
    global : {

    },
    init : function() {
        let resultTotalCnt = customAjax.fn_customAjax('/ajax/getDocBoxTotal');
        customPaging.init(10, resultTotalCnt.totalCount, '/ajax/getDocBoxList', 'docBoxList', 'paging',4 ,'1:doc_sn,2:doc_name:a,3:doc_reg_date,4:[button]:작성');
        $(document).on('click', '.customPaging-a', function(){
            var doc_sn = $(this).parent().prev().text();
            var url = '/docWritePop?doc='+doc_sn;
            var name = '문서작성';
            var option = 'location=no,width=800,height=600,top=0,left=0';
            window.open(url, name, option);
        });
        $("#searchKeyword").on('keypress', function(e) {
            if (e.keyCode == '13') {
                searchAction();
            }
        });
    },
    searchAction : function() {
        var data = {
            searchKeyword: $('#searchKeyword').val(),
        }
        var resultTotalCnt = customAjax.fn_customAjax('/ajax/getDocBoxTotal', data);
        customPaging.init(10, resultTotalCnt.totalCount, '/ajax/getDocBoxList', 'docBoxList', 'paging',4 ,'1:doc_sn,2:doc_name:a,3:doc_reg_date,4:[button]:작성');
    }
}