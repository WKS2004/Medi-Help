package lk.sliit.project.onlinemedicalstore.medihelp.models;

public class Admin extends User {
    public Admin(String username, String firstName, String lastName, String displayName, String password, String email, String address, String phoneNumber) {
        super(username, firstName, lastName, displayName, password, email, address, phoneNumber, "Admin");
    }

    public Admin(String username, String firstName, String lastName, String displayName, String password, String email, String address, String phoneNumber, String role) {
        super(username, firstName, lastName, displayName, password, email, address, phoneNumber, role);
    }
}
