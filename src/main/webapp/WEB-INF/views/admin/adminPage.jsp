<%--
  Created by IntelliJ IDEA.
  User: 쩡키
  Date: 2023-12-10
  Time: AM 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="today" class="java.util.Date" />
<jsp:include page="/WEB-INF/views/admin/templates/cmm.jsp" flush="false"/>
<div id="adminPageContent"></div>
<jsp:include page="/WEB-INF/views/admin/templates/footer.jsp" flush="false"/>
<script>
    $(document).on('click', '#test', function() {
        alert('Home 눌름');
    });
</script>