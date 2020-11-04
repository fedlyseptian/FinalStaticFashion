package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class LoginScreenMenu implements ActionListener {

    //Deklarasi
    JFrame frame = new JFrame("Login");
    JPanel panel = new JPanel(new GridLayout(3,1, 5, 5));

    //Title
    JLabel labelTitle = new JLabel("Login Form");

    JPanel panelForm = new JPanel(new GridLayout(2, 1, 10, 5));
    //Username
    JLabel labelUsername = new JLabel("Username");
    JTextField isiUsername = new JTextField("");
    //Password
    JLabel labelPassword = new JLabel("Password");
    JPasswordField isiPassword = new JPasswordField();

    JButton loginButton = new JButton("Login");

    public LoginScreenMenu(){
        panel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        //Title
        labelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelTitle);

        //Username
        labelUsername.setFont(new Font("Arial", Font.BOLD, 20));
        labelUsername.setHorizontalAlignment(JLabel.RIGHT);
        panelForm.add(labelUsername);
        panelForm.add(isiUsername);

        //Password
        labelPassword.setFont(new Font("Arial", Font.BOLD, 20));
        labelPassword.setHorizontalAlignment(JLabel.RIGHT);
        panelForm.add(labelPassword);
        panelForm.add(isiPassword);

        loginButton.setActionCommand("Login");
        loginButton.addActionListener(this);

        panel.add(panelForm);
        panel.add(loginButton);

        frame.add(panel);
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Login":
                // Cek ke databawse
                // New FRAME
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
