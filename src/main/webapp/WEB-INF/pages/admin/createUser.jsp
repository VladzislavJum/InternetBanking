<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="registration.label.firstname" var="firstname"/>
<spring:message code="registration.label.surname" var="surname"/>
<spring:message code="registration.label.patronymic" var="patronymic"/>
<spring:message code="registration.label.passportnumber" var="passportNumber"/>
<spring:message code="registration.label.login" var="login"/>
<spring:message code="registration.label.password" var="password"/>
<spring:url value="/admin/register" var="register"/>


<html>
<head>
    <title><spring:message code="createuser.label.create"/></title>
    <jsp:include page="common/navAdmin.jsp"/>
</head>
<body>

<div class="container full-height-border" id="container" pageID="2">
    <div class="row head-color-green">
        <h1 class="head-inf"><spring:message code="registration.label.registration"/></h1>
    </div>
    <form:form class="margin-top5 form-horizontal" method="post" action="${register}" commandName="userForm">

        <form:label class="control-label col-xs-5" cssStyle="color: #9d9d9d;"
                    path="firstname">${firstname}</form:label>
        <div class="col-xs-3">
            <form:input cssClass="form-control" path="firstname" placeholder="${firstname}"/>
        </div>
        <form:errors path="firstname" cssClass="error-text"/>
        <br/><br/>

        <form:label cssClass="control-label col-xs-5" cssStyle="color:#9d9d9d"
                    path="surname">${surname}</form:label>
        <div class="col-xs-3">
            <form:input cssClass="form-control" path="surname" placeholder="${surname}"/>
        </div>
        <form:errors path="surname" cssClass="error-text"/>
        <br/><br/>

        <form:label cssClass="control-label v col-xs-5" cssStyle="color:#9d9d9d"
                    path="patronymic">${patronymic}</form:label>
        <div class="col-xs-3">
            <form:input cssClass="form-control" path="patronymic" placeholder="${patronymic}"/>
        </div>
        <form:errors path="patronymic" cssClass="error-text"/>
        <br/><br/>

        <form:label cssClass="control-label col-xs-5" cssStyle="color:#9d9d9d"
                    path="passportNumber">${passportNumber}</form:label>
        <div class="col-xs-3">
            <form:input cssClass="form-control" path="passportNumber" placeholder="${passportNumber}"/>
        </div>
        <form:errors path="passportNumber" cssClass="error-text"/>
        <br/><br/>

        <form:label cssClass="control-label col-xs-5" cssStyle="color:#9d9d9d" path="login">${login}</form:label>
        <div class="col-xs-3">
            <form:input class="form-control" path="login" placeholder="${login}"/>
        </div>
        <form:errors path="login" cssClass="error-text"/>
        <br/><br/>

        <form:label class="control-label col-xs-5" cssStyle="color:#9d9d9d"
                    path="password">${password}</form:label>
        <div class="col-xs-3">
            <form:input class="form-control" path="password" placeholder="${password}" type="password"/>
        </div>
        <form:errors path="password" cssClass="error-text"/>
        <br/><br/>

        <div class="form-group">
            <div class="col-xs-offset-5 col-xs-9">
                <input type="submit" class="btn btn-primary"
                       value="<spring:message code="registration.button.signup"/>"/>
            </div>
        </div>
    </form:form>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
