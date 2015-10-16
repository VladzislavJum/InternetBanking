<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 14.10.2015
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="addUser" commandName="user">

  <table>
    <tr>
      <td><form:label path="firstName">
        <spring:message text="Name" />
      </form:label></td>
      <td><form:input path="First Name" /></td>
    </tr>
    <tr>
      <td><form:label path="surname">
        <spring:message text="Surname" />
      </form:label></td>
      <td><form:input path="lastname" /></td>
    </tr>
    <tr>
      <td><form:label path="secondName">
        <spring:message text="Second Name" />
      </form:label></td>
      <td><form:input path="email" /></td>
    </tr>
    <tr>
      <td><form:label path="passportNumber">
        <spring:message text="Passport Number" />
      </form:label></td>
      <td><form:input path="telephone" /></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit"
         value="<spring:message text="Add"/>" /></td>
    </tr>
  </table>
</form:form>


</body>
</html>
