package lk.sliit.project.onlinemedicalstore.medihelp.dsa;

import lk.sliit.project.onlinemedicalstore.medihelp.models.Product;

import java.util.List;

public class QuickSortProducts {
    public static void quickSortByPrice_lowToHigh(List<Product> products, int low, int high) {
        if (products != null && products.size() > 1) {
            if (low < high) {
                int pivot = partitionByPrice_lowToHigh(products, low, high);
                quickSortByPrice_lowToHigh(products, low, pivot - 1);
                quickSortByPrice_lowToHigh(products, pivot + 1, high);
            }
        }
    }

    public static void quickSortByPrice_highToLow(List<Product> products, int low, int high) {
        if (products != null && products.size() > 1) {
            if (low < high) {
                int pivot = partitionByPrice_highToLow(products, low, high);
                quickSortByPrice_highToLow(products, low, pivot - 1);
                quickSortByPrice_highToLow(products, pivot + 1, high);
            }
        }
    }

    private static int partitionByPrice_lowToHigh(List<Product> products, int low, int high) {
        Product pivot = products.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (products.get(j).getProductPrice() <= pivot.getProductPrice()) {
                i++;
                swap(products, i, j);
            }
            swap(products, (i + 1), high);
        }
        return i + 1;
    }

    private static int partitionByPrice_highToLow(List<Product> products, int low, int high) {
        Product pivot = products.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (products.get(j).getProductPrice() > pivot.getProductPrice()) {
                i++;
                swap(products, i, j);
            }
            swap(products, (i + 1), high);
        }
        return i + 1;
    }

    private static void swap(List<Product> products, int i, int j) {
        Product temp = products.get(i);
        products.set(i, products.get(j));
        products.set(j, temp);
    }
}
