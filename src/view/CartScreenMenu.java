package view;

import controller.ControllerDatabase;
import controller.Controller;
import model.Cart;
import model.MemberManager;
import model.Product;
import model.SellerManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static view.MainMenus.mindfullyFont;
import static view.ShoppingScreenMenu.listProductCart;

public class CartScreenMenu implements ActionListener {
    JFrame frame = new JFrame("Cart");
    JPanel panel = new JPanel(new BorderLayout());

    JPanel panelTitle = new JPanel();
    JPanel panelProduct = new JPanel();
    JPanel panelRincianBelanjaan = new JPanel(new GridLayout(1, 1));

    BoxLayout boxLayout = new BoxLayout(panelProduct, BoxLayout.Y_AXIS);
    JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    JLabel labelTitleWelcome = new JLabel();
    JButton backButton = new JButton("<<<");

    //Button
    JButton logoutButton = new JButton("Logout");
    JButton shoppingMenuButton = new JButton("Back To Shop");

    protected static JSpinner spinnerTotalProduct = new JSpinner();

    public CartScreenMenu(){
        if(MemberManager.getInstance().getMember()!=null){
            labelTitleWelcome = new JLabel("Welcome "+MemberManager.getInstance().getMember().getUsername()+" to Cart");
        }else{
            new MainMenus();
            frame.dispose();
        }
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        panel.setBorder(new LineBorder(Color.BLACK, 20));
        panelProduct.setLayout(boxLayout);

        labelTitleWelcome.setFont(mindfullyFont);
        labelTitleWelcome.setForeground(new Color(255, 145, 0));

        for (int i = 0; i < listProductCart.size(); i++) {

            // Panel Declaration
            JPanel productContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel panelImg = new JPanel();
            JPanel panelDesc = new JPanel(new GridLayout(3, 1));
            JPanel panelDescRight = new JPanel(new GridLayout(5, 1));
            JPanel panelButton = new JPanel(new GridLayout(2, 1,0,5));

            // Border Separator
            productContainer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.ORANGE));

            // Set Panel Dimension
            productContainer.setPreferredSize(new Dimension(1200, 200));
            panelImg.setPreferredSize(new Dimension(200, 200));
            panelDesc.setPreferredSize(new Dimension(500, 180));
            panelDescRight.setPreferredSize(new Dimension(300, 180));
            panelButton.setPreferredSize(new Dimension(120, 65));


