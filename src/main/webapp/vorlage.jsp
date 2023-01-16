<%--
  Created by IntelliJ IDEA.
  User: tlubowiecki
  Date: 16.01.23
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
  <h1>Hallo!</h1>
  <p>Das ist der Name: <%= request.getAttribute("name") %>, <%= request.getAttribute("methode") %></p>
</body>
</html>
