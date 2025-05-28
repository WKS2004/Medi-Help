package lk.sliit.project.onlinemedicalstore.medihelp.models;

import java.util.*;

public class Order {
    public String customerName;
    private String contactNo;
    private String email;
    private String address;
    private String paymentMethod;
    private double total;
    public String status;
    public String orderId;
    private List<String> items;
    String date;

    public Order(String orderId, String customerName, String contactNo, String email, String address,
                 String paymentMethod, List<String> items, double total) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.items = items;
        this.total = total;
        this.status = "Pending";
        this.date = new Date().toString();
    }

    @Override
    public String toString() {
        return orderId + "," + customerName + "," + contactNo + "," + email + "," + address + "," +
                paymentMethod + "," + status + "," + total + "," + items.toString().replace(",", ";") + "," + date;
    }

    public static Order fromString(String line) {
        String[] parts = line.split(",");
        List<String> items = Arrays.asList(parts[8].replace("[", "").replace("]", "").split(";"));
        Order order = new Order(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], items,
                Double.parseDouble(parts[7]));
        order.status = parts[6];
        order.date = parts[9];
        return order;
    }
}