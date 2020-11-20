package model;

import java.util.ArrayList;

public class SellerManager{
    private static SellerManager instance;
    private Seller seller;
    private ArrayList<Transactions> listTransaction;

    private SellerManager(){

    }

    public static SellerManager getInstance() {
        if (instance == null) {
            instance = new SellerManager();
        }
        return instance;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
