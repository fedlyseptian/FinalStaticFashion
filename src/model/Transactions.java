/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author TimothyRay
 */
public class Transactions {
    private String transactionID;
    private Date transactionDate;
    private String paymentOption;
    private double taxSeller;
    private String username;
    private ArrayList<DetailTransaction> listProduct = new ArrayList<>();
    private double subTotal;

    public Transactions(String transactionID, Date date, String paymentOption, double taxSeller, String username, double subTotal) {
        this.transactionID = transactionID;
        this.transactionDate=date;
        this.paymentOption = paymentOption;
        this.taxSeller = taxSeller;
        this.username = username;
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

    public void setPaymentOption(String paymentOption) {
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

    public String getPaymentOption() {
        return paymentOption;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<DetailTransaction> getListProduct() {
        return listProduct;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Transactions() {
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
