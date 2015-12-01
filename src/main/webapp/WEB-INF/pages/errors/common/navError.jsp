<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/user/accounts" var="accounts"/>
<spring:url value="/login" var="login"/>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
    <jsp:include page="../../footer.jsp"/>
</head>
<body>
<nav role="navigation" class="navbar navbar-inverse">
    <div class="navbar-header">
        <b class="navbar-brand"><spring:message code="label.internetbanking"/></b>
    </div>
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="${accounts}">&#9664</a></li>

        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${login}"><spring:message code="nav.button.logout"/> </a></li>
        </ul>
    </div>
</nav>
</body>
</html>
