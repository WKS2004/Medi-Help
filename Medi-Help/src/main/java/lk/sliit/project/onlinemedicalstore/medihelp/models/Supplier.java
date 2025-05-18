package lk.sliit.project.onlinemedicalstore.medihelp.models;

public class Supplier extends User {
    public Supplier(String username, String firstName, String lastName, String displayName, String password, String email, String address, String phoneNumber) {
        super(username, firstName, lastName, displayName, password, email, address, phoneNumber, "Pharmacist");
    }

    public Supplier(String username, String firstName, String lastName, String displayName, String password, String email, String address, String phoneNumber, String role) {
        super(username, firstName, lastName, displayName, password, email, address, phoneNumber, role);
    }
}
