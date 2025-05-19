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

@WebServlet(name = "UpdateProduct", value = "/products/update")
public class UpdateProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("loggedUser");

        if ( (loggedUser != null) && (loggedUser.getRole().equals("Admin")) ) {
            request.getRequestDispatcher("/products/updateProducts.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/products");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = getServletContext().getRealPath("/data/");
        AppConfig.getInstance().setBasePath(basePath);

        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("loggedUser");

        String productName = request.getParameter("productName");
        String productBrand = request.getParameter("productBrand");
        String productDescription = request.getParameter("productDescription");
        String productCategory = request.getParameter("productCategory");
        String productImagePath = request.getParameter("productImagePath");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));

        Product product = new Product(productName, productBrand, productDescription, productCategory, productImagePath, productPrice, productQuantity);

        List<Product> products = ProductServices.getAllProducts();
        session.setAttribute("products", products);

        boolean updatedStatus = ProductServices.updateProduct(productName, product);
        if (updatedStatus) {
            response.sendRedirect(request.getContextPath() + "/products?updateProduct=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/products?error=ProductCouldNotBeUpdated");
        }
    }
}
