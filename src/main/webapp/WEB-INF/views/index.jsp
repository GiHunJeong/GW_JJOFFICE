<%--
  Created by IntelliJ IDEA.
  User: 쩡키
  Date: 2023-12-08
  Time: AM 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/templates/cmm2.jsp" flush="false"/>
<button onclick="moveMainPage();">메인페이지</button>
<script>
  function moveMainPage() {
    location.href = 'main';
  }
</script>
