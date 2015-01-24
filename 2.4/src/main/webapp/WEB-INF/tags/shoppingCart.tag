<%@ attribute name="caption" required="true" rtexprvalue="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="mytags" %>

<c:url value="/shop/cart" var="shopCart"/>

<my:hasRole role="customer">
    <h3>${caption}</h3>
    <b>Count:</b> ${cart.count}, <b>${cart.total}$</b><br>
    <a href="${shopCart}">View shopping cart</a>
</my:hasRole>