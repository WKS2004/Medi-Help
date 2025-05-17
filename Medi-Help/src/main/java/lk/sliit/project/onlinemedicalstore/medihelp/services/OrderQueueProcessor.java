package lk.sliit.project.onlinemedicalstore.medihelp.services;

import lk.sliit.project.onlinemedicalstore.medihelp.models.Order;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class OrderQueueProcessor {
    private final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private final String filePath = "orders.txt";

    public void addOrder(Order order) throws IOException {
        orderQueue.offer(order);
        saveToFile(order);
    }

    private void saveToFile(Order order) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(order.toString());
            writer.newLine();
        }
    }

    public List<Order> getAllOrders() throws IOException {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orders.add(Order.fromString(line));
            }
        }
        return orders;
    }

    public List<Order> getOrdersByCustomer(String customerName) throws IOException {
        return getAllOrders().stream()
                .filter(order -> order.customerName.equalsIgnoreCase(customerName))
                .collect(Collectors.toList());
    }

    public Order getOrderById(String orderId) throws IOException {
        return getAllOrders().stream()
                .filter(order -> order.orderId.equals(orderId))
                .findFirst()
                .orElse(null);
    }

    public void updateOrderStatus(String orderId, String newStatus) throws IOException {
        List<Order> orders = getAllOrders();
        for (Order order : orders) {
            if (order.orderId.equals(orderId)) {
                order.status = newStatus;
            }
        }
        saveAllOrders(orders);
    }

    public void deleteOrder(String orderId) throws IOException {
        List<Order> orders = getAllOrders();
        orders.removeIf(order -> order.orderId.equals(orderId));
        saveAllOrders(orders);
    }

    public void deleteCancelledOrders() throws IOException {
        List<Order> orders = getAllOrders();
        orders.removeIf(order -> order.status.equals("Cancelled"));
        saveAllOrders(orders);
    }

    private void saveAllOrders(List<Order> orders) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Order order : orders) {
                writer.write(order.toString());
                writer.newLine();
            }
        }
    }
}