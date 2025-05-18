package lk.sliit.project.onlinemedicalstore.medihelp.models;

public class Feedback {
    private String feedbackID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String comment;

    public Feedback(String feedbackID, String firstName, String lastName, String email, String phoneNumber, String comment) {
        this.feedbackID = feedbackID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return (feedbackID + "||" + firstName + "||" + lastName + "||" + email + "||" + phoneNumber + "||" + comment);
    }

    public static Feedback toFeedbackFromText(String data) {
        String[] parts = data.split("\\|\\|");
        if (parts.length < 6) {
            throw new IllegalArgumentException("Corrupted user record: " + data);
        }
        return new Feedback(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
    }
}
