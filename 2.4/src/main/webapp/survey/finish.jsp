<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/includes/header.jsp">
    <jsp:param name="title" value="Survey results"/>
</jsp:include>

<c:url value="/survey/survey2.jsp" var="next"/>

<jsp:useBean id="survey" class="com.example.web.model.SurveyResults" scope="session"/>
<jsp:setProperty name="survey" property="*"/>

<b>Time:</b> <jsp:getProperty name="survey" property="time"/><br>
<b>Food:</b> <jsp:getProperty name="survey" property="food"/><br>
<b>Pet:</b> <jsp:getProperty name="survey" property="pet"/><br>
<b>Color:</b> <jsp:getProperty name="survey" property="color"/><br>

<jsp:include page="/WEB-INF/includes/footer.jsp"/>