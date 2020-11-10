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
