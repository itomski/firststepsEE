<%-- Derektiven:
 page = einstellungen für dieses Dokument
 include = Einbinden anderer Resourcen
 taglib = Einbindung von Bibliotheken, die die Funktionalität der JSPs erweitern
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp"%>
<body>
    <%@include file="header.jsp"%>
    <%@include file="main-nav.html"%>

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

    <%@include file="foot.html"%>
</body>
</html>
