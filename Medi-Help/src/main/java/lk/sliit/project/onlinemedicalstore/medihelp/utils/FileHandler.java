package lk.sliit.project.onlinemedicalstore.medihelp.utils;

import java.io.File;
import java.io.IOException;

public class FileHandler {
    public static void ensureFileExists(String FILE_PATH) {
        File file = new File(FILE_PATH);
        System.out.println("User file path: " + file.getAbsolutePath()); // Debug line
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error creating user file");
        }
    }
}
