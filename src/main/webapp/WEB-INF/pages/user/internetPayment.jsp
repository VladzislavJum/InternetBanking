<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="${pageContext.servletContext.contextPath}" var="path"/>
<spring:message code="createaccount.label.amountofmoney" var="money"/>
<spring:message code="createaccount.label.accountnumber" var="accNumber"/>
<spring:message code="internetpey.label.phonenumber" var="phoneNumber"/>
<spring:message code="moneytrans.button.transfer" var="transfer"/>
<spring:message code="paymentserv.button.pay" var="pay"/>


<html>
<head>
    <title><spring:message code="internetpay.label.internet"/></title>
</head>
<body>
<div class="container full-height-border">
    <jsp:include page="common/navUser.jsp"/>
    <form:form commandName="transactionForm" method="post" action="${path}/user/transfer" id="trans">
        <c:if test="${!empty accountList}">
            <div class="row">
                <div class="col-sm-3 col-sm-offset-3 head-users-accounts">${accNumber}</div>
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
                    <form:input class="form-control form-control-moresize" path="numberAccountTo"
                                placeholder="${phoneNumber}"/>
                </div>

                <div class="col-sm-3">
                    <form:input class="form-control form-control-moresize" path="amountOfTransferredMoney"
                                placeholder="${money}"/>
                </div>

            </div>


            <div class="row">
                <div class="col-sm-3 col-sm-offset-3">
                    <form:errors path="numberAccountTo" cssClass="error-text"/>
                </div>
                <div class="col-sm-3">
                    <form:errors path="amountOfTransferredMoney" cssClass="error-text"/>
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
</body>
</html>
