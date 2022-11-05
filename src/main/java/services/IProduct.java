package services;

import java.util.List;
import models.Product;

/**
 *
 * @author pc
 */
public interface IProduct {
    List<Product> getAll();
    List<Product> search(String ma);
    boolean save(Product product);
    boolean delete(Product product);
    Product getObj(String ma);
}
