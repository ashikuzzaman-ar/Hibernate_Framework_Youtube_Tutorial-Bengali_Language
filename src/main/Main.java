package main;

import db.config.SessionFactoryProvider;
import static db.config.SessionFactoryProvider.SESSION_FACTORY;
import db.models.Test;
import db.models.UserInfo;
import java.util.HashSet;
import java.util.Set;
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

//        UserInfo userInfo;
        session = SESSION_FACTORY.openSession();

        try {

            transaction = session.beginTransaction();

            UserInfo userInfo = new UserInfo();
            userInfo.setEmail("e_1");
            userInfo.setPassword("p_1");
            userInfo.setUsername("u_1");

            Set<Test> tests = new HashSet<>();

            Test test = new Test();
            test.setAge(12.5D);
            test.setIsMale(Boolean.FALSE);

            Test test1 = new Test();
            test1.setAge(15.5D);
            test1.setIsMale(Boolean.TRUE);

            tests.add(test);
            tests.add(test1);

            userInfo.setTests(tests);

            Set<Test> tests1 = new HashSet<>();

            Test test2 = new Test();
            test2.setAge(25.5D);
            test2.setIsMale(Boolean.TRUE);

            tests1.add(test);
            tests1.add(test2);

            UserInfo userInfo1 = new UserInfo();
            userInfo1.setEmail("e_2");
            userInfo1.setPassword("p_2");
            userInfo1.setUsername("u_2");

            userInfo1.setTests(tests1);

            session.save(userInfo);
            session.save(userInfo1);

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

        UserInfo ui = null;
        try {

            transaction = session.beginTransaction();

            ui = (UserInfo) session.get(UserInfo.class, 1L);
//            Test t = (Test) session.get(Test.class, 1L);

            transaction.commit();
        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();
            }
        } finally {

            session.close();
        }

        if (ui != null) {

            System.out.println("UserInfo Username: " + ui.getUsername());
            for (Test t : ui.getTests()) {

                System.out.println("Test Age: " + t.getAge());
            }
        }

        SESSION_FACTORY.close();
    }
}
