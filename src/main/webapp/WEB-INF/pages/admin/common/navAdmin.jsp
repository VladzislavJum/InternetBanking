<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../../../resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <jsp:include page="../../footer.jsp"/>
</head>
<body>
<header role="navigation" class="navbar navbar-inverse">
    <div class="navbar-header">
        <b class="navbar-brand"><spring:message code="label.internetbanking"/></b>
    </div>
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="/admin/signupform"><spring:message code="navadmin.button.createuser"/> </a></li>
            <li><a href="/admin/createaccountform"><spring:message code="navadmin.button.createaccount"/> </a></li>
            <li><a href="#"><spring:message code="navadmin.button.deleteuser"/> </a></li>
            <li><a href="#"><spring:message code="navadmin.button.deleteaccount"/> </a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
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
            <li><a href="/logout"><spring:message code="nav.button.logout"/> </a></li>
        </ul>
    </div>
</header>
</body>
</html>
