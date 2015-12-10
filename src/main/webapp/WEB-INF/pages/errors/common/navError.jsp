<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/user/accounts" var="accounts"/>
<spring:url value="/login" var="login"/>
<spring:url value="/" var="firstUrl"/>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
</head>
<body>
    <nav role="navigation" class="navbar navbar-inverse">
        <div class="navbar-header">
            <a class="navbar-brand" href="${firstUrl}"><spring:message code="label.internetbanking"/></a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle"><spring:message code="navuser.button.language"/>
                    <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="?lang=en"><spring:message code="nav.button.lang_en"/>
                    </a></li>
                    <li><a href="?lang=ru"><spring:message code="nav.button.lang_ru"/>
                    </a></li>
                </ul>
            </li>
            <li><a href="${logout}"><spring:message code="nav.button.logout"/> </a></li>
        </ul>
    </nav>
</body>
</html>
