package repositories;

import java.util.List;
import models.Category;

/**
 *
 * @author pc
 */
public interface CategoryInterface {
    List<Category> getAll();
    List<Category> Seach(String ten);
    boolean save(Category ca);
    boolean delete(Category ca);
    Category getCategory(String ma);
}
