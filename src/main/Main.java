package main;

import db.models.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author ashik
 */
public class Main {

    private static final SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    private static Session session;
    private static Transaction transaction;

    public static void main(String[] args) {
        // TODO code application logic here

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test_username_2");
        userInfo.setPassword("test_password_2");
        userInfo.setEmail("test_email_2");
        
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        
        try {

            session.save(userInfo);

            transaction.commit();
        } catch (Exception e) {

            if(transaction != null){
                
                transaction.rollback();
            }
            throw new ExceptionInInitializerError(e);
        } finally {

            session.close();
        }

        sessionFactory.close();
    }
}
