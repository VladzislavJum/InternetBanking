<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page session="true" %>
<html>
<head>
    <title>Login Page</title>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="container" style="width: 300px; margin-top: 10%;">

        <c:url value="/j_spring_security_check" var="loginUrl"/>
        <h4 style="color: #c12e2a"> ${message}</h4>


        <form method="post" action="${loginUrl}">
            <input type="text" name="login" value="" class="form-control" placeholder=
            <spring:message code="authorization.label.login"/> required>

            <input type="password" name="password" value="" style="margin-top: 5%" class="form-control" placeholder=
            <spring:message code="authorization.label.password"/> required>

            <button class="btn btn-default btn-primary btn-block" style="margin-top: 5%;" type="submit" value="submit">
                <spring:message code="authorization.label.signin"/>
            </button>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>



</div>

</body>
