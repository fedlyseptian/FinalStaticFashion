package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu implements ActionListener {

    // Declaration
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelAdminTitle = new JPanel();
    JPanel panelAdminMenu = new JPanel(new GridLayout(5, 2, 10, 10));

    // Label Declaration
    JLabel lblTitle = new JLabel("Admin Menu");

    // Button Declaration
    JButton btnProduct = new JButton("Product");
    JButton btnStore = new JButton("Store");
    JButton btnDiscount = new JButton("Discount");
    JButton btnAddAdmin = new JButton("Add Admin");
    JButton btnEditAdmin = new JButton("Edit Admin");
    JButton btnAboutUs = new JButton("Show / Edit About Us");
    JButton btnPoint = new JButton("Show / Edit Point");
    JButton btnTax = new JButton("Edit Seller Tax");
    JButton btnHistory = new JButton("History");
    JButton btnLogout = new JButton("Logout");

    public AdminMenu() {
        // Set Padding
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        // Title
        lblTitle.setFont(new Font("Arial", Font.BOLD, 50));
        panelAdminTitle.add(lblTitle);

        // Product
        btnProduct.setFont(new Font("Arial", Font.BOLD, 30));
        btnProduct.setActionCommand("Product");
        btnProduct.addActionListener(this);
        panelAdminMenu.add(btnProduct);

        // Store
        btnStore.setFont(new Font("Arial", Font.BOLD, 30));
        btnStore.setActionCommand("Store");
        btnStore.addActionListener(this);
        panelAdminMenu.add(btnStore);

        // Discount
        btnDiscount.setFont(new Font("Arial", Font.BOLD, 30));
        btnDiscount.setActionCommand("Discount");
        btnDiscount.addActionListener(this);
        panelAdminMenu.add(btnDiscount);

        // Add Admin
        btnAddAdmin.setFont(new Font("Arial", Font.BOLD, 30));
        btnAddAdmin.setActionCommand("AddAdmin");
        btnAddAdmin.addActionListener(this);
        panelAdminMenu.add(btnAddAdmin);

        // Edit Admin
        btnEditAdmin.setFont(new Font("Arial", Font.BOLD, 30));
        btnEditAdmin.setActionCommand("EditAdmin");
        btnEditAdmin.addActionListener(this);
        panelAdminMenu.add(btnEditAdmin);

        // About Us
        btnAboutUs.setFont(new Font("Arial", Font.BOLD, 30));
        btnAboutUs.setActionCommand("AboutUs");
        btnAboutUs.addActionListener(this);
        panelAdminMenu.add(btnAboutUs);

        // Point
        btnPoint.setFont(new Font("Arial", Font.BOLD, 30));
        btnPoint.setActionCommand("Point");
        btnPoint.addActionListener(this);
        panelAdminMenu.add(btnPoint);

        // Tax Seller
        btnTax.setFont(new Font("Arial", Font.BOLD, 30));
        btnTax.setActionCommand("Tax");
        btnTax.addActionListener(this);
        panelAdminMenu.add(btnTax);

        // History
        btnHistory.setFont(new Font("Arial", Font.BOLD, 30));
        btnHistory.setActionCommand("History");
        btnHistory.addActionListener(this);
        panelAdminMenu.add(btnHistory);

        // Logout
        btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
        btnLogout.setActionCommand("Logout");
        btnLogout.addActionListener(this);
        panelAdminMenu.add(btnLogout);

        // Add to main panel and frame
        panel.add(panelAdminTitle, BorderLayout.NORTH);
        panel.add(panelAdminMenu, BorderLayout.CENTER);
        frame.add(panel);

        frame.setSize(1280, 720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Product":
                // New FRAME
                frame.dispose();
                break;
            case "Store":
                // New Frame
                frame.dispose();
                break;
            case "Discount":
                // New FRAME
                frame.dispose();
                break;
            case "AddAdmin":
                // New FRAME
                frame.dispose();
                break;
            case "EditAdmin":
                // New FRAME
                frame.dispose();
                break;
            case "AboutUs":
                // New FRAME
                frame.dispose();
                break;
            case "Point":
                // New FRAME
                frame.dispose();
                break;
            case "Tax":
                // New FRAME
                frame.dispose();
                break;
            case "History":
                // New FRAME
                frame.dispose();
                break;
            case "Logout":
                // Clear Session
                new MainMenus();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
