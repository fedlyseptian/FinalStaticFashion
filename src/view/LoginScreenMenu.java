package view;

import controller.Controller;
import controller.ControllerDatabase;
import model.Member;
import model.MemberManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

public class LoginScreenMenu implements ActionListener {

    //Deklarasi
    JFrame frame = new JFrame("Login");
    JPanel panelTopLogin = new JPanel();
    JPanel panelLeftLogin = new JPanel();
    JPanel panelRightLogin = new JPanel();
    JPanel panelBottomLogin = new JPanel();
    JPanel panelCenterLogin = new JPanel(new GridLayout(5 ,1));

    //Title
    JLabel labelTitle = new JLabel("Login Form");

    //Username
    JLabel labelUsername = new JLabel("Username");
    JTextField isiUsername = new JTextField("");
    //Password
    JLabel labelPassword = new JLabel("Password");
    JPasswordField isiPassword = new JPasswordField();

    JButton backButton = new JButton("<<< Back to Main Menu");
    JButton loginButton = new JButton("Login");

    public LoginScreenMenu(){
        frame.setSize(500,400);
        frame.setLayout(new BorderLayout());

        panelTopLogin.setPreferredSize(new Dimension(500,80));
        panelLeftLogin.setPreferredSize(new Dimension(80, 240));
        panelCenterLogin.setPreferredSize(new Dimension(340, 240));
        panelRightLogin.setPreferredSize(new Dimension(80, 240));
        panelBottomLogin.setPreferredSize(new Dimension(500, 80));

        panelTopLogin.setBackground(Color.ORANGE);
        panelLeftLogin.setBackground(Color.BLACK);
        panelCenterLogin.setBackground(Color.BLACK);
        panelRightLogin.setBackground(Color.BLACK);
        panelBottomLogin.setBackground(Color.BLACK);

        //Title
        labelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelTitle.setForeground(new Color(0, 0, 0));
        panelTopLogin.add(labelTitle);

        //Username
        labelUsername.setFont(new Font("Arial", Font.BOLD, 20));
        labelUsername.setHorizontalAlignment(JLabel.LEFT);
        labelUsername.setForeground(new Color(255, 255, 255));
        panelCenterLogin.add(labelUsername);
        panelCenterLogin.add(isiUsername);

        //Password
        labelPassword.setFont(new Font("Arial", Font.BOLD, 20));
        labelPassword.setHorizontalAlignment(JLabel.LEFT);
        labelPassword.setForeground(new Color(255, 255, 255));
        panelCenterLogin.add(labelPassword);
        panelCenterLogin.add(isiPassword);

        backButton.setFont(new Font("Arial", Font.ITALIC, 15));
        backButton.setForeground(Color.RED);
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);

        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setActionCommand("Login");
        loginButton.addActionListener(this);

        panelBottomLogin.add(backButton);
        panelBottomLogin.add(loginButton);

        frame.add(panelTopLogin,BorderLayout.NORTH);
        frame.add(panelLeftLogin,BorderLayout.WEST);
        frame.add(panelCenterLogin,BorderLayout.CENTER);
        frame.add(panelRightLogin,BorderLayout.EAST);
        frame.add(panelBottomLogin,BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Login":
                // Cek ke database
                ArrayList<Member> listMember = ControllerDatabase.getAllMembers();
                String pass="";
                for(int i=0;i<isiPassword.getPassword().length;i++){
                    pass+=isiPassword.getPassword()[i];
                }
                pass=Controller.md5Java(pass);
                boolean found= false;
                int i;
                for(i=0;i<listMember.size();i++){
                    if(Controller.validateMember(listMember.get(i),listMember.get(i).getUsername(),pass)){
                        found=true;
                        break;
                    }
                }
                if(found){
                    MemberManager.getInstance().setMember(listMember.get(i));
                    new ShoppingScreenMenu();
                }else{
                    JOptionPane.showMessageDialog(null,"Username or Password is incorect");
                    new LoginScreenMenu();
                }
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
