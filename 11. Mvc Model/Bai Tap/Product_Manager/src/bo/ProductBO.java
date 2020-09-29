package bo;

import model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAll();
    String save(Product product);
    Product findById(int id);
    String update(int id,Product product);
    String remove(int id);
    List<Product> findNameRelative(List<Product> list,String name);
}
