<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Eshop - ${param.title}</title>
</head>
<body>
<table width="100%">
    <tr>
        <td>
            <h1>${param.title}</h1>
            <p>Simple servlet/jsp-based web-application demonstrates most features from Java Servlet specification</p>
            <app:menu caption="Menu"/>
        </td>
        <td>
            <app:advBlock title="Special offers!">
                See special offers for special prices!
            </app:advBlock>
        </td>
        <td>
            <app:shoppingCart caption="Shopping cart"/>
        </td>
        <td>
            <app:userInfo greeting="Welcome" caption="Please login"/>
        </td>
    </tr>
</table>
<hr>