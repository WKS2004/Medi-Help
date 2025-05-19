package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Order;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/placeOrder")
public class OrderServlet extends HttpServlet {
    private final OrderQueueProcessor processor = new OrderQueueProcessor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/place_order.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String orderId = "ORD" + System.currentTimeMillis();
        String customerName = req.getParameter("customerName");
        String contactNo = req.getParameter("contactNo");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String paymentMethod = req.getParameter("paymentMethod");
        String[] items = req.getParameterValues("items");
        double total = Double.parseDouble(req.getParameter("total"));

        List<String> itemList = items != null ? Arrays.asList(items) : List.of();
        Order order = new Order(orderId, customerName, contactNo, email, address, paymentMethod, itemList, total);

        try {
            processor.addOrder(order);
            req.setAttribute("message", "Order placed successfully!");
        } catch (IOException e) {
            req.setAttribute("error", "Failed to place order: " + e.getMessage());
        }

        req.getRequestDispatcher("/place_order.jsp").forward(req, res);
    }
}
