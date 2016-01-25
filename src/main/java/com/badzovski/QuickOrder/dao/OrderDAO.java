package com.badzovski.QuickOrder.dao;

import com.badzovski.QuickOrder.model.Order;

import java.util.List;

/**
 * Created by badzovski on 20.1.16.
 */
public interface OrderDAO {
    public Order findByID(int id); //or void

    public int insert(Order order); //or void

    public int update(Order order);

    public int insertOrderItems(Order order);

    public int deleteOrderItems(int id);

    public List<Order> all(int id, int status);

    public void delete(int id);
}
