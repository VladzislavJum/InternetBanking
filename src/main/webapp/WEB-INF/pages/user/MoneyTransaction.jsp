<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="${pageContext.servletContext.contextPath}" var="path"/>
<spring:message code="createaccount.label.amountofmoney" var="money"/>
<spring:message code="createaccount.label.accountnumber" var="number"/>
<spring:message code="moneytrans.button.transfer" var="transfer"/>

<html>
<head>
    <title><spring:message code="moneytrans.label.transaction"/></title>
    <link href="<c:url value="../../../resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="container full-height">
    <jsp:include page="common/navUser.jsp"/>

    <form:form commandName="transactionForm" method="post" action="${path}/user/transfer">
        <c:if test="${!empty accountList}">

            <div class="row">
                <div class="col-sm-3 head-column">${number}</div>
                <div class="col-sm-3 head-column">${money}</div>
            </div>

            <c:forEach items="${accountList}" var="account">
                <div class="row">
                    <div class="col-sm-3 account-inf">${account.accountNumber}</div>
                    <div class="col-sm-3 account-inf">${account.amountOfMoney}</div>
                    <div class="checkbox-text">
                        <div class="radio">
                           <form:radiobutton path="numberAccountFrom" value="${account.accountNumber}"/>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>

        <div class="form-group">
            <div class="col-xs-offset-5 col-xs-9">
                <input type="submit" class="btn btn-primary"
                       value="${transfer}"/>
            </div>
        </div>
        <form:errors path="numberAccountFrom" cssClass="error-text"/>
    </form:form>



</div>
</body>
</html>
