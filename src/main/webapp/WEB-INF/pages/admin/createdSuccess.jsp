<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <link href="<c:url value="../../../resources/css/style.css" />" rel="stylesheet">
    <title><spring:message code="createasuccess.label.success"/></title>
</head>

<body>
<div class="container full-height">
    <jsp:include page="common/navAdmin.jsp"/>
    <div class="head-inf"><spring:message code="createdsuccess.label.created"/></div>
    <br/>
</div>
</body>
</html>
