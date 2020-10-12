/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author TimothyRay
 */
public class Transactions {
    private String transactionID;
    private int d;
    private int m;
    private int y;
    private int paymentOption;
    private float taxSeller;
    private String username;
    private ArrayList<Product> listProduct = new ArrayList<>();

    public Transactions(String transactionID, int d, int m, int y, int paymentOption, float taxSeller, String username) {
        this.transactionID = transactionID;
        this.d = d;
        this.m = m;
        this.y = y;
        this.paymentOption = paymentOption;
        this.taxSeller = taxSeller;
        this.username = username;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPaymentOption(int paymentOption) {
        this.paymentOption = paymentOption;
    }

    public void setTaxSeller(float taxSeller) {
        this.taxSeller = taxSeller;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public int getD() {
        return d;
    }

    public int getM() {
        return m;
    }

    public int getY() {
        return y;
    }

    public int getPaymentOption() {
        return paymentOption;
    }

    public float getTaxSeller() {
        return taxSeller;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }
    
    
}
