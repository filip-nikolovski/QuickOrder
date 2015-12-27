package com.badzovski.QuickOrder.dao;

import com.badzovski.QuickOrder.model.Order;

import java.util.List;

/**
 * Created by badzovski on 27.12.15.
 */
public interface OrderDAO {

    public Order findByID(int id); //or void

    public int insert(Order order); //or void

    public int update(Order order);

    public List<Order> all(int id, int status);

    public void delete(int id);
}
