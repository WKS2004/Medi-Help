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

@WebServlet(name = "DeleteAccount", value = "/profile/delete")
public class DeleteProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        if (user != null) {
            switch (user.getRole()) {
                case "customer":
                    request.getRequestDispatcher("/user/deleteCustomerProfile.jsp").forward(request, response);
                    break;
                case "supplier":
                    request.getRequestDispatcher("/user/deleteSupplierProfile.jsp").forward(request, response);
                    break;
                case "admin":
                    request.getRequestDispatcher("/user/deleteAdminProfile.jsp").forward(request, response);
                    break;
            }
        }
        else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User loggedUser = (User)(session.getAttribute("loggedUser"));
        boolean deletedStatus = UserServices.deleteUser(loggedUser.getUsername());
        if (deletedStatus) {
            session.removeAttribute("loggedUser");
        }
        response.sendRedirect(deletedStatus ? request.getContextPath() + "/" : request.getContextPath() + "/profile?error=ProfileNotDeleted");
    }
}
