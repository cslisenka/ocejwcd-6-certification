<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<jsp:include page="/WEB-INF/includes/header.jsp">
    <jsp:param name="title" value="Exception!"/>
</jsp:include>

<%=exception%>

<%@include file="/WEB-INF/includes/footer.jsp"%>