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
<div>
  <div class="card">
    <div class="card-header">
      <h5 class="card-title m-0">문서양식</h5>
    </div>
    <div class="card-body">
      <table>
        <table id="docBoxList">

        </table>
        <div>
          <ul id="paging" class="pagination justify-content-center">

          </ul>
        </div>
      </table>
    </div>
  </div>
</div>
<script>
  function docWritePopAction(docName) {
    var url = '/docWritePop?doc='+docName;
    var name = '문서작성';
    var option = 'location=no,width=800,height=600,top=0,left=0';
    window.open(url, name, option);
  }
  customPaging.init(1, ${totalCount}, '/ajax/getDocBoxList', 'docBoxList', 'paging');
</script>
