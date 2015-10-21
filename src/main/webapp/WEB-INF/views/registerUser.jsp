<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<spring:message code="label.firstname" var="firstname"/>
<spring:message code="label.surname" var="surname"/>
<spring:message code="label.secondname" var="secondname"/>
<spring:message code="label.passportnumber" var="passportnumber"/>


<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <title></title>
</head>

<body>
<a href="?lang=en"><spring:message code="label.lang_en"/></a>
| <a href="?lang=ru"><spring:message code="label.lang_ru"/></a>

<form:form class="form-horizontal" method="post" action="/signupgood" commandName="userForm">
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

        <div class="form-group">
            <div class="col-xs-offset-5 col-xs-9">
                <input type="submit" class="btn btn-primary" value="<spring:message code="label.signup"/>"/>

            </div>
        </div>
    </div>
</form:form>

</body>
</html>
