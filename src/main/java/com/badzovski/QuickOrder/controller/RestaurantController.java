package com.badzovski.QuickOrder.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.badzovski.QuickOrder.dao.RestaurantDAO;
import src.main.java.com.badzovski.QuickOrder.model.Restaurant;

import java.util.List;

/**
 * Created by badzovski on 20.1.16.
 */
@RestController
@RequestMapping("api/restaurant")
public class RestaurantController {

    //Get the specific context
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Module.xml");
    RestaurantDAO restaurantDAO = ctx.getBean("restaurantDAO", RestaurantDAO.class);

    @RequestMapping("/")
    public ResponseEntity<?> allRestaurants() {

        try{
            List<Restaurant> listRestaurant = null;
            listRestaurant = restaurantDAO.allRestoraunts();

            return new ResponseEntity<>(listRestaurant, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("error "+ex.toString());
            return new ResponseEntity<>(ex.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getByID(@PathVariable("id") int id){
        try{

            Restaurant restaurant = restaurantDAO.findByID(id);

            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "+ex.toString());
            return new ResponseEntity<>(ex.toString() ,HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody Restaurant restaurant){
        try{
            restaurantDAO.insert(restaurant);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "+ex.toString());
            return new ResponseEntity<>(ex.toString() ,HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Restaurant restaurant){
        try{
            restaurantDAO.update(restaurant);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "+ex.toString());
            return new ResponseEntity<>(ex.toString() ,HttpStatus.BAD_REQUEST);
        }
    }



}
