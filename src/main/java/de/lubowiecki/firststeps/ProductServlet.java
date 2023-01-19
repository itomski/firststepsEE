package de.lubowiecki.firststeps;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private List<Product> products;

    @Override
    public void init() throws ServletException {
        super.init();
        products = new ArrayList<>();
        products.add(new Product(1, "Handschuhe", "100% Wolle", 19.99));
        products.add(new Product(2, "Taschenwärmer", "3 Std. Wärmedauer", 12.99));
        products.add(new Product(3, "Mütze", "100% Wolle", 10.99));
        products.add(new Product(4, "Tasse", "Keramik. Blau", 7.99));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        request.setAttribute("title", "Produkte");
        request.setAttribute("headline", "Unsere Produkte");
        request.setAttribute("products", products); // Weitergabe der Liste an die JSP
        // Leitet die Anfrage weiter an die JSP
        context.getRequestDispatcher("/WEB-INF/tpl/vorlage-products.jsp").forward(request, response);
    }
}
