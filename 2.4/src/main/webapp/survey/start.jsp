<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/includes/header.jsp">
    <jsp:param name="title" value="Survey: 1"/>
</jsp:include>

<c:url value="/survey/survey2.jsp" var="next"/>

<form action="${next}">
    <h3>Your favorite color</h3>
    <select name="color">
        <option value="green">Green</option>
        <option value="red">Red</option>
        <option value="bloe">Blue</option>
    </select>
    <br>
    <input type="submit" value="Next">
</form>

<jsp:include page="/WEB-INF/includes/footer.jsp"/>