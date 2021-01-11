<%@ page import="javax.naming.InitialContext" %>
<%@ page import="university.innopolis.stc.javaee.ejb.HelloEjbClient" %><%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 25.12.2020
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>Hello, world!!!</h1>
<br/>
<%
    InitialContext context = new InitialContext();
    HelloEjbClient client = (HelloEjbClient) context.lookup("java:module/HelloEjbClient");
    String helloMessage = client.getHelloMessage();
    out.println(helloMessage);
%>
</body>
</html>
