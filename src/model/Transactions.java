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
    private double taxSeller;
    private String username;
    private ArrayList<DetailTransaction> listProduct = new ArrayList<>();
    private String discountID;
    private double subTotal;

    public Transactions(String transactionID, int d, int m, int y, int paymentOption, double taxSeller, String username, String discountID,double subTotal) {
        this.transactionID = transactionID;
        this.d = d;
        this.m = m;
        this.y = y;
        this.paymentOption = paymentOption;
        this.taxSeller = taxSeller;
        this.username = username;
        this.discountID = discountID;
        this.subTotal = subTotal;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public void setTaxSeller(double taxSeller) {
        this.taxSeller = taxSeller;
    }

    public double getTaxSeller() {
        return taxSeller;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setListProduct(ArrayList<DetailTransaction> listProduct) {
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

    public String getUsername() {
        return username;
    }

    public ArrayList<DetailTransaction> getListProduct() {
        return listProduct;
    }

    public String getDiscountID() {
        return discountID;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Transactions() {
    }
}
