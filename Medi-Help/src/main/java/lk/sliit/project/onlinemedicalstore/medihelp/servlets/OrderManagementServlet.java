//package lk.sliit.project.onlinemedicalstore.medihelp.servlets;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import lk.sliit.project.onlinemedicalstore.medihelp.models.Order;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@WebServlet("/orderManagement")
//public class OrderManagementServlet extends HttpServlet {
//     OrderQueueProcessor processor = new OrderQueueProcessor();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        if (session == null || session.getAttribute("isAdmin") == null || !(Boolean) session.getAttribute("isAdmin")) {
//            res.sendRedirect("login.jsp");
//            return;
//        }
//
//        String statusFilter = req.getParameter("status");
//        String customerName = req.getParameter("customerName");
//
//        try {
//            List<Order> orders = processor.getAllOrders();
//            if (statusFilter != null && !statusFilter.equals("All")) {
//                orders = orders.stream()
//                        .filter(order -> order.status.equals(statusFilter))
//                        .collect(Collectors.toList());
//            }
//            if (customerName != null && !customerName.isEmpty()) {
//                orders = orders.stream()
//                        .filter(order -> order.customerName.equalsIgnoreCase(customerName))
//                        .collect(Collectors.toList());
//            }
//            req.setAttribute("orders", orders);
//        } catch (IOException e) {
//            req.setAttribute("error", "Failed to load orders: " + e.getMessage());
//        }
//
//        req.getRequestDispatcher("/order_management_panel.jsp").forward(req, res);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        if (session == null || session.getAttribute("isAdmin") == null || !(Boolean) session.getAttribute("isAdmin")) {
//            res.sendRedirect("login.jsp");
//            return;
//        }
//
//        String action = req.getParameter("action");
//        try {
//            if ("delete".equals(action)) {
//                String orderId = req.getParameter("orderId");
//                if (orderId == null) {
//                    req.setAttribute("error", "Order ID is required.");
//                } else {
//                    processor.deleteOrder(orderId);
//                    req.setAttribute("message", "Order deleted successfully!");
//                }
//            } else if ("deleteCancelled".equals(action)) {
//                processor.deleteCancelledOrders();
//                req.setAttribute("message", "All cancelled orders deleted!");
//            } else {
//                req.setAttribute("error", "Invalid action.");
//            }
//        } catch (IOException e) {
//            req.setAttribute("error", "Failed to perform action: " + e.getMessage());
//        }
//
//        doGet(req, res);
//    }
//}
