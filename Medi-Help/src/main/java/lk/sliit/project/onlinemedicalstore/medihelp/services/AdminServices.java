package lk.sliit.project.onlinemedicalstore.medihelp.services;

import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.utils.FileHandler;

import java.io.*;

import java.util.List;
import java.util.ArrayList;

public class AdminServices {
    private static final String FILE_PATH = AppConfig.getInstance().getBasePath() + "/admins.txt";

    public static boolean addAdmin(User user) {
        FileHandler.ensureFileExists(FILE_PATH);
        if (getAdminByUsername(user.getUsername()) != null) {
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

    public static boolean updateAdmin(String username, User updatingAdmin) {
        List<User> admins = getAllAdmins();
        boolean updatedStatus = false;

        FileHandler.ensureFileExists(FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))  {
            for (User admin : admins) {
                if (admin.getUsername().equals(username)) {
                    admin = updatingAdmin;
                    writer.write(admin.toString());
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

    public static boolean deleteAdmin(String username) {
        List<User> admins = getAllAdmins();
        boolean removedStatus = admins.removeIf(admin -> admin.getUsername().equals(username));

        if (removedStatus) {
            FileHandler.ensureFileExists(FILE_PATH);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (User admin : admins) {
                    writer.write(admin.toString());
                    writer.newLine();
                }
            }
            catch (IOException exception) {
                System.out.println("Error deleting admin!");
            }
        }
        return removedStatus;
    }

    public static List<User> getAllAdmins() {
        FileHandler.ensureFileExists(FILE_PATH);
        List<User> admins = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                admins.add(User.toUserFromText(line));
            }
        }
        catch (IOException exception) {
            System.out.println("Error");
        }
        return admins;
    }

    public static User getAdminByUsername(String username) {
        FileHandler.ensureFileExists(FILE_PATH);
        return (getAllAdmins().stream().filter(admin -> admin.getUsername().equals(username)).findFirst().orElse(null));
    }
}