package view;

import controller.ControllerDatabase;
import model.Discount;
import model.Product;
import model.Seller;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static view.MainMenus.mindfullyFont;

public class AdminDiscount implements ActionListener {

    JFrame frame = new JFrame("Discount Menu");
    JPanel panel = new JPanel(new BorderLayout());

    JPanel panelTitle = new JPanel();
    JPanel panelStore = new JPanel();

    BoxLayout boxLayout = new BoxLayout(panelStore, BoxLayout.Y_AXIS);
    JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JLabel lblTitle = new JLabel("Discount Menu");

    JButton backButton = new JButton("<<<");

    public AdminDiscount() {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        panel.setBorder(new LineBorder(Color.BLACK, 20));
        panelStore.setLayout(boxLayout);

        lblTitle.setFont(mindfullyFont);
        lblTitle.setForeground(new Color(255, 145, 0));

        // Loop through discount list
        ArrayList<Discount> listDiscount = ControllerDatabase.getAllDiscount();
        for (int i = 0; i < listDiscount.size(); i++) {
            // Panel Declaration
            JPanel discountContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel panelDesc = new JPanel(new GridLayout(2, 1));
            JPanel panelButton = new JPanel(new GridLayout(1, 1));

            // Border Separator
            discountContainer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.ORANGE));

            // Set Panel Dimension
            discountContainer.setPreferredSize(new Dimension(1200, 100));
            panelDesc.setPreferredSize(new Dimension(970, 100));
            panelButton.setPreferredSize(new Dimension(250, 30));

            // Discounts Data
            // --> Discount ID
            JLabel labelDiscountID = new JLabel("Discount ID : " + listDiscount.get(i).getDiscountID());
            labelDiscountID.setFont(new Font("Arial", Font.BOLD, 25));
            labelDiscountID.setForeground(Color.WHITE);

            // --> Discount Value
            JLabel labelValue = new JLabel(("Value : " + listDiscount.get(i).getDiscountValue()));
            labelValue.setFont(new Font("Arial", Font.PLAIN, 20));
            labelValue.setForeground(Color.WHITE);

            // --> Next Button
            JButton productButton = new JButton("> " + listDiscount.get(i).getDiscountID());

            int finalI = i;
            productButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AdminEditDiscount(listDiscount.get(finalI).getDiscountID());
                    frame.dispose();
                }
            });

            // Transparent background
            discountContainer.setBackground(new Color(0,0,0, 0));
            panelDesc.setBackground(new Color(0, 0, 0, 0));
            panelButton.setBackground(new Color(0,0,0, 0));

            panelDesc.add(labelDiscountID);
            panelDesc.add(labelValue);

            panelButton.add(productButton);

            discountContainer.add(panelDesc);
            discountContainer.add(panelButton);

            panelStore.add(discountContainer);
        }

        panelTitle.add(lblTitle);

        // Transaparent Child Background
        panelTitle.setBackground(new Color(0,0,0,0));
        panelStore.setBackground(new Color(0,0,0,0));

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
        panel.add(panelStore, BorderLayout.CENTER);
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
                new AdminMenu();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
