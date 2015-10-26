<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../../../resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>

</head>
<body>

<nav role="navigation" class="navbar navbar-inverse">
    <div class="navbar-header">
        <b><a href="#" class="navbar-brand"><spring:message code="label.internetbanking"/> </a></b>
    </div>
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="/user/accounts"><spring:message code="navuser.label.bankaccount"/> </a></li>
            <li><a href="#"><spring:message code="navuser.label.payment"/> </a></li>
            <li><a href="#"><spring:message code="navuser.label.moneytransaction"/> </a></li>
            <li><a href="#"><spring:message code="navuser.label.paymenthistory"/> </a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle"><spring:message code="navuser.label.language"/> <b
                        class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="?lang=en"><spring:message code="nav.label.lang_en"/>
                    </a></li>
                    <li><a href="?lang=ru"><spring:message code="nav.label.lang_ru"/>
                    </a></li>
                </ul>
            </li>
            <li><a href="/logout"><spring:message code="nav.label.logout"/> </a></li>
        </ul>
    </div>
</nav>
</body>
</html>
