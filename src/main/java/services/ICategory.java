package services;

import java.util.List;
import models.Category;

/**
 *
 * @author pc
 */
public interface ICategory {
    List<Category> getAll();
    List<Category> seach(String ten);
    boolean save(Category ca);
    boolean delete(Category ca);
    Category getObj(String ma);
}
