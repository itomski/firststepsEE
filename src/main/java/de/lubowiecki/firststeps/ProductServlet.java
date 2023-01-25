package de.lubowiecki.firststeps;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private final ProductRepository repository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        String action = request.getParameter("a"); // gewählte Aktion abfragen

        HttpSession session = request.getSession();

        try {
            if(session.getAttribute("signedAs") != null && session.getAttribute("signedAs").equals("ADMIN")) {
                if (action != null && action.equals("delete")) {
                    int id = Integer.parseInt(request.getParameter("id")); // ID für das Löschen abfragen
                    repository.delete(id); // Löschen
                    response.sendRedirect("products"); // Nach dem Löschen auf die Übersicht umleiten
                    return; // Methode beenden
                } else if (action != null && action.equals("edit")) {
                    int id = Integer.parseInt(request.getParameter("id")); // ID für das Löschen abfragen
                    request.setAttribute("product", repository.find(id).get()); // Ausgewähltes Objekt in dem Formular anzeigen
                }
            }
            else {
                request.setAttribute("product", new Product()); // Formular mit leeren Obejt füllen
            }

            request.setAttribute("title", "Produkte");
            request.setAttribute("headline", "Unsere Produkte");
            request.setAttribute("products", repository.find()); // Weitergabe der Liste an die JSP
        }
        catch(Exception e) {
            // Beim Fehler währen der DB-Abfrage kann man hier ne Meldung oder Default-Daten liefern
            log("Fehler bei DB-Anfrage", e);
            request.setAttribute("products", new ArrayList<>());
        }
        // Leitet die Anfrage weiter an die JSP
        context.getRequestDispatcher("/WEB-INF/tpl/vorlage-products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Eingabe MUSS validiert werden
        Product product = new Product();
        try {
            product.setId(Integer.parseInt(request.getParameter("id")));
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setPrice(Double.parseDouble(request.getParameter("price"))); // Gegenmaßnahmen ergreifen

            // hat das Produkt eine id == 0, dann wird ein neuer Datensatz in der DB angelegt
            // Ist die id > 0, dann wird ein vorhandener Datensatz upgedatet
            if(repository.save(product)) {
                // redirect: es wird ein neues Request an die vorgegebene Resource geschickt
                // im Browser wird kann sich die Adresszeile ändern
                response.sendRedirect("products"); // Weiterleiten
            }
        }
        catch(Exception e) {
            log("Problem beim Speichern", e);
            request.setAttribute("product", product);

            // forward: gleiches Request wird an eine zweite Resource weitergegeben
            // im Browser wird die Adresszeile beibehalten
            getServletContext().getRequestDispatcher("/WEB-INF/tpl/vorlage-products.jsp").forward(request, response);
        }
    }
}