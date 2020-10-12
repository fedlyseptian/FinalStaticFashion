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

    public Admin(String username, String password, char gender, String email, int d, int m, int y) {
        super(username, password, gender, email, d, m, y);
    }

    public Admin() {
    }
}
