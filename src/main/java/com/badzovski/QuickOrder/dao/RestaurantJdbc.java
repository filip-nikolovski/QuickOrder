package com.badzovski.QuickOrder.dao;

import com.badzovski.QuickOrder.model.Restaurant;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by filip on 12/12/15.
 */
public class RestaurantJdbc extends JdbcDaoSupport implements RestaurantDAO {

    @Override
    public int findByID(int id) {
        return 1;
    }

    @Override
    public int insert(Restaurant restaurant) {

        String sql = "INSERT INTO RESTAURANT " +
                "(NAME, LOCATION, EMAIL, DESCRIPTION, IMAGE)";

        getJdbcTemplate().update(sql, new Object[]{restaurant.getName(), restaurant.getLocation(), restaurant.getEmail()});
        return 1;
    }

    @Override
    public int update(Restaurant restaurant) {
        return 1;
    }
}
