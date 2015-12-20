package com.badzovski.QuickOrder.controller;

import com.badzovski.QuickOrder.dao.RestaurantDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by filip on 12/12/15.
 */

@RestController
@RequestMapping("api/Restaurant")
public class RestaurantController {

    //Get the specific context
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Module.xml");
    RestaurantDAO restaurantDAO = ctx.getBean("restaurantDAO", RestaurantDAO.class);
}
