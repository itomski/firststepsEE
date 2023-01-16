<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP - Hello World</title>
</head>
<body>
    <form action="hello" method="get">
        <h1>Form</h1>

        <div>
            <label for="name">Name</label>
            <input type="text" name="name" id="name">
        </div>

        <button type="submit">Senden</button>
    </form>
</body>
</html>