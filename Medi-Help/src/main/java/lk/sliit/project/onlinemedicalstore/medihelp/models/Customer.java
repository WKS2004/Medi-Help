package lk.sliit.project.onlinemedicalstore.medihelp.models;

public class Customer extends User {
    public Customer(String username, String firstName, String lastName, String displayName, String password, String email) {
        super(username, firstName, lastName, displayName, password, email, "Customer");
    }

    public Customer(String username, String firstName, String lastName, String displayName, String password, String email, String role) {
        super(username, firstName, lastName, displayName, password, email, role);
    }
}
