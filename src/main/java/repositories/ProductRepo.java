package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import models.Product;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;


public class ProductRepo implements ProductInterface{
    private Session se = HibernateUtil.getSessionFactory().openSession();
    private Transaction tra = se.getTransaction();
    @Override
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        Query qu = se.createQuery("FROM Product");
        list = qu.getResultList();
        return list;
//return se.createCriteria(Product.class).list();
    }

    @Override
    public List<Product> search(String ma) {
        List<Product> list = new ArrayList<>();
        Query qu = se.createQuery("SELECT p FROM Product p WHERE p.ma LIKE :ma");
        qu.setParameter("ma", "%"+ma+"%");
        list = qu.getResultList();
        return list;
    }

    @Override
    public boolean save(Product product) {
        try {
            tra.begin();
            se.saveOrUpdate(product);
            tra.commit();
            return true;
        } catch (Exception e) {
            tra.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
         try {
            tra.begin();
            se.delete(product);
            tra.commit();
            return true;
        } catch (Exception e) {
            tra.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Product getObj(String ma) {
        Product pro = null;
        try {
            Query qu = se.createQuery("SELECT P FROM Product P WHERE P.ma = :Ma");
            qu.setParameter("Ma", ma);
            pro =(Product) qu.getSingleResult();
        } catch (Exception e) {
        }
        return pro;
    }
    
}
