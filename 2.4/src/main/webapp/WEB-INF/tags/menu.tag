<%@ attribute name="caption" rtexprvalue="true" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="mytags" %>

<c:url value="/" var="main"/>
<c:url value="/survey" var="survey"/>
<c:url value="/shop/cart" var="shopCart"/>
<c:url value="/shop/catalog" var="shopCatalog"/>
<c:url value="/admin/info" var="adminInfo"/>
<c:url value="/admin/command" var="adminCommand"/>
<c:url value="/admin/session" var="adminSession"/>
<c:url value="/admin/cookie" var="adminCookie"/>
<c:url value="/admin/eltest" var="adminEltest">
    <c:param name="name" value="Kostya"/>
    <c:param name="surname" value="Slisenko"/>
    <c:param name="color" value="red"/>
    <c:param name="color" value="orange"/>
</c:url>

<b>${caption}: </b>
<a href="${main}">Main page</a> |
<a href="${survey}">Survey</a> |
<a href="${shopCatalog}">View catalog</a> |

<my:hasRole role="customer">
    <a href="${shopCart}">View shopping cart</a> |
</my:hasRole>
<my:hasRole role="admin">
    <br><b>Administration: </b>
    <a href="${adminInfo}">View system info</a> |
    <a href="${adminCommand}">Play with status, redirect, errors</a> |
    <a href="${adminSession}">Manage session</a> |
    <a href="${adminCookie}">Manage cookies</a> |
    <a href="${adminEltest}">JSP EL examples</a>
</my:hasRole>

<my:menu>
    <my:menuItem name="For users" url="/">
        <my:menuItem name="Entertament" url="/">
            <my:menuItem name="Survey" url="/"/>
            <my:menuItem name="Survey 2" url="/"/>
        </my:menuItem>
        <my:menuItem name="Shopping" url="/">
            <my:menuItem name="Shopping 1" url="/"/>
            <my:menuItem name="Shopping 2" url="/"/>
        </my:menuItem>
    </my:menuItem>
    <my:menuItem name="For customers" url="${main}">
        <my:menuItem name="My orders" url="/">
            <my:menuItem name="Incoming" url="/incoming"/>
            <my:menuItem name="Processed" url="/"/>
        </my:menuItem>
    </my:menuItem>
    <my:menuItem name="Administrators" url="${main}">
        <my:menuItem name="Log in" url="/admin"/>
    </my:menuItem>
</my:menu>