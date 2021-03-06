package src.main.java.com.badzovski.QuickOrder.dao;

import src.main.java.com.badzovski.QuickOrder.model.Customer;

import java.util.List;

/**
 * Created by NikolovskiF on 27.05.2015.
 */
public interface CustomerDAO {
    //create
    public void insert(Customer customer);

    //find by id
    public Customer finByCustomerId(int customerId);

    //Update
    public void update(Customer customer);

    //Delete
    public void delete(int id);

    //Get All
    public List<Customer> getAll();
}
