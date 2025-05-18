package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.services.UserServices;

import java.io.IOException;

@WebServlet(name = "UpdateProfile", value = "/profile/update")
public class UpdateProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        if (user != null) {
            switch (user.getRole()) {
                case "customer":
                    request.getRequestDispatcher("/user/customerProfileUpdate.jsp").forward(request, response);
                    break;
                case "supplier":
                    request.getRequestDispatcher("/user/supplierProfileUpdate.jsp").forward(request, response);
                    break;
                case "admin":
                    request.getRequestDispatcher("/user/adminProfileUpdate.jsp").forward(request, response);
                    break;
            }
        }
        else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String updateAction = request.getParameter("updateAction");
        User loggedUser = (User)(session.getAttribute("loggedUser"));

        if ("updateFirstName".equals(updateAction)) {
            String firstName = request.getParameter("firstName");

            loggedUser.setFirstName(firstName);

            boolean updatedFirstNameStatus = UserServices.updateUser(loggedUser.getUsername(), loggedUser);
            session.setAttribute("loggedUser", loggedUser);
            response.sendRedirect(updatedFirstNameStatus ? (request.getContextPath() + "/profile?success=FirstNameUpdated") : (request.getContextPath() + "/profile?error=FirstNameNotUpdated"));
        }
        else if ("updateLastName".equals(updateAction)) {
            String lastName = request.getParameter("lastName");

            loggedUser.setLastName(lastName);

            boolean updatedLastNameStatus = UserServices.updateUser(loggedUser.getUsername(), loggedUser);
            response.sendRedirect(updatedLastNameStatus ? (request.getContextPath() + "/profile?success=LastNameUpdated") : (request.getContextPath() + "/profile?error=LastNameNotUpdated"));
        }
        else if ("updateDisplayName".equals(updateAction)) {
            String newDisplayName = request.getParameter("newDisplayName");

            loggedUser.setDisplayName(newDisplayName);

            boolean updatedDisplayNameStatus = UserServices.updateUser(loggedUser.getUsername(), loggedUser);
            session.setAttribute("loggedUser", loggedUser);
            response.sendRedirect(updatedDisplayNameStatus ? (request.getContextPath() + "/profile?success=DisplayNameUpdated") : (request.getContextPath() + "/profile?error=DisplayNameNotUpdated"));
        }
        else if ("updatePassword".equals(updateAction)) {
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");

            if (oldPassword.equals(loggedUser.getPassword())) {
                if (newPassword.equals(confirmPassword)) {
                    loggedUser.setPassword(newPassword);
                }
            }

            boolean updatedPasswordStatus = UserServices.updateUser(loggedUser.getUsername(), loggedUser);
            session.setAttribute("loggedUser", loggedUser);
            response.sendRedirect(updatedPasswordStatus ? (request.getContextPath() + "/profile?success=PasswordUpdated") : (request.getContextPath() + "/profile?error=PasswordNotUpdated"));
        }
        else if ("updateAddress".equals(updateAction)) {
            String address = request.getParameter("address");

            loggedUser.setAddress(address);

            boolean updatedAddressStatus = UserServices.updateUser(loggedUser.getUsername(), loggedUser);
            session.setAttribute("loggedUser", loggedUser);
            response.sendRedirect(updatedAddressStatus ? (request.getContextPath() + "/profile?success=AddressUpdated") : (request.getContextPath() + "/profile?error=AddressNotUpdated"));
        }
        else if ("updatePhoneNumber".equals(updateAction)) {
            String phoneNumber = request.getParameter("phoneNumber");

            loggedUser.setPhoneNumber(phoneNumber);

            boolean updatedPhoneNumberStatus = UserServices.updateUser(loggedUser.getUsername(), loggedUser);
            session.setAttribute("loggedUser", loggedUser);
            response.sendRedirect(updatedPhoneNumberStatus ? (request.getContextPath() + "/profile?success=PhoneNumberUpdated") : (request.getContextPath() + "/profile?error=PhoneNumberNotUpdated"));
        }
    }
}
