package view;

import controller.Controller;
import controller.ControllerDatabase;
import model.Admin;
import model.TaxSeller;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

public class AdminTax implements ActionListener {

    JFrame frame = new JFrame("Admin --> Tax Seller");
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelAdminTitle = new JPanel();
    JPanel panelForm = new JPanel(new GridLayout(4, 1, 10, 20));

    JLabel lblTitle = new JLabel("Admin - Tax");

    JLabel lblTaxSeller = new JLabel("Tax Value : ");
    JTextField txtTaxSeller = new JTextField();

    JButton editButton = new JButton("Edit");
    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("<<<");

    static double tempTaxValue;

    public AdminTax() {
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

        // Tax Label
        lblTaxSeller.setFont(new Font("Arial", Font.BOLD, 20));
        lblTaxSeller.setForeground(Color.WHITE);

        txtTaxSeller.setEditable(false);

        TaxSeller taxSeller = ControllerDatabase.getTaxSeller();
        txtTaxSeller.setText(String.valueOf(taxSeller.getTaxValue()));

        // Form Tax Value
        panelForm.add(lblTaxSeller);
        panelForm.add(txtTaxSeller);

        // Edit Button
        editButton.setActionCommand("Edit");
        editButton.addActionListener(this);
        panelForm.add(editButton);

        // Submit Button
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(this);
        submitButton.setVisible(false);
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
                tempTaxValue = Double.parseDouble(txtTaxSeller.getText());
                txtTaxSeller.setEditable(true);
                submitButton.setVisible(true);
                break;
            case "Submit":
                if (Double.parseDouble(txtTaxSeller.getText()) >= 0.0) {
                    if (ControllerDatabase.updateTaxSeller(tempTaxValue, Double.parseDouble(txtTaxSeller.getText()))) {
                        new AdminTax();
                        frame.dispose();
                    }
                } else {
                    lblTaxSeller.setText("Tax Value : (ERROR)");
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
