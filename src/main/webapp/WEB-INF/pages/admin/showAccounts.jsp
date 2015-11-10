<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:message code="createaccount.label.amountofmoney" var="money"/>
<spring:message code="createaccount.label.accountnumber" var="number"/>
<spring:message code="action.button.delete" var="deleteButton"/>
<spring:message code="action.button.refill" var="refillButton"/>
<spring:message code="showusersoraccounts.label.action" var="action"/>
<spring:message code="createaccount.label.amountofmoney" var="amountOfMoney"/>
<spring:url value="${pageContext.servletContext.contextPath}" var="path"/>

<html>
<head>
    <title><spring:message code="showaccounts.label.show"/></title>
    <link href="<c:url value="../../../resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="../../../resources/js/window.js"/>"></script>

</head>
<body>
<div class="container full-height">
    <jsp:include page="common/navAdmin.jsp"/>
    <h1 class="head-inf"><spring:message code="showaccounts.label.accounts"/></h1>
    <h4 class="error-search"> ${notExist}</h4>

    <c:if test="${!empty accountList}">
        <table class="table">
            <thead>
            <tr class="thead-text">
                <th>${number}</th>
                <th>${money}</th>
                <th>${action}</th>
            </tr>
            </thead>

            <c:forEach items="${accountList}" var="account">
                <tr class="user-inf">
                    <td>${account.accountNumber}</td>
                    <td>${account.amountOfMoney}</td>
                    <td>
                        <spring:url value="${path}/admin/users/${userID}/accounts/${account.bankAccountID}/delete"
                                    var="deleteUrl"/>

                        <spring:url value="${path}/admin/users/${userID}/accounts/${account.bankAccountID}/delete"
                                    var="deleteUrl"/>
                        <div class="row">
                            <button class="btn btn-success col-sm-3 col-sm-offset-1"
                                    onclick="show('block')">${refillButton}</button>

                            <button class="btn btn-danger col-sm-3"
                                    onclick="location.href=('${deleteUrl}')">${deleteButton}</button>
                        </div>
                    </td>
                </tr>
                </tr>
            </c:forEach>

        </table>

        <div onclick="show('none')" id="wrap"></div>

        <div id="window" class="row">

            <img class="close" onclick="show('none')" src="http://sergey-oganesyan.ru/wp-content/uploads/2014/01/close.png">

            <form:form class="form-horizontal" method="post" action="${path}/admin/createaccount" commandName="historyForm">

            <form:label path="amountOfMoney" cssClass="control-label col-xs-5"
                        cssStyle="color:#9d9d9d">${amountOfMoney}</form:label>
            <form:errors path="amountOfMoney" cssClass="error-text"/>

            <div class="col-xs-3 margin-top10" >
                <form:input class="form-control" path="amountOfMoney" placeholder="${amountOfMoney}"/>
            </div>
            </form:form>

        </div>

    </c:if>
</div>
</body>
</html>
