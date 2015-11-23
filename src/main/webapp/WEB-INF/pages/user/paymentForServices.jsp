<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:message code="createaccount.label.amountofmoney" var="money"/>
<spring:message code="createaccount.label.accountnumber" var="number"/>
<spring:message code="paymentserv.button.pay" var="pay"/>
<html>
<head>
    <title><spring:message code="payment.label.payservices"/></title>
    <script src="<c:url value="../../../resources/js/service.js"/>"></script>

</head>
<body>
<div class="container full-height-border">
    <jsp:include page="common/navUser.jsp"/>
    <div class="row">
        <div class="dropdown">
            <button class="btn btn-success dropdown-toggle col-sm-4 button-actions-text service-button" type="button"
                    data-toggle="dropdown"><spring:message code="paymentserv.button.mobile"/>
            </button>
            <ul class="dropdown-menu menu-1">
                <b>
                    <li><a href="#">MTC</a></li>
                    <li><a href="#">VELCOM</a></li>
                    <li><a href="#">LIFE</a></li>
                </b>
            </ul>
        </div>


        <div class="dropdown">
            <button class="btn btn-success dropdown-toggle col-sm-4 button-actions-text service-button" type="button"
                    data-toggle="dropdown"><spring:message code="paymentserv.button.utilities"/>
            </button>
            <ul class="dropdown-menu menu-2">
                <b>
                    <li><a href="#">111</a></li>
                    <li><a href="#">2222</a></li>
                    <li><a href="#">333</a></li>
                    <li><a href="#">444</a></li>
                    <li><a href="#">55555</a></li>
                    <li><a href="#">5555.BY</a></li>
                </b>
            </ul>
        </div>




        <div class="dropdown">
            <button class="btn btn-success dropdown-toggle col-sm-4 button-actions-text service-button" type="button"
                    data-toggle="dropdown"><spring:message code="paymentserv.button.internet"/>
            </button>
            <ul class="dropdown-menu menu-3 ">
                <b>
                    <li><a onclick="internetService('asd')">FlyNet</a></li>
                    <li><a>Infolan.by</a></li>
                    <li><a>TCM</a></li>
                    <li><a>QLINE</a></li>
                    <li><a>NetBerry</a></li>
                    <li><a>UNET.BY</a></li>
                </b>
            </ul>
        </div>
    </div>

    <div class="margin-top5 ">
    <%--<form:form commandName="transactionForm" method="post" action="${path}/user/transfer" id="trans">--%>
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
                   <%-- <form:input class="form-control form-control-moresize" path="numberAccountTo"
                                placeholder="${number}"/>--%>
                </div>

                <div class="col-sm-3">
                   <%-- <form:input class="form-control form-control-moresize" path="amountOfTransferredMoney"
                                placeholder="${money}"/>--%>
                </div>

            </div>


           <%-- <div class="row">
                <div class="col-sm-3 col-sm-offset-3">
                    <form:errors path="numberAccountTo" cssClass="error-text"/>
                </div>
                <div class="col-sm-3">
                    <form:errors path="amountOfTransferredMoney" cssClass="error-text"/>
                </div>
            </div>--%>

            <div class="row">
                <input type="submit" class="btn btn-success btn-transfer col-sm-offset-5 col-sm-2"
                       value="${pay}"/>
            </div>

          <%--  <div class="error-text-trans">
                <form:errors path="numberAccountFrom"/>
            </div>--%>
        </c:if>

    <%--</form:form>--%>
    </div>

    <div class="col-sm-3">
        <input class="form-control form-control-moresize" name="amountOfTransferredMoney"
                    placeholder="${money}" id="form" style="display: none"/>
    </div>

</div>
</body>
</html>
