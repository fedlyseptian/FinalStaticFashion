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
    public static boolean insertProduct(Product product) {
        conn.connect();
        String query = "INSERT INTO products VALUES(?,?,?,?,?,?,?,?)";
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
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
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
                listProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listProducts);
    }
    
    //dibuat biar hemat waktu get, soalnya cuma butuh username
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
                seller.setPathLogo(rs.getString("pathLogo"));
                seller.setPathLogo(rs.getString("discountID"));
                listSellers.add(seller);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listSellers);
    }

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
}
