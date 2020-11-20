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
public class Discount {
    private String discountID;
    private double discountValue;

    public Discount(String discountID, double discountValue) {
        this.discountID = discountID;
        this.discountValue = discountValue;
    }

    public Discount() {
    }

    public String getDiscountID() {
        return discountID;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }
    
}
