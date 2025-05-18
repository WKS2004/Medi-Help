package lk.sliit.project.onlinemedicalstore.medihelp.services;

import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Product;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Review;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.utils.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewServices {
    private static final String FILE_PATH = AppConfig.getInstance().getBasePath() + "/reviews.txt";

    public boolean addReview(Review review) {
        FileHandler.ensureFileExists(FILE_PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(review.toString());
            writer.newLine();
            return true;
        }
        catch (IOException exception) {
            System.out.println("Error writing to file the Review!");
            return false;
        }
    }

    public static boolean updateReview(String username, String productName, Review updatingReview) {
        List<Review> reviews = getAllReviews();
        boolean updatedStatus = false;

        FileHandler.ensureFileExists(FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))  {
            for (Review review : reviews) {
                if ( (review.getUser().getUsername().equals(username)) && (review.getProduct().getProductName().equals(productName)) ) {
                    review = updatingReview;
                    writer.write(review.toString());
                    writer.newLine();
                    updatedStatus = true;
                }
            }
        }
        catch (IOException exception) {
            System.out.println("Error");
        }
        return updatedStatus;
    }

    public boolean removeReview(String username, String productName) {
        List<Review> reviews = getAllReviews();
        boolean removedStatus = reviews.removeIf(review -> ( (review.getUser().getUsername().equals(username)) && (review.getProduct().getProductName().equals(productName)) ) );

        if (removedStatus) {
            FileHandler.ensureFileExists(FILE_PATH);
            for (Review review : reviews) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                    writer.write(reviews.toString());
                    writer.newLine();
                }
                catch (IOException exception) {
                    System.out.println("Error removing Review!");
                }
            }
        }
        return removedStatus;
    }

    public static List<Review> getAllReviews() {
        FileHandler.ensureFileExists(FILE_PATH);
        List<Review> reviews = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reviews.add(Review.toReviewFromText(line));
            }
        }
        catch (IOException exception) {
            System.out.println("Error");
        }
        return reviews;
    }

    public static Review getReviewByUsername(String username) {
        FileHandler.ensureFileExists(FILE_PATH);
        return (getAllReviews().stream().filter(review -> review.getUser().getUsername().equals(username)).findFirst().orElse(null));
    }
}
