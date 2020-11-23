package view;

import model.Admin;
import model.AdminManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

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
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        // Set Padding
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));

        // Title
        lblTitle.setFont(mindfullyFont);
        lblTitle.setForeground(new Color(255, 145, 0));
        panelAdminTitle.add(lblTitle);
        panelAdminTitle.setBackground(Color.BLACK);

        // Product
        btnProduct.setFont(new Font("Arial", Font.BOLD, 30));
        btnProduct.setBackground(Color.BLACK);
        btnProduct.setForeground(Color.WHITE);
        btnProduct.setBorder(null);
        btnProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProduct.setForeground(new Color(255, 145, 0));
                btnProduct.setBackground(new Color(15, 15, 10));
                btnProduct.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProduct.setForeground(Color.WHITE);
                btnProduct.setBackground(Color.BLACK);
                btnProduct.setBorder(null);
            }
        });

        btnProduct.setActionCommand("Product");
        btnProduct.addActionListener(this);
        panelAdminMenu.add(btnProduct);

        // Store
        btnStore.setFont(new Font("Arial", Font.BOLD, 30));
        btnStore.setBackground(Color.BLACK);
        btnStore.setForeground(Color.WHITE);
        btnStore.setBorder(null);
        btnStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStore.setForeground(new Color(255, 145, 0));
                btnStore.setBackground(new Color(15, 15, 10));
                btnStore.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStore.setForeground(Color.WHITE);
                btnStore.setBackground(Color.BLACK);
                btnStore.setBorder(null);
            }
        });

        btnStore.setActionCommand("Store");
        btnStore.addActionListener(this);
        panelAdminMenu.add(btnStore);

        // Add Admin
        btnAddAdmin.setFont(new Font("Arial", Font.BOLD, 30));
        btnAddAdmin.setBackground(Color.BLACK);
        btnAddAdmin.setForeground(Color.WHITE);
        btnAddAdmin.setBorder(null);
        btnAddAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddAdmin.setForeground(new Color(255, 145, 0));
                btnAddAdmin.setBackground(new Color(15, 15, 10));
                btnAddAdmin.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddAdmin.setForeground(Color.WHITE);
                btnAddAdmin.setBackground(Color.BLACK);
                btnAddAdmin.setBorder(null);
            }
        });

        btnAddAdmin.setActionCommand("AddAdmin");
        btnAddAdmin.addActionListener(this);
        panelAdminMenu.add(btnAddAdmin);

        // Edit Admin
        btnEditAdmin.setFont(new Font("Arial", Font.BOLD, 30));
        btnEditAdmin.setBackground(Color.BLACK);
        btnEditAdmin.setForeground(Color.WHITE);
        btnEditAdmin.setBorder(null);
        btnEditAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditAdmin.setForeground(new Color(255, 145, 0));
                btnEditAdmin.setBackground(new Color(15, 15, 10));
                btnEditAdmin.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditAdmin.setForeground(Color.WHITE);
                btnEditAdmin.setBackground(Color.BLACK);
                btnEditAdmin.setBorder(null);
            }
        });

        btnEditAdmin.setActionCommand("EditAdmin");
        btnEditAdmin.addActionListener(this);
        panelAdminMenu.add(btnEditAdmin);

        // Discount
        btnDiscount.setFont(new Font("Arial", Font.BOLD, 30));
        btnDiscount.setBackground(Color.BLACK);
        btnDiscount.setForeground(Color.WHITE);
        btnDiscount.setBorder(null);
        btnDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDiscount.setForeground(new Color(255, 145, 0));
                btnDiscount.setBackground(new Color(15, 15, 10));
                btnDiscount.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDiscount.setForeground(Color.WHITE);
                btnDiscount.setBackground(Color.BLACK);
                btnDiscount.setBorder(null);
            }
        });

        btnDiscount.setActionCommand("Discount");
        btnDiscount.addActionListener(this);
        panelAdminMenu.add(btnDiscount);

        // Tax Seller
        btnTax.setFont(new Font("Arial", Font.BOLD, 30));
        btnTax.setBackground(Color.BLACK);
        btnTax.setForeground(Color.WHITE);
        btnTax.setBorder(null);
        btnTax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTax.setForeground(new Color(255, 145, 0));
                btnTax.setBackground(new Color(15, 15, 10));
                btnTax.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTax.setForeground(Color.WHITE);
                btnTax.setBackground(Color.BLACK);
                btnTax.setBorder(null);
            }
        });

        btnTax.setActionCommand("Tax");
        btnTax.addActionListener(this);
        panelAdminMenu.add(btnTax);

        // Point
        btnPoint.setFont(new Font("Arial", Font.BOLD, 30));
        btnPoint.setBackground(Color.BLACK);
        btnPoint.setForeground(Color.WHITE);
        btnPoint.setBorder(null);
        btnPoint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPoint.setForeground(new Color(255, 145, 0));
                btnPoint.setBackground(new Color(15, 15, 10));
                btnPoint.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPoint.setForeground(Color.WHITE);
                btnPoint.setBackground(Color.BLACK);
                btnPoint.setBorder(null);
            }
        });

        btnPoint.setActionCommand("Point");
        btnPoint.addActionListener(this);
        panelAdminMenu.add(btnPoint);

        // About Us
        btnAboutUs.setFont(new Font("Arial", Font.BOLD, 30));
        btnAboutUs.setBackground(Color.BLACK);
        btnAboutUs.setForeground(Color.WHITE);
        btnAboutUs.setBorder(null);
        btnAboutUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAboutUs.setForeground(new Color(255, 145, 0));
                btnAboutUs.setBackground(new Color(15, 15, 10));
                btnAboutUs.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAboutUs.setForeground(Color.WHITE);
                btnAboutUs.setBackground(Color.BLACK);
                btnAboutUs.setBorder(null);
            }
        });

        btnAboutUs.setActionCommand("AboutUs");
        btnAboutUs.addActionListener(this);
        panelAdminMenu.add(btnAboutUs);

        // History
        btnHistory.setFont(new Font("Arial", Font.BOLD, 30));
        btnHistory.setBackground(Color.BLACK);
        btnHistory.setForeground(Color.WHITE);
        btnHistory.setBorder(null);
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHistory.setForeground(new Color(255, 145, 0));
                btnHistory.setBackground(new Color(15, 15, 10));
                btnHistory.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHistory.setForeground(Color.WHITE);
                btnHistory.setBackground(Color.BLACK);
                btnHistory.setBorder(null);
            }
        });

        btnHistory.setActionCommand("History");
        btnHistory.addActionListener(this);
        panelAdminMenu.add(btnHistory);

        // Logout
        btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
        btnLogout.setBackground(Color.BLACK);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBorder(null);
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogout.setForeground(new Color(255, 67, 0));
                btnLogout.setBackground(new Color(15, 15, 10));
                btnLogout.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogout.setForeground(Color.WHITE);
                btnLogout.setBackground(Color.BLACK);
                btnLogout.setBorder(null);
            }
        });

        btnLogout.setActionCommand("Logout");
        btnLogout.addActionListener(this);
        panelAdminMenu.add(btnLogout);
        panelAdminMenu.setBackground(Color.BLACK);

        // Add to main panel and frame
        panel.add(panelAdminTitle, BorderLayout.NORTH);
        panel.add(panelAdminMenu, BorderLayout.CENTER);
        frame.add(panel);

        frame.getContentPane().setBackground(Color.BLACK);
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
                new AdminProduct();
                frame.dispose();
                break;
            case "Store":
                new AdminStore();
                frame.dispose();
                break;
            case "Discount":
                // New FRAME
                frame.dispose();
                break;
            case "AddAdmin":
                new AdminAddAdmin();
                frame.dispose();
                break;
            case "EditAdmin":
                new AdminEditAdmin();
                frame.dispose();
                break;
            case "AboutUs":
                new AdminAbout();
                frame.dispose();
                break;
            case "Point":
                // New FRAME
                frame.dispose();
                break;
            case "Tax":
                new AdminTax();
                frame.dispose();
                break;
            case "History":
                new AdminHistory();
                frame.dispose();
                break;
            case "Logout":
                // Clear Session
                AdminManager.getInstance().setAdmin(null);
                AdminManager.getInstance().setPassword(null);
                new MainMenus();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
