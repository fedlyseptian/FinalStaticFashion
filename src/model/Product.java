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
    String productID;
    String productName;
    String productBrand;
    String productCategory;
    String productStock;
    String sellerName;
    String productPrice;
    String productSize;

    public Product() {
    }

    public Product(String productID, String productName, String productBrand, String productCategory, String productStock, String sellerName, String productPrice, String productSize) {
        this.productID = productID;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productCategory = productCategory;
        this.productStock = productStock;
        this.sellerName = sellerName;
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

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setProductPrice(String productPrice) {
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

    public String getProductStock() {
        return productStock;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductSize() {
        return productSize;
    }
    
}
