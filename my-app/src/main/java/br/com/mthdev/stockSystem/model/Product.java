package br.com.mthdev.stockSystem.model;

public class Product {
    private String name;
    private String code;
    private double purchasePrice;
    private double sellingPrice;
    private int productsInventory;

    public Product(String name, String code, double purchasePrice, double sellingPrice, int productsInventory){
        this.name = name;
        this.code = code;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.productsInventory = productsInventory;
    }

    public double getSellingPrice() {return sellingPrice;}

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getProductsInventory() {
        return productsInventory;
    }

    public void setProductsInventory(int productsInventory) {
        this.productsInventory = productsInventory;
    }


}
