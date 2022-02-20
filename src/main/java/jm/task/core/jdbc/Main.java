package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
       // userService.createUsersTable();

        userService.saveUser("Radel", "Nigmatullun", (byte) 42);
        userService.saveUser("Ivan", "Krilov", (byte) 100);
        userService.saveUser("Oksana", "Fedorova", (byte) 25);
        userService.saveUser("Paul", "McCartney", (byte) 78);

       // userService.getAllUsers();

      //  userService.cleanUsersTable();

       // userService.dropUsersTable();
    }
}
