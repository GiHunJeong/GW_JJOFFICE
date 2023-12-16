var customAjax = {
    global : {

    },
    /**
     * CustomAjax
     * @param url
     * @param data
     * @returns {*}
     */
    fn_customAjax : function(url, data){
        var result;
        $.ajax({
            url : url,
            data : data,
            type : "post",
            dataType : "json",
            async : false,
            success : function(rs) {
                result = rs;
                result.flag = true;
            },
            error :function (e) {
                result = false;
                console.log('error : ', e);
            }
        });

        return result;
    },
    /**
     * Custom Ajax @RequestBody
     * @param url
     * @param JSON.stringify(data)
     * @returns {*}
     */
    fn_customAjax2 : function(url, data){
        var result;
        $.ajax({
            url : url,
            data : data,
            type : "post",
            dataType : "json",
            contentType : 'application/json; charset=utf-8',
            async : false,
            success : function(rs) {
                result = rs;
                result.flag = true;
            },
            error :function (e) {
                result = false;
                console.log('error : ', e);
            }
        });

        return result;
    },
    fn_customFormDataAjax : function(url, data){
        var result;
        $.ajax({
            url : url,
            data : data,
            type : "post",
            dataType : "json",
            contentType: false,
            processData: false,
            enctype : 'multipart/form-data',
            async : false,
            success : function(rs) {
                result = rs;
                result.flag = true;
            },
            error :function (e) {
                result = false;
                console.log('error : ', e);
            }
        });

        return result;
    },
}