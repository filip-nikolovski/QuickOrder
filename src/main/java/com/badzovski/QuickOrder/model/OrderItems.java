package com.badzovski.QuickOrder.model;

import java.util.List;

/**
 * Created by badzovski on 23.1.16.
 */
public class OrderItems {

    private Order order;
    private List<Product> productList;
    private List<Promotion> promotionList;
    private String note;
    private int quantity;

    public OrderItems(){
        //empty contructor
    }

    public OrderItems(Order order, List<Product> productList, List<Promotion> promotionList, String note, int quantity) {
        this.order = order;
        this.productList = productList;
        this.promotionList = promotionList;
        this.note = note;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "order=" + order +
                ", productList=" + productList +
                ", promotionList=" + promotionList +
                ", note='" + note + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
