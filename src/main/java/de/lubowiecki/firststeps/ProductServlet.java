package de.lubowiecki.firststeps;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private final ProductRepository repository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        request.setAttribute("title", "Produkte");
        request.setAttribute("headline", "Unsere Produkte");
        try {
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
}
