package controller;

import main.Main;
import model.Cart;
import model.Discount;
import model.Member;
import model.Product;
import view.ShoppingScreenMenu;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static view.AboutUsMenu.aboutUsText;

public class Controller {

    // Password to md5
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

    // Validate Member
    public static boolean validateMember(Member member, String username, String password){
        if(member.getUsername().equals(username) && member.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    // Password to String
    public static String toStringPass(char [] password) {
        String pass = "";
        for (int i = 0; i < password.length; i++) {
            pass += password[i];
        }
        return pass;
    }

    //Hitung Total Biaya Product Sebelum Diskon
    public static double hitungTotalBiayaBelanjaan(ArrayList<Cart> listProductCart){
        double total = 0;
        for(int i = 0 ; i < listProductCart.size() ; i++){
            total += listProductCart.get(i).getTotal() * listProductCart.get(i).getQuantity();
        }
        return total;
    }

    //Hitung Total Diskon
    public static double hitungTotalDiscount(ArrayList<Cart> listProductCart){
        double total = 0;
        double totalDiskon = 0;
        for(int i = 0 ; i < listProductCart.size() ; i++){
            //Get Discount Product
            Discount tempDiscount = ControllerDatabase.getDiscountByStoreName(listProductCart.get(i).getStoreName());
            total = (listProductCart.get(i).getTotal() * listProductCart.get(i).getQuantity());
            totalDiskon += total * tempDiscount.getDiscountValue();
        }
        return totalDiskon;
    }

    //Hitung Total Biaya Product Setelah Diskon
    public static double hitungTotalBiayaBelanjaanSetelahDiscount(ArrayList<Cart> listProductCart){
        double grandTotal = 0;
        grandTotal = hitungTotalBiayaBelanjaan(listProductCart) - hitungTotalDiscount(listProductCart);
        return grandTotal;
    }

    //Update Stock Because Cart
    public static void updateListProduct(ArrayList<Product> listProduct, String idProduct, int jumlahBarang){
        for(int i = 0 ; i < listProduct.size() ; i++){
            if(idProduct.equals(listProduct.get(i).getProductID())){
                listProduct.get(i).setProductStock(jumlahBarang);
            }
        }
    }
}
