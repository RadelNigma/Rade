package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/kata_radel?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "FFpe43FFpe43";

    private static SessionFactory sessionFactory;
    //private static final SessionFactory concreteSessionFactory;

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, URL);
                settings.put(Environment.USER, USERNAME);
                settings.put(Environment.PASS, PASSWORD);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

               //settings.put(Environment.HBM2DDL_AUTO, "none");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }


//    static {
//        try {
//            Properties prop = new Properties();
//            prop.setProperty(Environment.URL,URL);
//            prop.setProperty(Environment.USER,USERNAME);
//            prop.setProperty(Environment.PASS, PASSWORD);
//            prop.setProperty(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
//            prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
//            prop.setProperty(Environment.SHOW_SQL, "true");
//            prop.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//            prop.setProperty(Environment.HBM2DDL_AUTO, "create-drop");
//            prop.setProperty(Environment.SHOW_SQL, "true");
//
////            prop.setProperty("hibernate.connection.url", URL);
////            prop.setProperty("hibernate.connection.username", USERNAME);
////            prop.setProperty("hibernate.connection.password", PASSWORD);
////            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
//
//          //  prop.setProperty("hibernate.hbm2ddl.auto", "create");
//
//            concreteSessionFactory = new Configuration()
//                    .addProperties(prop)
//                    //.addPackage("com.kat")
//                    .addAnnotatedClass(User.class)
//                    .buildSessionFactory()
//            ;
//        }
//        catch (Exception ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//    public static Session getSession() throws HibernateException {
//        return concreteSessionFactory.openSession();
//    }


}
