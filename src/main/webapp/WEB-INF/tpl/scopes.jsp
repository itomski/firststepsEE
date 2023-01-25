<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scopes</title>
</head>
<body>
    <p>Application: ${applicationScope.appCounter} ${appCounter}</p>
    <p>Session: ${sessionScope.sessCounter} ${sessCounter}</p>
    <p>Request: ${requestScope.reqCounter} ${reqCounter}</p>
</body>
</html>
