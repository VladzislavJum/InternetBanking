<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/user/payment/internet/" var="internet"/>
<html>
<head>
    <title><spring:message code="payment.label.payservices"/></title>
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
                    <li><a href="${internet}FlyNet">FlyNet</a></li>
                    <li><a href="${internet}Infolan">Infolan</a></li>
                    <li><a href="${internet}TCM">TCM</a></li>
                    <li><a href="${internet}QLINE">QLINE</a></li>
                    <li><a href="${internet}NetBerry">NetBerry</a></li>
                    <li><a href="${internet}UNET">UNET</a></li>
                </b>
            </ul>
        </div>
    </div>

    <img class="col-sm-offset-4 margin-top5" style="width: 400px; height: 400px;"
         src="<c:url value="/resources/images/services.png"/>"/>

</div>
</body>
</html>
