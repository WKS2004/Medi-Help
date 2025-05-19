package lk.sliit.project.onlinemedicalstore.medihelp.models;

public class Customer extends User {
    public Customer(String username, String firstName, String lastName, String displayName, String password, String email, String address, String phoneNumber) {
        super(username, firstName, lastName, displayName, password, email, address, phoneNumber, "Customer");
    }

    public Customer(String username, String firstName, String lastName, String displayName, String password, String email, String address, String phoneNumber, String role) {
        super(username, firstName, lastName, displayName, password, email, address, phoneNumber, role);
    }
}
