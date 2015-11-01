<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:message code="authorization.label.login" var="login"/>
<spring:message code="authorization.label.password" var="password"/>
<spring:message code="authorization.button.signin" var="signin"/>

<html>
<head>
    <title>Login Page</title>
    <link href="<c:url value="../../resources/css/baseForLogin.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <jsp:include page="footer.jsp"/>

</head>
<body>
<div class="container" style="height: 100%;">
    <div class="col-md-4 col-md-offset-4" style="margin-top: 10%;">
        <c:url value="/j_spring_security_check" var="loginUrl"/>
        <h4 style="color: #c12e2a; text-align: center"> ${message}</h4>

        <form:form method="post" action="${loginUrl}">
            <input type="text" class="form-control" name="login" placeholder="${login}"/>

            <input type="password" name="password" style="margin-top: 5%" class="form-control"
                   placeholder="${password}"/>

            <div class="checkbox">
                <label style="color: white"><input type="checkbox" name="remember-me"><spring:message
                        code="authorization.label.remember"/></label>
            </div>

            <button class="btn btn-default btn-primary btn-block" style="margin-top: 5%;" type="submit"
                    value="submit">${signin}
            </button>
        </form:form>
    </div>
</div>
</body>
