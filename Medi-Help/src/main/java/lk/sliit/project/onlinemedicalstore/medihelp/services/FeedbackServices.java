package lk.sliit.project.onlinemedicalstore.medihelp.services;

import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Feedback;
import lk.sliit.project.onlinemedicalstore.medihelp.utils.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackServices {
    private static final String FILE_PATH = AppConfig.getInstance().getBasePath() + "/feedbacks.txt";

    public static boolean addFeedback(Feedback feedback) {
        FileHandler.ensureFileExists(FILE_PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(feedback.toString());
            writer.newLine();
            return true;
        }
        catch (IOException exception) {
            System.out.println("Error writing to file the Feedback!");
            return false;
        }
    }

    public static boolean removeFeedback(String feedbackID) {
        List<Feedback> feedbacks = getAllFeedbacks();
        boolean removedStatus = feedbacks.removeIf(feedback -> (feedback.getFeedbackID().equals(feedbackID)) );

        if (removedStatus) {
            FileHandler.ensureFileExists(FILE_PATH);
            for (Feedback feedback : feedbacks) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                    writer.write(feedback.toString());
                    writer.newLine();
                }
                catch (IOException exception) {
                    System.out.println("Error removing Feedback!");
                }
            }
        }
        return removedStatus;
    }

    public static List<Feedback> getAllFeedbacks() {
        FileHandler.ensureFileExists(FILE_PATH);
        List<Feedback> feedbacks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                feedbacks.add(Feedback.toFeedbackFromText(line));
            }
        }
        catch (IOException exception) {
            System.out.println("Error");
        }
        return feedbacks;
    }

    public static Feedback getFeedbackByFeedbackID(String feedbackID) {
        FileHandler.ensureFileExists(FILE_PATH);
        return (getAllFeedbacks().stream().filter(feedback -> feedback.getFeedbackID().equals(feedbackID)).findFirst().orElse(null));
    }
}