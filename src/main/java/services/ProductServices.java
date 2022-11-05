package services;

import java.util.ArrayList;
import java.util.List;
import models.Product;
import repositories.ProductInterface;
import repositories.ProductRepo;

/**
 *
 * @author pc
 */
public class ProductServices implements IProduct{
    private ProductInterface productSer = new ProductRepo();
    @Override
    public List<Product> getAll() {
        return productSer.getAll();
    }

    @Override
    public List<Product> search(String ma) {
        return productSer.search(ma);
    }

    @Override
    public boolean save(Product product) {
        return productSer.save(product);
    }

    @Override
    public boolean delete(Product product) {
        return productSer.delete(product);
    }

    @Override
    public Product getObj(String ma) {
        return productSer.getObj(ma);
    }
    
}
