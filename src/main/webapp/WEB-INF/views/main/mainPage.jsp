<%--
  Created by IntelliJ IDEA.
  User: 쩡키
  Date: 2023-12-08
  Time: AM 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="today" class="java.util.Date" />
<jsp:include page="/WEB-INF/views/templates/cmm.jsp" flush="false"/>
<input type="hidden" id="alertMsg" value="${msg}"/>
<div id="content"></div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp" flush="false"/>
<script>
    $(document).on('click', '#test', function() {
        alert('Home 눌름');
    });
    if($('#alertMsg').val() != '') {
        alert($('#alertMsg').val());
    }
</script>