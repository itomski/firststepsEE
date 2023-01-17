package de.lubowiecki.firststeps;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "/main")
public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = this.getServletContext();

        // getParameter bekommt name aus dem Formular als key
        String action  = req.getParameter("a");

        String title = "";
        String headline = "";
        String headerImg = "";
        String template = "vorlage";

        if(action == null)
            action = "leer";

        switch(action) {

            case "products":
                title = "Produkte";
                headline = "Das sind unsere Produkte";
                headerImg = "hamburg1.jpg";
                break;

            case "services":
                title = "Services";
                headline = "Das sind unsere Services";
                headerImg = "hamburg2.webp";
                break;

            case "team":
                title = "Team";
                headline = "Unsere volle Kompetenz";
                headerImg = "hamburg3.webp";
                break;

            case "contact":
                title = "Konktakt";
                headline = "Schreiben Sie uns doch...";
                headerImg = "hamburg4.webp";
                template = "contact-form";
                break;

            default:
                title = "Home";
                headline = "Herzlich Willkommen";
                headerImg = "hamburg1.jpg";
                break;
        }

        // Platzhalter für das Template erzeugen
        req.setAttribute("title", title);
        req.setAttribute("headline", headline);
        req.setAttribute("headerImg", headerImg);

        // Vorlage aufrufen
        context.getRequestDispatcher("/" + template + ".jsp").forward(req, resp);
    }
}