/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Member extends Person {

    String name;
    String address;
    double point;
    ArrayList<Transactions> listTransaction;

    public Member() {
    }

    public Member(String username, String password, String gender, String email, int day, int month, int year, String name, String address, double point, ArrayList<Transactions> listTransaction) {
        super(username, password, gender, email, day, month, year);
        this.name = name;
        this.address = address;
        this.point = point;
        this.listTransaction = listTransaction;
    }

    private boolean buyProduct() {
        boolean result = false;
        return result;
    }

    private boolean addToShopCart() {
        boolean result = false;
        return result;
    }

//    kayaknya ga butuh, udh make fungsi yang di class transaction
//    private double generateShopPayment() {
//        double grandTotal = 0;
//        return grandTotal;
//    }

    private void getListHistory() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public ArrayList<Transactions> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(ArrayList<Transactions> listTransaction) {
        this.listTransaction = listTransaction;
    }

}
