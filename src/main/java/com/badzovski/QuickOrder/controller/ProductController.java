package com.badzovski.QuickOrder.controller;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.badzovski.QuickOrder.dao.ProductDAO;
import src.main.java.com.badzovski.QuickOrder.model.Product;

import java.util.List;

/**
 * Created by badzovski on 20.1.16.
 */

@RestController
@RequestMapping("api/Product")
public class ProductController {

    //get the specific cintext
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Module.xml");
    ProductDAO productDAO = ctx.getBean("productDAO", ProductDAO.class);

    @RequestMapping("/")
    public String product(){

        return "All Products...";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable int id){

        try {
            Product product = null;

            product = productDAO.findByID(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "  + ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.toString() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/Restaurant/{id}/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductByRestaurantId(@PathVariable int id , @PathVariable int categoryId){

        try {
            List<Product> listProduct = null;

            listProduct = productDAO.allProductsByRestaurant(id);
            return new ResponseEntity<>(listProduct, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "  + ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.toString() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> inserProduct(@RequestBody Product product){

        try {
            productDAO.insert(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "  + ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.toString() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {

        try {
            productDAO.update(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("User not updated!");
            return new ResponseEntity<>(ex.toString() +" - "+ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping (value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){

        try{
            productDAO.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
