<%--
  Created by IntelliJ IDEA.
  User: Oleh
  Date: 03.05.2020
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Спортивний клуб</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
<form action="${contextPath}/clients" method="GET">
    <input type="submit" value="View all clients">
</form>
<form action="${contextPath}/trainers" METHOD="GET">
    <input type="submit" value="View all trainers">
</form>
</body>
</html>
