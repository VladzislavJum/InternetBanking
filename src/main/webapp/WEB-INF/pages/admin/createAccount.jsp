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

<div class="container" style="background-color: #245580">
    <jsp:include page="common/navAdmin.jsp"/>
    <form:form class="form-horizontal" method="post" action="/admin/createaccount" commandName="accountForm">

        <%--<h1 style="color: red"> ${message} </h1>--%>

        <form:label path="accountNumber" cssClass="control-label col-xs-5" cssStyle="color:#f9f9f9">${accountNumber}</form:label>
        <form:errors path="accountNumber" cssStyle="color: red; font-size: 20px;"/>

        <div class="col-xs-2">
            <form:input class="form-control" path="accountNumber" placeholder="${accountNumber}"/>
        </div>
        <br/><br/>

        <form:label path="amountOfMoney" cssClass="control-label col-xs-5" cssStyle="color:#f9f9f9">${amountOfMoney}</form:label>
        <form:errors path="amountOfMoney" cssStyle="color: red; font-size: 20px;"/>

        <div class="col-xs-2">
            <form:input class="form-control" path="amountOfMoney" placeholder="${amountOfMoney}"/>
        </div>
        <br/><br/>

        <form:label path="userLogin" cssClass="control-label col-xs-5" cssStyle="color:#f9f9f9">${userLogin}</form:label>
        <form:errors path="userLogin" cssStyle="color: red; font-size: 20px;"/>

        <div class="col-xs-2">
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


<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
            <div class="text-center">
                <h3 style="color: #ac2925">2015</h3>

            </div>
    </div>
</div>
</div>
</body>
</html>