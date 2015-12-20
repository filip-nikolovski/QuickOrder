package com.badzovski.QuickOrder.model;

/**
 * Created by filip on 12/20/15.
 */

public class Product{

    private int ID;
    private String Name;
    private String Description;
    private float Price;
    private String Image;
    private int categoryID;

    /*public Products() {
    }
*/

    public Product(String image, String description, float price, int categoryID, String name, int ID) {
        Image = image;
        Description = description;
        Price = price;
        this.categoryID = categoryID;
        Name = name;
        this.ID = ID;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Product{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", Image='" + Image + '\'' +
                ", categoryID=" + categoryID +
                '}';
    }
}