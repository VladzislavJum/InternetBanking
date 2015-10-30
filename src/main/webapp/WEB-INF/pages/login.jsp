<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page session="true" %>
<html>
<head>
    <title>Login Page</title>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="../../resources/css/base.css" />" rel="stylesheet">
    <jsp:include page="../common/footer.jsp"/>

</head>
<body>
<div class="container" style="height: 100%;">

    <div class="col-md-4 col-md-offset-4" style="margin-top: 10%;">
        <c:url value="/j_spring_security_check" var="loginUrl"/>

        <h4 style="color: #c12e2a; text-align: center"> ${message}</h4>

        <form method="post" action="${loginUrl}">
            <input type="text" name="login" value="" class="form-control" placeholder=
            <spring:message code="authorization.label.login"/> required>

            <input type="password" name="password" value="" style="margin-top: 5%" class="form-control"
                   placeholder=
                   <spring:message code="authorization.label.password"/> required>

            <button class="btn btn-default btn-primary btn-block" style="margin-top: 5%;" type="submit"
                    value="submit">
                <spring:message code="authorization.label.signin"/>
            </button>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
    <%--

        <div class="col-md-2 col-md-offset-4" style="margin-top: 10%">
            <img src="../../resources/images/dollar.png">
        </div>
    --%>

</div>

</body>
