package model;

import java.util.ArrayList;

public class Seller extends Member{
    String storeName;
    ArrayList<Product> listProducts = new ArrayList<>();

    public Seller() {
    }

    // ini dipake kalo member udh ada
    public Seller(Member member,String storeName,ArrayList<Product> listProducts){
        super(member.getUsername(), member.getPassword(), member.getGender(), member.getEmail(), member.getDay(), member.getMonth(), member.getYear(), member.getName(), member.getAddress(), member.getPoint(), member.getMoney());
        this.storeName = storeName;
        this.listProducts = listProducts;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }
}
