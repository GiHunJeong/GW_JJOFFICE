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

          <div style="text-align: center; margin-top: 10px;">
            <div style="display:inline-block;"><button type="button" class="btn btn-block btn-outline-danger" onclick="cancelAction();">닫기</button></div>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>
</body>
<script>
  function cancelAction() {
    window.close();
  }
</script>