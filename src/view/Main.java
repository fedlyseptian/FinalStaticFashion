/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Asus
 */
public class Main {

    JFrame frame = new JFrame("Final Static Fashion");
    JPanel panelTitle = new JPanel();
    JPanel panelTitle2 = new JPanel();
    JPanel panelProduct = new JPanel();
    JPanel panelStore = new JPanel();
    JPanel panelLogin = new JPanel();
    JPanel panelRegister = new JPanel();
    JPanel panelAbout = new JPanel();

    Main() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ADD FONT : Cramer Regular
        Font crafterFont = null;
        try {
            //create the font to use. Specify the size!
            crafterFont = Font.createFont(Font.TRUETYPE_FONT, new File("media/Crafter Regular.otf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(crafterFont);
        } catch (IOException | FontFormatException ignored) {}

        // ADD FONT : Mindfully Alternate Italic
        Font mindfullyFont = null;
        try {
            //create the font to use. Specify the size!
            mindfullyFont = Font.createFont(Font.TRUETYPE_FONT, new File("media/Mindfully Alternate Italic.ttf")).deriveFont(100f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(mindfullyFont);
        } catch (IOException | FontFormatException ignored) {}

        // Panel Set Bound
        panelTitle.setBounds(0, 0, 1280, 200);
        panelTitle.setBorder(new EmptyBorder(160, 10, 0, 10));
        panelTitle2.setBounds(0, 200, 1280, 200);
        panelProduct.setBounds(0, 400, 256, 320);
        panelStore.setBounds(256, 400, 256, 320);
        panelLogin.setBounds(512, 400, 256, 320);
        panelRegister.setBounds(768, 400, 256, 320);
        panelAbout.setBounds(1024, 400, 256, 320);

        // Panel Set Background : BLACK
        panelTitle.setBackground(Color.BLACK);
        panelTitle2.setBackground(Color.BLACK);
        panelRegister.setBackground(Color.BLACK);
        panelLogin.setBackground(Color.BLACK);
        panelProduct.setBackground(Color.BLACK);
        panelStore.setBackground(Color.BLACK);
        panelAbout.setBackground(Color.BLACK);

        // LABEL: Welcome To
        JLabel title = new JLabel("WELCOME TO");
        title.setFont(crafterFont);
        title.setForeground(Color.ORANGE);
        panelTitle.add(title);

        // LABEL: Final Static Fashion
        JLabel title2 = new JLabel("Final Static Fashion");
        title2.setFont(mindfullyFont);
        title2.setForeground(Color.ORANGE);
        panelTitle2.add(title2);

        // LABEL: Products
        ImageIcon iconProduct = new ImageIcon("media/productIcon.png");
        JLabel iconProductLabel = new JLabel(iconProduct);
        iconProductLabel.setPreferredSize(new Dimension(256, 150));
        iconProductLabel.setHorizontalAlignment(JLabel.CENTER);
        iconProductLabel.setVerticalAlignment(JLabel.CENTER);
        panelProduct.add(iconProductLabel);

        JLabel titleProduct = new JLabel("Let's browse our products");
        titleProduct.setFont(new Font("Consolas", Font.BOLD, 14));
        titleProduct.setForeground(Color.WHITE);
        titleProduct.setPreferredSize(new Dimension(256, 25));
        titleProduct.setHorizontalAlignment(JLabel.CENTER);
        titleProduct.setVerticalAlignment(JLabel.CENTER);
        JButton btnProduct = new JButton("Product");
        btnProduct.setBounds(0, 0, 100, 25);
        panelProduct.add(titleProduct);
        panelProduct.add(btnProduct);

        // LABEL: Store
        ImageIcon iconStore = new ImageIcon("media/storeIcon.png");
        JLabel iconStoreLabel = new JLabel(iconStore);
        iconStoreLabel.setPreferredSize(new Dimension(256, 150));
        iconStoreLabel.setHorizontalAlignment(JLabel.CENTER);
        iconStoreLabel.setVerticalAlignment(JLabel.CENTER);
        panelStore.add(iconStoreLabel);

        JLabel titleStore = new JLabel("Explore our stores");
        titleStore.setFont(new Font("Consolas", Font.BOLD, 14));
        titleStore.setForeground(Color.WHITE);
        titleStore.setPreferredSize(new Dimension(256, 25));
        titleStore.setHorizontalAlignment(JLabel.CENTER);
        titleStore.setVerticalAlignment(JLabel.CENTER);
        JButton btnStore = new JButton("Store");
        btnStore.setBounds(0, 0, 100, 25);
        panelStore.add(titleStore);
        panelStore.add(btnStore);

        // LABEL: Login
        ImageIcon iconLogin = new ImageIcon("media/loginIcon.png");
        JLabel iconLoginLabel = new JLabel(iconLogin);
        iconLoginLabel.setPreferredSize(new Dimension(256, 150));
        iconLoginLabel.setHorizontalAlignment(JLabel.CENTER);
        iconLoginLabel.setVerticalAlignment(JLabel.CENTER);
        panelLogin.add(iconLoginLabel);

        JLabel titleLogin = new JLabel("Log in and happy shopping");
        titleLogin.setFont(new Font("Consolas", Font.BOLD, 14));
        titleLogin.setForeground(Color.WHITE);
        titleLogin.setPreferredSize(new Dimension(256, 25));
        titleLogin.setHorizontalAlignment(JLabel.CENTER);
        titleLogin.setVerticalAlignment(JLabel.CENTER);
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(0, 0, 100, 25);
        panelLogin.add(titleLogin);
        panelLogin.add(btnLogin);

        // LABEL: Register
        ImageIcon iconRegister = new ImageIcon("media/registerIcon.png");
        JLabel iconRegisterLabel = new JLabel(iconRegister);
        iconRegisterLabel.setPreferredSize(new Dimension(256, 150));
        iconRegisterLabel.setHorizontalAlignment(JLabel.CENTER);
        iconRegisterLabel.setVerticalAlignment(JLabel.CENTER);
        panelRegister.add(iconRegisterLabel);

        JLabel titleRegister = new JLabel("Join our family");
        titleRegister.setFont(new Font("Consolas", Font.BOLD, 14));
        titleRegister.setForeground(Color.WHITE);
        titleRegister.setPreferredSize(new Dimension(256, 25));
        titleRegister.setHorizontalAlignment(JLabel.CENTER);
        titleRegister.setVerticalAlignment(JLabel.CENTER);
        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(0, 0, 100, 25);
        panelRegister.add(titleRegister);
        panelRegister.add(btnRegister);

        // LABEL: About
        ImageIcon iconAbout = new ImageIcon("media/aboutIcon.png");
        JLabel iconAboutLabel = new JLabel(iconAbout);
        iconAboutLabel.setPreferredSize(new Dimension(256, 150));
        iconAboutLabel.setHorizontalAlignment(JLabel.CENTER);
        iconAboutLabel.setVerticalAlignment(JLabel.CENTER);
        panelAbout.add(iconAboutLabel);

        JLabel titleAbout = new JLabel("Curious about our profile ?");
        titleAbout.setFont(new Font("Consolas", Font.BOLD, 14));
        titleAbout.setForeground(Color.WHITE);
        titleAbout.setPreferredSize(new Dimension(256, 25));
        titleAbout.setHorizontalAlignment(JLabel.CENTER);
        titleAbout.setVerticalAlignment(JLabel.CENTER);
        JButton btnAbout = new JButton("About");
        btnAbout.setBounds(0, 0, 100, 25);
        panelAbout.add(titleAbout);
        panelAbout.add(btnAbout);

        // Add to FRAME
        frame.add(panelTitle);
        frame.add(panelTitle2);
        frame.add(panelProduct);
        frame.add(panelStore);
        frame.add(panelLogin);
        frame.add(panelRegister);
        frame.add(panelAbout);
        frame.setSize(1280, 720);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new Main();

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