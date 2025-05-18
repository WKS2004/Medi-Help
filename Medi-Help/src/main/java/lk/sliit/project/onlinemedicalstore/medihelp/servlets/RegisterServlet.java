package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Customer;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Supplier;
import lk.sliit.project.onlinemedicalstore.medihelp.services.UserServices;

import java.io.IOException;

@WebServlet(name = "Register", value = "/register")
public class RegisterServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        String action = request.getParameter("action");

        HttpSession session = request.getSession(true);

        if ("register".equalsIgnoreCase(action)) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            session.setAttribute("email", email);
            session.setAttribute("password", password);

            if (session.getAttribute("email") == null || session.getAttribute("password") == null) {
                response.sendRedirect(request.getContextPath() + "register?error=sessionExpired");
                return;
            }

            request.getRequestDispatcher("/user/registerMoreDetails.jsp").forward(request, response);
        } else if ("registerMore".equalsIgnoreCase(action)) {
            String username = request.getParameter("username");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String displayName = firstName + " " + lastName;
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String role = request.getParameter("role");

            boolean success;
            if ("customer".equals(role)) {
                success = UserServices.registerUser(new Customer(username, firstName, lastName, displayName, (String) session.getAttribute("password"), (String) session.getAttribute("email"), address, phoneNumber));
            } else {
                success = UserServices.registerUser(new Supplier(username, firstName, lastName, displayName, (String) session.getAttribute("password"), (String) session.getAttribute("email"), address, phoneNumber));
            }
            response.sendRedirect(success ? request.getContextPath() + "/login?registrationSuccess=true" : request.getContextPath() + "/register?error=UserExists");
        }
    }
}
