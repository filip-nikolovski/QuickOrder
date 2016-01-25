package com.badzovski.QuickOrder.model;

import java.util.List;

/**
 * Created by badzovski on 20.1.16.
 */
public class Order {

    private int ID;
    private String orderTime;
    private String status;
    private int restaurantID;
    private String note;
    private int table;
    private List<Product> productList;
    private List<Promotion> promotionList;

                //retauranID

    public Order() {
    }


    public Order(int ID, String orderTime, String status, int restaurantID, List<Product> productList, List<Promotion> promotionList, String note, int table) {
        this.ID = ID;
        this.orderTime = orderTime;
        this.status = status;
        this.restaurantID = restaurantID;
        this.productList = productList;
        this.promotionList = promotionList;
        this.note = note;
        this.table = table;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", orderTime='" + orderTime + '\'' +
                ", status='" + status + '\'' +
                ", restaurantID=" + restaurantID +
                ", productList=" + productList +
                ", promotionList=" + promotionList +
                ", note=" + note +
                ", table=" + table +
                '}';
    }
}
