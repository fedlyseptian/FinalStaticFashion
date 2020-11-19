package model;

import java.util.ArrayList;

public class Seller extends Member{
    String storeName;
    ArrayList<Product> listProducts = new ArrayList<>();
    String pathLogo;
    String discountID;

    public String getPathLogo() {
        return pathLogo;
    }

    public String getDiscountID() {
        return discountID;
    }

    public void setPathLogo(String pathLogo) {
        this.pathLogo = pathLogo;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public Seller() {
    }

    public Seller(Member member,String storeName,ArrayList<Product> listProducts,String pathLogo,String discountID){
        super(member.getUsername(), member.getPassword(), member.getGender(), member.getEmail(), member.getDay(), member.getMonth(), member.getYear(), member.getName(), member.getAddress(), member.getPoint(), member.getMoney());
        this.storeName = storeName;
        this.listProducts = listProducts;
        this.pathLogo=pathLogo;
        this.discountID=discountID;
    }

    public Seller(String storeName, ArrayList<Product> listProducts, String pathLogo, String discountID) {
        this.storeName = storeName;
        this.listProducts = listProducts;
        this.pathLogo = pathLogo;
        this.discountID = discountID;
    }

    public Seller(String username, String password, String gender, String email, int day, int month, int year, String name, String address, double point, double money, String storeName, ArrayList<Product> listProducts, String pathLogo, String discountID) {
        super(username, password, gender, email, day, month, year, name, address, point, money);
        this.storeName = storeName;
        this.listProducts = listProducts;
        this.pathLogo = pathLogo;
        this.discountID = discountID;
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
