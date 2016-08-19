package main;

import db.config.SessionFactoryProvider;
import db.models.UserInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class Main implements SessionFactoryProvider{

    
    private static Session session;
    private static Transaction transaction;

    public static void main(String[] args) {
        // TODO code application logic here

        UserInfo userInfo1 = new UserInfo();
        UserInfo userInfo2 = new UserInfo();
        userInfo1.setUsername("test_username_1");
        userInfo1.setPassword("test_password_1");
        userInfo1.setEmail("test_email_1");
        userInfo2.setUsername("test_username_2");
        userInfo2.setPassword("test_password_2");
        userInfo2.setEmail("test_email_2");

        session = SESSION_FACTORY.openSession();

        try {
            
            transaction = session.beginTransaction();
            
            session.save(userInfo1);
            session.save(userInfo2);

            userInfo2.setUsername("Changed Username 2");
            
            transaction.commit();
            
            userInfo1.setUsername("Changed Username 1");
        } catch (Exception e) {

            if(transaction != null){

                transaction.rollback();
            }
            throw new ExceptionInInitializerError(e);
        } finally {

            session.close();
        }

        SESSION_FACTORY.close();
    }
}
