package view;

import controller.Controller;
import controller.ControllerDatabase;
import model.Admin;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

public class AdminAddAdmin implements ActionListener {

    JFrame frame = new JFrame("Admin --> Add Admin");
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelAdminTitle = new JPanel();
    JPanel panelForm = new JPanel(new GridLayout(5, 1, 10, 20));

    JLabel lblTitle = new JLabel("Admin - Add Admin");

    JLabel lblUsername = new JLabel("Username : ");
    JTextField txtUsername = new JTextField();

    JLabel lblPassword = new JLabel("Password : ");
    JPasswordField adminPassword = new JPasswordField();

    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("<<<");

    public AdminAddAdmin() {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        // Set Padding
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));

        // Title
        lblTitle.setFont(mindfullyFont);
        lblTitle.setForeground(new Color(255, 145, 0));
        panelAdminTitle.add(lblTitle);
        panelAdminTitle.setBackground(new Color(0, 0, 0, 0));

        // Back Button
        backButton.setBounds(5, 25, 75, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(null);
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setForeground(new Color(255, 145, 0));
                backButton.setBackground(new Color(15, 15, 10));
                backButton.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setForeground(Color.WHITE);
                backButton.setBackground(Color.BLACK);
                backButton.setBorder(null);
            }
        });

        backButton.setActionCommand("Back");
        backButton.addActionListener(this);

        // Form Username
        lblUsername.setFont(new Font("Arial", Font.BOLD, 20));
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.WHITE);
        panelForm.add(lblUsername);
        panelForm.add(txtUsername);

        // Form Password
        lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
        lblPassword.setBackground(Color.BLACK);
        lblPassword.setForeground(Color.WHITE);
        panelForm.add(lblPassword);
        panelForm.add(adminPassword);

        // Submit Button
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(this);
        panelForm.add(submitButton);

        panelForm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));
        panelForm.setPreferredSize(new Dimension(450, 550));
        panelForm.setBackground(new Color(0, 0, 0, 0));

        // Add to Panel
        panel.add(panelAdminTitle, BorderLayout.NORTH);
        panel.add(panelForm, BorderLayout.CENTER);

        panel.setBackground(Color.BLACK);

        frame.add(backButton);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(panel);
        frame.setSize(600, 700);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Submit":
                String adminPass = Controller.md5Java(Controller.toStringPass(adminPassword.getPassword()));
                Admin admin = new Admin(txtUsername.getText(), adminPass);
                ControllerDatabase.insertAdmin(admin);
                new AdminMenu();
                frame.dispose();
                break;
            case "Back":
                new AdminMenu();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
