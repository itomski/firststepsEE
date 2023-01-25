package de.lubowiecki.firststeps;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/scopes")
public class ScopeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Application Scope
        // Gehört allen Usern zusammen
        // Beginnt mit dem Start der Anwendung auf dem Server
        // Endet mit dem Stop der Anwendung auf dem Server
        ServletContext application = getServletContext();
        if(application.getAttribute("appCounter") == null) {
            application.setAttribute("appCounter", 0);
        }
        int i = ((Integer) application.getAttribute("appCounter")); // Object in int umwandeln
        application.setAttribute("appCounter", ++i); // Um 1 hochzählen

        // Session Scope
        // Gehört nur einem bestimmten User
        // Variablen in diesem Scope sind verfügbar, solange die Session (Zusammenhängender Besuch) andauert
        // User sendet mit seinen Requests einen Session-Cookie und solange die Session-ID gleich ist, wird die Session fortgesetzt
        // Endet wenn der Cookie gelöscht wird, der Server die Session löscht oder die Lebensdauer der Session abgelaufen ist
        HttpSession session = request.getSession();
        if(session.getAttribute("sessCounter") == null) {
            session.setAttribute("sessCounter", 0);
        }
        i = ((Integer) session.getAttribute("sessCounter"));
        session.setAttribute("sessCounter", ++i);

        // Request Scope:
        // Variablen in diesem Scope sind nur während des gleichen Requests verfügbar
        // Startet mir dem Request und endet mit dem Respons an den Browser
        if(request.getAttribute("reqCounter") == null) {
            request.setAttribute("reqCounter", 0);
        }
        i = ((Integer) request.getAttribute("reqCounter"));
        request.setAttribute("reqCounter", ++i);

        getServletContext().getRequestDispatcher("/WEB-INF/tpl/scopes.jsp").forward(request, response);
    }
}
