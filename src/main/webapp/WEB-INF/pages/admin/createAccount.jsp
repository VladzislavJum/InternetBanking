<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="createaccount.label.accountnumber" var="accountNumber"/>
<spring:message code="createaccount.label.amountofmoney" var="amountOfMoney"/>
<spring:message code="createaccount.label.userlogin" var="userLogin"/>
<spring:message code="createaccount.button.create" var="create"/>


<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <title></title>
</head>

<body>

<div class="container" style="height: 100%;>
    <jsp:include page="common/navAdmin.jsp"/>
    <div style="margin-top: 10%">
        <form:form class="form-horizontal" method="post" action="/admin/createaccount" commandName="accountForm">

            <form:label path="accountNumber" cssClass="control-label col-xs-4"
                        cssStyle="color:#9d9d9d">${accountNumber}</form:label>
            <form:errors path="accountNumber" cssStyle="color: red; font-size: 20px;"/>

            <div class="col-xs-3">
                <form:input class="form-control" path="accountNumber" placeholder="${accountNumber}"/>
            </div>
            <br/><br/>

            <form:label path="amountOfMoney" cssClass="control-label col-xs-4"
                        cssStyle="color:#9d9d9d">${amountOfMoney}</form:label>
            <form:errors path="amountOfMoney" cssStyle="color: red; font-size: 20px;"/>

            <div class="col-xs-3">
                <form:input class="form-control" path="amountOfMoney" placeholder="${amountOfMoney}"/>
            </div>
            <br/><br/>

            <form:label path="userLogin" cssClass="control-label col-xs-4"
                        cssStyle="color:#9d9d9d">${userLogin}</form:label>
            <form:errors path="userLogin" cssStyle="color: red; font-size: 20px;"/>

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
</div>
</body>
</html>