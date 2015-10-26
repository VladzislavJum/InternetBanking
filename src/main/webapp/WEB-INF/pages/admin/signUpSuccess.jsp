<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="registration.label.firstname" var="firstNameLabel"/>
<spring:message code="registration.label.surname" var="surnameLabel"/>
<spring:message code="registration.label.lastname" var="lastNameLabel"/>
<spring:message code="registration.label.passportnumber" var="passportNumberLabel"/>
<spring:message code="registration.label.login" var="loginLabel"/>
<spring:message code="registration.label.password" var="passwordLabel"/>


<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <title></title>
</head>

<body>

<div class="container" style="align-content: center">
    <jsp:include page="common/navAdmin.jsp"/>

    <h1><spring:message code="signupsuccess.label.created"/> </h1><br/>
    ${firstNameLabel}: ${firstName}<br/>
    ${surnameLabel}: ${surname}<br/>
    ${lastNameLabel}: ${lastName}<br/>
    ${passportNumberLabel}: ${passportNumber}<br/>
    ${loginLabel}: ${login}<br/>

</div>

</body>
</html>
