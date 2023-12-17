<%--
  Created by IntelliJ IDEA.
  User: 쩡키
  Date: 2023-12-13
  Time: PM 8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/templates/cmm2.jsp" flush="false"/>
<!-- Content Wrapper. Contains page content -->
<body style="background-color: #f4f6f9;">
<div class="content-wrapper" style="padding-top: 10px;">
  <!-- Main content -->
  <section class="content">
    <div class="container-fluid">
      <div class="card">
        <div class="card-header">
          <h5 class="card-title m-0">결재라인</h5>
        </div>
        <div class="card-body">

          <textarea id="contentBody" class="summernote" name="editordata"></textarea>
          <div style="text-align: center; margin-top: 10px;">
            <div style="display:inline-block;"><button type="button" class="btn btn-block btn-outline-primary" onclick="docWriteAction();">작성</button></div>
            <div style="display:inline-block;"><button type="button" class="btn btn-block btn-outline-danger" onclick="docCancelAction();">취소</button></div>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>
</body>
<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="resources/plugins/summernote/summernote-lite.js"></script>
<script src="resources/plugins/summernote/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="resources/plugins/summernote/summernote-lite.css">
<!--  -->
<script>
  $('.summernote').summernote({
    height: 450,
    lang: "ko-KR"
  });
  function docWriteAction() {
    let style = `<head><style>.table-bordered {border: 1px solid #ddd;}.table {width: 100%;max-width: 100%;margin-bottom: 20px;}table {background-color: transparent;}table {border-spacing: 0;border-collapse: collapse;}.table-bordered>tbody>tr:nth-of-type(odd) {background-color: #f9f9f9;}.table-bordered>tbody>tr>td, .table-bordered>tbody>tr>th, .table-bordered>tfoot>tr>td, .table-bordered>tfoot>tr>th, .table-bordered>thead>tr>td, .table-bordered>thead>tr>th {border: 1px solid #ddd;}.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {padding: 8px;line-height: 1.42857143;vertical-align: top;border-top: 1px solid #ddd;}</style></head>`;
    let body = ``;
    if($('#contentBody').val().indexOf("<table") != -1) {
      body += style+`<body>`+$('#contentBody').val()+`</body>`;
    }else {
      body += `<body>`+$('#contentBody').val()+`</body>`;
    }
    console.log(body);
    alert('작성 완료');
  }
  function docCancelAction() {
    window.close();
  }
</script>