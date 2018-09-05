<%--
  Created by IntelliJ IDEA.
  User: TRUNGNGUYENHAU
  Date: 9/5/2018
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>Forgot Password</title>
  </head>
  <body>
      <h1>Update Pasword</h1>
      <img src="<s:url value="/images/logo.jpg"/>" width="200px" height="100px" alt="logo">
      <s:actionerror />
      <s:form action="/forgot" method="post">
        <s:textfield name="email"            key="label.email" size="20" />
        <s:textfield name="confirmpassword"  key="label.confirmpassword" size="20" />
        <s:password  name="password"         key="label.password" size="20" />
        <s:submit method="execute"           key="label.updatepassword" align="center" />
      </s:form>
  </body>
</html>
