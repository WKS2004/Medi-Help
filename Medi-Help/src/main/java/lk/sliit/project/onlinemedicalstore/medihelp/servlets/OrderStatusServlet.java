package lk.sliit.project.onlinemedicalstore.medihelp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Order;

import java.io.IOException;

@WebServlet("/updateOrderStatus")
public class OrderStatusServlet extends HttpServlet {
    private final OrderQueueProcessor processor = new OrderQueueProcessor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("isAdmin") == null || !(Boolean) session.getAttribute("isAdmin")) {
            res.sendRedirect("login.jsp");
            return;
        }
        req.getRequestDispatcher("/order_status_update.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("isAdmin") == null || !(Boolean) session.getAttribute("isAdmin")) {
            res.sendRedirect("login.jsp");
            return;
        }

        try {
            String orderId = req.getParameter("orderId");
            String newStatus = req.getParameter("status");

            if (orderId == null || newStatus == null) {
                req.setAttribute("error", "Order ID and status are required.");
                req.getRequestDispatcher("/order_status_update.jsp").forward(req, res);
                return;
            }

            Order order = processor.getOrderById(orderId);
            if (order == null) {
                req.setAttribute("error", "Order not found.");
                req.getRequestDispatcher("/order_status_update.jsp").forward(req, res);
                return;
            }

            processor.updateOrderStatus(orderId, newStatus);
            req.setAttribute("message", "Status updated successfully!");
            req.setAttribute("order", order);
        } catch (IOException e) {
            req.setAttribute("error", "Failed to update status: " + e.getMessage());
        }

        req.getRequestDispatcher("/order_status_update.jsp").forward(req, res);
    }
}
