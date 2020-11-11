package view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterScreenMenu implements ActionListener {

    //Deklarasi
    JFrame frame = new JFrame("Register");
    JPanel panelTopMember = new JPanel();
    JPanel panelLeftMember = new JPanel();
    JPanel panelRightMember = new JPanel();
    JPanel panelBottomMember = new JPanel();
    JPanel panelCenterMember = new JPanel(new GridLayout(16,1));
    JPanel panelTanggalLahir = new JPanel(new GridLayout(1, 3));

    //Title
    JLabel labelTitleMember = new JLabel("Register Member");

    //Username
    JLabel labelUsernameMember = new JLabel("Username");
    JTextField isiUsernameMember = new JTextField("");
    //Password
    JLabel labelPasswordMember = new JLabel("Password");
    JPasswordField isiPasswordMember = new JPasswordField();
    //Name
    JLabel labelNameMember = new JLabel("Name");
    JTextField isiNameMember = new JTextField("");
    //Address
    JLabel labelAddressMember = new JLabel("Address");
    JTextField isiAddressMember = new JTextField("");
    //Gender
    JLabel labelJenisKelamin = new JLabel("Jenis Kelamin");
    JRadioButton radioPria, radioWanita;
    ButtonGroup groupJK;
    //Email
    JLabel labelEmailMember = new JLabel("Email");
    JTextField isiEmailMember = new JTextField("");
    //Tanggal Lahir
    JLabel labelTanggalLahirMember = new JLabel("Tanggal Lahir");
    JSpinner spinnerTanggal, spinnerBulan, spinnerTahun;

    JButton backButton = new JButton("<<< Back to Main Menu");
    JButton memberButton = new JButton("Become a Member");
    JButton sellerButton = new JButton("Become a Seller");

    public RegisterScreenMenu(){
        frame.setSize(700,600);
        frame.setLayout(new BorderLayout());

        // Set Panel Size
        panelTopMember.setPreferredSize(new Dimension(700,80));
        panelLeftMember.setPreferredSize(new Dimension(100, 320));
        panelCenterMember.setPreferredSize(new Dimension(460, 320));
        panelRightMember.setPreferredSize(new Dimension(100, 320));
        panelBottomMember.setPreferredSize(new Dimension(700, 80));
        panelTanggalLahir.setPreferredSize(new Dimension(700, 80));

        panelTopMember.setBackground(Color.ORANGE);
        panelLeftMember.setBackground(Color.BLACK);
        panelCenterMember.setBackground(Color.BLACK);
        panelRightMember.setBackground(Color.BLACK);
        panelBottomMember.setBackground(Color.BLACK);
        panelTanggalLahir.setBackground(Color.BLACK);

        //Title
        labelTitleMember.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitleMember.setForeground(new Color(0,0,0));
        labelTitleMember.setHorizontalAlignment(JLabel.CENTER);
        panelTopMember.add(labelTitleMember);

        //Username
        labelUsernameMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelUsernameMember.setHorizontalAlignment(JLabel.LEFT);
        labelUsernameMember.setForeground(new Color(255,255,255));
        panelCenterMember.add(labelUsernameMember);
        panelCenterMember.add(isiUsernameMember);

        //Password
        labelPasswordMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelPasswordMember.setHorizontalAlignment(JLabel.LEFT);
        labelPasswordMember.setForeground(new Color(255,255,255));
        panelCenterMember.add(labelPasswordMember);
        panelCenterMember.add(isiPasswordMember);

        //Name
        labelNameMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelNameMember.setHorizontalAlignment(JLabel.LEFT);
        labelNameMember.setForeground(new Color(255,255,255));
        panelCenterMember.add(labelNameMember);
        panelCenterMember.add(isiNameMember);

        //Address
        labelAddressMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelAddressMember.setHorizontalAlignment(JLabel.LEFT);
        labelAddressMember.setForeground(new Color(255,255,255));
        panelCenterMember.add(labelAddressMember);
        panelCenterMember.add(isiAddressMember);

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

        panelCenterMember.add(labelJenisKelamin);
        panelCenterMember.add(radioPria);
        panelCenterMember.add(radioWanita);

        //Email
        labelEmailMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelEmailMember.setHorizontalAlignment(JLabel.LEFT);
        labelEmailMember.setForeground(new Color(255,255,255));
        panelCenterMember.add(labelEmailMember);
        panelCenterMember.add(isiEmailMember);

        //Tanggal Lahir : Cara get data spinner nya pakai getValue(), contoh spinnerTanggal.getValue()
        panelCenterMember.add(panelTanggalLahir);
        //Label Tanggal Lahir
        labelTanggalLahirMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelTanggalLahirMember.setHorizontalAlignment(JLabel.LEFT);
        labelTanggalLahirMember.setForeground(new Color(255,255,255));
        panelCenterMember.add(labelTanggalLahirMember);
        //Spinner Tanggal
        spinnerTanggal = new JSpinner(new SpinnerNumberModel(1,1,31,1));
        //Spinner Bulan
        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        spinnerBulan = new JSpinner(new SpinnerListModel(months));
        //Spinner Tahun
        spinnerTahun = new JSpinner();
        spinnerTahun.setValue(1999);

        panelTanggalLahir.add(spinnerTanggal);
        panelTanggalLahir.add(spinnerBulan);
        panelTanggalLahir.add(spinnerTahun);
        panelCenterMember.add(panelTanggalLahir);

        //Back Button
        backButton.setFont(new Font("Arial", Font.ITALIC, 15));
        backButton.setForeground(Color.RED);
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);

        //Member Button
        memberButton.setFont(new Font("Arial", Font.BOLD, 15));
        memberButton.setActionCommand("BeMember");
        memberButton.addActionListener(this);

        //Seller Button
        sellerButton.setFont(new Font("Arial", Font.BOLD, 15));
        sellerButton.setActionCommand("BeSeller");
        sellerButton.addActionListener(this);

        panelBottomMember.add(backButton);
        panelBottomMember.add(memberButton);
        panelBottomMember.add(sellerButton);

        frame.add(panelTopMember,BorderLayout.NORTH);
        frame.add(panelLeftMember,BorderLayout.WEST);
        frame.add(panelCenterMember,BorderLayout.CENTER);
        frame.add(panelRightMember,BorderLayout.EAST);
        frame.add(panelBottomMember,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "BeMember":
                // Add data to database
                new ShoppingScreenMenu();
                frame.dispose();
                break;
            case "BeSeller":
                // Pass data to next frame
                new RegisterScreenSeller();
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
