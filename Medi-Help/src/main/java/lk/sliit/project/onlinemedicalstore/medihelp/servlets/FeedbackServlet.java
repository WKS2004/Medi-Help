package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Feedback;
import lk.sliit.project.onlinemedicalstore.medihelp.services.FeedbackServices;

import java.io.IOException;

@WebServlet(name = "FeedBack", value = "/feedback")
public class FeedbackServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/reviews-and-feedbacks/feedback.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String comment = request.getParameter("comment");

        Feedback feedback = new Feedback(firstName, lastName, email, phoneNumber, comment);

        boolean updatedStatus = FeedbackServices.addFeedback(feedback);
        response.sendRedirect(request.getContextPath() + "/feedback?feedbackUpdated=" + updatedStatus);
    }
}
