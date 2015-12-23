package src.main.java.com.badzovski.QuickOrder.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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

    


}
