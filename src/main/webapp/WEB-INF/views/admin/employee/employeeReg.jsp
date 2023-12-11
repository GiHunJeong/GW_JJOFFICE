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
        <h1 class="m-0">사원 등록</h1>
      </div><!-- /.col -->
      <div class="col-sm-6">
        <ol class="breadcrumb float-sm-right">
          <li class="breadcrumb-item"><a id="test" href="javascript:void(0);">Home</a></li>
          <li class="breadcrumb-item active">사원 관리</li>
          <li class="breadcrumb-item active">사원 등록</li>
        </ol>
      </div><!-- /.col -->
    </div><!-- /.row -->
  </div><!-- /.container-fluid -->
</div>
<!-- /.content-header -->
<div>
  <table>
    <tr>
      <td>사원명</td>
      <td><input id="empName" type="text"/></td>
    </tr>
    <tr>
      <td>아이디</td>
      <td><input id="empLoginId" type="text"/></td>
    </tr>
    <tr>
      <td>비밀번호</td>
      <td><input id="empLoginPw" type="password"/></td>
    </tr>
    <tr>
      <td>비밀번호체크</td>
      <td><input id="empLoginPwChk" type="password"/></td>
    </tr>
    <tr>
      <td>사원번호</td>
      <td><input id="empSn" type="text"/></td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td><input id="empPhone" type="tel"/></td>
    </tr>
    <tr>
      <td>주소</td>
      <td><input id="empAddr" type="text"/></td>
    </tr>
    <tr>
      <td>상세주소</td>
      <td><input id="empAddrDetail" type="text"/></td>
    </tr>
    <tr>
      <td>우편번호</td>
      <td><input id="empAddrZipcode" type="text"/></td>
    </tr>
    <tr>
      <td>사진등록</td>
      <td><input id="empPhoto" type="text"/></td>
    </tr>
  </table>
  <button onclick="employeeReg.signUpAction();">회원가입</button>
</div>
<script type="text/javascript" src="/js/jjoffice/admin/employeeReg.js"></script>
<script>
  employeeReg.init();
</script>