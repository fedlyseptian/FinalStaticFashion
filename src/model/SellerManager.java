package model;

import java.util.ArrayList;

public class SellerManager{
    private static SellerManager instance;
    private Seller seller;
    private String password;
    private ArrayList<Transactions> listTransaction;

    private SellerManager(){}

    public static SellerManager getInstance() {
        if (instance == null) {
            instance = new SellerManager();
        }
        return instance;
    }

    public static void setInstance(SellerManager instance) {
        SellerManager.instance = instance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Transactions> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(ArrayList<Transactions> listTransaction) {
        this.listTransaction = listTransaction;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
