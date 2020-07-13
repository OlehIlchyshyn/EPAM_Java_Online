<%--
  Created by IntelliJ IDEA.
  User: Oleh
  Date: 06.05.2020
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Clients</title>
</head>
<body>
<ul>
    <c:forEach items="${requestScope.clients}" var="client" >
        <li>
            <c:out value="${client.name}" />
        </li>
    </c:forEach>
</ul>
</body>
</html>
