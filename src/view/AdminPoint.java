package view;

import controller.ControllerDatabase;
import model.PointSystem;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

public class AdminPoint implements ActionListener {

    JFrame frame = new JFrame("Admin --> Point ");
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelAdminTitle = new JPanel();
    JPanel panelForm = new JPanel(new GridLayout(4, 1, 10, 20));

    JLabel lblTitle = new JLabel("Admin - Point");

    JLabel lblPoint = new JLabel("Point System : ");
    JTextField txtPoint = new JTextField();

    JButton editButton = new JButton("Edit");
    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("<<<");

    static double tempPointValue;

    public AdminPoint() {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        // Set Padding
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));

        // Title
        lblTitle.setFont(mindfullyFont);
        lblTitle.setFont(lblTitle.getFont().deriveFont(50f));
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

        // Point Label
        lblPoint.setFont(new Font("Arial", Font.BOLD, 20));
        lblPoint.setForeground(Color.WHITE);

        // Point Text Field
        txtPoint.setEditable(false);
        PointSystem point = ControllerDatabase.getPoint();
        txtPoint.setText(String.valueOf(point.getPointValue()));

        // Form Point Value
        panelForm.add(lblPoint);
        panelForm.add(txtPoint);

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
        frame.setSize(400, 500);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Edit":
                tempPointValue = Double.parseDouble(txtPoint.getText());
                txtPoint.setEditable(true);
                submitButton.setVisible(true);
                break;
            case "Submit":
                if (Double.parseDouble(txtPoint.getText()) >= 0.0) {
                    if (ControllerDatabase.updatePoint(tempPointValue, Double.parseDouble(txtPoint.getText()))) {
                        new AdminPoint();
                        frame.dispose();
                    }
                } else {
                    lblPoint.setText("Point Value : (ERROR)");
                }
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
