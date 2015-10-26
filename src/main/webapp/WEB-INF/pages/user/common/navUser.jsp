<%@ page import="java.util.ResourceBundle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="../../../resources/bootstrap/js/bootstrap.js"  type="text/javascript"></script>

</head>
<body>

<%
  ResourceBundle resource = ResourceBundle.getBundle("language");

  String english=resource.getString("lang_en");
  String russian=resource.getString("lang_ru");

%>



<div class="container">
  <nav role="navigation" class="navbar navbar-default">
    <div class="navbar-header">
      <a href="#" class="navbar-brand">Brand</a>
    </div>
    <div id="navbarCollapse" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#"><spring:message code="navuser.label.bankaccount"/> </a></li>
        <li><a href="#"><spring:message code="navuser.label.payment"/> </a></li>
        <li><a href="/welcome"><spring:message code="navuser.label.moneytransaction"/> </a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a data-toggle="dropdown" class="dropdown-toggle"><spring:message code="navuser.label.language"/> <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="?lang=en"><%=english%></a></li>
            <li><a href="?lang=ru"><%=russian%></a></li>
          </ul>
        </li>
        <li><a href="/logout"><spring:message code="navuser.label.logout"/> </a></li>
      </ul>
    </div>

  </nav>
</div>
</body>
</html>
