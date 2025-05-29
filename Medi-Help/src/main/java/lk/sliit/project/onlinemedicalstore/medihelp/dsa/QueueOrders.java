package lk.sliit.project.onlinemedicalstore.medihelp.dsa;

import lk.sliit.project.onlinemedicalstore.medihelp.models.Order;

import java.util.ArrayList;
import java.util.List;

public class QueueOrders {
    private final List<Order> ordersQueue;

    public QueueOrders() {
        this.ordersQueue = new ArrayList<>();
    }

    public boolean isEmpty() {
        return ordersQueue.isEmpty();
    }

    public int getNoOfOrders() {
        return ordersQueue.size();
    }

    public void insertOrder(Order order) {
        ordersQueue.add(order);
    }

    public Order peekOrder() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek order.");
            return null;
        }
        return ordersQueue.getFirst(); // Peek the front of the queue
    }

    public Order removeOrder() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot remove order.");
            return null;
        }
        return ordersQueue.removeFirst(); // Remove from the front
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(ordersQueue); // Return a copy to avoid direct modification
    }

    public void clearAllOrders() {
        ordersQueue.clear();
    }
}
