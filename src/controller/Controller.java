package controller;

import main.Main;
import model.Member;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
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

    public static boolean validateMember(Member member, String username, String password){
        if(member.getUsername().equals(username) && member.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    public static String toStringPass(char [] password){
        String pass="";
        for(int i=0;i<password.length;i++){
            pass+=password[i];
        }
        return pass;
    }
}
