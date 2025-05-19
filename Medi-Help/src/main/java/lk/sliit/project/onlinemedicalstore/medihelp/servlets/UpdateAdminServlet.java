package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Admin;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.services.AdminServices;

import java.io.IOException;

public class UpdateAdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        if (user != null && user.getRole().equals("Admin")) {
            request.getRequestDispatcher("/admin/updateAdmin.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("loggedUser");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String displayName = firstName + " " + lastName;
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");

        User updateAdmin = new Admin(loggedUser.getUsername(), firstName, lastName, displayName, loggedUser.getEmail(), password, address, phoneNumber);

        boolean updateAdminSuccess = AdminServices.updateAdmin(loggedUser.getUsername(), updateAdmin);
        if (updateAdminSuccess) {
            response.sendRedirect(request.getContextPath() + "/profile?updateAdmin=True");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/profile?error=AdminCouldNotBeUpdated");
        }
    }
}