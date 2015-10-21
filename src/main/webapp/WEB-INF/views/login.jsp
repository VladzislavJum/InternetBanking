<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page session="true" %>
<html>
<head>
    <title>Login Page</title>
    <link href="<c:url value="../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <%--<link href="<c:url value="../../resources/bootstrap/css/signin.css" />" rel="stylesheet">--%>
</head>
<body>
<a href="?lang=en"><spring:message code="label.lang_en"/></a>
| <a href="?lang=ru"><spring:message code="label.lang_ru"/></a>


<div class="container" style="width: 300px; margin-top: 10%">

    <c:url value="/j_spring_security_check" var="loginUrl"/>

    <form:form method="post" action="${loginUrl}">
        <input type="text" name="username" value="" class="form-control" placeholder=
        <spring:message code="label.login"/> required>

        <input type="password" name="password" value="" style="margin-top: 5%" class="form-control" placeholder=
        <spring:message code="label.password"/> required>

        <label class="checkbox">
            <input type="checkbox" name="_spring_security_remember_me" value="remember-me"> <spring:message
                code="label.remember"/>
        </label>
        <button class="btn btn-default btn-primary btn-block" style="margin-top: 5%" type="submit" value="submit">
            <spring:message code="label.signin"/>
        </button>


        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form:form>
</div>