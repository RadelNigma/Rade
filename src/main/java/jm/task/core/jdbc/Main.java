package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//        В методе main класса Main должны происходить следующие операции:
//
//      1  Создание таблицы User(ов)
//      2  Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
//      3  Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
//      4  Очистка таблицы User(ов)
//      5  Удаление таблицы

        UserDaoJDBCImpl userDaoJDBC  = new UserDaoJDBCImpl();
//        userDaoJDBC.createUsersTable();
//
//        userDaoJDBC.saveUser("Radel","Nigma", (byte) 42);
//        userDaoJDBC.saveUser("Kim","Dandy", (byte) 25);
//        userDaoJDBC.saveUser("Oksana","Fedorova", (byte) 35);
//        userDaoJDBC.saveUser("Poul","Maccartny", (byte) 78);


//        userDaoJDBC.getAllUsers();
//        userDaoJDBC.removeUserById(2);
//        userDaoJDBC.getAllUsers();
//        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
    }
}
