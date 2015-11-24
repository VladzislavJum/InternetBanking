<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="${pageContext.servletContext.contextPath}" var="path"/>
<spring:message code="createaccount.label.amountofmoney" var="money"/>
<spring:message code="internetpay.label.accountnumber" var="accountNumber"/>
<spring:message code="moneytrans.button.transfer" var="transfer"/>
<spring:message code="paymentserv.button.pay" var="pay"/>
<spring:url value="/user/payment/internet/pay" var="payUrl"/>


<html>
<head>
    <title><spring:message code="internetpay.label.internet"/></title>
</head>
<body>
<div class="container full-height-border">
    <jsp:include page="common/navUser.jsp"/>

    <div class="row head-color-green">
        <h1 class="head-inf">${name}</h1>
    </div>

    <form:form commandName="servicesForm" method="post" action="${payUrl}">
        <c:if test="${!empty accountList}">
            <div class="row">
                <div class="col-sm-3 col-sm-offset-3 head-users-accounts">${accountNumber}</div>
                <div class="col-sm-3 head-users-accounts">${money}</div>
            </div>

            <c:forEach items="${accountList}" var="account">

                <div class="funkyradio col-sm-offset-9">
                    <div class="funkyradio-primary">
                        <input type="radio" name="accountNumberFrom" id="${account.accountNumber}"
                               value="${account.accountNumber}"/>
                        <label for="${account.accountNumber}">.</label>
                    </div>
                </div>
                <div class="row">
                    <div class="account-inf col-sm-3 col-sm-offset-3">${account.accountNumber}</div>
                    <div class="account-inf col-sm-3">${account.amountOfMoney}</div>
                </div>
            </c:forEach>

            <form:hidden path="nameCorp"/>
            <div class="row margin-top5">
                <%--<div class="col-sm-3 col-sm-offset-3">
                    <form:input class="form-control form-control-moresize" path="number "
                                placeholder="Блаблабла"/>
                </div>--%>

                <div class="col-sm-4 col-sm-offset-4">
                    <form:input class="form-control form-control-moresize" path="amountOfMoney"
                                placeholder="${money}"/>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-3 col-sm-offset-3">
                    <form:errors path="nameCorp" cssClass="error-text"/>
                </div>
                <div class="col-sm-3">
                    <form:errors path="amountOfMoney" cssClass="error-text"/>
                </div>
            </div>

            <div class="row">
                <input type="submit" class="btn btn-success btn-transfer col-sm-offset-5 col-sm-2"
                       value="${pay}"/>
            </div>

            <div class="error-text-trans">
                <form:errors path="accountNumberFrom"/>
            </div>
        </c:if>
    </form:form>
</div>
</body>
</html>
