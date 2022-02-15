package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Radel", "Nigmatullun", (byte) 42);
        userDaoJDBC.saveUser("Ivan", "Krilov", (byte) 100);
        userDaoJDBC.saveUser("Oksana", "Fedorova", (byte) 25);
        userDaoJDBC.saveUser("Paul", "McCartney", (byte) 78);

        userDaoJDBC.getAllUsers();

        userDaoJDBC.cleanUsersTable();

        userDaoJDBC.dropUsersTable();
    }
}
