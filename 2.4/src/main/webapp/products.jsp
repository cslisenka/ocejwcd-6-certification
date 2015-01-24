<%@ page import="java.util.*, com.example.web.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/includes/header.jsp">
    <c:param name="title" value="Products catalog"/>
</c:import>

<c:url value="/shop/cart" var="shopCart"/>

<form action="${shopCart}" method="post">
    <table border="1" cellpadding="10">
        <tr>
            <td></td>
            <td></td>
            <td>id</td>
            <td>name</td>
            <td>price</td>
        </tr>

        <c:forEach var="product" items="${products}" varStatus="status">
        <tr>
            <td>${varStatus.count}</td>
            <td><input type="checkbox" name="productId" value="${product.id}"></td>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}$ <c:if test="${product.specialOffer}"><b>Special offer!</b></c:if></td>
        </tr>
        </c:forEach>
    </table>
    <input type="hidden" name="operation" value="add"/>
    <br>
    <input type="submit" value="Add to cart">
</form>
<c:import url="/WEB-INF/includes/footer.jsp"/>