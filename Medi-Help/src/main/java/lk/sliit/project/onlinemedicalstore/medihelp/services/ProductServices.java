package lk.sliit.project.onlinemedicalstore.medihelp.services;

import lk.sliit.project.onlinemedicalstore.medihelp.config.AppConfig;
import lk.sliit.project.onlinemedicalstore.medihelp.models.Product;
import lk.sliit.project.onlinemedicalstore.medihelp.models.User;
import lk.sliit.project.onlinemedicalstore.medihelp.utils.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServices {
    private static final String FILE_PATH = AppConfig.getInstance().getBasePath() + "/products.txt";

    public static boolean addProduct(Product product) {
        FileHandler.ensureFileExists(FILE_PATH);
        if (getProductByProductName(product.getProductName()) != null) {
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))  {
            writer.write(product.toString());
            writer.newLine();
            return true;
        }
        catch (IOException exception) {
            System.out.println("Error");
            return false;
        }
    }

    public static boolean updateProduct(String productName, Product updatingProduct) {
        List<Product> products = getAllProducts();
        boolean updatedStatus = false;

        FileHandler.ensureFileExists(FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))  {
            for (Product product : products) {
                if (product.getProductName().equals(productName)) {
                    product = updatingProduct;
                    writer.write(product.toString());
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

    public static boolean removeProduct(String productName) {
        List<Product> products = getAllProducts();
        boolean removedStatus = products.removeIf(product -> product.getProductName().equals(productName));

        if (removedStatus) {
            FileHandler.ensureFileExists(FILE_PATH);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (Product product : products) {
                    writer.write(product.toString());
                    writer.newLine();
                }
            }
            catch (IOException exception) {
                System.out.println("Error");
            }
        }
        return removedStatus;
    }

    public static List<Product> getAllProducts() {
        FileHandler.ensureFileExists(FILE_PATH);
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(Product.toProductFromText(line));
            }
        }
        catch (IOException exception) {
            System.out.println("Error");
        }
        return products;
    }

    public static Product getProductByProductName(String username) {
        FileHandler.ensureFileExists(FILE_PATH);
        return (getAllProducts().stream().filter(product -> product.getProductName().equals(username)).findFirst().orElse(null));
    }
}

