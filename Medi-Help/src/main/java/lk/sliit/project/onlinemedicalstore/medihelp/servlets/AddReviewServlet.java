package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Product;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Review;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.services.ProductServices;
import lk.sliit.project.onlinemedicalstore.medihelp.services.ReviewServices;

import java.io.IOException;

@WebServlet(name = "AddProductReview", value = "/product/review/add")
public class AddReviewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("loggedUser");

        String productName = request.getParameter("productName");
        Product product = ProductServices.getProductByProductName(productName);

        session.setAttribute("product", product);

        if (loggedUser != null) {
            request.getRequestDispatcher("/products/addReview.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/products");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("loggedUser");
        Product product = (Product) session.getAttribute("product");

        String comment = request.getParameter("comment");

        Review review = new Review(loggedUser, product, comment);

        boolean updatedStatus = ReviewServices.addReview(review);
        if (updatedStatus) {
            response.sendRedirect(request.getContextPath() + "/products/?addReview=true");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/products/?error=ReviewCouldNotBeAdded");
        }
    }
}
