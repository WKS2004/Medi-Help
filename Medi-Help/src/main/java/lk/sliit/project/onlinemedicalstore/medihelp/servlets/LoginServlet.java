package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.services.UserServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Login", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        request.getRequestDispatcher("/user/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        String usernameOrEmail = request.getParameter("usernameOrEmail");
        String password = request.getParameter("password");

        User user = UserServices.loginUser(usernameOrEmail, password);

        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedUser", user);
            response.sendRedirect(request.getContextPath() + "/profile");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/login?error=UserDoesNotExist");
        }
    }
}
