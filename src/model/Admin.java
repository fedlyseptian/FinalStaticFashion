/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fedly
 */
public class Admin extends Person {

    public Admin(String username, String password, String gender, String email, int day, int month, int year) {
        super(username, password, gender, email, day, month, year);
    }

    public Admin() {
    }
}
