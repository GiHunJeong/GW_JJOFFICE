var customPaging = {
    global:{
        page: 1,
        contentViewCnt: '',
        contentTotalCnt: '',
        contentUrl: '',
        contentId: '',
        pagingId: '',
        contentColInfo: '',
        contentInRowCnt:''
    },
    /**
     * customPasing
     * @param contentViewCnt 한 화면에 표시될 컨텐츠수 ex) 10 -> 1~10 자료, 5 -> 1~5자료 표시됨
     * @param contentTotalCnt 전체 컨텐츠의 갯수 ex) 해당 테이블의 데이터 총 갯수
     * @param contentUrl 한 화면에 보여줄 컨텐츠를 조회하는 ajax url ex) 'ajax/url'
     * @param contentId 컨텐츠가 표시될 위치 ID값 ex) 'contentId'
     * @param pagingId 페이징이 표시될 위치 ID값 ex) 'pagingId'
     * @param contentInRowCnt 데이터 로우의 갯수 ex | 로우1 | 로우2 | 로우3 | 로우4 | -> row = 4
     * @param contentColInfo 테이블에서 사용할 순번과 컬럼 ex) 1:컬럼네임1,3:컬럼네임2,5:컬럼네임3 ->
     *                                                1번 로우에 컬럼네임1 자료들표기,
     *                                                3번 로우에 컬럼네임2 자료들표기,
     *                                                5번 로우에 컬럼네임3 자료들표기
     *                                                a태그 사용 1:컬럼네임:a, 클래스명: customPaging-a
     *                                                button 사용 4:[button]:버튼네임, 클래스명: customPaging-btn
     */
    init : function(contentViewCnt, contentTotalCnt, contentUrl, contentId, pagingId, contentInRowCnt, contentColInfo) {
        // 페이징 번호 선택 css
        $(document).on('click', '.pageNum', function(){
            $('.pageNum Active').attr('class', 'page-link pageNum');
            $('.pageNum').css('text-decoration', 'none');
            $(this).css('text-decoration', 'underline');
            $(this).attr('class', 'page-link pageNum Active');
        })
        customPaging.global.contentViewCnt = contentViewCnt;
        customPaging.global.contentTotalCnt = contentTotalCnt;
        customPaging.global.contentUrl = contentUrl;
        customPaging.global.contentId = contentId;
        customPaging.global.pagingId = pagingId;
        customPaging.global.contentInRowCnt = contentInRowCnt;
        customPaging.global.contentColInfo = contentColInfo;
        customPaging.fn_paging(1);
    },
    //페이징
    fn_paging : function(num) {
        let page = num; // 현재 페이지
        let pageNum = 10; // 표시될 페이지의 갯수
        let contentViewCnt = customPaging.global.contentViewCnt; // 한 페이지에 표시될 컨텐츠의 갯수
        let contentTotalCnt = customPaging.global.contentTotalCnt; // 전체 컨텐츠의 갯수
        let pageGroup = Math.ceil(contentTotalCnt / contentViewCnt); // 화면에 보여질 페이지 그룹수
        let start = Math.ceil((page - 1) * pageNum) + 1; // 화면에 보여질 페이지 그룹의 첫번째 페이지 번호
        let last = page * pageNum; // 화면에 보여질 페이지 그룹의 마지막 페이지 번호
        // 페이지 prev
        let pageHtml = ''
        if(page > pageNum) {
            pageHtml +=
                `<li class="page-item"><a id="prev" class="page-link prevAndNext" href="javascript:void(0)" onclick="customPaging.fn_prevAndNextClickAction($(this).attr('id'),`+pageNum+`)">«</a></li>`;
        }
        // 페이지 넘버
        for(let i = page; i < page+10; i++) {
            if(i > pageGroup) break;
            pageHtml +=
                `<li class="page-item"><a class="page-link pageNum" href="javascript:void(0)" onclick="customPaging.fn_pageClickAction(`+i+`);">`+i+`</a></li>`;
        }
        // 페이지 next
        if(pageGroup > pageNum && pageGroup > last) {
            pageHtml +=
                `<li class="page-item"><a id="next" class="page-link prevAndNext" href="javascript:void(0)" onclick="customPaging.fn_prevAndNextClickAction($(this).attr('id'),`+pageNum+`)">»</a></li>`;
        }
        $('#'+customPaging.global.pagingId).html(pageHtml);
        $('#'+customPaging.global.pagingId).find('li .pageNum').eq(0).css('text-decoration', 'underline');
        $('#'+customPaging.global.pagingId).find('li .pageNum').eq(0).attr('class', 'page-link pageNum Active');
        customPaging.fn_pagingData(page);
    },
    // 페이지 넘버를 누를때 발생하는 이벤트
    fn_pageClickAction : function(page) {
        customPaging.fn_pagingData(page);
    },
    // 페이지 다음 이전 버튼을 누를때 발생하는 이벤트
    fn_prevAndNextClickAction : function (e, pageNum) {
        if(e === 'prev') {
            customPaging.global.page -= pageNum;
            $('#'+customPaging.global.pagingId).empty();
            customPaging.fn_paging(customPaging.global.page);
        }else {
            customPaging.global.page += pageNum;
            $('#'+customPaging.global.pagingId).empty();
            customPaging.fn_paging(customPaging.global.page);
        }
    },
    // 페이징 데이터
    fn_pagingData : function(page) {
        $('#'+customPaging.global.contentId).children().empty();
        let data = {
            start: ((page-1)*customPaging.global.contentViewCnt),
            last: customPaging.global.contentViewCnt,
            searchKeyword: $('#searchKeyword').val(),
        }
        var result = customAjax.fn_customAjax(customPaging.global.contentUrl, data);
        if(result.flag && result.rs.length != 0) {
            let html = '';
            let button = `<button type="button" class="customPaging-btn btn btn-block btn-outline-primary">!!btnTagName!!</button>`;
            let tr = `<tr>!!trTag!!</tr>`;
            let a = `<a href="javascript:void(0)" class="customPaging-a">!!aTag!!</a>`
            let pageHtml = '';
            let data = customPaging.global.contentColInfo;
            let dataArr = data.split(",");
            for(let i = 0; i < customPaging.global.contentInRowCnt; i ++) {
                html += '<td>'+(i+1)+'!C!O!L!U!M!N!</td>';
            }
            html = tr.replace('!!trTag!!', html);
            // 현재 페이지 컨텐츠 html 생성
            $.each(result.rs, function(index, value) {
                pageHtml += html;
                // 해당 테이블 숫자와 컬럼명에 대입
                $.each(dataArr, function(i, col) {
                    let aTag = col.split(":")[2];
                    let colName = col.split(":")[1];
                    if(aTag === 'a') {
                        pageHtml = pageHtml.replace(col.split(":")[0]+"!C!O!L!U!M!N!", a).replace("!!aTag!!", value[colName]);
                    }else if (colName === '[button]') {
                        let btnName = col.split(":")[2];
                        pageHtml = pageHtml.replace(col.split(":")[0]+"!C!O!L!U!M!N!", button).replace("!!btnTagName!!", btnName);
                    }else {
                        pageHtml = pageHtml.replace(col.split(":")[0]+"!C!O!L!U!M!N!", value[colName]);
                    }
                })
            })
            // 사용하지 않은 컬럼 데이터 초기화
            pageHtml = pageHtml.replaceAll(/(?:[0-9]!C!O!L!U!M!N!)/g, "");
            $('#'+customPaging.global.contentId).html(pageHtml);
        }else{
            let failedPageHtml = '';
            failedPageHtml = `<tr><td colspan="`+customPaging.global.contentInRowCnt+`" style="text-align: center;">No Data Result Found.</td></tr>`;
            $('#'+customPaging.global.contentId).html(failedPageHtml);
            $('#'+customPaging.global.pagingId).empty();
        }
    }
}