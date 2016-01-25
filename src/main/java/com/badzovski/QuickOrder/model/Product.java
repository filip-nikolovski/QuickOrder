package com.badzovski.QuickOrder.model;

/**
 * Created by badzovski on 20.1.16.
 */
public class Product {

    private int ID;
    private String Name;
    private String Description;
    private float Price;
    private String Image;
    private int categoryID;
    private int restaurantID;

    //properties for items in order
    private int quantity;
    private String note;

    public Product() {
    }

    public Product(String image, String description, float price, int categoryID, String name, int ID, int restaurantID, int quantity, String note) {
        Image = image;
        Description = description;
        Price = price;
        this.categoryID = categoryID;
        Name = name;
        this.ID = ID;
        this.restaurantID = restaurantID;
        this.quantity = quantity;
        this.note = note;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Product{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", Image='" + Image + '\'' +
                ", categoryID=" + categoryID +
                ", restaurantID=" + restaurantID +
                ", quantity=" + quantity +
                ", note=" + note +
                '}';
    }
}