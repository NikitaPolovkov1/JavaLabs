package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static String dbUrl =  "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
    private static String dbUsername = "sa";
    private static String dbPassowrd = "";
    public static Connection getConnection(){
         Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassowrd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
