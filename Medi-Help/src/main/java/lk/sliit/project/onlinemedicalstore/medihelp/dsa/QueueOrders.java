package lk.sliit.project.onlinemedicalstore.medihelp.dsa;

import lk.sliit.project.onlinemedicalstore.medihelp.models.Order;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOrders {
    private final Queue<Order> ordersQueue;
    private final int noOfOrders;

    public QueueOrders(Queue<Order> ordersQueue) {
        this.ordersQueue = ordersQueue;
        this.noOfOrders = this.ordersQueue.size();
    }

    public boolean isEmpty() {
        return noOfOrders == 0;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void insertOrder(Order order) {
        ordersQueue.add(order);
    }

    public Order peekOrder() {
        if (isEmpty()) {
            System.out.println("This Queue of Orders is empty! Cannot Peek Order!");
            return null;
        }
        return ordersQueue.peek();
    }

    public Order removeOrder() {
        if (isEmpty()) {
            System.out.println("This Queue of Orders is empty! Cannot Remove Order!");
            return null;
        }
        return ordersQueue.remove();
    }
}
