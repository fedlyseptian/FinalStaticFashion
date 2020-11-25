package view;

import model.MemberManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

public class MemberMenu implements ActionListener {

    // Declaration
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelMemberTitle = new JPanel();
    JPanel panelMemberMenu = new JPanel(new GridLayout(3, 2, 10, 10));

    // Label Declaration
    JLabel lblTitle = new JLabel("Member Menu");

    // Button Declaration
    JButton btnShopping = new JButton("Shopping");
    JButton btnTopUp = new JButton("Top Up");
    JButton btnEditMember = new JButton("Edit Member");
    JButton btnHistory = new JButton("History");
    JButton btnCart = new JButton("Cart");
    JButton btnLogout = new JButton("Logout");

    public MemberMenu() {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        // Set Padding
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));

        // Title
        lblTitle.setFont(mindfullyFont);
        lblTitle.setForeground(new Color(255, 145, 0));
        panelMemberTitle.add(lblTitle);
        panelMemberTitle.setBackground(Color.BLACK);

        // Shopping
        btnShopping.setFont(new Font("Arial", Font.BOLD, 30));
        btnShopping.setBackground(Color.BLACK);
        btnShopping.setForeground(Color.WHITE);
        btnShopping.setBorder(null);
        btnShopping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnShopping.setForeground(new Color(255, 145, 0));
                btnShopping.setBackground(new Color(15, 15, 10));
                btnShopping.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnShopping.setForeground(Color.WHITE);
                btnShopping.setBackground(Color.BLACK);
                btnShopping.setBorder(null);
            }
        });

        btnShopping.setActionCommand("Shopping");
        btnShopping.addActionListener(this);
        panelMemberMenu.add(btnShopping);

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
        panelMemberMenu.add(btnTopUp);

        // Edit Member
        btnEditMember.setFont(new Font("Arial", Font.BOLD, 30));
        btnEditMember.setBackground(Color.BLACK);
        btnEditMember.setForeground(Color.WHITE);
        btnEditMember.setBorder(null);
        btnEditMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMember.setForeground(new Color(255, 145, 0));
                btnEditMember.setBackground(new Color(15, 15, 10));
                btnEditMember.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMember.setForeground(Color.WHITE);
                btnEditMember.setBackground(Color.BLACK);
                btnEditMember.setBorder(null);
            }
        });

        btnEditMember.setActionCommand("EditMember");
        btnEditMember.addActionListener(this);
        panelMemberMenu.add(btnEditMember);

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
        panelMemberMenu.add(btnHistory);
        
        // Cart
        btnCart.setFont(new Font("Arial", Font.BOLD, 30));
        btnCart.setBackground(Color.BLACK);
        btnCart.setForeground(Color.WHITE);
        btnCart.setBorder(null);
        btnCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCart.setForeground(new Color(255, 145, 0));
                btnCart.setBackground(new Color(15, 15, 10));
                btnCart.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCart.setForeground(Color.WHITE);
                btnCart.setBackground(Color.BLACK);
                btnCart.setBorder(null);
            }
        });

        btnCart.setActionCommand("Cart");
        btnCart.addActionListener(this);
        panelMemberMenu.add(btnCart);

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
        panelMemberMenu.add(btnLogout);

        panelMemberMenu.setBackground(Color.BLACK);

        // Add to main panel and frame
        panel.add(panelMemberTitle, BorderLayout.NORTH);
        panel.add(panelMemberMenu, BorderLayout.CENTER);
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
            case "Shopping":
                new ShoppingScreenMenu();
                frame.dispose();
                break;
            case "TopUp":
                new MemberTopUp();
                frame.dispose();
                break;
            case "EditMember":
                new MemberEditMember();
                frame.dispose();
                break;
            case "History":
                new MemberHistory();
                frame.dispose();
                break;
            case "Cart":
                new CartScreenMenu();
                frame.dispose();
                break;
            case "Logout":
                // Clear Session
                MemberManager.getInstance().setMember(null);
                MemberManager.getInstance().setPassword(null);
                ShoppingScreenMenu.listProductCart.clear();
                new MainMenus();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
