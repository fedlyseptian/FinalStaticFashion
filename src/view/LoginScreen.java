/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author Asus
 */
public class LoginScreen {
    
    //Deklarasi 
    JFrame frame = new JFrame("Login");
    JPanel topPanel = new JPanel(new GridLayout(2,1));
    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel leftPanel = new JPanel(new GridLayout(25,4));
    JPanel rightPanel = new JPanel(new GridLayout(25,4));
    
    JLabel labelTitle = new JLabel("Login Form"); 
    //Username
    JLabel labelUsername = new JLabel("Username");
    JTextField isiUsername = new JTextField("");
    //Password
    JLabel labelPassword = new JLabel("Password");
    JPasswordField isiPassword = new JPasswordField();
    
    public LoginScreen(){
        System.out.println("Login Final Static Fashion");
        
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        topPanel.setBounds(0,0,500,80);
        leftPanel.setBounds(0,80,150,320);
        rightPanel.setBounds(150,80,350,320);
        bottomPanel.setBounds(0,400,500,100);
        
        topPanel.setBackground(Color.orange);
        leftPanel.setBackground(Color.darkGray);
        rightPanel.setBackground(Color.darkGray);
        bottomPanel.setBackground(Color.darkGray);
        
        Border paddingTop = BorderFactory.createEmptyBorder(0,25,0,25);
        topPanel.setBorder(paddingTop);
        
        Border paddingLeft = BorderFactory.createEmptyBorder(0,25,0,0);
        leftPanel.setBorder(paddingLeft);
        
        Border paddingRight = BorderFactory.createEmptyBorder(0,0,0,25);
        rightPanel.setBorder(paddingRight);
        
        Border paddingBottom = BorderFactory.createEmptyBorder(0,25,0,25);
        bottomPanel.setBorder(paddingBottom);
        
        //Title
        topPanel.add(labelTitle);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        
        //Username
        leftPanel.add(labelUsername);
        rightPanel.add(isiUsername);
        
        //Password
        
        
        


        frame.add(topPanel);
        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.add(bottomPanel);
        
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
