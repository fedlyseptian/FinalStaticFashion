package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterScreenMenu implements ActionListener {

    //Deklarasi
    JFrame frame = new JFrame("Register");
    JTabbedPane tabPanel = new JTabbedPane();
//    JPanel panelTitleMember = new JPanel();
//    JPanel panelTitleSeller = new JPanel();
    JPanel panelMember = new JPanel(new GridLayout(3,1, 2, 2));
    JPanel panelSeller = new JPanel(new GridLayout(3,1, 2, 2));

    JButton memberButton = new JButton("Become a Member");
    JButton sellerButton = new JButton("Become a Seller");

    //Title
    JLabel labelTitleMember = new JLabel("Register Form Member");
    JLabel labelTitleSeller = new JLabel("Register Form Seller");

    JPanel panelFormMember = new JPanel(new GridLayout(10, 1, 5, 2));
    JPanel panelFormSeller = new JPanel(new GridLayout(10, 1, 5, 2));
    //Username
    JLabel labelUsernameMember = new JLabel("Username");
    JTextField isiUsernameMember = new JTextField("");
    JLabel labelUsernameSeller = new JLabel("Username");
    JTextField isiUsernameSeller = new JTextField("");
    //Password
    JLabel labelPasswordMember = new JLabel("Password");
    JPasswordField isiPasswordMember = new JPasswordField();
    JLabel labelPasswordSeller = new JLabel("Password");
    JPasswordField isiPasswordSeller = new JPasswordField();
    //Name
    JLabel labelNameMember = new JLabel("Name");
    JTextField isiNameMember = new JTextField("");
    JLabel labelNameSeller = new JLabel("Name");
    JTextField isiNameSeller = new JTextField("");
    //Address
    JLabel labelAddressMember = new JLabel("Address");
    JTextField isiAddressMember = new JTextField("");
    JLabel labelAddressSeller = new JLabel("Address");
    JTextField isiAddressSeller = new JTextField("");
    //Gender
    JLabel labelGenderMember = new JLabel("Gender");
    JTextField isiGenderMember = new JTextField("");
    JLabel labelGenderSeller = new JLabel("Gender");
    JTextField isiGenderSeller = new JTextField("");
    //Email
    JLabel labelEmailMember = new JLabel("Email");
    JTextField isiEmailMember = new JTextField("");
    JLabel labelEmailSeller = new JLabel("Email");
    JTextField isiEmailSeller = new JTextField("");
    //Tanggal Lahir
    JLabel labelTanggalLahirMember = new JLabel("Tanggal Lahir");
    JTextField isiTanggalLahirMember = new JTextField("");
    JLabel labelTanggalLahirSeller = new JLabel("Tanggal Lahir");
    JTextField isiTanggalLahirSeller = new JTextField("");
    //storeName just for Seller
    JLabel labelStoreName = new JLabel("Store Name");
    JTextField isiStoreName = new JTextField("");

    public RegisterScreenMenu(){

        tabPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        //Title
        labelTitleMember.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitleMember.setHorizontalAlignment(JLabel.CENTER);
        panelMember.add(labelTitleMember);
        labelTitleSeller.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitleSeller.setHorizontalAlignment(JLabel.CENTER);
        panelSeller.add(labelTitleSeller);

        //Username
        labelUsernameMember.setFont(new Font("Arial", Font.BOLD, 20));
        labelUsernameMember.setHorizontalAlignment(JLabel.RIGHT);
        panelFormMember.add(labelUsernameMember);
        panelFormMember.add(isiUsernameMember);
        labelUsernameSeller.setFont(new Font("Arial", Font.BOLD, 20));
        labelUsernameSeller.setHorizontalAlignment(JLabel.RIGHT);
        panelFormSeller.add(labelUsernameSeller);
        panelFormSeller.add(isiUsernameSeller);

        //Password
        labelPasswordMember.setFont(new Font("Arial", Font.BOLD, 20));
        labelPasswordMember.setHorizontalAlignment(JLabel.RIGHT);
        panelFormMember.add(labelPasswordMember);
        panelFormMember.add(isiPasswordMember);
        labelPasswordSeller.setFont(new Font("Arial", Font.BOLD, 20));
        labelPasswordSeller.setHorizontalAlignment(JLabel.RIGHT);
        panelFormSeller.add(labelPasswordSeller);
        panelFormSeller.add(isiPasswordSeller);

        //Name
        labelNameMember.setFont(new Font("Arial", Font.BOLD, 20));
        labelNameMember.setHorizontalAlignment(JLabel.RIGHT);
        panelFormMember.add(labelNameMember);
        panelFormMember.add(isiNameMember);
        labelNameSeller.setFont(new Font("Arial", Font.BOLD, 20));
        labelNameSeller.setHorizontalAlignment(JLabel.RIGHT);
        panelFormSeller.add(labelNameSeller);
        panelFormSeller.add(isiNameSeller);

        //storeName
        labelStoreName.setFont(new Font("Arial", Font.BOLD, 20));
        labelStoreName.setHorizontalAlignment(JLabel.RIGHT);
        panelFormSeller.add(labelStoreName);
        panelFormSeller.add(isiStoreName);

        //Address
        labelAddressMember.setFont(new Font("Arial", Font.BOLD, 20));
        labelAddressMember.setHorizontalAlignment(JLabel.RIGHT);
        panelFormMember.add(labelAddressMember);
        panelFormMember.add(isiAddressMember);
        labelAddressSeller.setFont(new Font("Arial", Font.BOLD, 20));
        labelAddressSeller.setHorizontalAlignment(JLabel.RIGHT);
        panelFormSeller.add(labelAddressSeller);
        panelFormSeller.add(isiAddressSeller);

        //Gender
        labelGenderMember.setFont(new Font("Arial", Font.BOLD, 20));
        labelGenderMember.setHorizontalAlignment(JLabel.RIGHT);
        panelFormMember.add(labelGenderMember);
        panelFormMember.add(isiGenderMember);
        labelGenderSeller.setFont(new Font("Arial", Font.BOLD, 20));
        labelGenderSeller.setHorizontalAlignment(JLabel.RIGHT);
        panelFormSeller.add(labelGenderSeller);
        panelFormSeller.add(isiGenderSeller);

        //Email
        labelEmailMember.setFont(new Font("Arial", Font.BOLD, 20));
        labelEmailMember.setHorizontalAlignment(JLabel.RIGHT);
        panelFormMember.add(labelEmailMember);
        panelFormMember.add(isiEmailMember);
        labelEmailSeller.setFont(new Font("Arial", Font.BOLD, 20));
        labelEmailSeller.setHorizontalAlignment(JLabel.RIGHT);
        panelFormSeller.add(labelEmailSeller);
        panelFormSeller.add(isiEmailSeller);

        //Tanggal Lahir
        labelTanggalLahirMember.setFont(new Font("Arial", Font.BOLD, 20));
        labelTanggalLahirMember.setHorizontalAlignment(JLabel.RIGHT);
        panelFormMember.add(labelTanggalLahirMember);
        panelFormMember.add(isiTanggalLahirMember);
        labelTanggalLahirSeller.setFont(new Font("Arial", Font.BOLD, 20));
        labelTanggalLahirSeller.setHorizontalAlignment(JLabel.RIGHT);
        panelFormSeller.add(labelTanggalLahirSeller);
        panelFormSeller.add(isiTanggalLahirSeller);


        panelMember.add(panelFormMember);
        panelSeller.add(panelFormSeller);

        memberButton.setFont(new Font("Arial", Font.BOLD, 20));
        sellerButton.setFont(new Font("Arial", Font.BOLD, 20));

        panelMember.add(memberButton);
        panelSeller.add(sellerButton);

        tabPanel.add("Member", panelMember);
        tabPanel.add("Seller", panelSeller);

        frame.add(tabPanel);
        frame.setSize(900,700);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
