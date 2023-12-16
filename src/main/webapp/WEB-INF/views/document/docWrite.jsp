<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 쩡키
  Date: 2023-12-13
  Time: PM 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content-header">
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col-sm-6">
        <h1 class="m-0">기안</h1>
      </div><!-- /.col -->
      <div class="col-sm-6">
        <ol class="breadcrumb float-sm-right">
          <li class="breadcrumb-item"><a id="test" href="javascript:void(0);">Home</a></li>
          <li class="breadcrumb-item active">전자결재</li>
        </ol>
      </div><!-- /.col -->
    </div><!-- /.row -->
  </div><!-- /.container-fluid -->
</div>
<!-- /.content-header -->

<div class="card">
  <div class="card-header">
    <h3 class="card-title" style="margin-top: 10px;">문서양식</h3>
    <%-- 검색bar --%>
    <div class="form-inline justify-content-end">
      <div class="input-group">
        <input id="searchKeyword" class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button id="searchBtn" class="btn btn-sidebar" onclick="searchAction();" style="background-color: #007bff;">
            <i class="fas fa-search fa-fw"></i>
          </button>
        </div>
      </div>
    </div>
    <%-- 검색bar --%>
  </div>
  <!-- /.card-header -->
  <div class="card-body">
    <table class="table table-bordered">
      <thead>
      <tr>
        <th style="width: 10%">DocNo</th>
        <th style="width: 60%">양식명</th>
        <th style="width: 20%">생성일</th>
        <th style="width: 10%"></th>
      </tr>
      </thead>
      <tbody id="docBoxList">

      </tbody>
    </table>
  </div>
  <!-- /.card-body -->
  <div class="card-footer clearfix">
    <ul id="paging" class="pagination pagination-sm m-0 justify-content-center">

    </ul>
  </div>
</div>
<script>
  $(document).on('click', '.customPaging-a', function(){
    var doc_sn = $(this).parent().prev().text();
    var url = '/docWritePop?doc='+doc_sn;
    var name = '문서작성';
    var option = 'location=no,width=800,height=600,top=0,left=0';
    window.open(url, name, option);
  })
  $("#searchKeyword").on('keypress', function(e) {
    if (e.keyCode == '13') {
      searchAction();
    }
  });
  customPaging.init(10, ${totalCount}, '/ajax/getDocBoxList', 'docBoxList', 'paging',4 ,'1:doc_sn,2:doc_name:a,3:doc_reg_date,4:[button]:작성');
  function searchAction() {
    var data = {
      searchKeyword: $('#searchKeyword').val(),
    }
    var resultTotalCnt = customAjax.fn_customAjax('/ajax/getDocBoxTotal', data);
    customPaging.init(10, resultTotalCnt.totalCount, '/ajax/getDocBoxList', 'docBoxList', 'paging',4 ,'1:doc_sn,2:doc_name:a,3:doc_reg_date,4:[button]:작성');
  }
</script>
