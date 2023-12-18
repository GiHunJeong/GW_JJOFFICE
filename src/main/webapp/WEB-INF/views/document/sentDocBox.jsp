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
        <h1 class="m-0">발신 문서함</h1>
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
    <h3 class="card-title" style="margin-top: 10px;">내 발신함</h3>
    <%-- 검색bar --%>
    <div class="form-inline justify-content-end">
      <%-- 검색 카테고리 --%>
      <div class="col-sm1">
        <div class="form-group">
          <select id="searchCol" class="form-control">
            <option value="default">-- 선택 --</option>
            <option value="doc_sn">DocNo</option>
            <option value="doc_title">문서 제목</option>
            <option value="doc_form_name">양식</option>
          </select>
        </div>
      </div>
      <%-- 검색 카테고리 --%>
      <div class="input-group">
        <input id="searchKeyword" class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button id="searchBtn" class="btn btn-sidebar" onclick="sentDocBox.searchAction();" style="background-color: #007bff;">
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
        <th style="width: 60%">문서 제목</th>
        <th style="width: 10%">양식</th>
        <th style="width: 10%">기안자</th>
        <th style="width: 10%">기안일</th>
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
<script type="text/javascript" src="/js/jjoffice/document/sentDocBox.js"></script>
<script>
  sentDocBox.init();
</script>