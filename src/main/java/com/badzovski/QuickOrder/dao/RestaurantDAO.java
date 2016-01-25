package com.badzovski.QuickOrder.dao;

import src.main.java.com.badzovski.QuickOrder.model.Restaurant;

import java.util.List;

/**
 * Created by badzovski on 20.1.16.
 */
public interface RestaurantDAO {

    public Restaurant findByID(int id); //or void

    public int insert(Restaurant restaurant); //or void

    public int update(Restaurant restaurant);

    public List<Restaurant> allRestoraunts();
}
