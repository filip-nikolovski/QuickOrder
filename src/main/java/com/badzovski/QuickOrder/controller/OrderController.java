package com.badzovski.QuickOrder.controller;

import com.badzovski.QuickOrder.dao.OrderDAO;
import com.badzovski.QuickOrder.model.Order;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by badzovski on 20.1.16.
 */
@RestController
@RequestMapping("api/order")
public class OrderController {

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Module.xml");
    OrderDAO orderDAO = ctx.getBean("orderDAO", OrderDAO.class);

    @RequestMapping("/")
    public String order(){

        return "All Orders...";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderById (@PathVariable int id){
        try{
            Order orders = null;
            orders = orderDAO.findByID(id);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.getMessage() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrdersByRestaurant(@PathVariable int id){

        try{
            List<Order> orders = null;
          //  System.out.println(" null "+ orders.size());
            orders = orderDAO.all(id, 0);
          //  System.out.println("isempty "+ orders.size());
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.getMessage() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }



    @RequestMapping(value = "/{restaurantId}/{status}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrdersByRestaurant(@PathVariable int restaurantId, @PathVariable int status ){

        try{
            List<Order> orders = null;
            orders =orderDAO.all(restaurantId, status);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex.getMessage() + " " +ex.getStackTrace());
            return new ResponseEntity<>(ex.getMessage() + " " +ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> insertOrder(@RequestBody Order order){

        System.out.println(order.getStatus() + order.getOrderTime());

        try{
            orderDAO.insert(order);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "+ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.getMessage() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }



    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateOrder(@RequestBody Order order){

        System.out.println("order id i status "+order.getID() + order.getStatus());

        try{
            orderDAO.update(order);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "+ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.getMessage() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/insertItem", method = RequestMethod.POST)
    public ResponseEntity<?> insertItemsInOrder(@RequestBody Order order){
        try{
            orderDAO.insertOrderItems(order);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.getMessage() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/deleteItem/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteItem(@PathVariable int id){

        try {
            orderDAO.deleteOrderItems(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(id, HttpStatus.OK);
        }

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@PathVariable int id){

        System.out.println("order id  "+ id);

        try{
            orderDAO.delete(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "+ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.getMessage() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }

}
