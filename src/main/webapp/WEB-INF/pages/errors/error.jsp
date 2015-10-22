<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<spring:message code="error.url"/><br/>${url}
<br/>
<spring:message code="error.type"/><br/>${trace}

</body>
</html>
