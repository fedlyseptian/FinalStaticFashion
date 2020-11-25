package view;

import controller.ControllerDatabase;
import model.MemberManager;
import model.SellerManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainMenus.mindfullyFont;

public class MemberTopUp implements ActionListener {

    JFrame frame = new JFrame(" --> Top Up");
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelMemberTitle = new JPanel();
    JPanel panelForm = new JPanel(new GridLayout(4, 1, 10, 20));

    JLabel lblTitle = new JLabel("- Top Up");

    JLabel lblBalanceMember = new JLabel();
    JTextField txtBalanceMember = new JTextField();

    JLabel lblPointMember = new JLabel();

    JButton topUpButton = new JButton("Top Up");
    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("<<<");

    static double tempBalanceValue;

    public MemberTopUp() {
        // label Balance
        lblBalanceMember.setText("Your Balance: "+MemberManager.getInstance().getMember().getMoney());
        lblPointMember.setText("Your Point: "+MemberManager.getInstance().getMember().getPoint());

        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        // Set Padding
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));

        // Title
        lblTitle.setFont(mindfullyFont);
        lblTitle.setFont(lblTitle.getFont().deriveFont(50f));
        lblTitle.setForeground(new Color(255, 145, 0));
        panelMemberTitle.add(lblTitle);
        panelMemberTitle.setBackground(new Color(0, 0, 0, 0));

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

        // Balance Label
        lblBalanceMember.setFont(new Font("Arial", Font.BOLD, 20));
        lblBalanceMember.setForeground(Color.WHITE);
        lblPointMember.setFont(new Font("Arial", Font.BOLD, 20));
        lblPointMember.setForeground(Color.WHITE);

        // Balance Text Field
        txtBalanceMember.setVisible(false);
//        txtBalanceMember.setText(String.valueOf(MemberManager.getInstance().getMember().getMoney()));

        // Form Tax Value
        panelForm.add(lblBalanceMember);
        panelForm.add(lblPointMember);
        panelForm.add(txtBalanceMember);

        // Edit Button
        topUpButton.setActionCommand("TopUp");
        topUpButton.addActionListener(this);
        panelForm.add(topUpButton);

        // Submit Button
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(this);
        submitButton.setVisible(false);
        panelForm.add(submitButton);

        // Panel Form
        panelForm.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40));
        panelForm.setPreferredSize(new Dimension(450, 550));
        panelForm.setBackground(new Color(0, 0, 0, 0));

        // Add to Panel
        panel.add(panelMemberTitle, BorderLayout.NORTH);
        panel.add(panelForm, BorderLayout.CENTER);

        panel.setBackground(Color.BLACK);

        frame.add(backButton);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(panel);
        frame.setSize(400, 500);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "TopUp":
//                tempBalanceValue = Double.parseDouble(txtBalanceMember.getText());
                txtBalanceMember.setVisible(true);
                submitButton.setVisible(true);
                topUpButton.setVisible(false);
                break;
            case "Submit":
                if (Double.parseDouble(txtBalanceMember.getText()) >= 0.0) {
                    if (ControllerDatabase.updateMoney(MemberManager.getInstance().getMember().getUsername(),(Double.parseDouble(txtBalanceMember.getText())+MemberManager.getInstance().getMember().getMoney()))){
                        MemberManager.getInstance().getMember().setMoney(Double.parseDouble(txtBalanceMember.getText())+MemberManager.getInstance().getMember().getMoney());
                        new MemberTopUp();
                        frame.dispose();
                    }
                } else {
                    lblBalanceMember.setText("Tax Value : (ERROR)");
                }
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
