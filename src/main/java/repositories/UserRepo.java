package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import models.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

public class UserRepo implements UserInterface {

    private Session se = HibernateUtil.getSessionFactory().openSession();
    private Transaction tra = se.getTransaction();

    @Override
    public List<User> getAll() {
//        return se.createCriteria(User.class).list();
        List<User> listU = new ArrayList<>();
        Query query = se.createQuery("SELECT U FROM User U");

        listU = query.getResultList();
        return listU;
    }

    @Override
    public List<User> seach(String ma) {
        List<User> listU = new ArrayList<>();
        Query query = se.createQuery("SELECT U FROM User U WHERE U.ma like :Ma");
        query.setParameter("Ma", "%" + ma + "%");
        listU = query.getResultList();
        return listU;
    }

    @Override
    public boolean save(User user) {
        try {
            tra.begin();
            se.saveOrUpdate(user);
            tra.commit();
            return true;
        } catch (Exception e) {
            tra.rollback();
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean delete(User user) {
         try {
            tra.begin();
            se.delete(user);
            tra.commit();
            return true;
        } catch (Exception e) {
            tra.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getObj(String ma) {
        User us = null;
        try {
            Query qu =se.createQuery("SELECT U FROM User U WHERE U.ma=:Ma");
            qu.setParameter("Ma", ma);
            us = (User) qu.getSingleResult();
            
        } catch (Exception e) {
        }
        return us;
    }

}
