<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 쩡키
  Date: 2023-12-10
  Time: AM 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Content Header (Page header) -->
<div class="content-header">
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col-sm-6">
        <h1 class="m-0">사원 목록</h1>
      </div><!-- /.col -->
      <div class="col-sm-6">
        <ol class="breadcrumb float-sm-right">
          <li class="breadcrumb-item"><a id="test" href="javascript:void(0);">Home</a></li>
          <li class="breadcrumb-item active">사원 관리</li>
          <li class="breadcrumb-item active">사원 목록</li>
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
          <button id="searchBtn" class="btn btn-sidebar" onclick="employeeList.searchAction();" style="background-color: #007bff;">
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
        <th>사원명</th>
        <th>사  번</th>
        <th>사원ID</th>
        <th>연락처</th>
        <th>입사일</th>
        <th></th>
        <th></th>
      </tr>
      </thead>
      <tbody id="employeeList">

      </tbody>
    </table>
  </div>
  <!-- /.card-body -->
  <div class="card-footer clearfix">
    <ul id="paging" class="pagination pagination-sm m-0 justify-content-center">

    </ul>
  </div>
</div>
<script type="text/javascript" src="/js/jjoffice/admin/employee/employeeList.js"></script>
<script>
  employeeList.init();
</script>