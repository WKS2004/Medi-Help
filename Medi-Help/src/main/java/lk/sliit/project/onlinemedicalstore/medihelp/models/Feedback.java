package lk.sliit.project.onlinemedicalstore.medihelp.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Feedback {
    private String feedbackID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String comment;

    public Feedback(String firstName, String lastName, String email, String phoneNumber, String comment) {
        this.feedbackID = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = LocalDateTime.now();
        this.comment = comment;
    }

    public Feedback(String feedbackID, String firstName, String lastName, String email, String phoneNumber, LocalDateTime createdAt, String comment) {
        this.feedbackID = feedbackID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return (feedbackID + "||" + firstName + "||" + lastName + "||" + email + "||" + phoneNumber + "||" + createdAt + "||" + comment);
    }

    public static Feedback toFeedbackFromText(String data) {
        String[] parts = data.split("\\|\\|");
        if (parts.length < 6) {
            throw new IllegalArgumentException("Corrupted user record: " + data);
        }

        LocalDateTime createdAt = LocalDateTime.parse(parts[5]);
        return new Feedback(parts[0], parts[1], parts[2], parts[3], parts[4], createdAt, parts[6]);
    }
}
