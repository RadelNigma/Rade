package jm.task.core.jdbc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.query.Query;

import static jm.task.core.jdbc.util.Util.getSessionFactory;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    private void getSession(String sql) {
        Transaction transaction = null;
        try {
            Session session = getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void createUsersTable() {

        getSession("CREATE TABLE IF NOT EXISTS Users(" +
                "id int NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name varchar(50)," +
                "lastName varchar(50)," +
                "age int)");
    }

    @Override
    public void dropUsersTable() {
        getSession("DROP TABLE IF EXISTS users");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(session.load(User.class, id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    @Override
    public List<User> getAllUsers() {
//        Transaction transaction = null;
//        try (Session session = Util.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(new User(name, lastName, age));
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        getSession("delete from Users");
    }
}
