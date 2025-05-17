package lk.sliit.project.onlinemedicalstore.medihelp.services;

import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.utils.FileHandler;

import java.io.*;

import java.util.List;
import java.util.ArrayList;

public class UserServices {
    private static final String FILE_PATH = AppConfig.getInstance().getBasePath() + "/users.txt";

    public static boolean registerUser(User user) {
        FileHandler.ensureFileExists(FILE_PATH);
        if (getUserByUsername(user.getUsername()) != null) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))  {
            writer.write(user.toString());
            writer.newLine();
            return true;
        }
        catch (IOException exception) {
            System.out.println("Error");
            return false;
        }
    }

    public static User loginUser(String usernameOrEmail, String password) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (((user.getUsername().equals(usernameOrEmail)) || (user.getEmail().equals(usernameOrEmail))) && (user.getPassword().equals(password))) {
                return user;
            }
        }
        return null;
    }

    public static boolean updateDisplayName(String uID, String newDisplayName) {
        List<User> users = getAllUsers();
        boolean updatedStatus = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))  {
            for (User user : users) {
                if (user.getUsername().equals(uID)) {
                    user.setDisplayName(newDisplayName);
                    writer.write(user.toString());
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

    public static boolean updateUserPassword(String uID, String oldPassword, String newPassword, String confirmPassword) {
        List<User> users = getAllUsers();
        boolean updatedStatus = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            for (User user : users) {
                if (user.getUsername().equals(uID)) {
                    if (user.getPassword().equals(oldPassword) && (newPassword.equals(confirmPassword))) {
                        user.setPassword(newPassword);
                    }
                    writer.write(user.toString());
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

    public static boolean deleteUser(String username) {
        List<User> users = getAllUsers();
        boolean removedStatus = users.removeIf(user -> user.getUsername().equals(username));

        if (removedStatus) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                for (User user : users) {
                    writer.write(user.toString());
                    writer.newLine();
                }
            }
            catch (IOException exception) {
                System.out.println("Error");
            }
        }
        return removedStatus;
    }

    public static List<User> getAllUsers() {
        FileHandler.ensureFileExists(FILE_PATH);
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(User.toUserFromText(line));
            }
        }
        catch (IOException exception) {
            System.out.println("Error");
        }
        return users;
    }

    public static User getUserByUsername(String username) {
        FileHandler.ensureFileExists(FILE_PATH);
        return (getAllUsers().stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null));
    }
}