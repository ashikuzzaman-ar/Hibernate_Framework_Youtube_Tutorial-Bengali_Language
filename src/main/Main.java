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

    public static void main(String[] args) {
        // TODO code application logic here

        UserInfo userInfo;

        session = SESSION_FACTORY.openSession();

        try {

            transaction = session.beginTransaction();

            String hql = "FROM UserInfo UI WHERE UI.username LIKE 'test_username_2%'";
//            userInfo = (UserInfo) session.get(UserInfo.class, 8L);
//            userInfo = new UserInfo();
//            userInfo.setId(10L);

            Query query = session.createQuery(hql);
            List<UserInfo> userInfos = query.list();

            for(UserInfo ui: userInfos){
                
                session.delete(ui);
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
