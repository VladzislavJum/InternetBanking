<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:message code="createaccount.label.amountofmoney" var="money"/>
<spring:message code="createaccount.label.accountnumber" var="number"/>
<spring:message code="moneytrans.button.transfer" var="transfer"/>
<spring:message code="locale.label.lang" var="lang"/>
<spring:url value="/user/transfer" var="transferUrl"/>
<spring:url value="/user/account/searchAcc" var="searchAccUrlAjax"/>
<html>
<head>
    <title><spring:message code="moneytrans.label.transaction"/></title>
    <jsp:include page="common/navUser.jsp"/>
    <link href="<c:url value="/resources/css/accountSelect.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/select2/js/select2.js"/>"></script>
    <script src="<c:url value="/resources/select2/js/i18n/${lang}.js"/>"></script>
    <script src="<c:url value="/resources/js/accountSelectAjax.js"/>"></script>
    <script src="<c:url value="/resources/js/popUpSuccesTrans.js"/>"></script>
</head>
<body>
<div class="container full-height-border" id="container" pageID="2">
    <div class="row head-color-green">
        <img style="height: 100px; width: 150px;" class="col-sm-2"
             src="<c:url value="/resources/images/transfer1.jpg"/> ">
        <span class="col-sm-5 col-sm-offset-2 head-inf"><spring:message code="moneytrans.label.trans"/></span>
    </div>

    <div class="success-transfer">${result}</div>


<form:form commandName="transactionForm" method="post" action="${transferUrl}" cssClass="margin-top5" id="trans">
    <c:if test="${!empty accountList}">
    <div class="row">
        <div class="col-sm-3 col-sm-offset-3 head-users-accounts">${number}</div>
        <div class="col-sm-3 head-users-accounts">${money}</div>
    </div>

    <c:forEach items="${accountList}" var="account">
        <div class="funkyradio col-sm-offset-9">
            <div class="funkyradio-primary">
                <input type="radio" name="numberAccountFrom" id="${account.accountNumber}"
                       value="${account.accountNumber}"/>
                <label for="${account.accountNumber}">.</label>
            </div>
        </div>
        <div class="row">
            <div class="account-inf col-sm-3 col-sm-offset-3">${account.accountNumber}</div>
            <div class="account-inf col-sm-3">${account.amountOfMoney}</div>
        </div>
    </c:forEach>


    <div class="row margin-top5">
        <div class="col-sm-3 col-sm-offset-3">
            <form:input class="form-control form-control-moresize" path="amountOfTransferredMoney"
                        placeholder="${money}"/>
        </div>
        <div class="navbar-form col-sm-3" method="post" role="search">
            <form:select id="accSelect" data-placeholder="${number}" form="trans"
                         url="${searchAccUrlAjax}" path="objectTo">
            </form:select>
        </div>

        <div class="row">
            <div class="col-sm-3 col-sm-offset-3">
                <form:errors path="amountOfTransferredMoney" cssClass="error-text"/>
            </div>
            <div class="col-sm-3">
                <form:errors path="objectTo" cssClass="error-text"/>
            </div>
        </div>
        <div class="row">
            <input type="submit" class="btn btn-success btn-transfer col-sm-offset-5 col-sm-2"
                   value="${transfer}"/>
        </div>
        <div class="error-text-trans">
            <form:errors path="numberAccountFrom"/>
        </div>
        </c:if>
        </form:form>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
