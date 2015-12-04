<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
  <title><spring:message code="history.label.paymenthistory"/></title>

</head>
<body>
<div class="container full-height-border">
  <jsp:include page="common/navUser.jsp"/>
  <div class="row head-color-green">
    <h1 class="head-inf"><spring:message code="payment.label.history"/></h1>
  </div>

  <div class="row margin-top5">
    <div class="head-history-inf col-sm-3"><spring:message code="paymenthist.label.sender"/></div>
    <div class="head-history-inf col-sm-3"><spring:message code="paymenthist.label.recipient"/></div>
    <div class="head-history-inf col-sm-3"><spring:message code="paymenthist.label.amountofmoney"/></div>
    <div class="head-history-inf col-sm-3"><spring:message code="paymenthist.label.datetime"/></div>
  </div>

  <c:forEach items="${historyList}" var="history">
    <div class="row">
      <div class="account-inf col-sm-3">${history.accountNumberFrom}</div>
      <div class="account-inf col-sm-3">${history.objectTo}</div>
      <div class="account-inf col-sm-3">${history.amountOfMoney}</div>
      <div class="account-inf col-sm-3">${history.dateTime}</div>
    </div>
  </c:forEach>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
