<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page session="true" %>
<html>
<head>
    <title>Login Page</title>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="../../resources/css/base.css" />" rel="stylesheet">

</head>
<body>
<div class="container" style="height: 100%; background-color: #204d74">

    <div class="col-md-4 col-md-offset-2" style="margin-top: 15%">
        <c:url value="/j_spring_security_check" var="loginUrl"/>
        <h4 style="color: #c12e2a"> ${message}</h4>


        <form method="post" action="${loginUrl}">
            <input type="text" name="login" value="" class="form-control" placeholder=
            <spring:message code="authorization.label.login"/> required>

            <input type="password" name="password" value="" style="margin-top: 5%" class="form-control"
                   placeholder=
                   <spring:message code="authorization.label.password"/> required>

            <button class="btn btn-default btn-danger btn-block" style="margin-top: 5%;" type="submit"
                    value="submit">
                <spring:message code="authorization.label.signin"/>
            </button>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>

    <div class="col-md-2 col-md-offset-0" style="margin-top: 30%">
        <img src="../../resources/images/dollar.png">

    </div>
</div>
</body>
