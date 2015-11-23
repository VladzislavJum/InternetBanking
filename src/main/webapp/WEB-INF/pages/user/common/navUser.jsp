<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="${pageContext.servletContext.contextPath}" var="path"/>

<html>
<head>
    <link href="<c:url value="../../../../resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="../../../../resources/js/jquery.min.js"/>"></script>
    <script src="<c:url value="../../../../resources/bootstrap/js/bootstrap.js"/>"></script>
    <jsp:include page="../../footer.jsp"/>
</head>
<body>
<nav role="navigation" class="navbar navbar-inverse">
    <div class="navbar-header">
        <b class="navbar-brand"><spring:message code="label.internetbanking"/></b>
    </div>
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="${path}/user/accounts"><spring:message code="navuser.button.bankaccount"/> </a></li>
            <li><a href="${path}/user/payment"><spring:message code="navuser.button.payment"/> </a></li>
            <li><a href="${path}/user/transaction"><spring:message code="navuser.button.moneytransaction"/> </a></li>
            <li><a href="${path}/user/history"><spring:message code="navuser.button.paymenthistory"/> </a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle"><spring:message code="navuser.button.language"/> <b
                        class="caret"></b></a>
                <ul class="dropdown-menu nav-lang-menu">
                    <li><a href="${path}?lang=en"><spring:message code="nav.button.lang_en"/>
                    </a></li>
                    <li><a href="${path}?lang=ru"><spring:message code="nav.button.lang_ru"/>
                    </a></li>
                </ul>
            </li>
            <li><a href="${path}/logout"><spring:message code="nav.button.logout"/> </a></li>
        </ul>
    </div>
</nav>
</body>
</html>
