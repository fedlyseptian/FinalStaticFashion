/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.nio.channels.Selector;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import main.Main;
import model.*;
import view.CartScreenMenu;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeded
 */
public class ControllerDatabase {
    static DatabaseHandler conn = new DatabaseHandler();

    // Insert New Member
    public static boolean insertMember(Member member) {
        Date date = new Date(member.getYear()-1900,member.getMonth()-1,member.getDay());
        conn.connect();
        String query = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
             stmt.setString(1,member.getUsername());
             stmt.setString(2,member.getPassword());
             stmt.setString(3,member.getName());
             stmt.setString(4,member.getAddress());
             stmt.setString(5,member.getGender());
             stmt.setString(6,member.getEmail());
             stmt.setDate(7,date);
             stmt.setDouble(8,member.getPoint());
             stmt.setDouble(9,member.getMoney());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
//insertTransaction
    public static boolean insertTransaction(Transactions transaction) {
        conn.connect();
        String query = "INSERT INTO transactions VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
             stmt.setString(1,transaction.getTransactionID());
             stmt.setString(2,transaction.getUsername());
             Date date = new Date(transaction.getTransactionDate().getYear(), transaction.getTransactionDate().getMonth(),transaction.getTransactionDate().getDate());
             stmt.setDate(3, date);
             stmt.setString(4,transaction.getPaymentOption());
             stmt.setDouble(5,transaction.getSubTotal());
             stmt.setDouble(6,transaction.getTaxSeller());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Insert New Product
    public static boolean insertProduct(Product product) {
        conn.connect();
        String query = "INSERT INTO products VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
             stmt.setString(1,product.getProductID());
             stmt.setString(2,product.getProductName());
             stmt.setString(3,product.getProductBrand());
             stmt.setString(4,product.getProductCategory());
             stmt.setInt(5,product.getProductStock());
             stmt.setDouble(6,product.getProductPrice());
             stmt.setString(7,product.getProductSize());
             stmt.setString(8,product.getStoreName());
            stmt.setString(9,product.getProductPath());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Insert New Admin
    public static boolean insertAdmin(Admin admin){
        conn.connect();
        String query = "INSERT INTO admin VALUES(?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, admin.getUsername());
            stmt.setString(2, admin.getPassword());
            stmt.executeUpdate();
            return(true);
        }catch(SQLException e){
            e.printStackTrace();
            return (false);
        }
    }

    // Insert New Seller
    public static boolean insertSeller(Seller seller) {
        conn.connect();
        String query = "INSERT INTO seller VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1,seller.getStoreName());
            stmt.setString(2,seller.getUsername());
            stmt.setString(3,seller.getDiscountID());
            stmt.setString(4,seller.getPathLogo());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Insert New Discount
    public static boolean insertDiscount(Discount discount) {
        conn.connect();
        String query = "INSERT INTO discount VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1,discount.getDiscountID());
            stmt.setDouble(2, discount.getDiscountValue());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Insert New Product To Cart
//    public static boolean insertProductToListProduct(Cart cart) {
//        conn.connect();
//        String query = "INSERT INTO listproduct VALUES(?,?,?,?)";
//        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setInt(1,cart.getTransactionID());
//            stmt.setString(2,cart.getProductID());
//            stmt.setInt(3,cart.getQuantity());
//            stmt.setDouble(4,cart.getTotal());
//            stmt.executeUpdate();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }

    // Get All Products
    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> listProducts = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM products";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString("productID"));
                product.setProductName(rs.getString("productName"));
                product.setProductBrand(rs.getString("productBrand"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductStock(rs.getInt("productStock"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductSize(rs.getString("productSize"));
                product.setStoreName(rs.getString("storeName"));
                product.setProductPath(rs.getString("pathFotoProduct"));
                listProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listProducts);
    }

    // Get Products From Seller
    public static ArrayList<Product> getProductsSeller(String sName) {
        ArrayList<Product> listProducts = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM products WHERE storeName='" + sName + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString("productID"));
                product.setProductName(rs.getString("productName"));
                product.setProductBrand(rs.getString("productBrand"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductStock(rs.getInt("productStock"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductSize(rs.getString("productSize"));
                product.setStoreName(rs.getString("storeName"));
                product.setProductPath(rs.getString("pathFotoProduct"));
                listProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listProducts);
    }

    // Get Specific Products
    public static Product getProduct(String pID) {
        Product product = new Product();
        conn.connect();
        String query = "SELECT * FROM products WHERE productID='" + pID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                product.setProductID(rs.getString("productID"));
                product.setProductName(rs.getString("productName"));
                product.setProductBrand(rs.getString("productBrand"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductStock(rs.getInt("productStock"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductSize(rs.getString("productSize"));
                product.setStoreName(rs.getString("storeName"));
                product.setProductPath(rs.getString("pathFotoProduct"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (product);
    }

    // Get All Products Cart
    public static ArrayList<Cart> getAllProductsCart() {
        ArrayList<Cart> listProductsCart = new ArrayList<>();
        conn.connect();
        String query = "SELECT listproduct.productID, products.productName, products.productBrand, products.productCategory, products.productPrice, listproduct.quantity, products.productSize, products.storeName, products.pathFotoProduct FROM listproduct, products WHERE listproduct.productID = products.productID";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Cart product = new Cart();
                product.setProductID(rs.getString("productID"));
                product.setProductName(rs.getString("productName"));
                product.setProductBrand(rs.getString("productBrand"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setTotal(rs.getDouble("total"));
                product.setQuantity(rs.getInt("quantity"));
                product.setProductSize(rs.getString("productSize"));
                product.setStoreName(rs.getString("storeName"));
                product.setProductPath(rs.getString("pathFotoProduct"));
                listProductsCart.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listProductsCart);
    }

    // Check Product ID
    public static boolean checkProductIDAvailability(String pID) {
        boolean isAvailable = true;
        conn.connect();
        String query = "SELECT productID FROM products WHERE productID='" + pID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (pID.equals(rs.getString("productID"))) {
                    isAvailable = false;
                }
            }
        } catch (SQLException e) {
            isAvailable = true;
            e.printStackTrace();
        }
        return (isAvailable);
    }

    // Update Product Data
    public static boolean updateProduct(Product product, String pID) {
        conn.connect();
        String query = "UPDATE products SET " +
                "productID='" + product.getProductID() + "', " +
                "productName='" + product.getProductName() + "', " +
                "productBrand='" + product.getProductBrand() + "', " +
                "productCategory='" + product.getProductCategory() + "', " +
                "productStock='" + product.getProductStock() + "', " +
                "productPrice='" + product.getProductPrice() + "', " +
                "productSize='" + product.getProductSize() + "', " +
                "storeName='" + product.getStoreName() + "', " +
                "pathFotoProduct='" + product.getProductPath() + "' " +
                "WHERE productID='" + pID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Update Product Stock
    public static boolean updateProductStock(String idProd, int sisaStock) {
        conn.connect();
        String query = "UPDATE products SET " +
                "productStock='" + sisaStock + "' " +
                "WHERE productID='" + idProd + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    //dibuat biar hemat waktu get, soalnya cuma butuh username
    // Get All Username
    public static ArrayList<String> getAllUsernames() {
        ArrayList<String> listUsername = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM member";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String username = rs.getString("username");
                listUsername.add(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listUsername);
    }

    // Get All Members
    public static ArrayList<Member> getAllMembers(){
        ArrayList<Member> listMembers = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM member";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setAddress(rs.getString("address"));
                member.setGender(rs.getString("gender"));
                member.setEmail(rs.getString("email"));
                Date date = rs.getDate("birthDate");
                member.setDay(date.getDate());
                member.setMonth(date.getMonth()+1);
                member.setYear(date.getYear()+1900);
                member.setPoint(rs.getDouble("point"));
                member.setMoney(rs.getDouble("money"));
                listMembers.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listMembers);
    }

    // Get Specific Member
    public static Member getMember(String user) {
        Member member = new Member();
        conn.connect();
        String query = "SELECT * FROM member WHERE username='" + user + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setAddress(rs.getString("address"));
                member.setGender(rs.getString("gender"));
                member.setEmail(rs.getString("email"));
                Date date = rs.getDate("birthDate");
                member.setDay(date.getDate());
                member.setMonth(date.getMonth()+1);
                member.setYear(date.getYear()+1900);
                member.setPoint(rs.getDouble("point"));
                member.setMoney(rs.getDouble("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (member);
    }

    // Get All Sellers
    public static ArrayList<Seller> getAllSellers(){
        ArrayList<Seller> listSellers = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM seller";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Seller seller = new Seller();
                seller.setUsername(rs.getString("username"));
                seller.setStoreName(rs.getString("storeName"));
                seller.setDiscountID(rs.getString("discountID"));
                seller.setPathLogo(rs.getString("pathLogo"));
                listSellers.add(seller);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listSellers);
    }

    // Get Specific Sellers
    public static Seller getSpecificSeller(String sName){
        Seller seller = new Seller();
        conn.connect();
        String query = "SELECT * FROM seller WHERE storeName='" + sName + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                seller.setUsername(rs.getString("username"));
                seller.setStoreName(rs.getString("storeName"));
                seller.setDiscountID(rs.getString("discountID"));
                seller.setPathLogo(rs.getString("pathLogo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (seller);
    }

    // Get Member by Product (Store)
    public static Member getMemberByProduct(String sName){
        Seller sellerTemp = getSpecificSeller(sName);
        Member member = new Member();
        conn.connect();
        String query = "SELECT * FROM member, seller WHERE member.username=seller.username AND member.username='" + sellerTemp.getUsername() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setAddress(rs.getString("address"));
                member.setGender(rs.getString("gender"));
                member.setEmail(rs.getString("email"));
                Date date = rs.getDate("birthDate");
                member.setDay(date.getDate());
                member.setMonth(date.getMonth()+1);
                member.setYear(date.getYear()+1900);
                member.setPoint(rs.getDouble("point"));
                member.setMoney(rs.getDouble("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (member);
    }

    // Update Seller Data
    public static boolean updateSeller(Seller seller, String stName) {
        conn.connect();
        String query = "UPDATE seller SET " +
                "username='" + seller.getUsername() + "', " +
                "storeName='" + seller.getStoreName() + "', " +
                "discountID='" + seller.getDiscountID() + "', " +
                "pathLogo='" + seller.getPathLogo() + "' " +
                "WHERE storeName='" + stName + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Get All Admins
    public static ArrayList<Admin> getAllAdmins(){
        ArrayList<Admin> listAdmins = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM admin";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                listAdmins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listAdmins);
    }

    // Get All Discount
    public static ArrayList<Discount> getAllDiscount(){
        ArrayList<Discount> listDiscounts = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM discount";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Discount discount = new Discount();
                discount.setDiscountID(rs.getString("discountID"));
                discount.setDiscountValue(rs.getDouble("discountValue"));
                listDiscounts.add(discount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listDiscounts);
    }
    public static ArrayList<Transactions> getAllTransaction(){
        ArrayList<Transactions> listTransactions = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM transactions";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transactions transaction = new Transactions();
                transaction.setTransactionID(rs.getString("transactionID"));
                transaction.setUsername(rs.getString("username"));
                Date date = rs.getDate("transactionDate");
                transaction.setPaymentOption(rs.getString("paymentOption"));
                transaction.setSubTotal(rs.getDouble("subTotalTransaction"));
                transaction.setTaxSeller(rs.getDouble("taxSeller"));
                listTransactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listTransactions);
    }

    //get per transaction
    public static ArrayList<DetailTransaction> getListProduct(String transactionID){
        ArrayList<DetailTransaction> listProduct = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM listProduct";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DetailTransaction detail = new DetailTransaction();
                if(rs.getString("transactionID").equals(transactionID)){
                    detail.setTransactionID(rs.getString("transactionID"));
                    detail.setProductID(rs.getString("productID"));
                    detail.setQuantity(rs.getInt("quantity"));
                    detail.setTotal(rs.getDouble("total"));
                    listProduct.add(detail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listProduct);
    }

    // Get Discount by DiscountID
    public static Discount getDiscount(String dID){
        Discount discount= new Discount();
        conn.connect();
        String query = "SELECT * FROM discount WHERE discountID='" + dID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                discount.setDiscountID(rs.getString("discountID"));
                discount.setDiscountValue(rs.getDouble("discountValue"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (discount);
    }

    // Get Discount by StoreName
    public static Discount getDiscountByStoreName(String sName){
        Discount discount= new Discount();
        conn.connect();
        String query = "SELECT Discount.* FROM discount, seller WHERE seller.discountID=discount.discountID AND " +
                "seller.storeName='" + sName + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                discount.setDiscountID(rs.getString("discountID"));
                discount.setDiscountValue(rs.getDouble("discountValue"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (discount);
    }

    // Update About Us Text
    public static boolean updateDiscount(Discount discount) {
        conn.connect();
        String query = "UPDATE discount SET discountValue='" + discount.getDiscountValue() + "'"
                + " WHERE discountID='" + discount.getDiscountID() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Get Tax Seller
    public static TaxSeller getTaxSeller() {
        TaxSeller taxSeller = new TaxSeller();
        conn.connect();
        String query = "SELECT * FROM taxseller";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                taxSeller.setTaxValue(rs.getDouble("taxValue"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (taxSeller);
    }

    // Update Tax Seller
    public static boolean updateTaxSeller(double lastValue, double newValue) {
        conn.connect();
        String query = "UPDATE taxseller SET taxValue='" + newValue + "' "
                + " WHERE taxValue='" + lastValue + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Get Point
    public static PointSystem getPoint() {
        PointSystem point = new PointSystem();
        conn.connect();
        String query = "SELECT * FROM pointSystem";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                point.setPointValue(rs.getDouble("pointValue"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (point);
    }

    // Update Point
    public static boolean updatePoint(double lastValue, double newValue) {
        conn.connect();
        String query = "UPDATE pointSystem SET pointValue='" + newValue + "' "
                + " WHERE pointValue='" + lastValue + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Update Member Money
    public static boolean updateMoney(String username, double balance) {
        conn.connect();
        String query = "UPDATE member SET money='" + balance + "' "
                + " WHERE username='" + username + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Update Member Money
    public static boolean updatePointValue(String username, double balance) {
        conn.connect();
        String query = "UPDATE member SET point='" + balance + "' "
                + " WHERE username='" + username + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Get About Us Text
    public static String getAboutUsText() {
        String tempString = "";
        conn.connect();
        String query = "SELECT aboutUsText FROM aboutus";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                tempString = rs.getString("aboutUsText");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (tempString);
    }

    // Update About Us Text
    public static boolean updateAboutUsText(String newText) {
        conn.connect();
        String query = "UPDATE aboutus SET aboutUsText='" + newText + "'"
                + " WHERE aboutUsID='AUT'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Delete Admin
    public static boolean deleteAdmin(Admin admin) {
        conn.connect();
        String query = "DELETE FROM admin WHERE username='" + admin.getUsername() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Delete Member

    // Delete Product
    public static boolean deleteProduct(String pID) {
        conn.connect();
        String query = "DELETE FROM products WHERE productID='" + pID + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Delete member
    public static boolean deleteMember(Member member) {
        conn.connect();
        String query = "DELETE FROM member WHERE username='" + member.getUsername() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    //Get Stock Product
    public static int getStockProductByIdProduct(String idProduct){
        int stockProduct = 0;
        conn.connect();
        String query = "SELECT productStock FROM products WHERE productID='" + idProduct + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                stockProduct = rs.getInt("productStock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (stockProduct);
    }
    // Delete Member
//    public static boolean deleteProduct(String pID) {
//        conn.connect();
//        String query = "DELETE FROM products WHERE productID='" + pID + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            stmt.executeUpdate(query);
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }

    // Insert New Product To Cart
    public static boolean insertProductToListProduct(String transID, Cart cart) {
        conn.connect();
        String query = "INSERT INTO listproduct VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1,transID);
            stmt.setString(2,cart.getProductID());
            stmt.setInt(3,cart.getQuantity());
            stmt.setDouble(4,cart.getTotal()*cart.getQuantity());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // Create Table
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {
        conn.connect();
        ResultSetMetaData metaData = rs.getMetaData();


        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        conn.disconnect();

        return new DefaultTableModel(data, columnNames);

    }
}