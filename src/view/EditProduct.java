package view;

import controller.ControllerDatabase;
import model.Product;
import model.Seller;

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
import java.util.ArrayList;

import static view.MainMenus.mindfullyFont;

public class EditProduct implements ActionListener {

    JFrame frame = new JFrame("Edit Product");
    JPanel panel = new JPanel(new BorderLayout());

    JPanel panelTitle = new JPanel();
    JPanel panelProduct = new JPanel();
    JPanel panelProductLeft = new JPanel(new GridLayout(8, 2, 10, 10));
    JPanel panelProductRight = new JPanel();
    JPanel panelProductRightTop = new JPanel(new GridLayout(3, 1, 10, 10));
    JPanel panelProductRightBottom = new JPanel();
    JPanel panelButton = new JPanel(new GridLayout(1, 2, 20, 2));

    BoxLayout boxLayout = new BoxLayout(panelProduct, BoxLayout.X_AXIS);
    BoxLayout boxLayoutProductRight = new BoxLayout(panelProductRight, BoxLayout.Y_AXIS);

    JLabel lblTitle = new JLabel("Edit Product");
    JButton backButton = new JButton("<<<");

    JLabel lblProductID = new JLabel("ID : ");
    JTextField txtProductID = new JTextField();

    JLabel lblProductName = new JLabel("Name : ");
    JTextField txtProductName = new JTextField();

    JLabel lblProductBrand = new JLabel("Brand : ");
    JTextField txtProductBrand = new JTextField();

    JLabel lblProductCategory = new JLabel("Category : ");
    JTextField txtProductCategory = new JTextField();

    JLabel lblProductStock = new JLabel("Stock : ");
    JSpinner txtProductStock;

    JLabel lblProductPrice = new JLabel("Price : ");
    JSpinner txtProductPrice;

    JLabel lblProductSize = new JLabel("Size : ");
    JTextField txtProductSize = new JTextField();

    JLabel lblStoreName = new JLabel("Store Name : ");
    JComboBox txtStoreName;

    JLabel lblPathFotoProduct = new JLabel("Path Foto Product");
    JTextField txtPathFotoProduct = new JTextField();
    JButton btnEditFoto = new JButton("Edit Foto");

    JLabel lblFotoProduct = new JLabel();
    JFileChooser chooser = new JFileChooser();
    File f;
    String filename;

    JButton btnEditData = new JButton("Edit Data");
    JButton btnSubmit = new JButton("Save");

    static Product product;
    static String pID;

//    public EditProduct() {
//
//    }

