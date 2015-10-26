<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="<c:url value="../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">

</head>
<body>
<div class="container" align="center" style="background-color: #46b8da">
    <b>
        <h3>
            <sec:authorize access="isAnonymous()">
                <a href="/login" style="color: #c12e2a"><spring:message code="authorization.label.signin"/> </a><br/>
                <a href="/admin/signup" style="color: #c12e2a"><spring:message code="registration.label.signup"/> </a>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <a href="/logout">Logout</a>
            </sec:authorize>
        </h3>
    </b>

    <h1><spring:message code="label.welcome"/></h1>
</div>
<br/>


<sec:authorize access="isRememberMe()">
    <label><a href="#">View existing Users</a></label>
</sec:authorize>
</body>
</html>
