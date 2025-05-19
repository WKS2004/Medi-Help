package lk.sliit.project.onlinemedicalstore.medihelp.models;

import lk.sliit.project.onlinemedicalstore.medihelp.services.ProductServices;
import lk.sliit.project.onlinemedicalstore.medihelp.services.UserServices;

import java.time.LocalDateTime;

public class Review {
    private final User user;
    private final Product product;
    private String comment;
    private final LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Review(User user, Product product, String comment) {
        this.user = user;
        this.product = product;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public Review(User user, Product product, String comment, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.user = user;
        this.product = product;
        this.comment = comment;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public String toString() {
        return (user.getUsername() + "||" + product.getProductName() + "||" + comment + "||" + createdAt + "||" + modifiedAt);
    }

    public static Review toReviewFromText(String data) {
        String[] parts = data.split("\\|\\|");
        if (parts.length < 5) {
            throw new IllegalArgumentException("Corrupted user record: " + data);
        }

        User user = UserServices.getUserByUsername(parts[0]);
        Product product = ProductServices.getProductByProductName(parts[1]);
        LocalDateTime createdAt = LocalDateTime.parse(parts[3]);
        LocalDateTime modifiedAt = LocalDateTime.parse(parts[4]);

        return new Review(user, product, parts[2], createdAt, modifiedAt);
    }
}
