<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 23.10.2015
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
  <a href="/logout">Logout</a>
</sec:authorize>
<h1><spring:message code="label.cardnumber"/> </h1>

<c:if test="${!empty userCards}">
  <c:forEach items="${userCards}" var="userCards">
    ${userCards.getCardNumber()}<br/>
  </c:forEach>
</c:if>

</body>
</html>
