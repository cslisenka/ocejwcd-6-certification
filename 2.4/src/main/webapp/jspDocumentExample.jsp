<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
    <jsp:directive.page contentType="text/html; ISO-8859-1" language="java"/>
    <jsp:text><![CDATA[
        <html>
        <title>positiveTagLib</title>
        <body>
        ]]>
    </jsp:text>

    <jsp:scriptlet>
        int a = 1;
        out.println("a = " + a);
    </jsp:scriptlet>

    <jsp:text>Positive test taglib directive</jsp:text>
    <jsp:text><![CDATA[
        </body>
        </html>
        ]]>
    </jsp:text>
</jsp:root>