            // Product Image
            JLabel labelImg = new JLabel();
            labelImg.setIcon(new ImageIcon(new ImageIcon(listProductCart.get(i).getProductPath()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

            // Product Data
            // --> Name
            JLabel labelProductName = new JLabel(listProductCart.get(i).getProductName());
            labelProductName.setFont(new Font("Arial", Font.BOLD, 25));
            labelProductName.setForeground(Color.WHITE);

            // --> Brand
            JLabel labelProductBrand = new JLabel("Brand : " + listProductCart.get(i).getProductBrand());
            labelProductBrand.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductBrand.setForeground(Color.WHITE);

            // --> Category
            JLabel labelProductCategory = new JLabel("( " + listProductCart.get(i).getProductCategory() + " )");
            labelProductCategory.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductCategory.setForeground(Color.WHITE);

            // --> Price
            JLabel labelProductPrice = new JLabel("Price : " + listProductCart.get(i).getTotal());
            labelProductPrice.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductPrice.setForeground(Color.WHITE);

            // --> Size
            JLabel labelProductSize = new JLabel("Size : " + listProductCart.get(i).getProductSize());
            labelProductSize.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductSize.setForeground(Color.WHITE);

            // --> Store Name
            JLabel labelStoreName = new JLabel("Store Name : " + listProductCart.get(i).getStoreName());
            labelStoreName.setFont(new Font("Arial", Font.PLAIN, 20));
            labelStoreName.setForeground(Color.WHITE);

            // --> Total Product
            JLabel labelTotalProduct = new JLabel("Quantity : ");
            labelTotalProduct.setFont(new Font("Arial", Font.PLAIN, 20));
            labelTotalProduct.setForeground(Color.WHITE);
            spinnerTotalProduct = new JSpinner(new SpinnerNumberModel(listProductCart.get(i).getQuantity(),1,100,1));


            int finalI = i;
            // --> Update Product From Cart
            JButton updateProductFromCartButton = new JButton("Update");
            updateProductFromCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int temp = (int) spinnerTotalProduct.getValue();
                    listProductCart.get(finalI).setQuantity(temp);
                    JOptionPane.showMessageDialog(frame, "Success Update Data This Product", "Update Quantity", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new CartScreenMenu();
                }
            });

            // --> Delete Product From Cart
            JButton deleteProductFromCartButton = new JButton("Delete");


            deleteProductFromCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    listProductCart.remove(finalI);
                    JOptionPane.showMessageDialog(frame, "Success Delete This Product From Cart", "Delete From Cart", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new CartScreenMenu();
                }
            });

            // Transparent background
            productContainer.setBackground(new Color(0,0,0, 0));
            panelImg.setBackground(new Color(0, 0, 0, 0));
            panelDesc.setBackground(new Color(0, 0, 0, 0));
            panelDescRight.setBackground(new Color(0,0,0, 0));
            panelButton.setBackground(new Color(0,0,0, 0));

            // Add to main panel
            panelImg.add(labelImg);

            panelDesc.add(labelProductName);
            panelDesc.add(labelProductBrand);
            panelDesc.add(labelStoreName);

            panelDescRight.add(labelProductCategory);
            panelDescRight.add(labelProductSize);
            panelDescRight.add(labelProductPrice);
            panelDescRight.add(labelTotalProduct);
            panelDescRight.add(spinnerTotalProduct);

            panelButton.add(updateProductFromCartButton);
            panelButton.add(deleteProductFromCartButton);

            productContainer.add(panelImg);
            productContainer.add(panelDesc);
            productContainer.add(panelDescRight);
            productContainer.add(panelButton);

            panelProduct.add(productContainer);
        }

        panelTitle.add(labelTitleWelcome);

        //Back To Shopping Menu
        shoppingMenuButton.setFont(new Font("Arial", Font.BOLD, 15));
        shoppingMenuButton.setActionCommand("Shopping Menu");
        shoppingMenuButton.addActionListener(this);
        shoppingMenuButton.setBounds(990, 10, 150, 30);

        frame.add(shoppingMenuButton);

        //Logout Button
        logoutButton.setFont(new Font("Arial", Font.BOLD, 15));
        logoutButton.setActionCommand("Logout");
        logoutButton.addActionListener(this);
        logoutButton.setBounds(1150, 10, 90, 30);

        frame.add(logoutButton);

        //Panel Rincian Belanjaan di Cart
        JLabel jumlahTotalBiaya = new JLabel("Total Biaya : Rp." + Controller.hitungTotalBiayaBelanjaan(listProductCart));
        jumlahTotalBiaya.setFont(new Font("Calibri", Font.BOLD, 30));
        jumlahTotalBiaya.setHorizontalAlignment(JLabel.CENTER);
        jumlahTotalBiaya.setForeground(new Color(255, 145, 0));
        panelRincianBelanjaan.add(jumlahTotalBiaya);

//        //panelRincianBelanjaan
//        panelRincianBelanjaan.setPreferredSize(new Dimension(1080, 50));
//        //Border Separator For panelRincianBelanjaan
//        panelRincianBelanjaan.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.ORANGE));
//        //Border Empty For panelRincianBelanjaan
//        panelRincianBelanjaan.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));

        // Transaparent Child Background
        panelTitle.setBackground(new Color(0,0,0,0));
        panelProduct.setBackground(new Color(0,0,0,0));
        panelRincianBelanjaan.setBackground(new Color(0,0,0,0));

        // Coloring Panel
        panel.setBackground(Color.BLACK);

        // Back Button
        backButton.setBounds(5, 25, 100, 50);
        backButton.setFont(backButton.getFont().deriveFont(30f));
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

        //Frame add

        frame.add(backButton);

        panel.add(panelTitle, BorderLayout.NORTH);
        panel.add(panelProduct, BorderLayout.CENTER);
        panel.add(panelRincianBelanjaan, BorderLayout.SOUTH);
        frame.add(scrollPane);

        frame.setSize(1280, 720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Shopping Menu":
                new ShoppingScreenMenu();
                frame.dispose();
                break;
            case "Logout":
                // Logout account
                MemberManager.getInstance().setMember(null);
                MemberManager.getInstance().setPassword(null);
                SellerManager.getInstance().setSeller(null);
                SellerManager.getInstance().setPassword(null);
                listProductCart = null;
                new MainMenus();
                frame.dispose();
                break;
            case "Back":
                new MainMenus();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
