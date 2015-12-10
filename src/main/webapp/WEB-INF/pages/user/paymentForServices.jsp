<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/user/payment/service/utilities/" var="serviceUtilities"/>
<spring:url value="/user/payment/service/mobile/" var="serviceMobile"/>
<spring:url value="/user/payment/service/internet/" var="serviceInternet"/>
<spring:message code="paymentserv.label.electricity" var="electricity"/>
<spring:message code="paymentserv.label.gas" var="gas"/>
<spring:message code="paymentserv.label.water" var="water"/>
<html>
<head>
    <title><spring:message code="payment.label.payservices"/></title>
    <jsp:include page="common/navUser.jsp"/>
</head>
<body>
<div class="container full-height-border" id="container" pageID="3">
    <div class="row">
        <div class="dropdown">
            <button class="btn btn-success dropdown-toggle col-sm-4 button-actions-text service-button" type="button"
                    data-toggle="dropdown"><spring:message code="paymentserv.button.mobile"/>
            </button>
            <ul class="dropdown-menu menu-1">
                <b>
                    <li><a href="${serviceMobile}MTC">MTC</a></li>
                    <li><a href="${serviceMobile}VELCOM">VELCOM</a></li>
                    <li><a href="${serviceMobile}LIFE">LIFE</a></li>
                </b>
            </ul>
        </div>

        <div class="dropdown">
            <button class="btn btn-success dropdown-toggle col-sm-4 button-actions-text service-button" type="button"
                    data-toggle="dropdown"><spring:message code="paymentserv.button.utilities"/>
            </button>
            <ul class="dropdown-menu menu-2">
                <b>
                    <li><a href="${serviceUtilities}Water">${water}</a></li>
                    <li><a href="${serviceUtilities}Gas">${gas}</a></li>
                    <li><a href="${serviceUtilities}Electricity">${electricity}</a></li>
                </b>
            </ul>
        </div>

        <div class="dropdown">
            <button class="btn btn-success dropdown-toggle col-sm-4 button-actions-text service-button" type="button"
                    data-toggle="dropdown"><spring:message code="paymentserv.button.internet"/>
            </button>
            <ul class="dropdown-menu menu-3">
                <b>
                    <li><a href="${serviceInternet}FlyNet">FlyNet</a></li>
                    <li><a href="${serviceInternet}Infolan">Infolan</a></li>
                    <li><a href="${serviceInternet}TCM">TCM</a></li>
                    <li><a href="${serviceInternet}QLINE">QLINE</a></li>
                    <li><a href="${serviceInternet}NetBerry">NetBerry</a></li>
                    <li><a href="${serviceInternet}UNET">UNET</a></li>
                </b>
            </ul>
        </div>
    </div>

    <img class="col-sm-offset-4 margin-top5" style="width: 400px; height: 400px;"
         src="<c:url value="/resources/images/services.png"/>"/>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
