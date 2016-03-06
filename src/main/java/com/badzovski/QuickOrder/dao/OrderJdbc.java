package com.badzovski.QuickOrder.dao;

import com.badzovski.QuickOrder.model.Order;
import com.badzovski.QuickOrder.model.Product;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by badzovski on 20.1.16.
 */
public class OrderJdbc extends JdbcDaoSupport implements OrderDAO{


    @Override
    public Order findByID(int id) {

        Order order = null;
        String query = "SELECT * FROM `Order` o WHERE o.`ID` = "+id;
        //query += " AND o.`ID` = oi.`OrderID`";
        //query += " AND "


        //TODO: for not fount not fixed
        order = (Order) getJdbcTemplate().queryForObject(query, new BeanPropertyRowMapper(Order.class));
        System.out.println(order);


        String queryOrderProducts = "SELECT p.* FROM `Order` o, `OrderItems` oi, `Products` p WHERE o.`ID` = "+id;
        queryOrderProducts += " AND o.`ID` = oi.`OrderID`";
        queryOrderProducts += " AND oi.`ProductID` = p.`ID`";

        List<Product> productList = getJdbcTemplate().query(queryOrderProducts, new BeanPropertyRowMapper(Product.class));
        order.setProductList(productList);

        System.out.println(order.getProductList());

        //test case
        if(order == null){
            System.out.println("null");
        }else{
            System.out.println("ne e null "+order.toString());
        }

        return order;
    }

    @Override
    public List<Order> all(int id, int status) {

        String query = "SELECT * FROM `Order` WHERE `restaurantID` = "+ id ;
        if(status != 0){
            query +=" AND `Status`="+status;
        }
        List<Order> listOrders = getJdbcTemplate().query(query, new BeanPropertyRowMapper(Order.class));
        return listOrders;
    }

    @Override
    public int insert(final Order order) {
        final String query = "INSERT INTO `Order` " +
                "( `restaurantID`, `Status`, `Table`, `Note`) VALUES(?, ?, ?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();

        System.out.println("id i status: "+ order.getRestaurantID()+" - "+ order.getStatus());

        int rez = getJdbcTemplate().update(//query, new Object[]{order.getRestaurantID(), order.getStatus()},keyHolder); //, keyHolder
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(query, new String[]{"id"});
                        ps.setInt(1, order.getRestaurantID());
                        ps.setString(2, order.getStatus());
                        ps.setInt(3, order.getTable());
                        ps.setString(4, order.getNote());
                        return ps;
                    }
                },keyHolder);


       // Object object = new Object(){List<Product> }

        order.setID((keyHolder.getKey().intValue()));

        insertOrderItems(order);



/*

        String query1 = "INSERT INTO `OrderItems` (`OrderID`, `ProductID`, `PromotionID`, `Note`, `Quantity`) VALUES(?, ?, ?, ?, ?)";  //, `PromotionID`, `Note`
        getJdbcTemplate().batchUpdate(query1, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Product itemsInOrder = order.getProductList().get(i);

                Promotion promotionInOrder = null;
               // promotionInOrder.setId(0);
                //int broj = 0;

                */
/*if(orderItems.getPromotionList() != null && orderItems.getPromotionList().size()> i){
                    System.out.println("size "+orderItems.getPromotionList().size());
                    System.out.println(orderItems.getPromotionList().get(i));
                    promotionInOrder = orderItems.getPromotionList().get(i);
                }else {
                    promotionInOrder.setId(0);
                }
*//*

        */
/*        System.out.println("i " + i);
                if(orderItems.getPromotionList().size() >= i) {
                    System.out.println(orderItems.getPromotionList().indexOf(i));
                    System.out.println("test: " +orderItems.getPromotionList().get(i));
                    promotionInOrder = orderItems.getPromotionList().get(i);
                }*//*


                System.out.println(keyHolder.getKey().toString() +itemsInOrder.getID() );

                preparedStatement.setString(1,  keyHolder.getKey().toString());
                preparedStatement.setInt(2, itemsInOrder.getID());

                preparedStatement.setInt(3, 0);//promotionInOrder.getId());
                preparedStatement.setString(4, itemsInOrder.getNote());
                preparedStatement.setInt(5, itemsInOrder.getQuantity());

            }

            @Override
            public int getBatchSize() {
                return order.getProductList().size();
            }
        });
*/


        System.out.println("keyholder "+keyHolder.getKey());



        System.out.println("rezult: " +rez);
        return rez;
    }

    @Override
    public int update(Order order) {

        String query = "UPDATE `Order`" +
                " SET `Status` = ?"+  //, `OrderTime` = ?
                " WHERE `ID`=?";

        return getJdbcTemplate().update(query, new Object[]{order.getStatus(), order.getID()} );//order.getID()

        //todo: update whole orders
    }

    @Override
    public int insertOrderItems(final Order order) {
        String query = "INSERT INTO `OrderItems` (`OrderID`, `ProductID`, `PromotionID`, `Note`, `Quantity`) VALUES(?, ?, ?, ?, ?)";  //, `PromotionID`, `Note`
        getJdbcTemplate().batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Product itemsInOrder = order.getProductList().get(i);

                preparedStatement.setInt(1, order.getID() );
                preparedStatement.setInt(2, itemsInOrder.getID());

                preparedStatement.setInt(3, 0);//promotionInOrder.getId());
                preparedStatement.setString(4, itemsInOrder.getNote());
                preparedStatement.setInt(5, itemsInOrder.getQuantity());

            }

            @Override
            public int getBatchSize() {
                return order.getProductList().size();
            }
        });

        //todo: if(promotionList != null)

        return 1;
    }

    @Override
    public int deleteOrderItems(int productID) {

        String query = "DELETE FROM `OrderItems` WHERE `ID` = "+productID;

        return getJdbcTemplate().update(query);

        //return 0;
    }

    @Override
        public void delete(int id) {

        String query = "DELETE FROM `Order` where `ID` = "+id;

        getJdbcTemplate().update(query);

    }
}
