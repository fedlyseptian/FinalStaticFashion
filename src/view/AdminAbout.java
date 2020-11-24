package view;

import controller.ControllerDatabase;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

public class AdminAbout implements ActionListener {

    JFrame frame = new JFrame("Admin --> About Us");
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelAdminTitle = new JPanel();
    JPanel panelForm = new JPanel(new FlowLayout());

    JLabel lblTitle = new JLabel("Admin - About Us");

    JButton editButton = new JButton("Edit");
    JButton submitButton = new JButton("Save");
    JButton backButton = new JButton("<<<");

    JTextArea aboutTextArea = new JTextArea(20, 70);
    JScrollPane sp = new JScrollPane(aboutTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public AdminAbout() {
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

        // About Text Area
        aboutTextArea.setText((ControllerDatabase.getAboutUsText()));
        aboutTextArea.setEditable(false);
        aboutTextArea.setLineWrap(true);
        panelForm.add(sp);

        // Edit Button
        editButton.setActionCommand("Edit");
        editButton.addActionListener(this);
        panelForm.add(editButton);

        // Submit Button
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(this);
        submitButton.setVisible(false);
        panelForm.add(submitButton);

        // Panel Form
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
        frame.setSize(700, 800);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Edit":
                aboutTextArea.setEditable(true);
                submitButton.setVisible(true);
                break;
            case "Submit":
                ControllerDatabase.updateAboutUsText(aboutTextArea.getText());
                new AdminAbout();
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
