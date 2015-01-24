<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/includes/header.jsp">
    <jsp:param name="title" value="Survey: 2"/>
</jsp:include>

<c:url value="/survey/survey3.jsp" var="next"/>

<jsp:useBean id="survey" class="com.example.web.model.SurveyResults" scope="session"/>
<jsp:setProperty name="survey" property="*"/>

<form action="${next}">
    <h3>Name of your pet</h3>
    <input type="text" name="pet">
    <br>
    <h3>Your favorite food</h3>
    Hamburger: <input type="checkbox" name="food" value="hamburger"><br>
    Apples: <input type="checkbox" name="food" value="apples"><br>
    Fried potatoes: <input type="checkbox" name="food" value="fried potatoes"><br>
    <input type="submit" value="Next">
</form>

<jsp:include page="/WEB-INF/includes/footer.jsp"/>