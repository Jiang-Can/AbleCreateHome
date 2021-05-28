package com.HospitalManage.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    final static String DRIVER_NAME = "org.sqlite.JDBC";
    final static String URL = "jdbc:sqlite:mydb.db";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }


    public static void close(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
