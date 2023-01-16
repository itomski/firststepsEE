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
    <form action="hello" method="post">
        <h1>Form</h1>

        <div>
            <label for="firstname">Vorname</label>
            <input type="text" name="firstname" id="firstname">
        </div>

        <div>
            <label for="lastname">Nachname</label>
            <input type="text" name="lastname" id="lastname">
        </div>

        <button type="submit">Senden</button>
    </form>
</body>
</html>