package de.lubowiecki.firststeps;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/submit")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---- GET ----");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Formulardaten aus dem Request abfragen */
        final String title = request.getParameter("title");
        final String name = request.getParameter("name");
        final String country = request.getParameter("country");
        final String email = request.getParameter("email");
        final String message = request.getParameter("message");

        final PrintWriter output = response.getWriter();
        /*
        response.setContentType("text/html");
        output.println("<!DOCTYPE html>");
        output.println("<html><head></head><body>");
        output.println("<p>title: " + title + "</p>"); // Ausgabe wird mit dem Response an den Browser geschickt
        output.println("<p>name: " + name + "</p>");
        output.println("<p>country: " + country + "</p>");
        output.println("<p>email: " + email + "</p>");
        output.println("<p>message: " + message + "</p>");
        output.println("</body></html>");
        */
        response.setContentType("application/json"); // Typ der Rückgabe für den Browser bestimmen
        response.setCharacterEncoding("UTF-8"); // Zeichenkodierung bestimmen
        output.println("{");
        output.println("\"title\": \"" + title + "\"");
        output.println("\"name\": \"" + name + "\"");
        output.println("\"country\": \"" + country + "\"");
        output.println("\"email\": \"" + email + "\"");
        output.println("\"message\": \"" + message + "\"");
        output.println("}");
    }
}