    public EditProduct(String productID) {
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        // Panel Product
        panel.setBorder(new LineBorder(Color.BLACK, 20));
        panelProduct.setLayout(boxLayout);

        // Get Products From Database
        product = ControllerDatabase.getProduct(productID);
        pID = productID;

        // Panel Product Left
        panelProductLeft.setBorder(new EmptyBorder(20, 20, 20, 20));
        lblProductID.setFont(new Font("Arial", Font.BOLD, 20));
        lblProductID.setForeground(Color.WHITE);
        txtProductID.setText(product.getProductID());
        txtProductID.setEditable(false);
        panelProductLeft.add(lblProductID);
        panelProductLeft.add(txtProductID);

        lblProductName.setFont(new Font("Arial", Font.BOLD, 20));
        lblProductName.setForeground(Color.WHITE);
        txtProductName.setText(product.getProductName());
        txtProductName.setEditable(false);
        panelProductLeft.add(lblProductName);
        panelProductLeft.add(txtProductName);

        lblProductBrand.setFont(new Font("Arial", Font.BOLD, 20));
        lblProductBrand.setForeground(Color.WHITE);
        txtProductBrand.setText(product.getProductBrand());
        txtProductBrand.setEditable(false);
        panelProductLeft.add(lblProductBrand);
        panelProductLeft.add(txtProductBrand);

        lblProductCategory.setFont(new Font("Arial", Font.BOLD, 20));
        lblProductCategory.setForeground(Color.WHITE);
        txtProductCategory.setText(product.getProductCategory());
        txtProductCategory.setEditable(false);
        panelProductLeft.add(lblProductCategory);
        panelProductLeft.add(txtProductCategory);

        lblProductStock.setFont(new Font("Arial", Font.BOLD, 20));
        lblProductStock.setForeground(Color.WHITE);
        txtProductStock = new JSpinner(new SpinnerNumberModel(product.getProductStock(), 0, 1000, 1));
        txtProductStock.setEnabled(false);
        panelProductLeft.add(lblProductStock);
        panelProductLeft.add(txtProductStock);

        lblProductPrice.setFont(new Font("Arial", Font.BOLD, 20));
        lblProductPrice.setForeground(Color.WHITE);
        txtProductPrice = new JSpinner(new SpinnerNumberModel(product.getProductPrice(), 0, 10000000, 1000));
        txtProductPrice.setEnabled(false);
        panelProductLeft.add(lblProductPrice);
        panelProductLeft.add(txtProductPrice);

        lblProductSize.setFont(new Font("Arial", Font.BOLD, 20));
        lblProductSize.setForeground(Color.WHITE);
        txtProductSize.setText(product.getProductSize());
        txtProductSize.setEditable(false);
        panelProductLeft.add(lblProductSize);
        panelProductLeft.add(txtProductSize);

        lblStoreName.setFont(new Font("Arial", Font.BOLD, 20));
        lblStoreName.setForeground(Color.WHITE);
        ArrayList<Seller> listSeller = ControllerDatabase.getAllSellers();
        String[] listStoreName = new String[listSeller.size()];

        for (int i = 0; i < listSeller.size(); i++) {
            listStoreName[i] = listSeller.get(i).getStoreName();
        }
        txtStoreName = new JComboBox(listStoreName);
        txtStoreName.setSelectedItem(product.getStoreName());
        txtStoreName.setEnabled(false);
        panelProductLeft.add(lblStoreName);
        panelProductLeft.add(txtStoreName);

        // Panel Product Right Top
        lblPathFotoProduct.setFont(new Font("Arial", Font.BOLD, 20));
        lblPathFotoProduct.setForeground(Color.WHITE);
        panelProductRightTop.setBorder(new EmptyBorder(20, 20, 20, 20));
        txtPathFotoProduct.setText(product.getProductPath());
        txtPathFotoProduct.setEditable(false);
        panelProductRightTop.add(lblPathFotoProduct);
        panelProductRightTop.add(txtPathFotoProduct);

        btnEditFoto.setFont(new Font("Arial", Font.BOLD, 20));
        btnEditFoto.setActionCommand("EditFoto");
        btnEditFoto.addActionListener(this);
        btnEditFoto.setVisible(false);
        panelProductRightTop.add(btnEditFoto);

        // Panel Product Right Bottom
        panelProductRightBottom.setBorder(new EmptyBorder(20, 20, 20, 20));
        String pathFoto = product.getProductPath();
        lblFotoProduct.setIcon(new ImageIcon(new ImageIcon(pathFoto).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        panelProductRightBottom.add(lblFotoProduct);

        // Panel Product Right
        panelProductRight.add(panelProductRightTop);
        panelProductRight.add(panelProductRightBottom);
        panelProductRight.setLayout(boxLayoutProductRight);

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
        panelProduct.setBackground(new Color(0,0,0,0));
        panelProductLeft.setBackground(new Color(0,0,0,0));
        panelProductRight.setBackground(new Color(0,0,0,0));
        panelProductRightTop.setBackground(new Color(0,0,0,0));
        panelProductRightBottom.setBackground(new Color(0,0,0,0));
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

        panelProduct.add(panelProductLeft);
        panelProduct.add(panelProductRight);

        panel.add(panelTitle, BorderLayout.NORTH);
        panel.add(panelProduct, BorderLayout.CENTER);
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
                txtProductName.setEditable(true);
                txtProductBrand.setEditable(true);
                txtProductCategory.setEditable(true);
                txtProductStock.setEnabled(true);
                txtProductPrice.setEnabled(true);
                txtProductSize.setEditable(true);
                txtStoreName.setEnabled(true);
                btnEditFoto.setVisible(true);
                btnSubmit.setVisible(true);
                break;
            case "EditFoto":
                chooser.showOpenDialog(null);
                f = chooser.getSelectedFile();
                filename = f.getAbsolutePath();
                txtPathFotoProduct.setText(filename);
                lblFotoProduct.setIcon(new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
                break;
            case "Submit":
                boolean lanjut = true;

                if (txtProductID.getText().equals("") || txtProductName.getText().equals("") || txtProductBrand.getText().equals("")
                || txtProductCategory.getText().equals("") || txtProductSize.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Pastikan semua field terisi", "Perhatian", JOptionPane.WARNING_MESSAGE);
                    lanjut = false;
                }

                if (txtPathFotoProduct.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Pastikan mencantumkan foto product", "Foto Product", JOptionPane.INFORMATION_MESSAGE);
                    lanjut = false;
                }

                if (lanjut) {
                    // Get Filename
                    String filenameFotoProduct = txtProductID.getText() + ".jpg";

                    // Copy file
                    String desFilePath = null;
                    try {
                        desFilePath = new File(".") + "/media/Product/" + filenameFotoProduct;
                        Files.copy(Paths.get(txtPathFotoProduct.getText()),Paths.get(desFilePath),
                                StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e1) {
                        // Auto-generated catch block
                        e1.printStackTrace();
                    }

                    product.setProductName(txtProductName.getText());
                    product.setProductBrand(txtProductBrand.getText());
                    product.setProductCategory(txtProductCategory.getText());
                    product.setProductStock((Integer) txtProductStock.getValue());
                    product.setProductPrice((Double) txtProductPrice.getValue());
                    product.setProductSize(txtProductSize.getText());
                    product.setStoreName((String) txtStoreName.getSelectedItem());
                    product.setProductPath(desFilePath);

                    boolean isUpdated = ControllerDatabase.updateProduct(product, pID);

                    if (isUpdated) {
                        JOptionPane.showMessageDialog(frame, "Product Data UPDATE Successfully", "Success Update", JOptionPane.INFORMATION_MESSAGE);
                        new AdminProduct();
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Failed to UPDATE Product Data", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                }
                break;
            case "Back":
                new AdminProduct();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
