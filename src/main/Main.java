package main;

import db.config.SessionFactoryProvider;
import static db.config.SessionFactoryProvider.SESSION_FACTORY;
import db.models.UserAuthentication;
import db.models.UserDetails;
import java.util.Date;
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

        session = SESSION_FACTORY.openSession();

        try {

            transaction = session.beginTransaction();

            for (int i = 1; i <= 1000000; i++) {

                UserAuthentication ua = new UserAuthentication();
                ua.setUsername("Username " + i);
                ua.setPassword("Password " + i);

                UserDetails ud = new UserDetails();
                ud.setAddress("Adress " + i);
                ud.setBirthDate(new Date().toString());
                ud.setEmail("Email " + i);
                ud.setFirstName("First Name " + i);
                ud.setLastName("Last Name " + i);
                ud.setPhone("01xxxxx" + i);
                ud.setUserAuthentication(ua);

                ua.setUserDetails(ud);

                session.save(ua);
            }

            transaction.commit();
        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();
            }
            throw new ExceptionInInitializerError(e);
        } finally {

            session.close();
        }

//        session = SESSION_FACTORY.openSession();
//        transaction = null;
//
//        try {
//
//            transaction = session.beginTransaction();
//
//
//            transaction.commit();
//        } catch (Exception e) {
//
//            if (transaction != null) {
//
//                transaction.rollback();
//            }
//        } finally {
//
//            session.close();
//        }
        SESSION_FACTORY.close();
    }
}
