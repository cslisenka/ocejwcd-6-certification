<%@ page import="java.util.*" %>
<%@ page import="com.example.web.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/includes/header.jsp">
    <jsp:param name="title" value="Shopping cart"/>
</jsp:include>

<c:url value="/shop/cart" var="shopCart"/>

<h2>Shopping cart</h2>
<form action="${shopCart}" method="post">
    <table border="1" cellpadding="10">
        <tr>
            <td></td>
            <td>id</td>
            <td>name</td>
            <td>price</td>
        </tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("items");
            for (Product p : products) {
            %>
                <tr>
                    <td><input type="checkbox" name="productId" value="<%=p.getId()%>"></td>
                    <td><%=p.getId()%></td>
                    <td><%=p.getName()%></td>
                    <td><%=p.getPrice()%>$</td>
                </tr>
            <%
            }
        %>
        <tr>
            <td colspan="4">Total: <%=request.getAttribute("total")%></td>
        </tr>
    </table>
    <br>
    <input type="submit" name="operation" value="remove"><br>
    <input type="submit" name="operation" value="submitOrder"><br>
</form>

<%@include file="/WEB-INF/includes/footer.jsp"%>