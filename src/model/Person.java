/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author jeded
 */
public abstract class Person {
    private String username;
    private String password;
    private char gender;
    private String email;
    private int day;
    private int month;
    private int year;

    public Person(String username, String password, char gender, String email, int day, int month, int year) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Person() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public char getGender() {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(char gender) {
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
