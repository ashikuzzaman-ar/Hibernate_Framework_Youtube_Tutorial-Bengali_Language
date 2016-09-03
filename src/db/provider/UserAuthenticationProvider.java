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
public class UserAuthenticationProvider implements SessionFactoryProvider{
    
    private Session session;
    private Transaction transaction;
    private Query query;
    private String hql ;
    private List<UserAuthentication> resultList ;
    
    public List<UserAuthentication> fromTest(){
        
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
            
            if(this.transaction!=null){
                
                this.transaction.rollback();
            }
        }finally{
            
            this.session.close();
        }
        
        return this.resultList;
    }
    
    
    public List<UserAuthentication> whereTest(){
        
        this.session = SESSION_FACTORY.openSession();
        this.transaction = null;
        this.resultList = null;
        try {
            
            this.transaction = this.session.beginTransaction();
            this.hql = "FROM UserAuthentication UA WHERE UA.username LIKE :ua_un AND UA.id < :ua_id";
            this.query = this.session.createQuery(this.hql);
            this.query.setParameter("ua_un", "Username 5%");
            this.query.setParameter("ua_id", 100L);
            this.resultList = this.query.list();
            this.transaction.commit();
        } catch (Exception e) {
            
            if(this.transaction!=null){
                
                this.transaction.rollback();
            }
        }finally{
            
            this.session.close();
        }
        
        return this.resultList;
    }
    
    public List selectTest(){
        
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
            
            if(this.transaction!=null){
                
                this.transaction.rollback();
            }
        }finally{
            
            this.session.close();
        }
        
        return list;
    }
}
