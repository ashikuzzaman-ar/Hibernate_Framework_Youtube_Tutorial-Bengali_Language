/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.provider;

import db.config.SessionFactoryProvider;
import db.models.UserAuthentication;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class UserAuthenticationProvider implements SessionFactoryProvider {

    private Session session;
    private Transaction transaction;
    private Query query;
    private String hql;
    private List<UserAuthentication> resultList;

    public List<UserAuthentication> fromTest() {

        this.session = SESSION_FACTORY.openSession();
        this.transaction = null;
        this.resultList = null;
        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "FROM UserAuthentication UA";
            this.query = this.session.createQuery(this.hql);
//            this.query.setFirstResult(0);
//            this.query.setMaxResults(10);
            this.resultList = this.query.list();
            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        return this.resultList;
    }
    
    
    public List<UserAuthentication> limitTest() {

        this.session = SESSION_FACTORY.openSession();
        this.transaction = null;
        this.resultList = null;
        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "FROM UserAuthentication UA";// ORDER BY UA.id DESC
            this.query = this.session.createQuery(this.hql);
            this.query.setFirstResult(20);
            this.query.setMaxResults(10);
            this.resultList = this.query.list();
            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        return this.resultList;
    }

    public List<UserAuthentication> whereTest() {

        this.session = SESSION_FACTORY.openSession();
        this.transaction = null;
        this.resultList = null;
        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "FROM UserAuthentication UA WHERE UA.id < :ua_id";
            this.query = this.session.createQuery(this.hql);
            this.query.setParameter("ua_id", 15L);
            this.resultList = this.query.list();
            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        return this.resultList;
    }

    public Boolean updateTest() {

        this.session = SESSION_FACTORY.openSession();
        this.transaction = null;
        Boolean isUpdates = false;
        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "UPDATE UserAuthentication UA SET UA.username = :ua_un WHERE ( UA.id < :ua_id1 AND UA.id > :ua_id2 )";
            this.query = this.session.createQuery(this.hql);
            this.query.setParameter("ua_un", "Changed Username");
            this.query.setParameter("ua_id1", 10L);
            this.query.setParameter("ua_id2", 5L);
            this.query.executeUpdate();
            this.transaction.commit();
            isUpdates = true;
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }

            throw new ExceptionInInitializerError(e);
        } finally {

            this.session.close();
        }

        return isUpdates;
    }

    public Boolean deleteTest() {

        this.session = SESSION_FACTORY.openSession();
        this.transaction = null;
        Boolean isUpdates = false;
        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "DELETE FROM UserAuthentication UA WHERE ( UA.id <= :ua_id1 AND UA.id >= :ua_id2 )";
            this.query = this.session.createQuery(this.hql);
            this.query.setParameter("ua_id1", 7L);
            this.query.setParameter("ua_id2", 4L);
            this.query.executeUpdate();
            this.transaction.commit();
            isUpdates = true;
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }

            throw new ExceptionInInitializerError(e);
        } finally {

            this.session.close();
        }

        return isUpdates;
    }
    
    
    public List aggrTest() {

        this.session = SESSION_FACTORY.openSession();
        this.transaction = null;
        List list = null;
        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "SELECT AVG(UA.id) FROM UserAuthentication UA";
            this.query = this.session.createQuery(this.hql);
            list = this.query.list();
            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }

            throw new ExceptionInInitializerError(e);
        } finally {

            this.session.close();
        }

        return list;
    }

    public List selectTest() {

        this.session = SESSION_FACTORY.openSession();
        this.transaction = null;
        List list = null;
        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "SELECT UA.username FROM UserAuthentication UA";
            this.query = this.session.createQuery(this.hql);
            list = this.query.list();
            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        return list;
    }
}
