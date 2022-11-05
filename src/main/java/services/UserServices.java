
package services;

import java.util.ArrayList;
import java.util.List;
import models.User;
import repositories.UserInterface;
import repositories.UserRepo;


public class UserServices implements IUers{
    private UserInterface userItg = new UserRepo();
    
    @Override
    public List<User> getAll() {
       List<User> list = new ArrayList<>();
       list = userItg.getAll();
       return list;
    }

    @Override
    public List<User> seach(String ma) {
       List<User> list = new ArrayList<>();
       list = userItg.seach(ma);
       return list;
    }

    @Override
    public boolean save(User user) {
        return userItg.save(user);
    }

    @Override
    public boolean delete(User user) {
        return userItg.delete(user);
    }

    @Override
    public User getObj(String ma) {
        return userItg.getObj(ma);
    }
    
}
