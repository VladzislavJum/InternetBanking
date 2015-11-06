<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:message code="authorization.label.login" var="login"/>
<spring:message code="authorization.label.password" var="password"/>
<spring:message code="authorization.button.signin" var="signin"/>
<spring:message code="login.button.language.en" var="en"/>
<spring:message code="login.button.language.ru" var="ru"/>
<spring:url value="${pageContext.servletContext.contextPath}" var="path"/>

<html>
<head>
    <title><spring:message code="login.label.auth"/></title>
    <link href="<c:url value="../../resources/css/login.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <jsp:include page="footer.jsp"/>

</head>
<body>
<button class="btn btn-success"
        onclick="location.href=('${path}?lang=en')">${en}</button>
<button class="btn btn-primary"
        onclick="location.href=('${path}?lang=ru')">${ru}</button>

<div class="container full-height">
    <div class="col-md-4 col-md-offset-4 margin-top10">
        <c:url value="${path}/j_spring_security_check" var="loginUrl"/>
        <h4 class="error-login"> ${message}</h4>

        <form:form method="post" action="${loginUrl}">
            <input type="text" class="form-control" name="login" placeholder="${login}"/>

            <input type="password" name="password" class="form-control margin-top5"
                   placeholder="${password}"/>

            <div class="checkbox">
                <label style="color: white"><input type="checkbox" name="remember-me"><spring:message
                        code="authorization.label.remember"/></label>
            </div>

            <button class="btn btn-default btn-primary btn-block margin-top5" type="submit"
                    value="submit">${signin}
            </button>
        </form:form>
    </div>
</div>
</body>
