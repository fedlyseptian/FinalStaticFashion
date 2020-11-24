package view;

import controller.ControllerDatabase;
import model.AdminManager;
import model.Discount;
import model.SellerManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

public class EditDiscount implements ActionListener {

    JFrame frame = new JFrame("Edit Discount");
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelAdminTitle = new JPanel();
    JPanel panelForm = new JPanel(new GridLayout(5, 1, 5, 5));

    JLabel lblTitle = new JLabel("Edit Discount");

    JLabel lblDiscountID = new JLabel("Discount ID");
    JTextField txtDiscountID = new JTextField();

    JLabel lblDiscountValue = new JLabel("Discount Value");
    JSpinner spinnerDiscountValue;

    JButton submitButton = new JButton("Save");
    JButton backButton = new JButton("<<<");

    static Discount discount;

//    public EditDiscount() {}

    public EditDiscount(String dID) {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        // Set Padding
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));

        // Title
        lblTitle.setFont(mindfullyFont);
        lblTitle.setForeground(new Color(255, 145, 0));
        panelAdminTitle.add(lblTitle);
        panelAdminTitle.setBackground(new Color(0, 0, 0, 0));

        // Back Button
        backButton.setBounds(5, 25, 75, 30);
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

        // Get Discount from Database
        discount = ControllerDatabase.getDiscount(dID);

        // Form
        lblDiscountID.setFont(new Font("Arial", Font.BOLD, 20));
        lblDiscountID.setBackground(Color.BLACK);
        lblDiscountID.setForeground(Color.WHITE);
        txtDiscountID.setEditable(false);
        txtDiscountID.setText(discount.getDiscountID());

        lblDiscountValue.setFont(new Font("Arial", Font.BOLD, 20));
        lblDiscountValue.setBackground(Color.BLACK);
        lblDiscountValue.setForeground(Color.WHITE);
        spinnerDiscountValue = new JSpinner(new SpinnerNumberModel(discount.getDiscountValue(), 0, 100 , 0.1));

        panelForm.add(lblDiscountID);
        panelForm.add(txtDiscountID);
        panelForm.add(lblDiscountValue);
        panelForm.add(spinnerDiscountValue);

        // Submit Button
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(this);
        panelForm.add(submitButton);

        // Panel Form
        panelForm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));
        panelForm.setPreferredSize(new Dimension(450, 550));
        panelForm.setBackground(new Color(0, 0, 0, 0));

        // Add to Panel
        panel.add(panelAdminTitle, BorderLayout.NORTH);
        panel.add(panelForm, BorderLayout.CENTER);

        panel.setBackground(Color.BLACK);

        frame.add(backButton);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(panel);
        frame.setSize(700, 800);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Submit":
                discount.setDiscountValue((Double) spinnerDiscountValue.getValue());
                ControllerDatabase.updateDiscount(discount);
                if(AdminManager.getInstance().getAdmin()!=null){
                    new AdminDiscount();
                } else if (SellerManager.getInstance().getSeller()!=null) {
                    new SellerMenu();
                } else {
                    new MainMenus();
                }
                frame.dispose();
                break;
            case "Back":
                if(AdminManager.getInstance().getAdmin()!=null){
                    new AdminDiscount();
                } else if (SellerManager.getInstance().getSeller()!=null) {
                    new SellerMenu();
                } else {
                    new MainMenus();
                }
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
