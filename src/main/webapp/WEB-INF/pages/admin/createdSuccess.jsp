<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="createaccount.label.userlogin" var="userLoginLabel"/>
<spring:message code="createaccount.label.accountnumber" var="accountNumberLabel"/>
<spring:message code="createaccount.label.amountofmoney" var="amountOfMoneyLabel"/>


<html>
<head>
    <meta charset="UTF-8"/>
    <link href="<c:url value="../../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <title></title>
</head>

<body>

<div class="container">
    <jsp:include page="common/navAdmin.jsp"/>

    <h1><spring:message code="createdsuccess.label.created"/> </h1><br/>
    ${userLoginLabel}: ${userLogin}<br/>
    ${accountNumberLabel}: ${accountNumber}<br/>
    ${amountOfMoneyLabel}: ${amountOfMoney}<br/>

</div>

</body>
</html>
