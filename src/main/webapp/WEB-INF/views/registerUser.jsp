<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">
    <link  href="../../resources/bootstrap/js/bootstrap.js">
    <%--<link rel="stylesheet" type="text/css" href="../css/register.css">--%>
    <title></title>
</head>

<body>

<form:form class="form-horizontal" method="post" action="/signupgood" commandName="userForm">
<div class="form-group">

    <form:label class="control-label col-xs-5" path="firstName">
        <spring:message text="First Name"/>
    </form:label>
    <div class="col-xs-3">
        <form:input class="form-control" placeholder="First Name" path="firstName"/>
    </div>
        <br><br>
    <form:label class="control-label col-xs-5" path="surname">
        <spring:message text="label.surname"/>
    </form:label>
    <div class="col-xs-3">
        <form:input class="form-control" placeholder="Surname" path="surname"/>
    </div>
        <br><br>

    <form:label class="control-label col-xs-5" path="secondName">
        <spring:message text="label.secondname"/>
    </form:label>
    <div class="col-xs-3">
        <form:input class="form-control" placeholder="Second Name" path="secondName"/>
    </div>
        <br><br>
    <form:label class="control-label col-xs-5" path="passportNumber">
        <spring:message text="label.passportnumber"/>
    </form:label>
    <div class="col-xs-3">
        <form:input class="form-control" placeholder="passportNumber" path="passportNumber"/>
    </div>
        <br>
        <br>
        <div class="form-group">
        <div class="col-xs-offset-5 col-xs-9">
            <input type="submit" class="btn btn-primary" value="<spring:message text="label.signup"/>"/>
            </form:form>
        </div>
    </div>

</body>
</html>
