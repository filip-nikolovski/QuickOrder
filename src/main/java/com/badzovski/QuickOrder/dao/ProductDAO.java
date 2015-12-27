package src.main.java.com.badzovski.QuickOrder.dao;

import java.util.List;
import src.main.java.com.badzovski.QuickOrder.model.Product;
/**
 * Created by filip on 12/20/15.
 */

public interface ProductDAO{

    public Product findByID(int id); //or void

    public void insert(Product Product); //or void

    public void update(Product Product);

    public List<Product> allProductsByRestaurant(int id);

    public void delete(int id);
}