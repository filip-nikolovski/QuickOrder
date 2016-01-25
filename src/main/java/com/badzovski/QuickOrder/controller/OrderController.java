package com.badzovski.QuickOrder.controller;

import com.badzovski.QuickOrder.dao.OrderDAO;
import com.badzovski.QuickOrder.model.Order;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by badzovski on 19.1.16.
 */
@RestController
@RequestMapping("api/Order")
public class OrderController {

//    System.out.println("test");

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Module.xml");
    OrderDAO orderDAO = ctx.getBean("orderDAO", OrderDAO.class);

    @RequestMapping("/")
    public String order(){

        System.out.println("test");

        return "All Orders...";
     }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> insertOrder(@RequestBody Order order){

        System.out.println("test ok!!!");

        try{
            orderDAO.insert(order);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "+ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.getMessage() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }

}
