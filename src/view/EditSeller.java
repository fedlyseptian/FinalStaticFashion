package view;

import controller.ControllerDatabase;
import model.AdminManager;
import model.MemberManager;
import model.Seller;
import model.SellerManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static view.MainMenus.mindfullyFont;

public class EditSeller implements ActionListener {
    JFrame frame = new JFrame("Edit Seller");
    JPanel panel = new JPanel(new BorderLayout());

    JPanel panelTitle = new JPanel();
    JPanel panelStore = new JPanel();
    JPanel panelStoreLeft = new JPanel(new GridLayout(8, 2, 10, 10));
    JPanel panelStoreRight = new JPanel();
    JPanel panelStoreRightTop = new JPanel(new GridLayout(3, 1, 10, 10));
    JPanel panelStoreRightBottom = new JPanel();
    JPanel panelButton = new JPanel(new GridLayout(1, 2, 20, 2));

    BoxLayout boxLayout = new BoxLayout(panelStore, BoxLayout.X_AXIS);
    BoxLayout boxLayoutProductRight = new BoxLayout(panelStoreRight, BoxLayout.Y_AXIS);

    JLabel lblTitle = new JLabel("Edit Seller");
    JButton backButton = new JButton("<<<");

    JLabel lblUsername = new JLabel("Owner : ");
    JTextField txtUsername = new JTextField();

    JLabel lblStoreName = new JLabel("Store Name : ");
    JTextField txtStoreName = new JTextField();

    JLabel lblDiscountID = new JLabel("Discount ID : ");
    JTextField txtDiscountID = new JTextField();

    JLabel lblPathLogo = new JLabel("Path Foto Logo");
    JTextField txtPathLogo = new JTextField();
    JButton btnEditLogo = new JButton("Edit Foto");

    JLabel lblLogo = new JLabel();
    JFileChooser chooser = new JFileChooser();
    File f;
    String filename;

    JButton btnEditDiscount = new JButton("Edit Discount");
    JButton btnEditData = new JButton("Edit Data");
    JButton btnSubmit = new JButton("Save");

    static Seller seller;
    static String stName;

//    public EditSeller() {}

    public EditSeller(String sName) {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        // Panel Store
        panel.setBorder(new LineBorder(Color.BLACK, 20));
        panelStore.setLayout(boxLayout);

        // Get Seller From Database
        seller = ControllerDatabase.getSpecificSeller(sName);
        stName = sName;

        // Panel Store Left
        panelStoreLeft.setBorder(new EmptyBorder(20, 20, 20, 20));
        lblUsername.setFont(new Font("Arial", Font.BOLD, 20));
        lblUsername.setForeground(Color.WHITE);
        txtUsername.setText(seller.getUsername());
        txtUsername.setEditable(false);
        panelStoreLeft.add(lblUsername);
        panelStoreLeft.add(txtUsername);

        lblStoreName.setFont(new Font("Arial", Font.BOLD, 20));
        lblStoreName.setForeground(Color.WHITE);
        txtStoreName.setText(seller.getStoreName());
        txtStoreName.setEditable(false);
        panelStoreLeft.add(lblStoreName);
        panelStoreLeft.add(txtStoreName);

        lblDiscountID.setFont(new Font("Arial", Font.BOLD, 20));
        lblDiscountID.setForeground(Color.WHITE);
        txtDiscountID.setText(seller.getDiscountID());
        txtDiscountID.setEditable(false);
        panelStoreLeft.add(lblDiscountID);
        panelStoreLeft.add(txtDiscountID);

        btnEditDiscount.setVisible(false);
        btnEditDiscount.setActionCommand("EditDiscount");
        btnEditDiscount.addActionListener(this);
        btnEditDiscount.setFont(new Font("Arial", Font.BOLD, 20));
        panelStoreLeft.add(btnEditDiscount);

        // Panel Store Right Top
        lblPathLogo.setFont(new Font("Arial", Font.BOLD, 20));
        lblPathLogo.setForeground(Color.WHITE);
        panelStoreRightTop.setBorder(new EmptyBorder(20, 20, 20, 20));
        txtPathLogo.setText(seller.getPathLogo());
        txtPathLogo.setEditable(false);
        panelStoreRightTop.add(lblPathLogo);
        panelStoreRightTop.add(txtPathLogo);

        btnEditLogo.setFont(new Font("Arial", Font.BOLD, 20));
        btnEditLogo.setActionCommand("EditFoto");
        btnEditLogo.addActionListener(this);
        btnEditLogo.setVisible(false);
        panelStoreRightTop.add(btnEditLogo);

        // Panel Store Right Bottom
        panelStoreRightBottom.setBorder(new EmptyBorder(20, 20, 20, 20));
        String pathFoto = seller.getPathLogo();
        lblLogo.setIcon(new ImageIcon(new ImageIcon(pathFoto).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        panelStoreRightBottom.add(lblLogo);

        // Panel Store Right
        panelStoreRight.add(panelStoreRightTop);
        panelStoreRight.add(panelStoreRightBottom);
        panelStoreRight.setLayout(boxLayoutProductRight);

        // Panel Button
        panelButton.setBorder(new EmptyBorder(0, 75, 0, 75));
        btnEditData.setFont(new Font("Arial", Font.BOLD, 20));
        btnEditData.setActionCommand("EditData");
        btnEditData.addActionListener(this);
        panelButton.add(btnEditData);

        btnSubmit.setFont(new Font("Arial", Font.BOLD, 20));
        btnSubmit.setActionCommand("Submit");
        btnSubmit.addActionListener(this);
        btnSubmit.setVisible(false);
        panelButton.add(btnSubmit);

        // Label Title
        lblTitle.setFont(mindfullyFont);
        lblTitle.setForeground(new Color(255, 145, 0));
        panelTitle.add(lblTitle);

        // Transaparent Child Background
        panelTitle.setBackground(new Color(0,0,0,0));
        panelStore.setBackground(new Color(0,0,0,0));
        panelStoreLeft.setBackground(new Color(0,0,0,0));
        panelStoreRight.setBackground(new Color(0,0,0,0));
        panelStoreRightTop.setBackground(new Color(0,0,0,0));
        panelStoreRightBottom.setBackground(new Color(0,0,0,0));
        panelButton.setBackground(new Color(0,0,0,0));

        // Coloring Panel
        panel.setBackground(Color.BLACK);

        // Back Button
        backButton.setBounds(5, 25, 100, 50);
        backButton.setFont(backButton.getFont().deriveFont(30f));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(null);
        backButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                backButton.setForeground(new Color(255, 145, 0));
                backButton.setBackground(new Color(15, 15, 10));
                backButton.setBorder(new BevelBorder(0, Color.BLACK, new Color(20, 20, 20)));
            }
            public void mouseExited(MouseEvent evt) {
                backButton.setForeground(Color.WHITE);
                backButton.setBackground(Color.BLACK);
                backButton.setBorder(null);
            }
        });

