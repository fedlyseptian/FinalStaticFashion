package view;

import model.Seller;
import model.SellerManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

public class SellerMenu implements ActionListener {

    // Declaration
    JFrame frame = new JFrame("Seller Menu");
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelAdminTitle = new JPanel();
    JPanel panelAdminMenu = new JPanel(new GridLayout(5, 2, 10, 10));

    // Label Declaration
    JLabel lblTitle = new JLabel("Seller Menu");

    // Button Declaration
    JButton btnBuyProduct = new JButton("Buy Product");
    JButton btnShopCart = new JButton("ShopCart");
    JButton btnEditProfile = new JButton("Edit Profile");
    JButton btnTopUp = new JButton("Top Up");
    JButton btnHistory = new JButton("History");

    JButton btnProduct = new JButton("Edit Product");
    JButton btnStore = new JButton("Edit Store");
    JButton btnDiscount = new JButton("Edit Discount");
    JButton btnLogout = new JButton("Logout");

    public static Seller seller = SellerManager.getInstance().getSeller();

    public SellerMenu() {
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

        // Buy Products
        btnBuyProduct.setFont(new Font("Arial", Font.BOLD, 30));
        btnBuyProduct.setBackground(Color.BLACK);
        btnBuyProduct.setForeground(Color.WHITE);
        btnBuyProduct.setBorder(null);
        btnBuyProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuyProduct.setForeground(new Color(255, 145, 0));
                btnBuyProduct.setBackground(new Color(15, 15, 10));
                btnBuyProduct.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuyProduct.setForeground(Color.WHITE);
                btnBuyProduct.setBackground(Color.BLACK);
                btnBuyProduct.setBorder(null);
            }
        });

        btnBuyProduct.setActionCommand("BuyProduct");
        btnBuyProduct.addActionListener(this);
        panelAdminMenu.add(btnBuyProduct);

        // Shop Cart
        btnShopCart.setFont(new Font("Arial", Font.BOLD, 30));
        btnShopCart.setBackground(Color.BLACK);
        btnShopCart.setForeground(Color.WHITE);
        btnShopCart.setBorder(null);
        btnShopCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnShopCart.setForeground(new Color(255, 145, 0));
                btnShopCart.setBackground(new Color(15, 15, 10));
                btnShopCart.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnShopCart.setForeground(Color.WHITE);
                btnShopCart.setBackground(Color.BLACK);
                btnShopCart.setBorder(null);
            }
        });

        btnShopCart.setActionCommand("ShopCart");
        btnShopCart.addActionListener(this);
        panelAdminMenu.add(btnShopCart);

        // Edit Profile
        btnEditProfile.setFont(new Font("Arial", Font.BOLD, 30));
        btnEditProfile.setBackground(Color.BLACK);
        btnEditProfile.setForeground(Color.WHITE);
        btnEditProfile.setBorder(null);
        btnEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditProfile.setForeground(new Color(255, 145, 0));
                btnEditProfile.setBackground(new Color(15, 15, 10));
                btnEditProfile.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditProfile.setForeground(Color.WHITE);
                btnEditProfile.setBackground(Color.BLACK);
                btnEditProfile.setBorder(null);
            }
        });

        btnEditProfile.setActionCommand("EditProfile");
        btnEditProfile.addActionListener(this);
        panelAdminMenu.add(btnEditProfile);

        // Top Up
        btnTopUp.setFont(new Font("Arial", Font.BOLD, 30));
        btnTopUp.setBackground(Color.BLACK);
        btnTopUp.setForeground(Color.WHITE);
        btnTopUp.setBorder(null);
        btnTopUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTopUp.setForeground(new Color(255, 145, 0));
                btnTopUp.setBackground(new Color(15, 15, 10));
                btnTopUp.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTopUp.setForeground(Color.WHITE);
                btnTopUp.setBackground(Color.BLACK);
                btnTopUp.setBorder(null);
            }
        });

        btnTopUp.setActionCommand("TopUp");
        btnTopUp.addActionListener(this);
        panelAdminMenu.add(btnTopUp);

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

        // Edit Product
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

        btnProduct.setActionCommand("EditProduct");
        btnProduct.addActionListener(this);
        panelAdminMenu.add(btnProduct);

        // Edit Store
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

        btnStore.setActionCommand("EditStore");
        btnStore.addActionListener(this);
        panelAdminMenu.add(btnStore);

        // Edit Discount
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

        btnDiscount.setActionCommand("EditDiscount");
        btnDiscount.addActionListener(this);
        panelAdminMenu.add(btnDiscount);

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
            case "BuyProduct":
                new ShoppingScreenMenu();
                frame.dispose();
                break;
            case "ShopCart":
                new CartScreenMenu();
                frame.dispose();
                break;
            case "EditProfile":
                new MemberEditMember();
                frame.dispose();
                break;
            case "TopUp":
                new MemberTopUp();
                frame.dispose();
                break;
            case "History":
                // new History();
                frame.dispose();
                break;
            case "EditProduct":
                new ASProduct();
                frame.dispose();
                break;
            case "EditStore":
                new EditSeller(seller.getStoreName());
                frame.dispose();
                break;
            case "EditDiscount":
                new EditDiscount(seller.getDiscountID());
                frame.dispose();
                break;
            case "Logout":
                // Clear Session
                SellerManager.getInstance().setSeller(null);
                SellerManager.getInstance().setPassword(null);
                new MainMenus();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
