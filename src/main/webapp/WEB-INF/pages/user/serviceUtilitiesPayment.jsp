<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:message code="createaccount.label.amountofmoney" var="money"/>
<spring:message code="createaccount.label.accountnumber" var="accountNumber"/>
<spring:message code="moneytrans.button.transfer" var="transfer"/>
<spring:message code="paymentserv.button.pay" var="pay"/>
<spring:url value="/user/payment/service/utilities/${name}/pay" var="payUrl"/>
<spring:message code="paymentserv.label.electricity" var="electricity"/>
<spring:message code="paymentserv.label.gas" var="gas"/>
<spring:message code="paymentserv.label.water" var="water"/>
<spring:message code="paymentserv.label.utilitiesinternet.personalacc" var="personalAccNumber"/>
<spring:message code="paymentserv.label.phonenumber" var="phoneNumber"/>
<spring:message code="paymentserv.label.electricity.amountenergy" var="amountEnergy"/>
<spring:message code="paymentserv.label.water.amountwater" var="amountWater"/>
<spring:message code="paymentserv.label.gas.amountgas" var="amountGas"/>

<html>
<head>
    <title><spring:message code="servicepay.label.services"/></title>
    <jsp:include page="common/navUser.jsp"/>
</head>
<body>
<div class="container full-height-border">
    <div class="row head-color-green">
        <c:choose>
            <c:when test="${name.equals('Gas')}">
                <h1 class="head-inf">${gas}</h1>
            </c:when>
            <c:when test="${name.equals('Water')}">
                <h1 class="head-inf">${water}</h1>
            </c:when>
            <c:when test="${name.equals('Electricity')}">
                <h1 class="head-inf">${electricity}</h1>
            </c:when>
            <c:otherwise>
                <h1 class="head-inf">${name}</h1>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="success-transfer">${result}</div>
    <form:form commandName="servicesForm" method="post" action="${payUrl}" cssClass="margin-top5">
        <c:if test="${!empty accountList}">

            <div class="text-center"><form:errors path="nameCorp" cssClass="error-text"/></div>

            <div class="row">
                <div class="col-sm-3 col-sm-offset-3 head-users-accounts">${accountNumber}</div>
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
            <c:choose>
                <c:when test="${name.equals('Gas')}">
                    <div class="tariff-inf col-sm-6 col-sm-offset-3"><spring:message code="paymentserv.label.gasm3"/>
                        <sup>3</sup>: 850</div>
                    <div class="row margin-top5">
                        <div class="col-sm-3 col-sm-offset-3">
                            <label class="payment-inf">${personalAccNumber}</label>
                        </div>
                        <div class="col-sm-3">
                            <label class="payment-inf">${amountGas}</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-3 col-sm-offset-3">
                            <form:input class="form-control form-control-moresize" path="numberCorporationAcc"
                                        placeholder="${personalAccNumber}"/>
                        </div>

                        <div class="col-sm-3">
                            <form:input class="form-control form-control-moresize" path="amount"
                                        placeholder="${amountGas}"/>
                        </div>
                    </div>

                </c:when>
                <c:when test="${name.equals('Electricity')}">
                    <div class="tariff-inf col-sm-6 col-sm-offset-3"><spring:message code="paymentserv.label.electrkvh"/>
                        <sup>3</sup>: 1000</div>
                    <div class="row margin-top5">
                        <div class="col-sm-3 col-sm-offset-3">
                            <label class="payment-inf">${personalAccNumber}</label>
                        </div>
                        <div class="col-sm-3">
                            <label class="payment-inf">${amountEnergy}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3 col-sm-offset-3">
                            <form:input class="form-control form-control-moresize" path="numberCorporationAcc"
                                        placeholder="${personalAccNumber}"/>
                        </div>

                        <div class="col-sm-3">
                            <form:input class="form-control form-control-moresize" path="amount"
                                        placeholder="${amountEnergy}"/>
                        </div>
                    </div>

                </c:when>
                <c:when test="${name.equals('Water')}">
                    <div class="tariff-inf col-sm-6 col-sm-offset-3"><spring:message code="paymentserv.label.waterm3"/>
                        : 1500</div>
                    <div class="row margin-top5">
                        <div class="col-sm-3 col-sm-offset-3">
                            <label class="payment-inf">${personalAccNumber}</label>
                        </div>
                        <div class="col-sm-3">
                            <label class="payment-inf">${amountWater}</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-3 col-sm-offset-3">
                            <form:input class="form-control form-control-moresize" path="numberCorporationAcc"
                                        placeholder="${personalAccNumber}"/>
                        </div>

                        <div class="col-sm-3">
                            <form:input class="form-control form-control-moresize" path="amount"
                                        placeholder="${amountWater}"/>
                        </div>
                    </div>

                </c:when>
                <c:otherwise>
                    <h1 class="head-inf">${name}</h1>
                </c:otherwise>
            </c:choose>

            <form:hidden path="nameCorp"/>

            <div class="row">
                <div class="col-sm-3 col-sm-offset-3">
                    <form:errors path="numberCorporationAcc" cssClass="error-text"/>
                </div>
                <div class="col-sm-3">
                    <form:errors path="amount" cssClass="error-text"/>
                </div>
            </div>

            <div class="row">
                <input type="submit" class="btn btn-success btn-transfer col-sm-offset-5 col-sm-2"
                       value="${pay}"/>
            </div>

            <div class="error-text-trans">
                <form:errors path="numberAccountFrom"/>
            </div>
        </c:if>
    </form:form>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
