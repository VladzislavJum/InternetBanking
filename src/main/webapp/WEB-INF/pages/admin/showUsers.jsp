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
<spring:message code="showusersoraccounts.label.action" var="actonLabel"/>
<spring:message code="action.button.delete" var="deleteButton"/>
<spring:message code="action.button.accounts" var="accountsButton"/>
<spring:message code="action.button.unlocked" var="lockButton"/>
<spring:message code="action.button.unlock" var="unlockButton"/>
<spring:url value="${pageContext.servletContext.contextPath}" var="path"/>

<html>
<head>
    <title><spring:message code="showusers.label.show"/></title>
    <script src="<c:url value="../../../resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="../../../resources/js/usersAjax.js"/>"></script>
    <script src="<c:url value="../../../resources/js/clickForUser.js"/>"></script>


</head>
<body>

<div class="container full-height-border">
    <jsp:include page="common/navAdmin.jsp"/>
    <div class="row head-color-green">
        <h1 class="head-inf"><spring:message code="showusers.label.listusers"/></h1>
    </div>
    <h4 class="error-search"> ${message}</h4>

    <c:if test="${!empty userList}">
        <div class="row">
            <div class="col-sm-2 head-users">${firstnameLabel}</div>
            <div class="col-sm-2 head-users">${surnameLabel}</div>
            <div class="col-sm-2 head-users">${patronymicLabel}</div>
            <div class="col-sm-2 head-users">${passportnumberLabel}</div>
            <div class="col-sm-2 head-users">${loginLabel}</div>
            <div class="col-sm-2 head-users">${actonLabel}</div>
        </div>

        <c:forEach items="${userList}" var="user">

            <spring:url value="${path}/admin/users/${user.userID}/accounts" var="accountsUrl"/>
            <spring:url value="${path}/admin/users/${user.userID}/delete" var="deleteUrl"/>
            <spring:url value="${path}/admin/users/${user.userID}/lockorunlock" var="lockOrUnlockUrl"/>


            <div class="row" id="user${user.userID}">
                <div class="user-inf col-sm-2">${user.firstname}</div>
                <div class="user-inf col-sm-2">${user.surname}</div>
                <div class="user-inf col-sm-2">${user.patronymic}</div>
                <div class="user-inf col-sm-2">${user.passportNumber}</div>
                <div class="user-inf col-sm-2">${user.login}</div>
                <div class="user-inf col-sm-2">
                    <div class="row">
                        <button class="btn btn-info col-sm-4 button-actions-text"
                                onclick="location.href='${accountsUrl}'"><img
                                src="<c:url value="../../../resources/images/button/accounts.png"/>"
                                title="${accountsButton}"></button>
                        <c:choose>
                            <c:when test="${user.unlocked}">
                                <button class="btn btn-success col-sm-4 button-actions-text"
                                        userID="${user.userID}"
                                        unlock="${user.unlocked}"
                                        onclick="lockOrUnlockViaAjax(this);"><img id="unlockimg"
                                        src="<c:url value="../../../resources/images/button/unlock.png"/>"
                                        title="<spring:message code="action.button.lockorunlock"/>">
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-warning col-sm-4 button-actions-text"
                                        userID="${user.userID}"
                                        unlock="${user.unlocked}"
                                        onclick="lockOrUnlockViaAjax(this);"><img id="unlockimg"
                                        src="<c:url value="../../../resources/images/button/lock.png"/>"
                                        title="<spring:message code="action.button.lockorunlock"/>">
                                </button>
                            </c:otherwise>
                        </c:choose>

                        <button class="btn btn-danger col-sm-4 button-actions-text" id="delete${user.userID}"
                                userID="${user.userID}"
                                data-toggle="modal" data-target="#delPopup"><img
                                src="<c:url value="../../../resources/images/button/delete.png"/>"
                                title="${deleteButton}"></button>
                    </div>
                </div>
            </div>
        </c:forEach>

        <div>
            <div id="delPopup" class="modal fade" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title delete-text"><spring:message
                                    code="showusers.label.titledelete"/>: ${user.login}</h4>
                        </div>
                        <div class="modal-body">
                            <p><spring:message code="showusers.label.deletingdialog"/></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" id="delUserButton"
                                    data-dismiss="modal">${deleteButton}</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message
                                    code="showusers.buttondialog.cancel"/></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </c:if>


</div>

</body>
</html>
