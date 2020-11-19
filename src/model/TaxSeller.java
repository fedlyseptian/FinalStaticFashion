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
public class TaxSeller {
    private double taxValue;

    public TaxSeller() {
    }

    public TaxSeller(double taxValue) {
        this.taxValue = taxValue;
    }
    
    public double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }
}
