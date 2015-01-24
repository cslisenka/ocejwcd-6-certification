<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/includes/header.jsp">
    <jsp:param name="title" value="Survey: 3"/>
</jsp:include>

<c:url value="/survey/finish.jsp" var="next"/>

<jsp:useBean id="survey" class="com.example.web.model.SurveyResults" scope="session"/>
<jsp:setProperty name="survey" property="*"/>

<form action="${next}">
    <h3>Your favorite period of time</h3>
    <select name="time">
        <option value="1">Summer</option>
        <option value="2">Autumn</option>
        <option value="3">Spring</option>
        <option value="4">Winter</option>
    </select>
    <br>
    <input type="submit" value="Finish">
</form>

<jsp:include page="/WEB-INF/includes/footer.jsp"/>