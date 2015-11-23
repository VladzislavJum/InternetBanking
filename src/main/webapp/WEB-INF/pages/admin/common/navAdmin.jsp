<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="navadmin.label.searchuser" var="searchUserLabel"/>
<spring:message code="navadmin.label.searcaccount" var="searchAccountLabel"/>
<spring:url value="/admin/users" var="users"/>
<spring:url value="/admin/createaccountform" var="createaccountform"/>
<spring:url value="/admin/signupform" var="signupform"/>
<spring:url value="/admin/signupform" var="signupform"/>
<spring:url value="/admin/signupform" var="signupform"/>
<spring:url value="/admin/account/search" var="accountSearch"/>
<spring:url value="/admin/users/search" var="userSearch"/>
<spring:url value="/logout" var="logout"/>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
    <jsp:include page="../../footer.jsp"/>
</head>
<body>
<header role="navigation" class="navbar navbar-inverse">
    <div class="navbar-header">
        <b class="navbar-brand"><spring:message code="label.internetbanking"/></b>
    </div>
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="${users}"><spring:message code="navadmin.button.users"/> </a></li>
            <li><a href="${signupform}"><spring:message code="navadmin.button.createuser"/> </a></li>
            <li><a href="${createaccountform}"><spring:message code="navadmin.button.createaccount"/> </a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <form:form class="navbar-form" method="post" action="${accountSearch}"
                           commandName="searchAccountForm">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="searchStr" placeholder="${searchAccountLabel}">
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                </form:form>
            </li>

            <li>
                <form:form class="navbar-form" method="post" action="${userSearch}  "
                           commandName="searchUserForm">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="searchStr" placeholder="${searchUserLabel}">
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                </form:form>
            </li>

            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle"><spring:message code="navuser.button.language"/> <b
                        class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="?lang=en"><spring:message code="nav.button.lang_en"/>
                    </a></li>
                    <li><a href="?lang=ru"><spring:message code="nav.button.lang_ru"/>
                    </a></li>
                </ul>
            </li>
            <li><a href="${logout}"><spring:message code="nav.button.logout"/> </a></li>
        </ul>
    </div>

</header>
</body>
</html>
