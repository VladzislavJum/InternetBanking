<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><spring:message code="error.label.error"/></title>
    <jsp:include page="common/navError.jsp"/>
</head>
<body>
<div class="container full-height-border">
    <div class="row head-color-green">
        <h1 class="head-inf"><spring:message code="label.error.error"/><br/></h1>
    </div>
<!--
<c:forEach items="${trace.stackTrace}" var="tracemsg"> ${tracemsg}</c:forEach>
-->
</div>
</body>
<jsp:include page="../footer.jsp"/>
</html>
