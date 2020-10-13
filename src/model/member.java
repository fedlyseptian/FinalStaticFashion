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

    public Member(String username, String password, char gender, String email, int d, int m, int y, String name, String address, double point, ArrayList<Transactions> listTransaction) {
        super(username, password, gender, email, d, m, y);
        this.name = name;
        this.address = address;
        this.point = point;
        this.listTransaction = listTransaction;
    }

    public Member(){

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

    public ArrayList<Transactions> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(ArrayList<Transactions> listTransaction) {
        this.listTransaction = listTransaction;
    }
    
    
    
    
}
