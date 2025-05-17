package lk.sliit.project.onlinemedicalstore.medihelp.models;

public class User {
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String displayName;
    protected String password;
    protected String email;
    protected String role;

    public User(String username, String firstName, String lastName, String displayName, String password, String email, String role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return (username + "||" + firstName + "||" + lastName + "||" + displayName + "||" + password + "||" + email + "||" + role);
    }


    public static User toUserFromText(String data) {
        String[] parts = data.split("\\|\\|");
        if (parts.length < 7) {
            throw new IllegalArgumentException("Corrupted user record: " + data);
        }
        return new User(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }
}