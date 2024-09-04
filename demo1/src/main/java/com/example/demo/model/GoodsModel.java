package com.example.demo.model;

public class GoodsModel {
    private int ID;
    private String Name;
    private double Price;
    private boolean Product;
    private boolean isDeleted;

    public GoodsModel(int id, String name, double price, boolean product, boolean isDeleted){
        ID = id;
        Name = name;
        Price = price;
        Product = product;
        this.isDeleted = isDeleted;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public boolean isProduct() {
        return Product;
    }

    public void setProduct(boolean product) {
        Product = product;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
