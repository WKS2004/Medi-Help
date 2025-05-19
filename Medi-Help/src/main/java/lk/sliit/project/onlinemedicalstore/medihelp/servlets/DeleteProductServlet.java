package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Product;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.services.ProductServices;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteProduct", value = "/products/delete")
public class DeleteProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("loggedUser");

        if ( (loggedUser != null) && (loggedUser.getRole().equals("Admin")) ) {
            request.getRequestDispatcher("/products/deleteProducts.jsp").forward(request, response);
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

        String productName = request.getParameter("productName");

        boolean updatedStatus = ProductServices.removeProduct(productName);

        List<Product> products = ProductServices.getAllProducts();
        session.setAttribute("products", products);

        if (updatedStatus) {
            response.sendRedirect(request.getContextPath() + "/products?updateProduct=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/products?error=ProductCouldNotBeDeleted");
        }
    }
}
