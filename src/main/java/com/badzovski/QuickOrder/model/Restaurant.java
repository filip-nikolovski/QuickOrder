package com.badzovski.QuickOrder.model;

/**
 * Created by filip on 12/12/15.
 */
public class Restaurant {

    private String name;
    private String location;
    private String email;

    public Restaurant() {
    }

    public Restaurant(String name, String location, String email) {
        this.name = name;
        this.location = location;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
