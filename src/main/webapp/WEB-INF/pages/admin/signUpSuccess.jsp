<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../../resources/css/mystyle.css" />" rel="stylesheet">
    <title></title>
</head>

<body>

<div class="container">
    <jsp:include page="common/navAdmin.jsp"/>
    <h1><spring:message code="signupsuccess.label.created"/></h1><br/>
</div>

</body>
</html>
