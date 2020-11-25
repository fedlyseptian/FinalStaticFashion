package model;

import java.util.ArrayList;

public class Cart {
    private String productID;
    private String productName;
    private String productBrand;
    private String productCategory;
    private String storeName;
    private String productSize;
    private String productPath;
    private int quantity;
    private double total;

    public Cart() {}

    public Cart(String productID, String productName, String productBrand, String productCategory, String storeName, String productSize, String productPath, int quantity, double total) {
        this.productID = productID;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productCategory = productCategory;
        this.storeName = storeName;
        this.productSize = productSize;
        this.productPath = productPath;
        this.quantity = quantity;
        this.total = total;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductPath() {
        return productPath;
    }

    public void setProductPath(String productPath) {
        this.productPath = productPath;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
