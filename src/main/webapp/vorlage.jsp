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

    <div class="container">
        <div class="row">
            <main class="col-8">
                <h1 id="head1">${headline}</h1>
            </main>

            <aside class="col-4" id="box1">
            </aside>
        </div>
    </div>

    <footer>Footer</footer>

    <script src="webjars/bootstrap/5.2.3/js/bootstrap.bundle.min.js"></script>

    <script>
        let url = "http://localhost:8080/firststeps_war_exploded/submit"

        document.getElementById("head1").addEventListener('click', () => {
            fetch(url) // Fragt asynchron Daten vom Server ab. asynchron = ohne die Seite neu zu laden
                .then(res => res.json()) // Das was der Server liefert wird als JSON eingelesen
                .then(out => { // das empfangene JSON wird verarbeitet
                    document.getElementById("box1").innerText = out[0].name; // Name des ersten Objektes im out-Array wird in die box1 ausgegeben
                })
                .catch(error => console.log(error)); // Wird aufgerufen, wenn etwas schief läuft
        });
    </script>

</body>
</html>
