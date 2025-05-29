package lk.sliit.project.onlinemedicalstore.medihelp.services;

import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.dsa.QueueOrders;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Order;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class OrderQueueProcessor {
    private final QueueOrders orderQueue;
    private final String filePath = AppConfig.getInstance().getBasePath() + "orders.txt";

    public OrderQueueProcessor() {
        this.orderQueue = new QueueOrders();

        try {
            List<Order> existingOrders = getAllOrdersFromFile();
            for (Order order : existingOrders) {
                orderQueue.insertOrder(order);
            }
        } catch (IOException e) {
            System.out.println("Failed to load existing orders: " + e.getMessage());
        }
    }

    public void addOrder(Order order) throws IOException {
        orderQueue.insertOrder(order);
        saveToFile(order);
    }

    private void saveToFile(Order order) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(order.toString());
            writer.newLine();
        }
    }

    private List<Order> getAllOrdersFromFile() throws IOException {
        List<Order> orders = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return orders;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orders.add(Order.fromString(line));
            }
        }
        return orders;
    }

    public List<Order> getAllOrders() {
        return orderQueue.getAllOrders();
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

    public void removeOrder() throws IOException {
        orderQueue.removeOrder();  // Removes from front
        saveAllOrders(orderQueue.getAllOrders());
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