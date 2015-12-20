package com.badzovski.QuickOrder.dao;

import com.badzovski.QuickOrder.model.Restaurant;

/**
 * Created by filip on 12/12/15.
 */
public interface RestaurantDAO {


    public int findByID(int id); //or void

    public int insert(Restaurant restaurant); //or void

    public int update(Restaurant restaurant);
}
