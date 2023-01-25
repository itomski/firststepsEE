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

    <div id="content" class="container">
        <div class="row">
            <main class="col-sm-8 py-3">
                <h1>${headline}</h1>

                <%
                    int z = 100;
                    z = 200; // hier kommt Java dazwischen, kann mehrzeilig sein
                %>
                <%! int a = 10; %><%-- hier nur Deklarationen rein --%>
                <%! int x = 10, c = 20; long z = 20L; Object o = new Object(); %>
                <!-- <%= a %> --><%-- Ausgabe --%>
                <%-- Kommentar, wird im HTML-Code nicht angezeigt --%>

                <!-- <p class="">Das ist das <span class="">Haus</span> von Nikigraus</p> -->

                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Beschreibung</th>
                            <th>Preis</th>
                            <c:if test="${signedAs eq 'ADMIN'}">
                                <th>&nbsp;</th>
                            </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${products}" var="p">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.name}</td>
                                <td>${p.description}</td>
                                <td>${p.price}</td>
                                <c:if test="${signedAs eq 'ADMIN'}">
                                    <td>
                                        <a href="products?a=edit&id=${p.id}" class="btn btn-warning" title="Bearbeiten"> <!-- a = Anchor, Link -->
                                            <span class="bi bi-pencil-square"></span> <!-- span = Inline-Tag ohne eigene Bedeutung -->
                                        </a>
                                        <a href="products?a=delete&id=${p.id}" class="btn btn-danger" title="Löschen">
                                            <span class="bi bi-trash3"></span>
                                        </a>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </main>

            <aside class="col-sm-4 py-3">
                <h2>Neues Produkt</h2>
                <form action="products" method="post">

                    <input type="hidden" name="id" value="${product.id}">

                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" name="name" id="name" class="form-control" value="${product.name}">
                    </div>

                    <div class="mb-3">
                        <label for="description" class="form-label">Beschreibung</label>
                        <textarea name="description" id="description" rows="5" class="form-control">${product.description}</textarea>
                    </div>

                    <div class="mb-3">
                        <label for="price" class="form-label">Preis</label>
                        <input type="text" name="price" id="price" class="form-control" value="${product.price}">
                    </div>

                    <button type="submit" class="btn btn-success">Speichern</button>
                </form>
            </aside>
        </div>
    </div>

    <%@include file="foot.html"%>
</body>
</html>
