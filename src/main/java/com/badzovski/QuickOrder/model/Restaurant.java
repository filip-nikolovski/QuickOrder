package com.badzovski.QuickOrder.model;

/**
 * Created by filip on 12/12/15.
 */
public class Restaurant {

    private String name;
    private String location;
    private String description;


    public Restaurant() {
    }

    public Restaurant(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", email='" + description + '\'' +
                '}';
    }
}
