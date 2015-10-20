<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page session="true" %>
<html>
<head>
    <title>Login Page</title>
    <link href="<c:url value="../../resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
    <%--<link href="<c:url value="../../resources/bootstrap/css/signin.css" />" rel="stylesheet">--%>
</head>
<body>

<div class="container" style="width: 300px; margin-top: 10%">

    <c:url value="/j_spring_security_check" var="loginUrl"/>

    <form method="post" action="${loginUrl}">
        <input type="text" name="login" class="form-control" placeholder=
        <spring:message code="label.login"/> required>

        <input type="password" name="password" style="margin-top: 5%" class="form-control" placeholder=
        <spring:message code="label.password"/> required>

        <label class="checkbox">
            <input type="checkbox" name="_spring_security_remember_me" value="remember-me"> Remember me
        </label>

        <button class="btn btn-default btn-primary btn-block" style="margin-top: 5%" type="submit">
            <spring:message code="label.signin"/>
        </button>
    </form>
</div>

<%--

<div class="container">

    <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="input-block-level" placeholder="Email address">
        <input type="password" class="input-block-level" placeholder="Password">
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->
--%>


</body>
</html>