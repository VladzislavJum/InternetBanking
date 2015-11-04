<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<spring:message code="createaccount.label.amountofmoney" var="money"/>
<spring:message code="createaccount.label.accountnumber" var="number"/>
<spring:message code="action.button.delete" var="deleteButton"/>
<spring:message code="showusersoraccounts.label.action" var="action"/>
<spring:url value="${pageContext.servletContext.contextPath}" var="path"/>

<html>
<head>
    <title><spring:message code="showaccounts.label.show"/></title>
    <link href="<c:url value="../../../resources/css/style.css" />" rel="stylesheet">
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
                        <button class="btn btn-danger"
                                onclick="location.href=('${deleteUrl}')">${deleteButton}</button>
                    </td>
                </tr>
                </tr>
            </c:forEach>

        </table>
    </c:if>
</div>
</body>
</html>
