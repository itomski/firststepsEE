<%-- Derektiven:
 page = einstellungen für dieses Dokument
 include = Einbinden anderer Resourcen
 taglib = Einbindung von Bibliotheken, die die Funktionalität der JSPs erweitern
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li><a href="products">Produkte</a></li>
            <li><a href="main?a=services">Services</a></li>
            <li><a href="main?a=team">Team</a></li>
            <li><a href="main?a=contact">Kontakt</a></li>
        </ul>
    </nav>

    <div class="container">
        <div class="row">
            <main class="col-8">
                <h1>${headline}</h1>

                <%
                    int z = 100;
                    z = 200; // hier kommt Java dazwischen, kann mehrzeilig sein
                %>
                <%! int a = 10; %><%-- hier nur Deklarationen rein --%>
                <%! int x = 10, c = 20; long z = 20L; Object o = new Object(); %>
                <%= a %><%-- Ausgabe --%>
                <%-- Kommentar, wird im HTML-Code nicht angezeigt --%>

                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Beschreibung</th>
                            <th>Preis</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${products}" var="p">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.name}</td>
                                <td>${p.description}</td>
                                <td>${p.price}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </main>

            <aside class="col-4">
            </aside>
        </div>
    </div>

    <footer>Footer</footer>

    <script src="webjars/bootstrap/5.2.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
