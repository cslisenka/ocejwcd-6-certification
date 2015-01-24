<%@ page %>
<% int i = 10; %>

I = <%=i%><br>

<!-- Dynamic include does not work because it should be compiled as separate servlet -->
<!--jsp:include page="include.jsp"/-->

after dynamic include, I = <%=i%><br>

<% i = 10; %>

<%@include file="include.jsp"%>

after static include, I = <%=i%><br>