package view;

import controller.Controller;
import controller.ControllerDatabase;
import model.Admin;
import model.Member;
import model.MemberManager;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class MemberEditMember implements ActionListener {

    //Deklarasi
    JFrame frame = new JFrame("Edit Data Member");
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
    JLabel isiUsernameMember = new JLabel("");
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

    JButton backButton = new JButton("<<< Back to Member Menu");
    JButton updateButton = new JButton("Update");

    public MemberEditMember(){

        System.out.println(MemberManager.getInstance().getMember().getMoney());
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

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
        isiUsernameMember.setText(MemberManager.getInstance().getMember().getUsername());
        isiUsernameMember.setFont(new Font("Arial", Font.BOLD, 15));
        isiUsernameMember.setHorizontalAlignment(JLabel.LEFT);
        isiUsernameMember.setForeground(new Color(255,255,255));
        panelCenterMember.add(labelUsernameMember);
        panelCenterMember.add(isiUsernameMember);

        //Password
        labelPasswordMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelPasswordMember.setHorizontalAlignment(JLabel.LEFT);
        labelPasswordMember.setForeground(new Color(255,255,255));
        isiPasswordMember.setText(MemberManager.getInstance().getPassword());
        panelCenterMember.add(labelPasswordMember);
        panelCenterMember.add(isiPasswordMember);

        //Name
        labelNameMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelNameMember.setHorizontalAlignment(JLabel.LEFT);
        labelNameMember.setForeground(new Color(255,255,255));
        isiNameMember.setText(MemberManager.getInstance().getMember().getName());
        panelCenterMember.add(labelNameMember);
        panelCenterMember.add(isiNameMember);

        //Address
        labelAddressMember.setFont(new Font("Arial", Font.BOLD, 15));
        labelAddressMember.setHorizontalAlignment(JLabel.LEFT);
        labelAddressMember.setForeground(new Color(255,255,255));
        isiAddressMember.setText(MemberManager.getInstance().getMember().getAddress());
        panelCenterMember.add(labelAddressMember);
        panelCenterMember.add(isiAddressMember);

        //Gender
        labelJenisKelamin.setFont(new Font("Arial", Font.BOLD, 15));
        labelJenisKelamin.setHorizontalAlignment(JLabel.LEFT);
        labelJenisKelamin.setForeground(new Color(255,255,255));
        radioPria = new JRadioButton("Pria", true);
        radioPria.setActionCommand("L");
        radioWanita = new JRadioButton("Wanita");
        radioWanita.setActionCommand("P");
        radioPria.setForeground(new Color(255, 255, 255));
        radioWanita.setForeground(new Color(255, 255, 255));
        if(MemberManager.getInstance().getMember().getGender().equals("L")){
            radioPria.setSelected(true);
        }else if(MemberManager.getInstance().getMember().getGender().equals("P")){
            radioWanita.setSelected(true);
        }
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
        isiEmailMember.setText(MemberManager.getInstance().getMember().getEmail());
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
        spinnerTanggal = new JSpinner(new SpinnerNumberModel(MemberManager.getInstance().getMember().getDay(),1,31,1));
        //Spinner Bulan
        String birthMonth = "";
        switch(MemberManager.getInstance().getMember().getMonth()){
            case 1:
                birthMonth = "January";
                break;
            case 2:
                birthMonth = "February";
                break;
            case 3:
                birthMonth = "March";
                break;
            case 4:
                birthMonth = "April";
                break;
            case 5:
                birthMonth = "May";
                break;
            case 6:
                birthMonth = "June";
                break;
            case 7:
                birthMonth = "July";
                break;
            case 8:
                birthMonth = "August";
                break;
            case 9:
                birthMonth = "September";
                break;
            case 10:
                birthMonth = "October";
                break;
            case 11:
                birthMonth = "November";
                break;
            case 12:
                birthMonth = "December";
                break;
            default:
        }

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        spinnerBulan = new JSpinner(new SpinnerListModel(months));
        spinnerBulan.setValue(birthMonth);
        //Spinner Tahun
        spinnerTahun = new JSpinner(new SpinnerNumberModel(MemberManager.getInstance().getMember().getYear(),1900,new Date().getYear()+1900,1));

        panelTanggalLahir.add(spinnerTanggal);
        panelTanggalLahir.add(spinnerBulan);
        panelTanggalLahir.add(spinnerTahun);
        panelCenterMember.add(panelTanggalLahir);

        //Back Button
        backButton.setFont(new Font("Arial", Font.ITALIC, 15));
        backButton.setForeground(Color.RED);
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);

        //Update Button
        updateButton.setFont(new Font("Arial", Font.BOLD, 15));
        updateButton.setActionCommand("update");
        updateButton.addActionListener(this);

        panelBottomMember.add(backButton);
        panelBottomMember.add(updateButton);

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
        ControllerDatabase controller = new ControllerDatabase();
        int month=-1;
        switch(spinnerBulan.getValue().toString()){
            case "January":
                month=1;
                break;
            case "February":
                month=2;
                break;
            case "March":
                month=3;
                break;
            case "April":
                month=4;
                break;
            case "May":
                month=5;
                break;
            case "June":
                month=6;
                break;
            case "July":
                month=7;
                break;
            case "August":
                month=8;
                break;
            case "September":
                month=9;
                break;
            case "October":
                month=10;
                break;
            case "November":
                month=11;
                break;
            case "December":
                month=12;
                break;
            default:
        }

        String pass = Controller.md5Java(Controller.toStringPass(isiPasswordMember.getPassword()));
        Member member = new Member(isiUsernameMember.getText(), pass,groupJK.getSelection().getActionCommand(),isiEmailMember.getText(),Integer.parseInt(spinnerTanggal.getValue().toString()),month,Integer.parseInt(spinnerTahun.getValue().toString()),isiNameMember.getText(),isiAddressMember.getText(),0,0);
        switch (command) {
            case "update":
                // Add data to database
                if(isiUsernameMember.getText().equals("") || pass.equals("") || isiEmailMember.getText().equals("") || isiNameMember.getText().equals("") || isiAddressMember.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill in the blank");
                    new RegisterScreenMenu();
                    frame.dispose();
                }else{
                    controller.deleteMember(member);
                    controller.insertMember(member);
                    MemberManager.getInstance().setMember(member);
                    new MemberMenu();
                    frame.dispose();
                }
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
