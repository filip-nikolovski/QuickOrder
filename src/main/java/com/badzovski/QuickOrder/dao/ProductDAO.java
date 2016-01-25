package com.badzovski.QuickOrder.dao;

import src.main.java.com.badzovski.QuickOrder.model.Product;

import java.util.List;

/**
 * Created by badzovski on 20.1.16.
 */
public interface ProductDAO {

    public Product findByID(int id); //or void

    public void insert(Product Product); //or void

    public void update(Product Product);

    public List<Product> allProductsByRestaurant(int id);

    public void delete(int id);
}