var docWritePop = {
    global:{

    },
    init : function() {
        $('.summernote').summernote({
            height: 450,
            lang: "ko-KR"
        });
    },
    docWriteAction : function() {
        let style = `<head><style>.table-bordered {border: 1px solid #ddd;}.table {width: 100%;max-width: 100%;margin-bottom: 20px;}table {background-color: transparent;}table {border-spacing: 0;border-collapse: collapse;}.table-bordered>tbody>tr:nth-of-type(odd) {background-color: #f9f9f9;}.table-bordered>tbody>tr>td, .table-bordered>tbody>tr>th, .table-bordered>tfoot>tr>td, .table-bordered>tfoot>tr>th, .table-bordered>thead>tr>td, .table-bordered>thead>tr>th {border: 1px solid #ddd;}.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {padding: 8px;line-height: 1.42857143;vertical-align: top;border-top: 1px solid #ddd;}</style></head>`;
        let body = ``;
        if($('#contentBody').val().indexOf("<table") != -1) {
            body += style+`<body>`+$('#contentBody').val()+`</body>`;
        }else {
            body += `<body>`+$('#contentBody').val()+`</body>`;
        }
        var data = {
            docContent: body,
        }
        var result = customAjax.fn_customAjax('/ajax/setDocumentInfo', data);
        alert(result.rs);
    },
    docCancelAction : function() {
        window.close();
    },
}