<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/includes/header.jsp">
    <jsp:param name="title" value="Please login to application"/>
</jsp:include>
<form method="POST" action="j_security_check">
    User: <input type="text" name="j_username"/><br>
    Password: <input type="text" name="j_password"/><br>
    <input type="submit" value="Login"/>
</form>
<%@include file="/WEB-INF/includes/footer.jsp"%>