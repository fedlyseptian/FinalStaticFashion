/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TimothyRay
 */
public class Product {
    private String productID;
    private String productName;
    private String productBrand;
    private String productCategory;
    private int productStock;
//    private String sellerName;
    private String storeName;
    private double productPrice;
    private String productSize;

    public Product() {
    }

    public Product(String productID, String productName, String productBrand, String productCategory, int productStock, String storeName, double productPrice, String productSize) {
        this.productID = productID;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productCategory = productCategory;
        this.productStock = productStock;
        this.storeName = storeName;
        this.productPrice = productPrice;
        this.productSize = productSize;
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

//    public void setSellerName(String sellerName) {
//        this.sellerName = sellerName;
//    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getProductStock() {
        return productStock;
    }

//    public String getSellerName() {
//        return sellerName;
//    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }
}
