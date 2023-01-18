<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css">
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

            <form action="submit" method="post">

                <div class="mb-3">
                    <div class="form-check">
                        <input type="radio" name="title" id="title_1" value="w" class="form-check-input">
                        <label for="title_1" class="form-check-label">Frau</label>
                    </div>
                    <div class="form-check">
                        <input type="radio" name="title" id="title_2" value="m" class="form-check-input">
                        <label for="title_2" class="form-check-label">Herr</label>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" name="name" id="name" class="form-control">
                </div>

                <div class="mb-3">
                    <label for="country" class="form-label">Land</label>
                    <select name="country" id="country" class="form-select">
                        <option value="de">Deutschland</option>
                        <option value="es">Spanien</option>
                        <option value="uk">England</option>
                        <option value="us">USA</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">E-Mail</label>
                    <input type="email" name="email" id="email" class="form-control">
                </div>

                <div class="mb">
                    <label for="message" class="form-label">Nachricht</label>
                    <textarea name="message" id="message" rows="5" class="form-control"></textarea>
                </div>
                <button type="submit" class="btn btn-success">Senden</button>

            </form>

        </main>

        <aside>
        </aside>
    </div>

    <footer>Footer</footer>

    <script src="webjars/bootstrap/5.2.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
