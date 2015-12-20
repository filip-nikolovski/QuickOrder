package com.badzovski.QuickOrder.dao;

import com.badzovski.QuickOrder.model.Product;
/**
 * Created by filip on 12/20/15.
 */

public interface ProductDAO{

    public Product findByID(int id); //or void

    public void insert(Product Product); //or void

    public void update(Product Product);

    public List<Product> allProducts();

    public void delete(int id);
}