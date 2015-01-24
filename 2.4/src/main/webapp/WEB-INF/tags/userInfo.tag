<%@ attribute name="greeting" rtexprvalue="true" required="true" %>
<%@ attribute name="caption" rtexprvalue="true" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="mytags" %>

<c:url value="/login" var="logoutUrl">
    <c:param name="logout" value="true"/>
</c:url>
<c:url value="/login" var="loginUrl"/>

<my:hasRole anonymous="true">
    <h3>${caption}</h3>
    <a href="${loginUrl}">Login</a>
</my:hasRole>
<my:hasRole>
    <h3>${greeting}, ${userName}</h3>
    <a href="${logoutUrl}">Logout</a>
</my:hasRole>