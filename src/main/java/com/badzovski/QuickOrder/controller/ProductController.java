package src.main.java.com.badzovski.QuickOrder.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by badzovski on 22.12.15.
 */

@RestController
@RequestMapping("api/Product")
public class ProductController {

    //get the specific cintext
    ClassPathXmlApplicationContext ctx =new ClassPathXmlApplicationContext("Spring-Module.xml");
    src.main.java.com.badzovski.QuickOrder.dao.ProductDAO productDAO = ctx.getBean("productDAO", src.main.java.com.badzovski.QuickOrder.dao.ProductDAO.class);

    @RequestMapping("/")
    public String product(){

        return "All Products...";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable int id){

        try {
            src.main.java.com.badzovski.QuickOrder.model.Product product = null;

            product = productDAO.findByID(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "  + ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.toString() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/Restaurant/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductByRestaurantId(@PathVariable int id){

        try {
            List<src.main.java.com.badzovski.QuickOrder.model.Product> listProduct = null;

            listProduct = productDAO.allProductsByRestaurant(id);
            return new ResponseEntity<>(listProduct, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "  + ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.toString() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> inserProduct(@RequestBody src.main.java.com.badzovski.QuickOrder.model.Product product){

        try {
            productDAO.insert(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception ex){
            System.out.println("Error "  + ex.getMessage() + ex.getStackTrace());
            return new ResponseEntity<>(ex.toString() + ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody src.main.java.com.badzovski.QuickOrder.model.Product product) {

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
