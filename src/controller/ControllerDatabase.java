/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.nio.channels.Selector;
import java.sql.*;
import java.util.ArrayList;

import main.Main;
import model.*;

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
            stmt.setString(2, seller.getUsername());
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
                listMembers.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listMembers);
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

    // Delete admin
    public static boolean deleteAdmin(Admin admin) {
        conn.connect();
        String query = "DELETE FROM admin WHERE username='"+admin.getUsername()+"'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
