<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <title></title>

</head>
<body>
<header>
</header>

<div class="container" style="background-color: lightsteelblue">
    <jsp:include page="common/navUser.jsp"/>
    <h1><spring:message code="accounts.label.accounts"/></h1>
    <c:if test="${!empty userAccounts}">
    <c:forEach items="${userAccounts}" var="userAccounts">
        ${userAccounts.getAccountNumber()}<br/>
    </c:forEach>
</c:if>
</div>

<footer>
</footer>
</body>
</html>
