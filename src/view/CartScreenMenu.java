package view;

import controller.ControllerDatabase;
import controller.Controller;
import model.Cart;
import model.MemberManager;
import model.Product;
import model.SellerManager;
import view.ShoppingScreenMenu;

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
    JPanel panelRincianBelanjaan = new JPanel(new GridLayout(4, 1));



    BoxLayout boxLayout = new BoxLayout(panelProduct, BoxLayout.Y_AXIS);
    JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    JLabel labelTitleWelcome = new JLabel();
    JButton backButton = new JButton("<<<");

    //Button
    JButton shoppingMenuButton = new JButton("Back To Shop");

    protected static JSpinner spinnerTotalProduct = new JSpinner();

    //Buat ambil stock product
    ArrayList<Product> listProduct = ControllerDatabase.getAllProducts();

    //Deklarasi Rincian Biaya
    double totalBiaya = 0;
    double diskon = 0;
    double grandTotal = 0;

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
            int hasilGetStockProduct = ControllerDatabase.getStockProductByIdProduct(listProductCart.get(i).getProductID());
            spinnerTotalProduct = new JSpinner(new SpinnerNumberModel(listProductCart.get(i).getQuantity(),1,hasilGetStockProduct,1));


            int finalI = i;
            // --> Update Product From Cart
            JButton updateProductFromCartButton = new JButton("Update");
            updateProductFromCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int temp = (int) spinnerTotalProduct.getValue();
                    if(temp > 0 && temp < hasilGetStockProduct){
                        listProductCart.get(finalI).setQuantity(temp);
                        Controller.updateListProduct(listProduct,listProductCart.get(finalI).getProductID(),temp);
                        JOptionPane.showMessageDialog(frame, "Success Update Data This Product", "Update Quantity", JOptionPane.INFORMATION_MESSAGE);
                        new CartScreenMenu();
                        frame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(frame, "Failed To Update Data This Product, because the quantity is not valid", "Failed Update", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            // --> Delete Product From Cart
            JButton deleteProductFromCartButton = new JButton("Delete");


            deleteProductFromCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int temp = (int) spinnerTotalProduct.getValue();
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
        shoppingMenuButton.setBounds(1050, 10, 150, 30);

        frame.add(shoppingMenuButton);

        //Panel Rincian Belanjaan di Cart
        panelRincianBelanjaan.setPreferredSize(new Dimension(500, 200));
        //Total Biaya Sebelum Diskon
        totalBiaya = Controller.hitungTotalBiayaBelanjaan(listProductCart);
        JLabel totalBiayaSebelumDiskon = new JLabel("Total Biaya : Rp." + totalBiaya);
        totalBiayaSebelumDiskon.setFont(new Font("Calibri", Font.BOLD, 30));
        totalBiayaSebelumDiskon.setHorizontalAlignment(JLabel.CENTER);
        totalBiayaSebelumDiskon.setForeground(new Color(255, 145, 0));
        panelRincianBelanjaan.add(totalBiayaSebelumDiskon);

        //Besar Diskon
        diskon = Controller.hitungTotalDiscount(listProductCart);
        JLabel totalDiskon = new JLabel("Total Discount : Rp." + diskon);
        totalDiskon.setFont(new Font("Calibri", Font.BOLD, 30));
        totalDiskon.setHorizontalAlignment(JLabel.CENTER);
        totalDiskon.setForeground(new Color(255, 145, 0));
        panelRincianBelanjaan.add(totalDiskon);

        //Total Biaya Setelah Diskon
        grandTotal = Controller.hitungTotalBiayaBelanjaanSetelahDiscount(listProductCart);
        JLabel totalBiayaSetelahDiskon = new JLabel("Grand Total Biaya : Rp." + grandTotal);
        totalBiayaSetelahDiskon.setFont(new Font("Calibri", Font.BOLD, 30));
        totalBiayaSetelahDiskon.setHorizontalAlignment(JLabel.CENTER);
        totalBiayaSetelahDiskon.setForeground(new Color(255, 145, 0));
        panelRincianBelanjaan.add(totalBiayaSetelahDiskon);

        //Button Buy Product
        JButton buyNowButton = new JButton("Buy Now");
        buyNowButton.setFont(new Font("Arial", Font.BOLD, 20));
        buyNowButton.setActionCommand("Buy");
        buyNowButton.addActionListener(this);
        panelRincianBelanjaan.add(buyNowButton);

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
            case "Buy":
                new PaymentScreenMenu(totalBiaya,diskon,grandTotal,listProductCart);
                frame.dispose();
                break;
            case "Back":
                if (SellerManager.getInstance().getSeller() != null) {
                    new SellerMenu();
                } else if (MemberManager.getInstance().getMember() != null){
                    new MemberMenu();
                }
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
