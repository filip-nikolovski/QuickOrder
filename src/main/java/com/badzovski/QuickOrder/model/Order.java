package com.badzovski.QuickOrder.model;

/**
 * Created by badzovski on 27.12.15.
 */
public class Order {

    private int ID;
    private String orderTime;
    private String status;
    private int restaurantID;

    public Order() {
    }


    public Order(int ID, String orderTime, String status, int restaurantID) {
        this.ID = ID;
        this.orderTime = orderTime;
        this.status = status;
        this.restaurantID = restaurantID;
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

    @Override
    public String toString() {
        return "OrderDAO{" +
                "ID=" + ID +
                ", orderTime='" + orderTime + '\'' +
                ", status='" + status + '\'' +
                ", restaurantID=" + restaurantID +
                '}';
    }
}
