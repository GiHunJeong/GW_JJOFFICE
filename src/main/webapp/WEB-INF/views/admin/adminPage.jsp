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
<div id="adminPageContent">
    <video src="/resources/video/admin_bg_2160p.mp4" muted autoplay loop style="width:100%; height:100vh; object-fit:cover;"></video>
</div>
<jsp:include page="/WEB-INF/views/admin/templates/footer.jsp" flush="false"/>
<script type="text/javascript" src="/js/jjoffice/admin/adminPage.js"></script>
<script>
    adminPage.init();
</script>