package view;

import controller.ControllerDatabase;
import model.*;
import view.CartScreenMenu;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static view.MainMenus.mindfullyFont;

public class ShoppingScreenMenu implements ActionListener {
    JFrame frame = new JFrame("Shopping Menu");
    JPanel panel = new JPanel(new BorderLayout());

    JPanel panelTitle = new JPanel();
    JPanel panelProduct = new JPanel();

    BoxLayout boxLayout = new BoxLayout(panelProduct, BoxLayout.Y_AXIS);
    JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    JLabel labelTitleWelcome = new JLabel();
    JButton backButton = new JButton("<<<");

    //Button
    JButton cartButton = new JButton("Cart");

    public static ArrayList<Cart> listProductCart = new ArrayList<>();
    public ShoppingScreenMenu(){
        if(MemberManager.getInstance().getMember()!=null){
            labelTitleWelcome = new JLabel("Welcome "+MemberManager.getInstance().getMember().getUsername()+" to Shopping Menu");
        }else if(SellerManager.getInstance().getSeller()!=null) {
            labelTitleWelcome = new JLabel("Welcome "+SellerManager.getInstance().getSeller().getUsername()+" to Shopping Menu");
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

        // Loop through product list
        ArrayList<Product> listProduct = ControllerDatabase.getAllProducts();

        for (int i = 0; i < listProduct.size(); i++) {

            // Panel Declaration
            JPanel productContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel panelImg = new JPanel();
            JPanel panelDesc = new JPanel(new GridLayout(4, 1));
            JPanel panelDescRight = new JPanel(new GridLayout(4, 1));
            JPanel panelButton = new JPanel(new GridLayout(1, 1));

            // Border Separator
            productContainer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.ORANGE));

            // Set Panel Dimension
            productContainer.setPreferredSize(new Dimension(1200, 200));
            panelImg.setPreferredSize(new Dimension(200, 200));
            panelDesc.setPreferredSize(new Dimension(500, 120));
            panelDescRight.setPreferredSize(new Dimension(300, 120));
            panelButton.setPreferredSize(new Dimension(120, 30));

            // Product Image
            JLabel labelImg = new JLabel();
            labelImg.setIcon(new ImageIcon(new ImageIcon(listProduct.get(i).getProductPath()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

            // Product Data
            // --> Name
            JLabel labelProductName = new JLabel(listProduct.get(i).getProductName());
            labelProductName.setFont(new Font("Arial", Font.BOLD, 25));
            labelProductName.setForeground(Color.WHITE);

            // --> Brand
            JLabel labelProductBrand = new JLabel("Brand : " + listProduct.get(i).getProductBrand());
            labelProductBrand.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductBrand.setForeground(Color.WHITE);

            // --> Category
            JLabel labelProductCategory = new JLabel("( " + listProduct.get(i).getProductCategory() + " )");
            labelProductCategory.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductCategory.setForeground(Color.WHITE);

            // --> Price
            JLabel labelProductPrice = new JLabel("Price : " + listProduct.get(i).getProductPrice());
            labelProductPrice.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductPrice.setForeground(Color.WHITE);

            // --> Size
            JLabel labelProductSize = new JLabel("Size : " + listProduct.get(i).getProductSize());
            labelProductSize.setFont(new Font("Arial", Font.PLAIN, 20));
            labelProductSize.setForeground(Color.WHITE);

            // --> Store Name
            JLabel labelStoreName = new JLabel("Store Name : " + listProduct.get(i).getStoreName());
            labelStoreName.setFont(new Font("Arial", Font.PLAIN, 20));
            labelStoreName.setForeground(Color.WHITE);

            // --> Store Discount
            //Show Discount Product
            Discount tempDiscount = ControllerDatabase.getDiscountByStoreName(listProduct.get(i).getStoreName());
            JLabel labelDiscount = new JLabel("Store Discount : " + tempDiscount.getDiscountValue()*100+"%");
            labelDiscount.setFont(new Font("Arial", Font.PLAIN, 20));
            labelDiscount.setForeground(Color.WHITE);

            //Stock Product
            JLabel labelStockProduct = new JLabel("Stock : " + listProduct.get(i).getProductStock());
            labelStockProduct.setFont(new Font("Arial", Font.PLAIN, 20));
            labelStockProduct.setForeground(Color.WHITE);

            // --> Next Button
            JButton addToCartButton = new JButton("Add To Cart");

            int finalI = i;
            addToCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //listProduct.get(finalI).setProductStock(listProduct.get(finalI).getProductStock()-1);
                    if (listProductCart.isEmpty()) {
                        Cart cart = new Cart(listProduct.get(finalI).getProductID(),listProduct.get(finalI).getProductName(),listProduct.get(finalI).getProductBrand(),listProduct.get(finalI).getProductCategory(),listProduct.get(finalI).getStoreName(),listProduct.get(finalI).getProductSize(),listProduct.get(finalI).getProductPath(),1,listProduct.get(finalI).getProductPrice());
                        listProductCart.add(cart);
                        JOptionPane.showMessageDialog(frame, "Success Add This Product To Cart", "Add To Cart", JOptionPane.INFORMATION_MESSAGE);
                    } else{
                        boolean isIdBelumDitemukan = true;
                        boolean bikinBaru = true;
                        int k = 0;
                        do{
                            if(listProduct.get(finalI).getProductID().equals(listProductCart.get(k).getProductID())){
                                int temp = listProductCart.get(k).getQuantity() + 1;
                                listProductCart.get(k).setQuantity(temp);
                                JOptionPane.showMessageDialog(frame, "Success Add This Product To Cart", "Add To Cart", JOptionPane.INFORMATION_MESSAGE);
                                isIdBelumDitemukan = false;
                                bikinBaru = false;
                            }else {
                                k++;
                            }
                        }while(isIdBelumDitemukan == true && k < listProductCart.size());

                        if(bikinBaru){
                            Cart cart2 = new Cart(listProduct.get(finalI).getProductID(),listProduct.get(finalI).getProductName(),listProduct.get(finalI).getProductBrand(),listProduct.get(finalI).getProductCategory(),listProduct.get(finalI).getStoreName(),listProduct.get(finalI).getProductSize(),listProduct.get(finalI).getProductPath(),1,listProduct.get(finalI).getProductPrice());
                            listProductCart.add(cart2);
                            JOptionPane.showMessageDialog(frame,  "Success Add This Product To Cart", "Add To Cart", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }

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
            //Show Discount Product
            panelDesc.add(labelDiscount);

            panelDescRight.add(labelProductCategory);
            panelDescRight.add(labelProductSize);
            panelDescRight.add(labelProductPrice);
            panelDescRight.add(labelStockProduct);

            panelButton.add(addToCartButton);

            productContainer.add(panelImg);
            productContainer.add(panelDesc);
            productContainer.add(panelDescRight);
            productContainer.add(panelButton);

            panelProduct.add(productContainer);
        }

        panelTitle.add(labelTitleWelcome);

        //Cart Button
        cartButton.setFont(new Font("Arial", Font.BOLD, 15));
        cartButton.setActionCommand("Cart");
        cartButton.addActionListener(this);
        cartButton.setBounds(1050, 10, 90, 30);

        frame.add(cartButton);

        // Transaparent Child Background
        panelTitle.setBackground(new Color(0,0,0,0));
        panelProduct.setBackground(new Color(0,0,0,0));

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

        frame.add(backButton);

        panel.add(panelTitle, BorderLayout.NORTH);
        panel.add(panelProduct, BorderLayout.CENTER);
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
            case "Cart":
                new CartScreenMenu();
                frame.dispose();
                break;
            case "Back":
                new MemberMenu();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
