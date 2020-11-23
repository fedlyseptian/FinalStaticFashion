package view;

import controller.ControllerDatabase;
import controller.DatabaseHandler;
import model.Transactions;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static view.MainMenus.mindfullyFont;

public class AdminHistory implements ActionListener {
    static DatabaseHandler conn = new DatabaseHandler();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());

    JPanel panelTitle = new JPanel();
    JPanel panelTransaction = new JPanel();

    BoxLayout boxLayout = new BoxLayout(panelTransaction, BoxLayout.Y_AXIS);
    JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    JLabel lblTitle = new JLabel("History");
    JButton backButton = new JButton("<<<");

    String [] column = {"ProductID", "Quantity", "Total"};

    public AdminHistory() {

        panel.setBorder(new LineBorder(Color.BLACK, 20));
        panelTransaction.setLayout(boxLayout);

        lblTitle.setFont(mindfullyFont);
        lblTitle.setForeground(new Color(255, 145, 0));

        ArrayList<Transactions> listTransaction = ControllerDatabase.getAllTransaction();
        for (int i = 0; i < listTransaction.size(); i++) {

            // Panel Declaration
            JPanel transactionContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel panelDesc = new JPanel(new GridLayout(3, 3));
            JPanel panelTableHeader = new JPanel(new GridLayout(1,4));
            JPanel panelTable = new JPanel(new GridLayout(1,1));

            // Border Separator
            transactionContainer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.ORANGE));

            // Set Panel Dimension

            panelDesc.setPreferredSize(new Dimension(1200, 180));
            panelTableHeader.setPreferredSize(new Dimension(1200, 60));


            // --> TransactionID
            JLabel labelTransactionID = new JLabel(listTransaction.get(i).getTransactionID());
            labelTransactionID.setFont(new Font("Arial", Font.BOLD, 25));
            labelTransactionID.setForeground(Color.WHITE);

            // --> Username
            JLabel labelUsername = new JLabel(listTransaction.get(i).getUsername());
            labelUsername.setFont(new Font("Arial", Font.BOLD, 25));
            labelUsername.setForeground(Color.WHITE);

            // --> DiscountID
            JLabel labelDiscountID = new JLabel("DiscountID: "+listTransaction.get(i).getDiscountID());
            labelDiscountID.setFont(new Font("Arial", Font.BOLD, 25));
            labelDiscountID.setForeground(Color.WHITE);

            // --> TransactionDate
            JLabel labelTransactionDate= new JLabel("Date: "+(listTransaction.get(i).getY())+"-"+(listTransaction.get(i).getM())+"-"+listTransaction.get(i).getD());
            labelTransactionDate.setFont(new Font("Arial", Font.BOLD, 25));
            labelTransactionDate.setForeground(Color.WHITE);

            // --> PaymentOption
            JLabel labelPaymentOption= new JLabel("Payment Option: "+String.valueOf(listTransaction.get(i).getPaymentOption()));
            labelPaymentOption.setFont(new Font("Arial", Font.BOLD, 25));
            labelPaymentOption.setForeground(Color.WHITE);

            // --> SubTotal
            JLabel labelSubTotal = new JLabel("Total: "+String.valueOf(listTransaction.get(i).getSubTotal()));
            labelSubTotal.setFont(new Font("Arial", Font.BOLD, 25));
            labelSubTotal.setForeground(Color.WHITE);

            JLabel labelID = new JLabel("TransactionID");
            labelID.setFont(new Font("Arial", Font.BOLD, 20));
            labelID.setForeground(Color.WHITE);

            JLabel labelProductID = new JLabel("ProductID");
            labelProductID.setFont(new Font("Arial", Font.BOLD, 20));
            labelProductID.setForeground(Color.WHITE);

            JLabel labelQuantity = new JLabel("Quantity");
            labelQuantity.setFont(new Font("Arial", Font.BOLD, 20));
            labelQuantity.setForeground(Color.WHITE);

            JLabel labelSubTot = new JLabel("SubTotal");
            labelSubTot.setFont(new Font("Arial", Font.BOLD, 20));
            labelSubTot.setForeground(Color.WHITE);

            // Transparent background
            transactionContainer.setBackground(new Color(0,0,0,0));
            panelDesc.setBackground(new Color(0, 0, 0,0));
            panelTable.setBackground(new Color(0,0,0,0));
            panelTableHeader.setBackground(new Color(0,0,0,0));

            panelDesc.add(labelTransactionID);
            panelDesc.add(labelUsername);
            panelDesc.add(labelDiscountID);
            panelDesc.add(labelTransactionDate);
            panelDesc.add(labelPaymentOption);
            panelDesc.add(labelSubTotal);

            panelTableHeader.add(labelID);
            panelTableHeader.add(labelProductID);
            panelTableHeader.add(labelQuantity);
            panelTableHeader.add(labelSubTot);

            conn.connect();
            JTable table = new JTable();
            String query = "SELECT * FROM listProduct WHERE transactionID='"+listTransaction.get(i).getTransactionID()+"'";
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                table = new JTable(ControllerDatabase.buildTableModel(rs));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            table.setRowHeight(40);
            table.setBackground(new Color(0,0,0,0));
            table.setForeground(Color.WHITE);
            table.setFont(new Font("Arial", Font.BOLD, 20));
            table.setGridColor(Color.BLACK);
            panelTable.setPreferredSize(new Dimension(1200,(table.getRowCount()*40)));
            panelTable.add(table);

            transactionContainer.setPreferredSize(new Dimension(1200, (table.getRowCount()*40+270)));
            transactionContainer.add(panelDesc);
            transactionContainer.add(panelTableHeader);
            transactionContainer.add(panelTable);
//            transactionContainer.add(panelTable);

            panelTransaction.add(transactionContainer);
        }

        panelTitle.add(lblTitle);

        // Transaparent Child Background
        panelTitle.setBackground(new Color(0,0,0,0));
        panelTransaction.setBackground(new Color(0,0,0,0));

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
        panel.add(panelTransaction, BorderLayout.CENTER);
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
            case "Back":
                new MainMenus();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
