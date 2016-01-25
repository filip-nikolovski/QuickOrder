package com.badzovski.QuickOrder.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by badzovski on 20.1.16.
 */
public class DBConnection {

    private DataSource dataSource;
    Connection conn = null;
    PreparedStatement ps = null;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
