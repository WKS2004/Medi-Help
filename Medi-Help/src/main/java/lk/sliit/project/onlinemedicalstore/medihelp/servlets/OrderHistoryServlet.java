package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Order;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {
    private final OrderQueueProcessor processor = new OrderQueueProcessor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String customerName = req.getParameter("customerName"); // Assume logged-in user
        String statusFilter = req.getParameter("status");

        try {
            List<Order> orders = processor.getOrdersByCustomer(customerName);
            if (statusFilter != null && !statusFilter.equals("All")) {
                orders = orders.stream()
                        .filter(order -> order.status.equals(statusFilter))
                        .collect(Collectors.toList());
            }
            req.setAttribute("orders", orders);
        } catch (IOException e) {
            req.setAttribute("error", "Failed to load order history: " + e.getMessage());
        }

        req.getRequestDispatcher("/order_history.jsp").forward(req, res);
    }
}