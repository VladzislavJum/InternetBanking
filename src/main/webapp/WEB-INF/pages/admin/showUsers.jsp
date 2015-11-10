<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="registration.label.login" var="loginLabel"/>
<spring:message code="registration.label.firstname" var="firstnameLabel"/>
<spring:message code="registration.label.surname" var="surnameLabel"/>
<spring:message code="registration.label.patronymic" var="patronymicLabel"/>
<spring:message code="registration.label.passportnumber" var="passportnumberLabel"/>
<spring:message code="showusersoraccounts.label.action" var="actonLable"/>
<spring:message code="action.button.delete" var="deleteButton"/>
<spring:message code="action.button.accounts" var="accountsButton"/>
<spring:message code="action.button.unlocked" var="lockButton"/>
<spring:message code="action.button.unlock" var="unlockButton"/>
<spring:url value="${pageContext.servletContext.contextPath}" var="path"/>

<html>
<head>
    <link href="<c:url value="../../../resources/css/style.css" />" rel="stylesheet">
    <title><spring:message code="showusers.label.show"/></title>
</head>
<body>
<header>
</header>

<div class="container full-height">
    <jsp:include page="common/navAdmin.jsp"/>

    <h1 class="head-inf"><spring:message code="showusers.label.listusers"/></h1>
    <h4 class="error-search"> ${message}</h4>

    <c:if test="${!empty userList}">

        <table class="table">
            <thead>
            <tr class="thead-text">
                <th>${firstnameLabel}</th>
                <th>${surnameLabel}</th>
                <th>${patronymicLabel}</th>
                <th>${passportnumberLabel}</th>
                <th>${loginLabel}</th>
                <th>${actonLable}</th>
            </tr>
            </thead>

            <c:forEach items="${userList}" var="user">
                <tr class="user-inf">
                    <td>${user.firstname}</td>
                    <td>${user.surname}</td>
                    <td>${user.patronymic}</td>
                    <td>${user.passportNumber}</td>
                    <td>${user.login}</td>

                    <td>
                        <spring:url value="${path}/admin/users/${user.userID}/accounts" var="accountsUrl"/>
                        <spring:url value="${path}/admin/users/${user.userID}/delete" var="deleteUrl"/>
                        <spring:url value="${path}/admin/users/${user.userID}/lockorunlock" var="lockOrUnlockUrl"/>

                        <div class="row">
                            <button class="btn btn-info col-sm-4 button-actions-text"
                                    onclick="location.href='${accountsUrl}'">${accountsButton}</button>
                            <c:choose>
                                <c:when test="${user.unlocked}">
                                    <button class="btn btn-warning col-sm-4 col-sm-offset-0 button-actions-text"
                                            onclick="location.href=('${lockOrUnlockUrl}')">${lockButton}</button>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-success col-sm-4 col-sm-offset-0 button-actions-text"
                                            onclick="location.href=('${lockOrUnlockUrl}')">${unlockButton}</button>
                                </c:otherwise>
                            </c:choose>
                            <button class="btn btn-danger col-sm-4 col-sm-offset-0 button-actions-text
                                    onclick="location.href=('${deleteUrl}')">${deleteButton}</button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>

</body>
</html>
