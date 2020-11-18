/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.ControllerDatabase;
import model.Member;
import model.Product;
import model.Transactions;
import view.AdminMenu;
import view.MainMenus;

import java.util.ArrayList;

/**
 *
 * @author TimothyRay
 */
public class Main {

    public static void main(String[] args) {
        new MainMenus();
//        ArrayList<Product> listProduct = new ArrayList<>();
//        listProduct = ControllerDatabase.getAllProducts();
//        for (int i = 0; i < listProduct.size(); i++) {
//            System.out.println(listProduct.get(i).getProductName());
//        }
    }
}
