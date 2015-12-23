package src.main.java.com.badzovski.QuickOrder.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import src.main.java.com.badzovski.QuickOrder.model.Restaurant;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by filip on 12/12/15.
 */
public class RestaurantJdbc extends JdbcDaoSupport implements src.main.java.com.badzovski.QuickOrder.dao.RestaurantDAO {

    @Override
    public Restaurant findByID(int id) {

        Restaurant restoraunt = null;
        String query = "SELECT * FROM Restaurant"+
                " WHERE ID ="+id;

            restoraunt = (Restaurant) getJdbcTemplate().queryForObject(query, new BeanPropertyRowMapper(Restaurant.class));

        return restoraunt;
    }

    @Override
    public List<Restaurant> allRestoraunts() {

        List<Restaurant> listRestoraunt = new ArrayList<Restaurant>();
        String query = "SELECT * FROM Restaurant";

        listRestoraunt = getJdbcTemplate().query(query, new BeanPropertyRowMapper(Restaurant.class));

        return listRestoraunt;
    }




    @Override
    public int insert(Restaurant restaurant) {

        String sql = "INSERT INTO Restaurant " +
                "(NAME, LOCATION, DESCRIPTION) VALUES (?, ?, ?)";

//        try{
            getJdbcTemplate().update(sql, new Object[]{restaurant.getName(), restaurant.getLocation(), restaurant.getDescription()});
            System.out.println("error: " + 1);
            return 1;
//        }catch (Exception ex){
//            System.out.println("error: " + ex.toString());
//            return 0;
//        }

    }

    @Override
    public int update(Restaurant restaurant) {
        String query = "UPDATE Restaurant" +
                " SET NAME = ?, LOCATION = ?, DESCRIPTION = ?"+
                " WHERE ID=?";

        getJdbcTemplate().update(query, new Object[]{restaurant.getName(), restaurant.getLocation(), restaurant.getDescription(), 1});

        System.out.println("error: " + 1);
        return 1;
    }
}
