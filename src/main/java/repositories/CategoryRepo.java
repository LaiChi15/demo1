package repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import models.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author pc
 */
public class CategoryRepo implements CategoryInterface{
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();
    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        Query query = session.createQuery("SELECT C FROM Category C");
        list = query.getResultList();
        return list;
    }

    @Override
    public List<Category> Seach(String ten) {
         List<Category> list = new ArrayList<>();
        Query query = session.createQuery("SELECT C FROM Category C WHERE C.ten like :Ten");
        query.setParameter("Ten", "%"+ten+"%");
        list = query.getResultList();
        return list;
    }

    @Override
    public boolean save(Category ca) {
        try {
            transaction.begin();
            session.saveOrUpdate(ca);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Category ca) {
          try {
            transaction.begin();
            session.delete(ca);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Category getCategory(String ma) {
        Category cate = null;
        try {
            Query qu = session.createQuery("SELECT C FROM Category C WHERE C.ma = :Ma ");
            qu.setParameter("Ma", ma);
            cate = (Category) qu.getSingleResult();
        } catch (Exception e) {
        }
        return cate;
    }
}
