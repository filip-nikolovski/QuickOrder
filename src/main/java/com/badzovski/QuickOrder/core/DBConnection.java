package com.badzovski.QuickOrder.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * Created by filip on 12/12/15.
 */
public class DBConnection {

    private DataSource dataSource;
    Connection conn = null;
    PreparedStatement ps = null;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    try{
//        String query = "";
//
//        conn = dataSource.getConnection();
//        ps = conn.prepareStatement(query);
//
//    }catch(Exception ex){


}

