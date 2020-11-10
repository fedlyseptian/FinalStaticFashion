/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.Main;
import model.Member;
import model.Product;
import model.Seller;

/**
 *
 * @author jeded
 */
public class ControllerDatabase {
    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean insertMember(Member member) {
        Date date = new Date(member.getYear()-1900,member.getMonth()-1,member.getDay());
        conn.connect();
        String query = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?)";
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
    public static boolean insertSeller(Seller seller) {
        conn.connect();
        String query = "INSERT INTO seller VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
             stmt.setString(1,seller.getUsername());
             stmt.setString(2, seller.getStoreName());
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listProducts);
    }

    public static String md5Java(String message)
    {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            //merubah byte array ke dalam String Hexadecimal
            StringBuilder sb = new StringBuilder(2*hash.length);
            for(byte b : hash)
            {
                sb.append(String.format("%02x", b&0xff));
            }
            digest = sb.toString();
        } catch (UnsupportedEncodingException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return digest;
    }
}
