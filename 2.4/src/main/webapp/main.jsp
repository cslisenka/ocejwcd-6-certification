<%@ page import="java.util.*, java.text.*, com.example.web.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="mytags" %>
<c:url value="/image" var="image"/>

<jsp:include page="/WEB-INF/includes/header.jsp">
    <jsp:param name="title" value="Main page"/>
</jsp:include>
<%! int hitsCount=0; %>
<%! String currentDate() {
    return DateFormat.getDateInstance().format(new Date());
}
%>

<!-- it is possible to use JSP document syntacs in regular JSP files -->
<jsp:scriptlet>
    int a = 1;
    out.println("a = " + a);
</jsp:scriptlet>

<my:currentDate>
    Current date:
    Day: ${day}<br>
    Month: ${month}<br>
    Year: ${year}<br>
</my:currentDate>
<%-- JSP comment is not displayed in html --%>
<h3><%= config.getInitParameter("title") %></h3>
<b>Hits count: <% out.print(hitsCount++); %></b><br>
<b>Current date: <%=currentDate()%></b><br>
<img src="${image}"/>
<%@include file="/WEB-INF/includes/footer.jsp"%>