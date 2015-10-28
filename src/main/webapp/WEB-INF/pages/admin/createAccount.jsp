<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="createaccount.label.accountnumber" var="accountNumber"/>
<spring:message code="createaccount.label.amountofmoney" var="amountOfMoney"/>
<spring:message code="createaccount.label.userlogin" var="userLogin"/>
<spring:message code="createaccount.label.create" var="create"/>


<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <title></title>
</head>

<body>

<div class="container">
    <jsp:include page="common/navAdmin.jsp"/>
    <form:form class="form-horizontal" method="post" action="/admin/createaccount" commandName="accountForm">

        <h1 style="color: red"> ${message} </h1>

        <form:label path="accountNumber" class="control-label col-xs-5">${accountNumber}</form:label>
        <form:errors path="accountNumber" cssStyle="color: red"/>

        <div class="col-xs-3">
            <form:input class="form-control" path="accountNumber" placeholder="${accountNumber}"/>
        </div>
        <br/><br/>

        <form:label path="amountOfMoney" class="control-label col-xs-5">${amountOfMoney}</form:label>
        <form:errors path="amountOfMoney" cssStyle="color: red"/>

        <div class="col-xs-3">
            <form:input class="form-control" path="amountOfMoney" placeholder="${amountOfMoney}"/>
        </div>
        <br/><br/>

        <form:label path="userLogin" class="control-label col-xs-5">${userLogin}</form:label>

        <div class="col-xs-3">
            <form:input class="form-control" path="userLogin" placeholder="${userLogin}"/>
        </div>
        <br/><br/>

        <div class="form-group">
            <div class="col-xs-offset-5 col-xs-9">
                <input type="submit" class="btn btn-primary"
                       value="${create}"/>

            </div>
        </div>
    </form:form>
</div>

</body>
</html>