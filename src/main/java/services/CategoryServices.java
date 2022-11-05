package services;

import java.util.ArrayList;
import java.util.List;
import models.Category;
import repositories.CategoryInterface;
import repositories.CategoryRepo;


public class CategoryServices implements ICategory{
    private CategoryInterface cateSer = new CategoryRepo();
    @Override
    public List<Category> getAll() {
        List<Category> listC = new ArrayList<>();
        listC = cateSer.getAll();
        return listC;
    }

    @Override
    public List<Category> seach(String ten) {
        List<Category> listC = new ArrayList<>();
        listC = cateSer.Seach(ten);
        return listC;
    }
    @Override
    public boolean save(Category ca) {
        return cateSer.save(ca);
    }

    @Override
    public boolean delete(Category ca) {
        return cateSer.delete(ca);
    }

    @Override
    public Category getObj(String ma) {
        return cateSer.getCategory(ma);
    }
    
}
