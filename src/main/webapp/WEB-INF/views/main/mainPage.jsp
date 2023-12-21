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
<div id="content">
    <video src="/resources/video/user_bg_1080p.mp4" muted autoplay loop style="width:100%; height:100vh; object-fit:cover;"></video>
</div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp" flush="false"/>
<script type="text/javascript" src="/js/jjoffice/main/mainPage.js"></script>
<script>
    mainPage.init();
    mainPage.menu();
</script>