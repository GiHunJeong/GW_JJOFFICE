var customPaging = {
    global:{
        page: 1,
        viewCnt: '',
        totalCnt: '',
        contentUrl: '',
        contentId: '',
        pagingId: ''
    },
    init : function(viewCnt, totalCnt, contentUrl, contentId, pagingId) { // 한 화면에 표시될 컨텐츠수, 전체 컨텐츠의 갯수, 컨텐츠가 표시될 위치 ID값, 페이징이 표시될 위치 ID값
        // 페이징 번호 선택 css
        $(document).on('click', '.pageNum', function(){
            $('.pageNum Active').attr('class', 'pageNum');
            $('.pageNum').css('text-decoration', 'none');
            $(this).css('text-decoration', 'underline');
            $(this).attr('class', 'pageNum Active');
        })
        customPaging.global.viewCount = viewCnt;
        customPaging.global.totalCount = totalCnt;
        customPaging.global.contentUrl = contentUrl;
        customPaging.global.contentId = contentId;
        customPaging.global.pagingId = pagingId;
        customPaging.fn_paging(1);
    },
    //페이징
    fn_paging : function(num) {
        let page = num; // 현재 페이지
        let pageNum = 10; // 표시될 페이지의 갯수
        let viewCount = customPaging.global.viewCount; // 한 페이지에 표시될 컨텐츠의 갯수
        let totalCount = customPaging.global.totalCount; // 전체 컨텐츠의 갯수
        let pageGroup = Math.ceil(totalCount / viewCount); // 화면에 보여질 페이지 그룹수
        let start = Math.ceil((page - 1) * pageNum) + 1; // 화면에 보여질 페이지 그룹의 첫번째 페이지 번호
        let last = page * pageNum; // 화면에 보여질 페이지 그룹의 마지막 페이지 번호
        console.log(start, last);
        // 페이지 prev
        let pageHtml = ''
        if(page > pageNum) {
            pageHtml +=
                `<li><a href="javascript:void(0)" class="prevAndNext" id="prev" onclick="customPaging.fn_prevAndNextClickAction($(this).attr('id'),`+pageNum+`)"><&nbsp&nbsp</a></li>`;
        }
        // 페이지 넘버
        for(let i = page; i <= page+10; i++) {
            if(i > pageGroup) break;
            pageHtml +=
                `<li><a href="javascript:void(0)" class="pageNum" onclick="customPaging.fn_pageClickAction(`+i+`);">&nbsp`+i+`&nbsp</a></li>`;
        }
        // 페이지 next
        if(pageGroup > pageNum && pageGroup > last) {
            pageHtml +=
                `<li><a href="javascript:void(0)" class="prevAndNext" id="next" onclick="customPaging.fn_prevAndNextClickAction($(this).attr('id'),`+pageNum+`)">&nbsp&nbsp></a></li>`;
        }
        $('#'+customPaging.global.pagingId).html(pageHtml);
        $('#'+customPaging.global.pagingId).find('li .pageNum').eq(0).css('text-decoration', 'underline');
        $('#'+customPaging.global.pagingId).find('li .pageNum').eq(0).attr('class', 'pageNum Active');
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
            start: ((page-1)*customPaging.global.viewCount),
            last: customPaging.global.viewCount,
        }
        let result = customAjax.fn_customAjax(customPaging.global.contentUrl, data);
        if(result.flag) {
            let html = `<tr><td>양식명</td></tr>`;
            $.each(result.rs, function(index, value) {
                html +=
                    `<tr><td><a>`+value.doc_name+`</a></td></tr>`;
            })
            $('#'+customPaging.global.contentId).html(html);
        }
    }
}