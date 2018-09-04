<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World Example</title>
</head>
<body>
    <p>Hello <s:property value="name"/></p>
    <p>Your Address <s:property value="address"/></p>
    <p>Your Phone Number <s:property value="phonenumber"/></p>
    <p>Your Status <s:property value="status"/></p>
</body>
</html>