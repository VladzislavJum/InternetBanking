<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="label.firstname" var="firstname"/>
<spring:message code="label.surname" var="surname"/>
<spring:message code="label.secondname" var="secondname"/>
<spring:message code="label.passportnumber" var="passportnumber"/>
<spring:message code="label.login" var="login"/>
<spring:message code="label.password" var="password"/>


<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <title></title>
</head>

<body>

<sec:authorize access="isAnonymous()">
    <a href="/login">Login</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a href="/logout">Logout</a>
</sec:authorize>
<br/>


<a href="?lang=en"><spring:message code="label.lang_en"/></a>
| <a href="?lang=ru"><spring:message code="label.lang_ru"/></a>

<form:form class="form-horizontal" method="post" action="/signupsucces" commandName="userForm">
    <div class="form-group" style="margin-top: 10%;">

        <label class="control-label col-xs-5">${firstname}</label>
        <div class="col-xs-3">
            <input class="form-control" name="firstName" placeholder="${firstname}" required/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">${surname}</label>
        <div class="col-xs-3">
            <input class="form-control" name="surname" placeholder="${surname}" required/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">${secondname}</label>
        <div class="col-xs-3">
            <input class="form-control" name="secondName" placeholder="${secondname}" required/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">${passportnumber}</label>
        <div class="col-xs-3">
            <input class="form-control" name="passportNumber" placeholder="${passportnumber}" required/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5" >${login}</label>
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
                <input type="submit" class="btn btn-primary" value="<spring:message code="label.signup"/>"/>

            </div>
        </div>
    </div>
</form:form>

</body>
</html>
