package model;

public class DetailTransaction {
    private String transactionID;
    private String productID;
    private int quantity;
    private double total;

    public DetailTransaction(String transactionID, String productID, int quantity, double total) {
        this.transactionID = transactionID;
        this.productID = productID;
        this.quantity = quantity;
        this.total = total;
    }

    public DetailTransaction() {}

    public String getTransactionID() {
        return transactionID;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
