<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h2>Error</h2>
    ErrorData.requestURI = ${pageContext.errorData.requestURI}<br>
    ErrorData.servletName = ${pageContext.errorData.servletName}<br>
    ErrorData.statusCode = ${pageContext.errorData.statusCode}<br>
    ErrorData.throwable = ${pageContext.errorData.throwable}<br>
    ErrorData.throwable.message = ${pageContext.errorData.throwable.message}<br>

    <h2>Stack trace</h2>
    <%=exception.getMessage()%>
</body>
</html>
