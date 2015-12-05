<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="navadmin.label.searchuser" var="searchUserLabel"/>
<spring:message code="navadmin.label.searcaccount" var="searchAccountLabel"/>
<spring:url value="/admin/users" var="users"/>
<spring:url value="/admin/createaccountform" var="createaccountform"/>
<spring:url value="/admin/signupform" var="signupform"/>
<spring:url value="/admin/account/" var="accountSearchUrl"/>
<spring:url value="/admin/account/searchAcc" var="searchAccUrlAjax"/>
<spring:url value="/admin/user/" var="userSearchUrl"/>
<spring:url value="/admin/users/searchUsers" var="searchUserUrlAjax"/>
<spring:url value="/logout" var="logout"/>
<spring:message code="locale.label.lang" var="lang"/>
<spring:url value="/" var="firstUrl"/>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/select2/js/select2.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
    <script src="<c:url value="/resources/select2/js/i18n/${lang}.js"/>"></script>
    <script src="<c:url value="/resources/js/navAdminAjax.js"/>"></script>
</head>
<body>
<div class="container" style="border: 1px solid #ffffff; border-bottom: none; border-top: none;">
    <header role="navigation" class="navbar navbar-inverse">
        <div class="navbar-header">
            <a class="navbar-brand" href="${firstUrl}"><spring:message code="label.internetbanking"/></a>
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
                    <div class="navbar-form" method="post" role="search">
                        <select multiple id="selectAccID" data-placeholder="${searchAccountLabel}" class="form-control"
                                onchange="window.location.href='${accountSearchUrl}'+this.value;"
                                url="${searchAccUrlAjax}">
                        </select>
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                </li>
                <li>
                    <div class="navbar-form" method="post" role="search">
                        <select multiple id="selectUserID" data-placeholder="${searchUserLabel}" class="form-control"
                                onchange="window.location.href='${userSearchUrl}'+this.value;"
                                url="${searchUserUrlAjax}">
                        </select>
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                </li>

                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle"><spring:message code="navuser.button.language"/>
                        <b
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
</div>
</body>
</html>
