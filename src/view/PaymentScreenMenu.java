package view;

import model.Cart;
import model.MemberManager;
import controller.ControllerDatabase;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static view.ShoppingScreenMenu.listProductCart;

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

    public PaymentScreenMenu(double totalBiayaSebelumDiskon, double totalDiskon, double totalBiayaSetelahDiskon, ArrayList<Cart> listProductCart){
        if(MemberManager.getInstance().getMember()!=null){
            labelTitle = new JLabel("Welcome To Payment, Get Your Favorite Product Now");
        }else{
            new MainMenus();
            frame.dispose();
        }

        //Size Panel
        panelTop.setPreferredSize(new Dimension(1200, 80));
        panelLeft.setPreferredSize(new Dimension(200, 200));
        panelCenter.setPreferredSize(new Dimension(500, 200));
        panelRight.setPreferredSize(new Dimension(200, 2000));
        panelBottom.setPreferredSize(new Dimension(1200, 80));

        //Background Panel
        panelTop.setBackground(new Color(0,0,0));
        panelLeft.setBackground(new Color(0, 0, 0));
        panelCenter.setBackground(new Color(0, 0, 0));
        panelRight.setBackground(new Color(0,0,0));
        panelBottom.setBackground(new Color(0,0,0));

        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        //Panel Center
        JPanel panelDescLeft = new JPanel(new GridLayout(2,1));
        JPanel panelDescRight = new JPanel(new GridLayout(3,1));

        // Transaparent Child Background
        panelDescLeft.setBackground(new Color(0,0,0));
        panelDescRight.setBackground(new Color(0,0,0));

        // --> Data Member
        //Money
        JLabel labelMoney = new JLabel("Your Money : Rp." + ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getMoney());
        labelMoney.setFont(new Font("Arial", Font.PLAIN, 20));
        labelMoney.setForeground(Color.WHITE);
        panelDescLeft.add(labelMoney);

        //Point
        JLabel labelPoint = new JLabel("Your Point : Rp." + ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getPoint());
        labelPoint.setFont(new Font("Arial", Font.PLAIN, 20));
        labelPoint.setForeground(Color.WHITE);
        panelDescLeft.add(labelPoint);

        //Total Biaya Sebelum Diskon
        JLabel labelTotalBiayaSebelumDiskon = new JLabel("Total Biaya : Rp." + totalBiayaSebelumDiskon);
        labelPoint.setFont(new Font("Arial", Font.PLAIN, 20));
        labelPoint.setForeground(Color.WHITE);
        panelDescRight.add(labelTotalBiayaSebelumDiskon);

        //Total Biaya Sebelum Diskon
        JLabel labelTotalDiskon = new JLabel("Total Diskon : Rp." + totalDiskon);
        labelPoint.setFont(new Font("Arial", Font.PLAIN, 20));
        labelPoint.setForeground(Color.WHITE);
        panelDescRight.add(labelTotalDiskon);

        //Total Biaya Sebelum Diskon
        JLabel labelTotalBiayaSetelahDiskon = new JLabel("Grand Total : Rp." + totalBiayaSetelahDiskon);
        labelPoint.setFont(new Font("Arial", Font.PLAIN, 20));
        labelPoint.setForeground(Color.WHITE);
        panelDescRight.add(labelTotalBiayaSetelahDiskon);

        //Button Buy
        JButton buyWithMoneyButton = new JButton("Buy With Money");
        buyWithMoneyButton.setFont(new Font("Arial", Font.BOLD, 20));
        buyWithMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getMoney() >= totalBiayaSetelahDiskon){
                    double sisaMoneyUser = ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getMoney() - totalBiayaSetelahDiskon;
                    MemberManager.getInstance().getMember().setMoney(sisaMoneyUser);
                    for(int i = 0 ; i < listProductCart.size() ; i++){
                        int sisaProduk = ControllerDatabase.getProduct(listProductCart.get(i).getProductID()).getProductStock() - listProductCart.get(i).getQuantity();
                        ControllerDatabase.updateProductStock(listProductCart.get(i).getProductID(), sisaProduk);
                    }

                    JOptionPane.showMessageDialog(frame, "Success Buying", "Success Buy", JOptionPane.INFORMATION_MESSAGE);
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
                    double sisaPointUser = ControllerDatabase.getMember(MemberManager.getInstance().getMember().getUsername()).getPoint() - totalBiayaSetelahDiskon;
                    MemberManager.getInstance().getMember().setMoney(sisaPointUser);
                    for(int i = 0 ; i < listProductCart.size() ; i++){
                        int sisaProduk = ControllerDatabase.getProduct(listProductCart.get(i).getProductID()).getProductStock() - listProductCart.get(i).getQuantity();
                        ControllerDatabase.updateProductStock(listProductCart.get(i).getProductID(), sisaProduk);
                    }
                    JOptionPane.showMessageDialog(frame, "Success Buying", "Success Buy", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(frame, "Insufficient Money, Please Top Up", "Failed Buy", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        panelBottom.add(buyWithPointButton);

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
            case "Buy":
                //
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
