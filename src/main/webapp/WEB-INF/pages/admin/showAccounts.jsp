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
<spring:url value="/admin/users/" var="accUrljs"/>
<spring:url value="/admin/users/" var="allAccsUsrl"/>
<spring:url value="/admin/user/" var="userInfUrl"/>


<html>
<head>
    <title><spring:message code="showaccounts.label.show"/></title>
    <jsp:include page="common/navAdmin.jsp"/>
    <script src="<c:url value="/resources/js/clickForAccount.js"/>"></script>
    <script src="<c:url value="/resources/js/accountsAjax.js"/>"></script>

</head>
<body>
<div class="container full-height-border">
    <h4 class="error-search"> ${notExist}</h4>
    <c:if test="${!empty accountList}">
        <c:choose>
            <c:when test="${accountList.size() == 1}">
                <div class="row head-color-green">
                    <h1 class="head-inf"><spring:message code="showaccounts.label.account"/>&nbsp;<a
                            href="${userInfUrl}${user.userID}" style="color: #d58512">${user.login}</a></h1>
                </div>
                <a href="${allAccsUsrl}${user.userID}/accounts"><span class="col-sm-offset-8 user-acc-text">
                    <spring:message code="showaccounts.label.allaccs"/>&nbsp;${user.login}</span></a>
            </c:when>
            <c:otherwise>
                <div class="row head-color-green">
                    <h1 class="head-inf"><spring:message code="showaccounts.label.accounts"/>&nbsp;<a
                            href="${userInfUrl}${user.userID}" style="color: #d58512">${user.login}</a></h1>
                </div>
            </c:otherwise>
        </c:choose>
        <div class="row">
            <div class="col-sm-4 head-users-accounts">${number}</div>
            <div class="col-sm-4 head-users-accounts">${money}</div>
            <div class="col-sm-4 head-users-accounts">${action}</div>
        </div>
        <div id="rowDivForEach">
            <c:forEach items="${accountList}" var="account">
                <div class="row" id="account${account.bankAccountID}">
                    <div class="account-inf col-sm-4">${account.accountNumber}</div>
                    <div class="account-inf col-sm-4">${account.amountOfMoney}</div>
                    <div class="account-inf col-sm-4">
                        <button class="btn btn-success col-sm-3 col-sm-offset-2" id="refill${account.bankAccountID}"
                                data-toggle="modal" data-target="#refPopup" url="${accUrljs}"
                                accID="${account.bankAccountID}" userID="${user.userID}">${refillButton}
                        </button>
                        <a class="col-sm-3">|</a>
                        <button class="btn btn-danger col-sm-3" id="delete${account.bankAccountID}"
                                accID="${account.bankAccountID}" data-toggle="modal"
                                data-target="#target">${deleteButton}</button>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div id="target" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                        </button>
                        <h4 class="modal-title delete-text">
                            <spring:message
                                    code="showusers.label.titledelete"/>?</h4>
                    </div>
                    <div class="modal-body">
                        <p><spring:message code="showusersaccounts.label.deletingdialog"/></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" userID="${user.userID}"
                                id="delAccButton" url="${accUrljs}deleteuseracc"
                                data-dismiss="modal">${deleteButton}</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message
                                code="showusers.buttondialog.cancel"/></button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="refPopup" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-sm" style="width: 400px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                        </button>
                        <h4 class="modal-title"><spring:message code="showusersaccounts.label.titlerefill"/></h4>
                    </div>
                    <div class="modal-body">
                        <spring:url value="/admin/users/${user.userID}/accounts/${accID}/refill" var="refillUrl"/>
                        <form:form id="formID" class="form-horizontal" method="post" action="${refillUrl}"
                                   commandName="refillForm">
                        <div class="text-center"><form:errors path="amountOfMoney" cssClass="error-text"/></div>
                        <div class="col-sm-8 col-sm-offset-2">
                            <input class="form-control" name="amountOfMoney" placeholder="${amountOfMoney}"
                                   id="inputMoney"/>
                        </div>
                        <img style="height: 300px; width: 380px;"
                             src="<c:url value="/resources/images/fallingMoney.jpg"/>">
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary col-sm-7" id="refAccButton"
                                type="submit">${refillButton}</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message
                                code="showusers.buttondialog.cancel"/></button>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
    </c:if>
</div>
</body>
<jsp:include page="../footer.jsp"/>
</html>
