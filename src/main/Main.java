package main;

import db.config.SessionFactoryProvider;
import db.models.UserInfo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class Main implements SessionFactoryProvider {

    private static Session session;
    private static Transaction transaction;
    private static Query query;
    private static String hql;
    private static List<UserInfo> userInfos;

    public static void main(String[] args) {
        // TODO code application logic here

        session = SESSION_FACTORY.openSession();

        try {

            transaction = session.beginTransaction();

            hql = "FROM UserInfo UI WHERE UI.username='Changed Username 2'";

            query = session.createQuery(hql);

            userInfos = query.list();

            transaction.commit();
        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();
            }
            throw new ExceptionInInitializerError(e);
        } finally {

            session.close();
        }

        if (userInfos != null && userInfos.size() > 0) {

            for (UserInfo userInfo : userInfos) {

                System.out.println("ID: " + userInfo.getId());
                System.out.println("IUsername: " + userInfo.getUsername());
                System.out.println("Password: " + userInfo.getPassword());
                System.out.println("Email: " + userInfo.getEmail());
            }
        }

        SESSION_FACTORY.close();
    }
}
