package main;

import db.config.SessionFactoryProvider;
import db.models.Test;
import db.models.UserInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class Main implements SessionFactoryProvider {

    private static Session session;
    private static Transaction transaction;

    public static void main(String[] args) {
        // TODO code application logic here

        UserInfo userInfo;

        session = SESSION_FACTORY.openSession();

        try {

            transaction = session.beginTransaction();

            userInfo = new UserInfo();
            userInfo.setEmail("e_1");
            userInfo.setPassword("p_1");
            userInfo.setUsername("u_1");

            Test test = new Test();
            test.setAge(12.5D);
            test.setIsMale(Boolean.FALSE);

            userInfo.setTest(test);

            UserInfo ui = new UserInfo();
            ui.setEmail("e_2");
            ui.setPassword("p_2");
            ui.setUsername("u_2");

            Test test1 = new Test();
            test1.setAge(15.5D);
            test1.setIsMale(Boolean.TRUE);

            ui.setTest(test1);

            session.save(userInfo);
            session.save(ui);

            transaction.commit();
        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();
            }
            throw new ExceptionInInitializerError(e);
        } finally {

            session.close();
        }

        session = SESSION_FACTORY.openSession();
        transaction = null;

        try {

            transaction = session.beginTransaction();

//            UserInfo ui = (UserInfo) session.get(UserInfo.class, 1L);
            Test t = (Test) session.get(Test.class, 1L);

            transaction.commit();

            System.out.println("UserInfo Username: " + t.getUserInfo().getUsername());
            System.out.println("Test Age: " + t.getAge());
        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();
            }
        } finally {

            session.close();
        }

//        if (userInfo != null) {
//
//            System.out.println("ID: " + userInfo.getId());
//            System.out.println("Username: " + userInfo.getUsername());
//            System.out.println("Password: " + userInfo.getPassword());
//            System.out.println("Email: " + userInfo.getEmail());
//        }
        SESSION_FACTORY.close();
    }
}
