package view;

import javax.swing.*;
import java.awt.*;

public class RegisterScreenMenu {

    //Deklarasi
    JFrame frame = new JFrame("Login");
    JTabbedPane tabPanel = new JTabbedPane();
    JPanel panelMember = new JPanel(new GridLayout(2,1, 2, 2));
    JPanel panelSeller = new JPanel(new GridLayout(2,1, 2, 2));

    JButton memberButton = new JButton("Become a Member");
    JButton sellerButton = new JButton("Become a Seller");

    public RegisterScreenMenu(){

        tabPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        memberButton.setFont(new Font("Arial", Font.BOLD, 20));
        sellerButton.setFont(new Font("Arial", Font.BOLD, 20));

        panelMember.add(memberButton);
        panelSeller.add(sellerButton);

        tabPanel.add("Member", panelMember);
        tabPanel.add("Seller", panelSeller);

        frame.add(tabPanel);
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

}
