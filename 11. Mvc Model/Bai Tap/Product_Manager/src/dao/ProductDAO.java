package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();

    String save(Product product);

    String update(int id,Product product);
    String remove(int id);
    Product findById(int id);
    Product findName(String name);
    List<Product> findNameRelative(List<Product> list,String name);
}
