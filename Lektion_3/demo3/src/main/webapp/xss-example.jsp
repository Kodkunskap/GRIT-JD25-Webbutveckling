<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String name = request.getParameter("name");
    request.setAttribute("name", name);
%>
<html>
    <head>
        <title>XSS Example</title>
    </head>
    <body>

        <h1>Hello, <%= request.getParameter("name") %></h1>

        <%--
            xss-example.jsp?name=<script>alert('XSS');</script>

            <script>alert('XSS');</script>
        --%>

        <p>Om vi escapar HTML/XML blir vi inte känsliga för XSS.</p>

        <blockquote>
            ${fn:escapeXml(requestScope.name)}
        </blockquote>

    </body>
</html>
