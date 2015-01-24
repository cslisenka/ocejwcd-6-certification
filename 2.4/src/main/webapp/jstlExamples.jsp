<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL examples</title>
</head>
<body>
    <%
        pageContext.setAttribute("htmlFragment", "<b>bold</b>");
        pageContext.setAttribute("cities", Arrays.asList("Minsk", "Grodno", "Moscow", "Prague", "New York"));
        pageContext.setAttribute("condition", true);
    %>

    <h2>c:out</h2>
    no params: <c:out value="${htmlFragment}"/><br>
    escapeXml="false" : <c:out value="${htmlFragment}" escapeXml="false"/><br>
    default="default value": <c:out value="${unknownVariable}" default="default value" /><br>

    <h2>c:forEach</h2>
    <c:forEach var="city" items="${cities}" varStatus="varStatus">
        ${city}
        (count=${varStatus.count}, begin=${varStatus.begin}, current=${varStatus.current}, step=${varStatus.step},
        end=${varStatus.end}, first=${varStatus.first}, index=${varStatus.index}, last=${varStatus.last})<br>
    </c:forEach>

    <h2>c:if</h2>
    <c:if test="${condition}">c:if (true)</c:if>

    <h2>c:choose, c:set, c:remove</h2>

    <c:set var="chooseNumber" value="2"/>
    <c:set var="text">
        My text
    </c:set>
    <c:choose>
        <c:when test="${chooseNumber eq 1}">
            1
        </c:when>
        <c:when test="${chooseNumber eq 2}">
            2 - ${text}
        </c:when>
        <c:otherwise>
            ${text}
        </c:otherwise>
    </c:choose>
    <br>

    <c:remove var="text"/>
    after remove text = ${text}<br>
</body>
</html>
