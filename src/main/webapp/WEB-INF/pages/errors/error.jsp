<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<spring:message code="label.error.url"/><br/>${url}
<br/>
<spring:message code="label.error.type"/><br/>${trace}
<!--
<c:forEach items="${trace.stackTrace}" var="tracemsg"> ${tracemsg}
</c:forEach>
-->
</body>
</html>
