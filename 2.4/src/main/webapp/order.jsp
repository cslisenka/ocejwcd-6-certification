<%@ page import="java.util.*, com.example.web.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/shop/catalog" var="shopCatalog"/>

<jsp:include page="/WEB-INF/includes/header.jsp">
    <jsp:param name="title" value="Your order"/>
</jsp:include>
<h2>Your order confirmed</h2>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
    </tr>
    <%
        List<Product> products = (List<Product>) request.getAttribute("orderItems");
        for (Product p : products) {
        %>
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getName()%></td>
                <td><%=p.getPrice()%>$</td>
            </tr>
        <%
        }
    %>
</table>
Total: <b><%=request.getAttribute("total")%></b><br>
<a href="${shopCatalog}">Back</a>
<%@include file="/WEB-INF/includes/footer.jsp"%>