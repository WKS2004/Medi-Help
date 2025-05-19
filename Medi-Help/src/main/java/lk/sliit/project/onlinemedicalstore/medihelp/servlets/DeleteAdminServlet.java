package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.services.AdminServices;

import java.io.IOException;

public class DeleteAdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        if (user != null && user.getRole().equals("Admin")) {
            request.getRequestDispatcher("/admin/deleteAdmin.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");

        String username = request.getParameter("username");

        boolean deleteAdminSuccess = AdminServices.deleteAdmin(username);
        if (deleteAdminSuccess) {
            response.sendRedirect(request.getContextPath() + "/profile?deleteAdmin=true");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/profile?error=AdminCouldNotBeDeleted");
        }

    }
}