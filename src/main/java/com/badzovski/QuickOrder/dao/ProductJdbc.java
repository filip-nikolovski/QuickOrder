package src.main.java.com.badzovski.QuickOrder.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import src.main.java.com.badzovski.QuickOrder.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by badzovski on 22.12.15.
 */
public class ProductJdbc extends JdbcDaoSupport implements src.main.java.com.badzovski.QuickOrder.dao.ProductDAO {

    public Product findByID(int id) {
        String query = "SELECT * FROM Products"+
                " WHERE ID = "+id;

        Product product = (Product) getJdbcTemplate().queryForObject(query, new BeanPropertyRowMapper(Product.class));

        return product;
    }

    public void insert(Product product) {

        String query = "INSERT INTO Products " +
                "(NAME, DESCRIPTION, PRICE, IMAGE, RESTAURANTID, CATEGORYID) VALUES(?, ?, ?, ?, ?, ?)";

        getJdbcTemplate().update(query, new Object[]{ product.getName(), product.getDescription(), product.getPrice(), product.getImage(), product.getRestaurantID(), product.getCategoryID()});
    }

    public void update(Product product) {

        String query = "UPDATE Products"+
                " SET NAME = ?, DESCRIPTION = ?, PRICE = ?, IMAGE = ?, RESTAURANTID = ?, CATEGORYID = ?"+
                " WHERE ID=?";

        getJdbcTemplate().update(query, new Object[]{product.getName(), product.getDescription(), product.getPrice(), product.getImage(), product.getRestaurantID(), product.getCategoryID(), product.getID()});
    }

    public List<Product> allProductsByRestaurant(int id) {

        String query = "SELECT * FROM Products where RestaurantID ="+id;
//        List<Product> listProducts = new ArrayList<Product>();

        List<Product> listProducts = getJdbcTemplate().query(query, new BeanPropertyRowMapper(Product.class));

        return listProducts;
    }

    public void delete(int id) {

        String query = "DELETE FROM Products WHERE ID=?";

        getJdbcTemplate().update(query, id);
    }
}
