package controller;

import main.Main;
import model.Cart;
import model.Member;
import model.Transactions;
import view.ShoppingScreenMenu;

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

    //Hitung Total Biaya Product
    public static double hitungTotalBiayaBelanjaan(ArrayList<Cart> listProductCart){
        double total = 0;
        for(int i = 0 ; i < listProductCart.size() ; i++){
            total += listProductCart.get(i).getTotal() * listProductCart.get(i).getQuantity();
        }
        return total;
    }

    public static String generateNewTransactionID(){
        ArrayList<Transactions>listTransaction= new ArrayList<>();
        listTransaction = ControllerDatabase.getAllTransaction();
        int countTransaction = listTransaction.size();
        String newID = "T"+String.format("%09d", countTransaction+1);
        return newID;
    }
}
