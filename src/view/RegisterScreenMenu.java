package view;

import javax.swing.*;
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
    JTextField isiTanggalLahirMember = new JTextField("");

    JButton memberButton = new JButton("Become a Member");

    public RegisterScreenMenu(){
        frame.setSize(700,600);
        frame.setLayout(new BorderLayout());


        panelTopMember.setPreferredSize(new Dimension(700,80));
        panelLeftMember.setPreferredSize(new Dimension(100, 320));
        panelCenterMember.setPreferredSize(new Dimension(460, 320));
        panelRightMember.setPreferredSize(new Dimension(100, 320));
        panelBottomMember.setPreferredSize(new Dimension(700, 80));

        panelTopMember.setBackground(Color.ORANGE);
        panelLeftMember.setBackground(Color.BLACK);
        panelCenterMember.setBackground(Color.BLACK);
        panelRightMember.setBackground(Color.BLACK);
        panelBottomMember.setBackground(Color.BLACK);

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

        //Tanggal Lahir
        labelTanggalLahirMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelTanggalLahirMember.setHorizontalAlignment(JLabel.LEFT);
        labelTanggalLahirMember.setForeground(new Color(255,255,255));
        panelCenterMember.add(labelTanggalLahirMember);
        panelCenterMember.add(isiTanggalLahirMember);

        memberButton.setFont(new Font("Arial", Font.BOLD, 15));

        panelBottomMember.add(memberButton);

        frame.add(panelTopMember,BorderLayout.NORTH);
        frame.add(panelLeftMember,BorderLayout.WEST);
        frame.add(panelCenterMember,BorderLayout.CENTER);
        frame.add(panelRightMember,BorderLayout.EAST);
        frame.add(panelBottomMember,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public static void main(String[] args) {
        new RegisterScreenMenu();
    }
}
