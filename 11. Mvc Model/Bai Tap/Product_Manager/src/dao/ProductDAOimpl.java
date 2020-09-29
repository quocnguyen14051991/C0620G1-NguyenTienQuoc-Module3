package dao;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductDAOimpl implements ProductDAO {
    static Map<Integer, Product> mapProduct = new TreeMap<>();

    static {
        mapProduct.put(1, new Product("1", "Omo", "200"));
        mapProduct.put(2, new Product("2", "Coca", "200"));
        mapProduct.put(3, new Product("3", "Pepsi", "200"));
        mapProduct.put(4, new Product("4", "Lavie", "200"));
        mapProduct.put(5, new Product("5", "Voka", "200"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(mapProduct.values());
    }

    @Override
    public String save(Product product) {
        this.mapProduct.put(Integer.parseInt(product.getIdProduct()), product);
        return "Add new ok";
    }

    @Override
    public String update(int id, Product product) {
        this.mapProduct.put(id, product);
        return "Update ok";
    }

    @Override
    public String remove(int id) {
        this.mapProduct.remove(id);
        return "Delete is ok";
    }

    @Override
    public Product findById(int id) {
        return mapProduct.get(id);
    }

    @Override
    public Product findName(String name) {
        return null;
    }

    @Override
    public List<Product> findNameRelative(List<Product> list,String name) {
        List<Product> listProduct=new ArrayList<Product>();
        for (Product product: list) {
            if(product.getNameProduct() != null && product.getNameProduct().contains(name)){
                listProduct.add(product);
            }
        }
        return listProduct;
    }
}
