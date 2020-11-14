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

    private String name;
    private String address;
    private double point;
    private double money;
    private String gender;
    private String email;
    private int day;
    private int month;
    private int year;
    //ini ga pasti
    ArrayList<Transactions> listTransaction;

    public Member() {
    }

    //Pake listTransaction
//    public Member(String username, String password, String gender, String email, int day, int month, int year, String name, String address, double point, ArrayList<Transactions> listTransaction) {
//        super(username, password, gender, email, day, month, year);
//        this.name = name;
//        this.address = address;
//        this.point = point;
//        this.listTransaction = listTransaction;
//    }
    //Tanpa listTransaction
    public Member(String username, String password, String gender, String email, int day, int month, int year, String name, String address, double point,double money) {
        super(username, password);
        this.name = name;
        this.address = address;
        this.point = point;
        this.money=money;
        this.gender=gender;
        this.email=email;
        this.day=day;
        this.month=month;
        this.year=year;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
