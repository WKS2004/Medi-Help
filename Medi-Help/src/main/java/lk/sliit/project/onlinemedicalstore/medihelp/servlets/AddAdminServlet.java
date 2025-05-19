package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Admin;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.services.AdminServices;

import java.io.IOException;

@WebServlet(name = "AddAdmin", value = "/profile/admin/add")
public class AddAdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        if (user != null && user.getRole().equals("Admin")) {
            request.getRequestDispatcher("/admin/addAdmin.jsp").forward(request, response);
        }
        else {
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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String displayName = firstName + " " + lastName;
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");

        boolean newAdminCreated = AdminServices.addAdmin(new Admin(username, firstName, lastName, displayName, password, email, address, phoneNumber));
        if (newAdminCreated) {
            response.sendRedirect(request.getContextPath() + "/profile?addNewAdmin=success");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/profile?error=AdminCouldNotBeAdded");
        }
    }
}