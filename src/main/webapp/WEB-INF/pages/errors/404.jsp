<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title><spring:message code="error.label.404"/></title>
</head>
<body>
<div class="container full-height-border">
    <jsp:include page="common/navError.jsp"/>
    <div class="row head-color-green">
        <h1 class="head-inf"><spring:message code="label.error.404"/></h1>
    </div>
</div>
</body>
<jsp:include page="../footer.jsp"/>
</html>