        backButton.setActionCommand("Back");
        backButton.addActionListener(this);

        frame.add(backButton);

        panelStore.add(panelStoreLeft);
        panelStore.add(panelStoreRight);

        panel.add(panelTitle, BorderLayout.NORTH);
        panel.add(panelStore, BorderLayout.CENTER);
        panel.add(panelButton, BorderLayout.SOUTH);
        frame.add(panel);

        frame.setSize(1280, 720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        FileFilter imageFilter = new FileNameExtensionFilter(
                "Image files", ImageIO.getReaderFileSuffixes());
        chooser.setFileFilter(imageFilter);
        switch (command) {
            case "EditData":
                txtUsername.setEditable(true);
                txtStoreName.setEditable(true);
                txtStoreName.setEditable(true);
                btnEditDiscount.setVisible(true);
                btnEditLogo.setVisible(true);
                btnSubmit.setVisible(true);
                break;
            case "EditDiscount":
                // new frame EditDiscount, kirim seller.DiscountID
                frame.dispose();
                break;
            case "EditFoto":
                chooser.showOpenDialog(null);
                f = chooser.getSelectedFile();
                filename = f.getAbsolutePath();
                txtPathLogo.setText(filename);
                lblLogo.setIcon(new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
                break;
            case "Submit":
                boolean lanjut = true;

                if (txtUsername.getText().equals("") || txtStoreName.getText().equals("") || txtDiscountID.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Pastikan semua field terisi", "Perhatian", JOptionPane.WARNING_MESSAGE);
                    lanjut = false;
                }

                if (txtPathLogo.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Pastikan mencantumkan logo", "Foto Logo Toko", JOptionPane.INFORMATION_MESSAGE);
                    lanjut = false;
                }

                if (lanjut) {
                    // Get Filename
                    String filenameFotoProduct = txtStoreName.getText() + ".jpg";

                    // Copy file
                    String desFilePath = null;
                    try {
                        desFilePath = new File(".") + "/media/Store/" + filenameFotoProduct;
                        Files.copy(Paths.get(txtPathLogo.getText()), Paths.get(desFilePath),
                                StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e1) {
                        // Auto-generated catch block
                        e1.printStackTrace();
                    }

                    seller.setUsername(txtUsername.getText());
                    seller.setStoreName(txtStoreName.getText());
                    seller.setDiscountID(txtDiscountID.getText());
                    seller.setPathLogo(desFilePath);

                    boolean isUpdated = ControllerDatabase.updateSeller(seller, stName);

                    if (isUpdated) {
                        JOptionPane.showMessageDialog(frame, "Seller (Store) Data UPDATE Successfully", "Success Update", JOptionPane.INFORMATION_MESSAGE);
                        new AdminStore();
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Failed to UPDATE Seller (Store0", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                }
                break;
            case "Back":
                if(AdminManager.getInstance().getAdmin()!=null){
                    new AdminStore();
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
