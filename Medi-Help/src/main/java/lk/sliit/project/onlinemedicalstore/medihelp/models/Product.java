package lk.sliit.project.onlinemedicalstore.medihelp.models;

public class Product {
    private String productName;
    private String productBrand;
    private String productDescription;
    private String productCategory;
    private String productType;
    private String productImage;
    private double productPrice;
    private int productQuantity;
    private final boolean productStatus;

    public Product(String productName, String productBrand, String productDescription, String productCategory, String productType, String productImage, double productPrice, int productQuantity, boolean productStatus) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productType = productType;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productStatus = productStatus;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductImage() {
        return productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    @Override
    public String toString() {
        return (productName + "||" + productBrand + "||" + productDescription + "||" + productCategory + "||" + productType + "||" + productImage + "||" + productPrice + "||" + productQuantity + "||" + productStatus);
    }

    public static Product toProductFromText(String data) {
        String[] parts = data.split("\\|\\|");
        if (parts.length < 9) {
            throw new IllegalArgumentException("Corrupted user record: " + data);
        }

        return new Product(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], Double.parseDouble(parts[6]), Integer.parseInt(parts[7]), Boolean.parseBoolean(parts[8]));
    }
}
