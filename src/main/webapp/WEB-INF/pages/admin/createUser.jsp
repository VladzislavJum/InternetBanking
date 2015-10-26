<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="registration.label.firstname" var="firstName"/>
<spring:message code="registration.label.surname" var="surname"/>
<spring:message code="registration.label.lastname" var="lastName"/>
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

<div class="container">
    <jsp:include page="common/navAdmin.jsp"/>
    <form:form class="form-horizontal" method="post" action="/admin/register" commandName="userForm">

        <label class="control-label col-xs-5">${firstName}</label>

        <div class="col-xs-3">
            <input class="form-control" name="firstName" placeholder="${firstName}" required/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">${surname}</label>

        <div class="col-xs-3">
            <input class="form-control" name="surname" placeholder="${surname}" required/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">${lastName}</label>

        <div class="col-xs-3">
            <input class="form-control" name="lastName" placeholder="${lastName}" required/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">${passportNumber}</label>

        <div class="col-xs-3">
            <input class="form-control" name="passportNumber" placeholder="${passportNumber}" required/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">${login}</label>

        <div class="col-xs-3">
            <input class="form-control" name="login" placeholder="${login}" required/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">${password}</label>

        <div class="col-xs-3">
            <input class="form-control" name="password" placeholder="${password}" required/>
        </div>
        <br/><br/>

        <div class="form-group">
            <div class="col-xs-offset-5 col-xs-9">
                <input type="submit" class="btn btn-primary"
                       value="<spring:message code="registration.label.signup"/>"/>
            </div>
        </div>
    </form:form>
</div>

</body>
</html>
