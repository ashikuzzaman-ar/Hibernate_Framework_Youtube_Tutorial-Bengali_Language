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
            
            String[] phones = new String[3];
            phones[0] = "01717000000";
            phones[0] = "01617000000";
            phones[0] = "01817000000";
            
            userInfo.setPhones(phones);
            
            Test test = new Test();
            test.setAge(12.5D);
            test.setIsMale(Boolean.FALSE);
            
            userInfo.setTest(test);

            session.save(userInfo);
            
            transaction.commit();
        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();
            }
            throw new ExceptionInInitializerError(e);
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
