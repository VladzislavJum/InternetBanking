<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="registration.label.firstname" var="firstname"/>
<spring:message code="registration.label.surname" var="surname"/>
<spring:message code="registration.label.patronymic" var="patronymic"/>
<spring:message code="registration.label.passportnumber" var="passportNumber"/>
<spring:message code="registration.label.login" var="login"/>
<spring:message code="registration.label.password" var="password"/>


<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <title></title>
</head>
<body>

<div class="container" style="height: 100%;">
    <jsp:include page="common/navAdmin.jsp"/>
    <div style="margin-top: 10%">

        <form:form class="form-horizontal" method="post" action="/admin/register" commandName="userForm">

            <form:label class="control-label col-xs-4" cssStyle="color: #9d9d9d;"
                        path="firstname">${firstname}</form:label>
            <div class="col-xs-3">
                <form:input cssClass="form-control" path="firstname" placeholder="${firstname}"/>
            </div>
            <form:errors path="firstname" cssStyle="color: red; font-size: 20px;"/>
            <br/><br/>

            <form:label cssClass="control-label col-xs-4" cssStyle="color:#9d9d9d"
                        path="surname">${surname}</form:label>
            <div class="col-xs-3">
                <form:input cssClass="form-control" path="surname" placeholder="${surname}"/>
            </div>
            <form:errors path="surname" cssStyle="color: red; font-size: 20px;"/>
            <br/><br/>

            <form:label cssClass="control-label v col-xs-4" cssStyle="color:#9d9d9d"
                        path="patronymic">${patronymic}</form:label>
            <div class="col-xs-3">
                <form:input cssClass="form-control" path="patronymic" placeholder="${patronymic}"/>
            </div>
            <form:errors path="patronymic" cssStyle="color: red; font-size: 20px;"/>
            <br/><br/>

            <form:label cssClass="control-label col-xs-4" cssStyle="color:#9d9d9d"
                        path="passportNumber">${passportNumber}</form:label>
            <div class="col-xs-3">
                <form:input cssClass="form-control" path="passportNumber" placeholder="${passportNumber}"/>
            </div>
            <form:errors path="passportNumber" cssStyle="color: red; font-size: 20px;"/>
            <br/><br/>

            <form:label cssClass="control-label col-xs-4" cssStyle="color:#9d9d9d" path="login">${login}</form:label>
            <div class="col-xs-3">
                <form:input class="form-control" path="login" placeholder="${login}"/>
            </div>
            <form:errors path="login" cssStyle="color: red; font-size: 20px;"/>
            <br/><br/>

            <form:label class="control-label col-xs-4" cssStyle="color:#9d9d9d"
                        path="password">${password}</form:label>
            <div class="col-xs-3">
                <form:input class="form-control" path="password" placeholder="${password}"/>
            </div>
            <form:errors path="password" cssStyle="color: red; font-size: 20px;"/>
            <br/><br/>

            <div class="form-group">
                <div class="col-xs-offset-5 col-xs-9">
                    <input type="submit" class="btn btn-primary"
                           value="<spring:message code="registration.button.signup"/>"/>
                </div>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>
