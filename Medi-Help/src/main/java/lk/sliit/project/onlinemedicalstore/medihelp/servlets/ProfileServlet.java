package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;

import java.io.IOException;

@WebServlet(name = "Profile", value = "/profile")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            switch (user.getRole()) {
                case "customer":
                    request.getRequestDispatcher("/user/customerProfile.jsp").forward(request, response);
                    break;
                case "supplier":
                    request.getRequestDispatcher("/user/supplierProfile.jsp").forward(request, response);
                    break;
                case "admin":
                    request.getRequestDispatcher("/user/adminProfile.jsp").forward(request, response);
                    break;
            }
        }
        else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
