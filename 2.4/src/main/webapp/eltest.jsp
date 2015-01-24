<%@ page import="java.util.*" %>
<%@ taglib prefix="func" uri="DiceFunctions" %>
<html>
    <head>
    </head>
    <body>
        <h2>EL example</h2>
        Attribute "myattr": ${myattr.name}<br>
        <b>Test map</b><br>
        testMap.name = ${testMap.name}<br>
        testMap.param = ${testMap.param}<br>
        testMap["param no convention"] = ${testMap["param no convention"]}<br>
        <b>Test list and array</b><br>
        list[0] = ${list[0]}<br>
        list["1"] = ${list["1"]}<br>
        array[0] = ${array[0]}<br>
        array["1"] = ${array["1"]}<br>
        <b>Test scopes</b><br>
        pageScope.myattr.name = ${pageScope.myattr.name}<br>
        requestScope.myattr.name = ${requestScope.myattr.name}<br>
        sessionScope.myattr.name = ${sessionScope.myattr.name}<br>
        applicationScope.myattr.name = ${applicationScope.myattr.name}<br>

        <h2>Request params</h2>
        param.name = ${param.name}<br>
        param.surname = ${param.surname}<br>
        paramValues.color[0] = ${paramValues.color[0]}<br>
        paramValues.color[1] = ${paramValues.color[1]}<br>

        <h2>Context init params</h2>
        initParam["my context param"] = ${initParam["my context param"]}<br>

        <h2>Cookies</h2>
        cookie.cookieName.value = ${cookie.cookieName.value}<br>

        <h2>Headers</h2>
        header.host = ${header.host}<br>

        <h2>Request info</h2>
        <table border="1">
            <tr><td>PathInfo</td><td>${pageContext.request.pathInfo}</td></tr>
            <tr><td>Locale</td><td>${pageContext.request.locale}</td></tr>
            <tr><td>Method</td><td>${pageContext.request.method}</td></tr>
            <tr><td>ContextPath</td><td>${pageContext.request.contextPath}</td></tr>
            <tr><td>AuthType</td><td>${pageContext.request.authType}</td></tr>
            <tr><td>PathTranslated</td><td>${pageContext.request.pathTranslated}</td></tr>
            <tr><td>QueryString</td><td>${pageContext.request.queryString}</td></tr>
            <tr><td>RemoteUser</td><td>${pageContext.request.remoteUser}</td></tr>
            <tr><td>RequestedSessionId</td><td>${pageContext.request.requestedSessionId}</td></tr>
            <tr><td>RequestURI</td><td>${pageContext.request.requestURI}</td></tr>
            <tr><td>RequestURL</td><td>${pageContext.request.requestURL}</td></tr>
            <tr><td>ServletPath</td><td>${pageContext.request.servletPath}</td></tr>
            <tr><td>CharacterEncoding</td><td>${pageContext.request.characterEncoding}</td></tr>
            <tr><td>ContentType</td><td>${pageContext.request.contentType}</td></tr>
            <tr><td>LocalAddr</td><td>${pageContext.request.localAddr}</td></tr>
            <tr><td>LocalPort</td><td>${pageContext.request.localPort}</td></tr>
            <tr><td>RemoteHost</td><td>${pageContext.request.remoteHost}</td></tr>
            <tr><td>RemotePort</td><td>${pageContext.request.remotePort}</td></tr>
            <tr><td>ServerPort</td><td>${pageContext.request.serverPort}</td></tr>
            <tr><td>LocalName</td><td>${pageContext.request.localName}</td></tr>
            <tr><td>Protocol</td><td>${pageContext.request.protocol}</td></tr>
            <tr><td>Scheme</td><td>${pageContext.request.scheme}</td></tr>
            <tr><td>UserPrincipal</td><td>${pageContext.request.userPrincipal}</td></tr>
            <tr><td>ContentLength</td><td>${pageContext.request.contentLength}</td></tr>
        </table>

        <h2>Request info</h2>
        pageContext.session.id = ${pageContext.session.id}<br>

        <h2>EL functions examples</h2>
        func:greetings() = ${func:greetings("Konstantin")}<br>
        func:random() = ${func:random()}<br>
    </body>
</html>