<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header style="background-image: url('img/${headerImg}')">Header</header>

    <nav id="top-nav">
        <ul>
            <li><a href="main" class="aktiv">Home</a></li>
            <li><a href="main?a=products">Produkte</a></li>
            <li><a href="main?a=services">Services</a></li>
            <li><a href="main?a=team">Team</a></li>
            <li><a href="main?a=contact">Kontakt</a></li>
        </ul>
    </nav>

    <div id="content">
        <main>
            <h1>${headline}</h1>
        </main>

        <aside>
        </aside>
    </div>

    <footer>Footer</footer>
</body>
</html>
