package com.badzovski.QuickOrder.dao;

import com.badzovski.QuickOrder.model.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created by badzovski on 27.12.15.
 */
public class OrderJdbc extends JdbcDaoSupport implements OrderDAO {

    @Override
    public Order findByID(int id) {

        Order order = null;
        String query = "SELECT * FROM Order WHERE ID = "+id;

        order = (Order) getJdbcTemplate().queryForObject(query, new BeanPropertyRowMapper(Order.class));

        return order;
    }

    @Override
    public int insert(Order order) {
        String query = "INSERT INTO Order " +
                "(RetauranID, Status, OrderTime) VALUES (?, ?, ?)";

        return getJdbcTemplate().update(query, new Object[]{order.getRestaurantID(), order.getStatus(), order.getOrderTime()});
    }

    @Override
    public int update(Order order) {

        String query = "UPDATE Order" +
                " SET Status = ?, OrderTime = ?"+
                " WHERE ID=?";

        return getJdbcTemplate().update(query, new Object[]{order.getStatus(), order.getOrderTime(), order.getID()} );

    }

    @Override
    public List<Order> all(int id, int status) {

        String query = "SELECT * FROM Order WHERE RetauranID = "+ id +
                " AND Status="+status;

        List<Order> listOrders = getJdbcTemplate().query(query, new BeanPropertyRowMapper(Order.class));

        return null;
    }

    @Override
    public void delete(int id) {

        String query = "DELETE FROM Order where ID = "+id;

        getJdbcTemplate().update(query);

    }
}
