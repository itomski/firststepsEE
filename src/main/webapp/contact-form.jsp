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

            <form action="#" method="get">

                <div class="mb">
                    <input type="radio" name="title" id="title_1" value="frau"><label for="title_1">Frau</label><br>
                    <input type="radio" name="title" id="title_2" value="herr"><label for="title_2">Herr</label><br>
                </div>

                <div class="mb">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name">
                </div>

                <div class="mb">
                    <label for="country">Land</label>
                    <select name="country" id="country">
                        <option value="de">Deutschland</option>
                        <option value="es">Spanien</option>
                        <option value="uk">England</option>
                        <option value="us">USA</option>
                    </select>
                </div>

                <div class="mb">
                    <label for="email">E-Mail</label>
                    <input type="email" name="email" id="email">
                </div>

                <div class="mb">
                    <label for="message">Nachricht</label>
                    <textarea name="message" id="message" rows="5"></textarea>
                </div>
                <button type="submit">Senden</button>

            </form>

        </main>

        <aside>
        </aside>
    </div>

    <footer>Footer</footer>
</body>
</html>
