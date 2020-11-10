package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterScreenSeller implements ActionListener {

    //Deklarasi
    JFrame frame = new JFrame("Register");
    JPanel panelTopSeller = new JPanel();
    JPanel panelLeftSeller = new JPanel();
    JPanel panelRightSeller = new JPanel();
    JPanel panelBottomSeller = new JPanel();
    JPanel panelCenterSeller = new JPanel(new GridLayout(18,1));

    //Title
    JLabel labelTitleSeller = new JLabel("Register Seller");

    //Username
    JLabel labelUsernameSeller = new JLabel("Username");
    JTextField isiUsernameSeller = new JTextField("");
    //Password
    JLabel labelPasswordSeller = new JLabel("Password");
    JPasswordField isiPasswordSeller = new JPasswordField();
    //Name
    JLabel labelNameSeller = new JLabel("Name");
    JTextField isiNameSeller = new JTextField("");
    //Address
    JLabel labelAddressSeller = new JLabel("Address");
    JTextField isiAddressSeller = new JTextField("");
    //Gender
    JLabel labelJenisKelamin = new JLabel("Jenis Kelamin");
    JRadioButton radioPria, radioWanita;
    ButtonGroup groupJK;
    //Email
    JLabel labelEmailSeller = new JLabel("Email");
    JTextField isiEmailSeller = new JTextField("");
    //Tanggal Lahir
    JLabel labelTanggalLahirSeller = new JLabel("Tanggal Lahir");
    JTextField isiTanggalLahirSeller = new JTextField("");
    //StoreName
    JLabel labelStoreName = new JLabel("Store Name");
    JTextField isiStoreName = new JTextField("");

    JButton backButton = new JButton("<<< Back to Main Menu");
    JButton memberButton = new JButton("Back to Member");
    JButton sellerButton = new JButton("Become a Seller");

    public RegisterScreenSeller(){
        frame.setSize(700,600);
        frame.setLayout(new BorderLayout());


        panelTopSeller.setPreferredSize(new Dimension(700,80));
        panelLeftSeller.setPreferredSize(new Dimension(100, 320));
        panelCenterSeller.setPreferredSize(new Dimension(460, 320));
        panelRightSeller.setPreferredSize(new Dimension(100, 320));
        panelBottomSeller.setPreferredSize(new Dimension(700, 80));

        panelTopSeller.setBackground(Color.ORANGE);
        panelLeftSeller.setBackground(Color.BLACK);
        panelCenterSeller.setBackground(Color.BLACK);
        panelRightSeller.setBackground(Color.BLACK);
        panelBottomSeller.setBackground(Color.BLACK);

        //Title
        labelTitleSeller.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitleSeller.setForeground(new Color(0,0,0));
        labelTitleSeller.setHorizontalAlignment(JLabel.CENTER);
        panelTopSeller.add(labelTitleSeller);

        //Username
        labelUsernameSeller.setFont(new Font("Arial", Font.BOLD, 15));
        labelUsernameSeller.setHorizontalAlignment(JLabel.LEFT);
        labelUsernameSeller.setForeground(new Color(255,255,255));
        panelCenterSeller.add(labelUsernameSeller);
        panelCenterSeller.add(isiUsernameSeller);

        //Password
        labelPasswordSeller.setFont(new Font("Arial", Font.BOLD, 15));
        labelPasswordSeller.setHorizontalAlignment(JLabel.LEFT);
        labelPasswordSeller.setForeground(new Color(255,255,255));
        panelCenterSeller.add(labelPasswordSeller);
        panelCenterSeller.add(isiPasswordSeller);

        //Name
        labelNameSeller.setFont(new Font("Arial", Font.BOLD, 15));
        labelNameSeller.setHorizontalAlignment(JLabel.LEFT);
        labelNameSeller.setForeground(new Color(255,255,255));
        panelCenterSeller.add(labelNameSeller);
        panelCenterSeller.add(isiNameSeller);

        //Address
        labelAddressSeller.setFont(new Font("Arial", Font.BOLD, 15));
        labelAddressSeller.setHorizontalAlignment(JLabel.LEFT);
        labelAddressSeller.setForeground(new Color(255,255,255));
        panelCenterSeller.add(labelAddressSeller);
        panelCenterSeller.add(isiAddressSeller);

        //Gender
        labelJenisKelamin.setFont(new Font("Arial", Font.BOLD, 15));
        labelJenisKelamin.setHorizontalAlignment(JLabel.LEFT);
        labelJenisKelamin.setForeground(new Color(255,255,255));
        radioPria = new JRadioButton("Pria", true);
        radioWanita = new JRadioButton("Wanita");
        radioPria.setForeground(new Color(255, 255, 255));
        radioWanita.setForeground(new Color(255, 255, 255));
        radioPria.setBackground(Color.BLACK);
        radioWanita.setBackground(Color.BLACK);

        groupJK = new ButtonGroup();
        groupJK.add(radioPria);
        groupJK.add(radioWanita);

        panelCenterSeller.add(labelJenisKelamin);
        panelCenterSeller.add(radioPria);
        panelCenterSeller.add(radioWanita);

        //Email
        labelEmailSeller.setFont(new Font("Arial", Font.BOLD, 15));
        labelEmailSeller.setHorizontalAlignment(JLabel.LEFT);
        labelEmailSeller.setForeground(new Color(255,255,255));
        panelCenterSeller.add(labelEmailSeller);
        panelCenterSeller.add(isiEmailSeller);

        //Tanggal Lahir
        labelTanggalLahirSeller.setFont(new Font("Arial", Font.BOLD, 15));
        labelTanggalLahirSeller.setHorizontalAlignment(JLabel.LEFT);
        labelTanggalLahirSeller.setForeground(new Color(255,255,255));
        panelCenterSeller.add(labelTanggalLahirSeller);
        panelCenterSeller.add(isiTanggalLahirSeller);

        //StoreName
        labelStoreName.setFont(new Font("Arial", Font.BOLD, 15));
        labelStoreName.setHorizontalAlignment(JLabel.LEFT);
        labelStoreName.setForeground(new Color(255,255,255));
        panelCenterSeller.add(labelStoreName);
        panelCenterSeller.add(isiStoreName);

        backButton.setFont(new Font("Arial", Font.ITALIC, 15));
        backButton.setForeground(Color.RED);
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);

        memberButton.setFont(new Font("Arial", Font.BOLD, 15));
        memberButton.setActionCommand("BeMember");
        memberButton.addActionListener(this);

        sellerButton.setFont(new Font("Arial", Font.BOLD, 15));
        sellerButton.setActionCommand("BeSeller");
        sellerButton.addActionListener(this);

        panelBottomSeller.add(backButton);
        panelBottomSeller.add(memberButton);
        panelBottomSeller.add(sellerButton);

        frame.add(panelTopSeller,BorderLayout.NORTH);
        frame.add(panelLeftSeller,BorderLayout.WEST);
        frame.add(panelCenterSeller,BorderLayout.CENTER);
        frame.add(panelRightSeller,BorderLayout.EAST);
        frame.add(panelBottomSeller,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "BeMember":
                // Pass data to next frame
                new RegisterScreenMenu();
                frame.dispose();
                break;
            case "BeSeller":
                // Add data to database
                // New FRAME
                frame.dispose();
                break;
            case "Back":
                new MainMenus();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
