package view;

import controller.ControllerDatabase;
import model.Seller;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static view.MainMenus.mindfullyFont;

public class AdminStore implements ActionListener {

    JFrame frame = new JFrame("Admin --> Store");
    JPanel panel = new JPanel(new BorderLayout());

    JPanel panelTitle = new JPanel();
    JPanel panelStore = new JPanel();

    BoxLayout boxLayout = new BoxLayout(panelStore, BoxLayout.Y_AXIS);
    JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JLabel lblTitle = new JLabel("Admin - Store");

    JButton backButton = new JButton("<<<");

    public AdminStore() {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        panel.setBorder(new LineBorder(Color.BLACK, 20));
        panelStore.setLayout(boxLayout);

        lblTitle.setFont(mindfullyFont);
        lblTitle.setForeground(new Color(255, 145, 0));

        // Loop through seller list
        ArrayList<Seller> listSeller = ControllerDatabase.getAllSellers();
        for (int i = 0; i < listSeller.size(); i++) {
            // Panel Declaration
            JPanel storeContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel panelImg = new JPanel();
            JPanel panelDesc = new JPanel(new GridLayout(2, 1));
            JPanel panelButton = new JPanel(new GridLayout(1, 1));

            // Border Separator
            storeContainer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.ORANGE));

            // Set Panel Dimension
            storeContainer.setPreferredSize(new Dimension(1200, 200));
            panelImg.setPreferredSize(new Dimension(200, 200));
            panelDesc.setPreferredSize(new Dimension(780, 120));
            panelButton.setPreferredSize(new Dimension(250, 30));

            // Store Logo
            JLabel labelImg = new JLabel();
            labelImg.setIcon(new ImageIcon(new ImageIcon(listSeller.get(i).getPathLogo()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

            // Seller Data
            // --> Name
            JLabel labelStoreName = new JLabel(listSeller.get(i).getStoreName());
            labelStoreName.setFont(new Font("Arial", Font.BOLD, 25));
            labelStoreName.setForeground(Color.WHITE);

            // --> Brand
            JLabel labelOwner = new JLabel(("Owner : " + listSeller.get(i).getUsername()));
            labelOwner.setFont(new Font("Arial", Font.PLAIN, 20));
            labelOwner.setForeground(Color.WHITE);

            // --> Next Button
            JButton productButton = new JButton("> " + listSeller.get(i).getStoreName());

            int finalI = i;
            productButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new EditSeller(listSeller.get(finalI).getStoreName());
                    frame.dispose();
                }
            });

            // Transparent background
            storeContainer.setBackground(new Color(0,0,0, 0));
            panelImg.setBackground(new Color(0, 0, 0, 0));
            panelDesc.setBackground(new Color(0, 0, 0, 0));
            panelButton.setBackground(new Color(0,0,0, 0));

            // Add to main panel
            panelImg.add(labelImg);

            panelDesc.add(labelStoreName);
            panelDesc.add(labelOwner);

            panelButton.add(productButton);

            storeContainer.add(panelImg);
            storeContainer.add(panelDesc);
            storeContainer.add(panelButton);

            panelStore.add(storeContainer);
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
