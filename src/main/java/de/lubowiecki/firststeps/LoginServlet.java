package de.lubowiecki.firststeps;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private static final UserRepository userRepo = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/tpl/login-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Formulardaten abfragen
        final String user = request.getParameter("user");
        final String password = request.getParameter("password");

        Optional<User> opt = userRepo.checkCredentials(user, password);
        if(opt.isPresent()) { // Anmeldung war ok
            HttpSession session = request.getSession();
            session.setAttribute("signedIn", true);
            session.setAttribute("signedAs", opt.get().getRole());
            getServletContext().getRequestDispatcher("/WEB-INF/tpl/admin.jsp").forward(request, response);
        }
        else { // Anmeldung ist gescheitert
            request.setAttribute("msg", "LOGIN_ERROR");
            getServletContext().getRequestDispatcher("/WEB-INF/tpl/login-form.jsp").forward(request, response);
        }

    }
}
