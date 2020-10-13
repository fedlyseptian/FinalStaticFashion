/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 * @author Asus
 */
public class Main {

    public static void main(String[] args) {
        // temporary aja
        Scanner scanner = new Scanner(System.in);
        String inputs;

        chooseMenu:
        while (true) {
            System.out.println("Welcome To Final Static Fashion\n" +
                    "1. Product\n" +
                    "2. Store\n" +
                    "3. Login\n" +
                    "4. Register\n" +
                    "5. About Us\n" +
                    "6. EXIT\n" +
                    "-> ");
            inputs = scanner.nextLine();
            switch (inputs) {
                case "1":
                    new ProductMenu();
                    break;
                case "2":
                    new StoreMenu();
                    break;
                case "3":
                    new LoginMenu();
                    break;
                case "4":
                    new RegisterMenu();
                    break;
                case "5":
                    new AboutUsMenu();
                    break;
                default:
                    System.out.println("\nThank You\n");
                    break chooseMenu;
            }
        }

    }

}