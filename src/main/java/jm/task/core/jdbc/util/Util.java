package jm.task.core.jdbc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
   private static String dbURL = "jdbc:h2:mem:test; INIT=RUNSCRIPT FROM 'classpath:init.sql'";
   private static String dbUserName = "sa";
   private static String dbPassword = "";

    public static Connection getConnection()  {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

//    String dbURL = null;
//    String dbUserName = "sa";
//    String dbPassword = "";
//    FileInputStream fis;
//    Properties properties = new Properties();
//
//        try {
//                fis =new FileInputStream("src/main/resources/config.properties");
//                properties.load(fis);
//                dbURL =properties.getProperty("db.host");
//                } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                } catch (IOException e) {
//                e.printStackTrace();
//                }