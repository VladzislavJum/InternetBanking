<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="createaccount.label.accountnumber" var="accountNumber"/>
<spring:message code="createaccount.label.amountofmoney" var="amountOfMoney"/>
<spring:message code="createaccount.label.userlogin" var="userLogin"/>
<spring:message code="createaccount.button.create" var="create"/>
<spring:url value="/admin/createaccount" var="createaccount"/>
<spring:url value="/admin/users/searchUsers" var="searchUserUrlAjax"/>
<html>
<head>
    <title><spring:message code="createaccount.label.create"/></title>
    <jsp:include page="common/navAdmin.jsp"/>
    <link href="<c:url value="/resources/css/userSelect.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/js/userSelectAjax.js"/>"></script>
</head>
<body>
<div class="container full-height-border" id="container" pageID="3">
    <div class="row head-color-green">
        <h1 class="head-inf"><spring:message code="createaccount.label.newaccount"/></h1>
    </div>
    <div class="margin-top5">
        <form:form class="form-horizontal" method="post" action="${createaccount}" commandName="accountForm">
            <form:label path="accountNumber" cssClass="control-label col-xs-5"
                        cssStyle="color:#9d9d9d">${accountNumber}</form:label>

            <div class="col-xs-3">
                <form:input class="form-control" path="accountNumber" placeholder="${accountNumber}"/>
            </div>
            <form:errors path="accountNumber" cssClass="error-text"/>
            <br/><br/>

            <form:label path="amountOfMoney" cssClass="control-label col-xs-5"
                        cssStyle="color:#9d9d9d">${amountOfMoney}</form:label>

            <div class="col-xs-3">
                <form:input class="form-control" path="amountOfMoney" placeholder="${amountOfMoney}"/>
            </div>
            <form:errors path="amountOfMoney" cssClass="error-text"/>
            <br/><br/>

            <form:label path="userLogin" cssClass="control-label col-xs-5"
                        cssStyle="color:#9d9d9d; margin-right: 15px;">${userLogin}</form:label>

            <div class="navbar-form" method="post" role="search">
                <form:select id="userSelect" data-placeholder="${userLogin}" form="accountForm"
                             url="${searchUserUrlAjax}" path="userLogin" cssStyle="max-width: 50px;">
                </form:select>
                <form:errors path="userLogin" cssClass="error-text" cssStyle="margin-left: 10px;"/>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-5 col-xs-2">
                    <input type="submit" class="btn btn-primary"
                           value="${create}"/>
                </div>
            </div>
        </form:form>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>