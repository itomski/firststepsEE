package de.lubowiecki.firststeps;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + req.getMethod() + " Hallo " + req.getParameter("name") + "</h1>");
        out.println("</body></html>");
        */

        ServletContext context = this.getServletContext();

        // getParameter bekommt name aus dem Formular als key
        User userObj = new User(1, req.getParameter("firstname"), req.getParameter("lastname"));

        // Platzhalter für das Template erzeugen
        req.setAttribute("user", userObj);

        // Vorlage aufrufen
        context.getRequestDispatcher("/vorlage.jsp").forward(req, resp);
    }
}