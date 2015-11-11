<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="payment.label.payservices"/></title>
    <link href="<c:url value="../../../resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="container full-height">
    <jsp:include page="common/navUser.jsp"/>

    <div class="row">
        <button class="btn btn-success col-sm-4 button-actions-text onclick=" location.href=('${deleteUrl}')"
                style="height: 100px">dsfdff</button>
        <button class="btn btn-success col-sm-4 button-actions-text onclick=" location.href=('${deleteUrl}')"
                style="height: 100px">${deleteButton}</button>
        <button class="btn btn-success col-sm-4 button-actions-text onclick=" location.href=('${deleteUrl}')"
                style="height: 100px">${deleteButton}</button>


    </div>

</div>
</body>
</html>
