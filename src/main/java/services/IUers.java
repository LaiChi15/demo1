
package services;

import java.util.List;
import models.User;


public interface IUers {
    List<User> getAll();
    List<User> seach(String ma);
    boolean save(User user);
    boolean delete(User user);
    User getObj(String ma);
    
}
