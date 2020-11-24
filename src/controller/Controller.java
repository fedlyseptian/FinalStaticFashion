package controller;

import main.Main;
import model.Cart;
import model.Discount;
import model.Member;
import model.Product;
import model.Product;
import model.Transactions;
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

    public static String generateNewTransactionID(){
        ArrayList<Transactions>listTransaction= new ArrayList<>();
        listTransaction = ControllerDatabase.getAllTransaction();
        int countTransaction = listTransaction.size();
        String newID = "T"+String.format("%09d", countTransaction+1);
        return newID;
    }

    public static String generateNewProductID(String productName, String storeName){
        char firstP = productName.charAt(0);
        char lastP = productName.charAt(productName.length()-1);
        char middleP = productName.charAt(productName.length()/2);
        char firstS = storeName.charAt(0);
        char lastS = storeName.charAt(storeName.length()-1);
        char middleS = storeName.charAt(storeName.length()/2);
        String ID1 = (String.valueOf(firstS)+String.valueOf(middleS)+String.valueOf(lastS)+"-"+String.valueOf(firstP)+String.valueOf(middleP)+String.valueOf(lastP)).toUpperCase();
        int count = 1;
        String ID2 = "";
        String newID = ID1+String.format("%03d", count);
        boolean found = false;
        ArrayList<Product> listProduct = ControllerDatabase.getAllProducts();
        for(int i=0;i<listProduct.size();i++){
            if(newID.equals(listProduct.get(i).getProductID())){
                found=true;
                count++;
                ID2 = ID1+String.format("%03d", count);
            }
        }
        if(!found){
            return newID;
        }else{
            return ID2;
        }
    }
}
