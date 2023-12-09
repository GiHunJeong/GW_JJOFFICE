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
<div>
  <table>
    <thead>
      <th>사원명</th>
      <th>사  번</th>
      <th>사원ID</th>
    </thead>
    <tbody>
    <c:forEach var="e" items="${empList}">
      <tr>
        <td>${e.emp_name}</td>
        <td>${e.emp_sn}</td>
        <td>${e.emp_login_id}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>