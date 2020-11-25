package view;

import controller.Controller;
import controller.ControllerDatabase;
import model.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterScreenSeller implements ActionListener {

    //Deklarasi
    JFrame frame = new JFrame("Register");
    JPanel panelTopSeller = new JPanel();
    JPanel panelLeftSeller = new JPanel();
    JPanel panelRightSeller = new JPanel();
    JPanel panelBottomSeller = new JPanel();
    JPanel panelCenterSeller = new JPanel(new GridLayout(18,1));
    JPanel panelTanggalLahir = new JPanel(new GridLayout(1, 3));

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
    JSpinner spinnerTanggal, spinnerBulan, spinnerTahun;
    //StoreName
    JLabel labelStoreName = new JLabel("Store Name");
    JTextField isiStoreName = new JTextField("");

    JButton backButton = new JButton("<<< Back to Main Menu");
    JButton memberButton = new JButton("Back to Member");
    JButton sellerButton = new JButton("Become a Seller");

    public RegisterScreenSeller(){
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        ControllerDatabase controller = new ControllerDatabase();
        ArrayList<String> listUsername = new ArrayList<>();
        ArrayList<Admin> listAdmin = new ArrayList<>();
        listUsername = controller.getAllUsernames();
        frame.setSize(700,600);
        frame.setLayout(new BorderLayout());

        panelTopSeller.setPreferredSize(new Dimension(700,80));
        panelLeftSeller.setPreferredSize(new Dimension(100, 320));
        panelCenterSeller.setPreferredSize(new Dimension(460, 320));
        panelRightSeller.setPreferredSize(new Dimension(100, 320));
        panelBottomSeller.setPreferredSize(new Dimension(700, 80));
        panelTanggalLahir.setPreferredSize(new Dimension(700, 80));

        panelTopSeller.setBackground(Color.ORANGE);
        panelLeftSeller.setBackground(Color.BLACK);
        panelCenterSeller.setBackground(Color.BLACK);
        panelRightSeller.setBackground(Color.BLACK);
        panelBottomSeller.setBackground(Color.BLACK);
        panelTanggalLahir.setBackground(Color.BLACK);

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
        radioPria.setActionCommand("L");
        radioWanita = new JRadioButton("Wanita");
        radioWanita.setActionCommand("P");
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

        //Tanggal Lahir : Cara get data spinner nya pakai getValue(), contoh spinnerTanggal.getValue()
        panelCenterSeller.add(panelTanggalLahir);
        //Label Tanggal Lahir
        labelTanggalLahirSeller.setFont(new Font("Arial", Font.BOLD, 15));
        labelTanggalLahirSeller.setHorizontalAlignment(JLabel.LEFT);
        labelTanggalLahirSeller.setForeground(new Color(255,255,255));
        panelCenterSeller.add(labelTanggalLahirSeller);
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
        panelCenterSeller.add(panelTanggalLahir);

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
        ArrayList<String> finalListUsername = listUsername;
        listAdmin = controller.getAllAdmins();
        ArrayList<Admin> finalListAdmin = listAdmin;
        isiUsernameSeller.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                for(int i = 0; i< finalListUsername.size(); i++){
                    if(i<finalListAdmin.size()) {
                        if (isiUsernameSeller.getText().equals(finalListAdmin.get(i).getUsername())) {
                            labelUsernameSeller.setText("Username has been used");
                            labelUsernameSeller.setForeground(Color.RED);
                            sellerButton.setEnabled(false);
                            break;
                        } else {
                            labelUsernameSeller.setText("Username");
                            labelUsernameSeller.setForeground(Color.WHITE);
                            sellerButton.setEnabled(true);
                        }
                    }
                    if(isiUsernameSeller.getText().equals(finalListUsername.get(i))){
                        labelUsernameSeller.setText("Username has been used");
                        labelUsernameSeller.setForeground(Color.RED);
                        sellerButton.setEnabled(false);
                        break;
                    }else{
                        labelUsernameSeller.setText("Username");
                        labelUsernameSeller.setForeground(Color.WHITE);
                        sellerButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                for(int i = 0; i< finalListUsername.size(); i++){
                    if(i<finalListAdmin.size()) {
                        if (isiUsernameSeller.getText().equals(finalListAdmin.get(i).getUsername())) {
                            labelUsernameSeller.setText("Username has been used");
                            labelUsernameSeller.setForeground(Color.RED);
                            sellerButton.setEnabled(false);
                            break;
                        } else {
                            labelUsernameSeller.setText("Username");
                            labelUsernameSeller.setForeground(Color.WHITE);
                            sellerButton.setEnabled(true);
                        }
                    }
                    if(isiUsernameSeller.getText().equals(finalListUsername.get(i))){
                        labelUsernameSeller.setText("Username has been used");
                        labelUsernameSeller.setForeground(Color.RED);
                        sellerButton.setEnabled(false);
                        break;
                    }else{
                        labelUsernameSeller.setText("Username");
                        labelUsernameSeller.setForeground(Color.WHITE);
                        sellerButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        ArrayList<Seller> listSeller = ControllerDatabase.getAllSellers();
        isiStoreName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                for(int i=0;i<listSeller.size();i++){
                    if(isiStoreName.getText().equals(listSeller.get(i).getStoreName())){
                        labelStoreName.setText("Store name has been used");
                        labelStoreName.setForeground(Color.RED);
                        sellerButton.setEnabled(false);
                        break;
                    }else{
                        labelStoreName.setText("Store Name");
                        labelStoreName.setForeground(Color.WHITE);
                        sellerButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                for(int i=0;i<listSeller.size();i++){
                    if(isiStoreName.getText().equals(listSeller.get(i).getStoreName())){
                        labelStoreName.setText("Store name has been used");
                        labelStoreName.setForeground(Color.RED);
                        sellerButton.setEnabled(false);
                        break;
                    }else{
                        labelStoreName.setText("Store Name");
                        labelStoreName.setForeground(Color.WHITE);
                        sellerButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e){

            }
        });
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
//        String pass="";
//        for(int i=0;i<isiPasswordSeller.getPassword().length;i++){
//            pass+=isiPasswordSeller.getPassword()[i];
//        }
        String pass = Controller.md5Java(Controller.toStringPass(isiPasswordSeller.getPassword()));
        Member member = new Member(isiUsernameSeller.getText(), pass,groupJK.getSelection().getActionCommand(),isiEmailSeller.getText(),Integer.parseInt(spinnerTanggal.getValue().toString()),month,Integer.parseInt(spinnerTahun.getValue().toString()),isiNameSeller.getText(),isiAddressSeller.getText(),0,0);
        switch (command) {
            case "BeMember":
                // Pass data to next frame
                new RegisterScreenMenu();
                frame.dispose();
                break;
            case "BeSeller":
                // Add data to database
                if(isiUsernameSeller.getText().equals("") || pass.equals("") || isiEmailSeller.getText().equals("") || isiNameSeller.getText().equals("") || isiAddressSeller.getText().equals("") || isiStoreName.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill in the blank");
                }else {
                    controller.insertMember(member);
                    Discount d = new Discount(Controller.generateNewDiscountID(isiUsernameSeller.getText(), isiStoreName.getText()), 0.0);
                    ControllerDatabase.insertDiscount(d);
                    Seller seller = new Seller(member, isiStoreName.getText(), null,Controller.generateNewProductID(isiUsernameSeller.getText(), isiStoreName.getText()),"");
                    SellerManager.getInstance().setSeller(seller);
                    MemberManager.getInstance().setMember(member);
                    controller.insertSeller(seller);
                    new SellerMenu();
                    frame.dispose();
                }
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
