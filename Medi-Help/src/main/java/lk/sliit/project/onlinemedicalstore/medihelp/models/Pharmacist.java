package lk.sliit.project.onlinemedicalstore.medihelp.models;

public class Pharmacist extends User {
    public Pharmacist(String username, String firstName, String lastName, String displayName, String password, String email) {
        super(username, firstName, lastName, displayName, password, email, "Pharmacist");
    }

    public Pharmacist(String username, String firstName, String lastName, String displayName, String password, String email, String role) {
        super(username, firstName, lastName, displayName, password, email, role);
    }
}

