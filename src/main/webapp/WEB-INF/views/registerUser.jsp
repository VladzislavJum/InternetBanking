<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <title></title>
</head>

<body>
<form:form class="form-horizontal" method="post" action="/signupgood" commandName="userForm">
    <div class="form-group" style="margin-top: 10%;">

        <label class="control-label col-xs-5">
            <spring:message code="label.firstname" var="fname"/>
        </label>
        <div class="col-xs-3">
            <form:input class="form-control" path="firstName" />
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">
            <spring:message code="label.surname" var="surname"/>
        </label>
        <div class="col-xs-3">
            <form:input class="form-control" path="surname"/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">
            <spring:message code="label.secondname" var="sname"/>
        </label>
        <div class="col-xs-3">
            <form:input class="form-control" path="secondName"/>
        </div>
        <br/><br/>

        <label class="control-label col-xs-5">
            <spring:message code="label.passportnumber" var="pnumber"/>
        </label>
        <div class="col-xs-3">
            <form:input class="form-control" path="passportNumber"/>
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
