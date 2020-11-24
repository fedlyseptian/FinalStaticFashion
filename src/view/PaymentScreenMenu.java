package view;

import controller.Controller;
import model.*;
import controller.ControllerDatabase;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import static view.ShoppingScreenMenu.listProductCart;
import static view.MainMenus.mindfullyFont;

public class PaymentScreenMenu implements ActionListener {
    //Deklarasi
    JFrame frame = new JFrame("Final Static Fashion - Payment");
    JPanel panelTop = new JPanel();
    JPanel panelLeft = new JPanel();
    JPanel panelRight = new JPanel();
    JPanel panelBottom = new JPanel();
    JPanel panelCenter = new JPanel(new GridLayout(1,2));

    //Title
    JLabel labelTitle = new JLabel();

    //Get All Products from Database
    ArrayList<Product> listProduct = ControllerDatabase.getAllProducts();
    JButton backButton = new JButton("<<<");

    public PaymentScreenMenu(double totalBiayaSebelumDiskon, double diskon, double totalBiayaSetelahDiskon, ArrayList<Cart> listProductCart){
        if(MemberManager.getInstance().getMember()!=null){
            labelTitle = new JLabel("Welcome To Payment, Get Your Favorite Product Now");
        }else{
            new MainMenus();
            frame.dispose();
        }

        labelTitle.setFont(mindfullyFont);
        labelTitle.setForeground(new Color(255, 145, 0));
        labelTitle.setFont(labelTitle.getFont().deriveFont(45f));
        panelTop.add(labelTitle);

        //Size Panel
        panelTop.setPreferredSize(new Dimension(1280, 150));
        panelLeft.setPreferredSize(new Dimension(200, 470));
        panelCenter.setPreferredSize(new Dimension(880, 470));
        panelRight.setPreferredSize(new Dimension(200, 470));
        panelBottom.setPreferredSize(new Dimension(1280, 100));

        //Background Panel
        panelTop.setBackground(new Color(0,0,0));
        panelLeft.setBackground(new Color(0, 0, 0));
        panelCenter.setBackground(new Color(0, 0, 0));
        panelRight.setBackground(new Color(0,0,0));
        panelBottom.setBackground(new Color(0,0,0));

        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

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

        //Panel Center
        JPanel panelDescLeft = new JPanel(new GridLayout(2,1));
        JPanel panelDescRight = new JPanel(new GridLayout(3,1));

        // Transaparent Child Background
        panelDescLeft.setBackground(new Color(0,0,0));
        panelDescRight.setBackground(new Color(0,0,0));

        // --> Data Member
        //Money
        JLabel labelMoney = new JLabel("Your Money : Rp." + ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getMoney());
        labelMoney.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelMoney.setForeground(Color.WHITE);
        panelDescLeft.add(labelMoney);

        //Point
        JLabel labelPoint = new JLabel("Your Point : Rp." + ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getPoint());
        labelPoint.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelPoint.setForeground(Color.WHITE);
        panelDescLeft.add(labelPoint);

        //Total Biaya Sebelum Diskon
        double totalBiaya = totalBiayaSebelumDiskon;
        JLabel labelTotalBiayaSebelumDiskon = new JLabel("Total Biaya : Rp." + totalBiaya);
        labelTotalBiayaSebelumDiskon.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelTotalBiayaSebelumDiskon.setForeground(Color.WHITE);
        panelDescRight.add(labelTotalBiayaSebelumDiskon);

        //Total Biaya Sebelum Diskon
        double totalDiskon = diskon;
        JLabel labelTotalDiskon = new JLabel("Total Diskon : Rp." + totalDiskon);
        labelTotalDiskon.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelTotalDiskon.setForeground(Color.WHITE);
        panelDescRight.add(labelTotalDiskon);

        //Total Biaya Sebelum Diskon
        double grandTotal = totalBiayaSetelahDiskon;
        JLabel labelTotalBiayaSetelahDiskon = new JLabel("Grand Total : Rp." + grandTotal);
        labelTotalBiayaSetelahDiskon.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelTotalBiayaSetelahDiskon.setForeground(Color.WHITE);
        panelDescRight.add(labelTotalBiayaSetelahDiskon);

        //Button Buy
        JButton buyWithMoneyButton = new JButton("Buy With Money");
        buyWithMoneyButton.setFont(new Font("Arial", Font.BOLD, 20));
        buyWithMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getMoney() >= totalBiayaSetelahDiskon){
                    // melakukan set ulang pada tabungan pembeli
                    double sisaMoneyUser = ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getMoney() - totalBiayaSetelahDiskon;
                    MemberManager.getInstance().getMember().setMoney(sisaMoneyUser);
                    ControllerDatabase.updateMoney(MemberManager.getInstance().getMember().getUsername(), sisaMoneyUser);
                    for(int i = 0 ; i < listProductCart.size() ; i++){
                        // Mengurangi jumlah stok
                        int sisaProduk = ControllerDatabase.getProduct(listProductCart.get(i).getProductID()).getProductStock() - listProductCart.get(i).getQuantity();
                        ControllerDatabase.updateProductStock(listProductCart.get(i).getProductID(), sisaProduk);

                        // Menambahkan tabungan di seller
                        Member owner = ControllerDatabase.getMemberByProduct(listProductCart.get(i).getStoreName());
                        double pajak = ControllerDatabase.getTaxSeller().getTaxValue() * totalBiayaSetelahDiskon;
                        double uangDiterima = totalBiayaSetelahDiskon - pajak;
                        double uangTerbaru = owner.getMoney() + uangDiterima;
                        ControllerDatabase.updateMoney(owner.getUsername(), uangTerbaru);
                    }
                    String transID = Controller.generateNewTransactionID();
                    ControllerDatabase.insertTransaction(new Transactions(transID,new Date(),String.valueOf(EnumPaymentMethod.CASH),ControllerDatabase.getTaxSeller().getTaxValue(),MemberManager.getInstance().getMember().getUsername(),totalBiayaSetelahDiskon));
                    for (int i = 0; i < listProductCart.size(); i++) {
                        // insert data to listproduct
                        Cart c = listProductCart.get(i);
                        ControllerDatabase.insertProductToListProduct(transID, c);
                    }
                    //ControllerDatabase.insertProductToListProduct();
                    JOptionPane.showMessageDialog(frame, "Success Buying", "Success Buy", JOptionPane.INFORMATION_MESSAGE);
                    ControllerDatabase.updatePointValue(MemberManager.getInstance().getMember().getUsername(),MemberManager.getInstance().getMember().getPoint()+totalBiayaSetelahDiskon*ControllerDatabase.getPoint().getPointValue());
                    listProductCart.clear();
                }else{
                    JOptionPane.showMessageDialog(frame, "Insufficient Money, Please Top Up", "Failed Buy", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        panelBottom.add(buyWithMoneyButton);

        JButton buyWithPointButton = new JButton("Buy With Point");
        buyWithPointButton.setFont(new Font("Arial", Font.BOLD, 20));
        buyWithPointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getPoint() >= totalBiayaSetelahDiskon){
                    // Get sisa point user
                    double sisaPointUser = ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getPoint() - totalBiayaSetelahDiskon;
                    MemberManager.getInstance().getMember().setMoney(sisaPointUser);
                    ControllerDatabase.updatePointValue(MemberManager.getInstance().getMember().getUsername(), sisaPointUser);

                    for(int i = 0 ; i < listProductCart.size() ; i++){
                        // Update Stok - Dikurangin
                        int sisaProduk = ControllerDatabase.getProduct(listProductCart.get(i).getProductID()).getProductStock() - listProductCart.get(i).getQuantity();
                        ControllerDatabase.updateProductStock(listProductCart.get(i).getProductID(), sisaProduk);

                        // Menambahkan tabungan di seller
                        Member owner = ControllerDatabase.getMemberByProduct(listProductCart.get(i).getStoreName());
                        double pajak = ControllerDatabase.getTaxSeller().getTaxValue() * totalBiayaSetelahDiskon;
                        double uangDiterima = totalBiayaSetelahDiskon - pajak;
                        double uangTerbaru = owner.getMoney() + uangDiterima;
                        ControllerDatabase.updateMoney(owner.getUsername(), uangTerbaru);
                    }
                    String transID = Controller.generateNewTransactionID();
                    ControllerDatabase.insertTransaction(new Transactions(transID,new Date(),String.valueOf(EnumPaymentMethod.CASH),ControllerDatabase.getTaxSeller().getTaxValue(),MemberManager.getInstance().getMember().getUsername(),totalBiayaSetelahDiskon));
                    for (int i = 0; i < listProductCart.size(); i++) {
                        // insert data to listproduct
                        Cart c = listProductCart.get(i);
                        ControllerDatabase.insertProductToListProduct(transID, c);
                    }
                    JOptionPane.showMessageDialog(frame, "Success Buying", "Success Buy", JOptionPane.INFORMATION_MESSAGE);
                    listProductCart.clear();
                }else{
                    JOptionPane.showMessageDialog(frame, "Insufficient Money, Please Top Up", "Failed Buy", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        panelBottom.add(buyWithPointButton);

        //Button Top Up
        JButton topUpButton = new JButton("Top Up");
        topUpButton.setFont(new Font("Arial", Font.BOLD, 20));
        topUpButton.setActionCommand("Top Up");
        topUpButton.addActionListener(this);

        panelBottom.add(topUpButton);

        panelCenter.add(panelDescLeft);
        panelCenter.add(panelDescRight);

        frame.add(panelTop,BorderLayout.NORTH);
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelCenter,BorderLayout.CENTER);
        frame.add(panelRight,BorderLayout.EAST);
        frame.add(panelBottom,BorderLayout.SOUTH);

        frame.setSize(1280, 720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Top Up":
                new MemberTopUp();
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
