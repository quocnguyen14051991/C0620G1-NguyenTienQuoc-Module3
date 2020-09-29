package bo;

import dao.ProductDAO;
import dao.ProductDAOimpl;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBOimpl implements ProductBO {

    ProductDAO productDAO = new ProductDAOimpl();

    @Override
    public List<Product> findAll() {
        return this.productDAO.findAll();
    }

    @Override
    public String save(Product product) {
        String message=null;
        if(product.getNameProduct()==null || product.getNameProduct().equals("")){
            message="save not ok";
        }else {
            message=this.productDAO.save(product);
        }
        return message;
    }

    @Override
    public Product findById(int id) {
       return this.productDAO.findById(id);
    }

    @Override
    public String update(int id, Product product) {
        String message=null;
        if(product==null){
            message="Update not ok";
        }else {
            message=productDAO.update(id,product);
        }
        return message;
    }

    @Override
    public String remove(int id) {
        return productDAO.remove(id);
    }

    @Override
    public List<Product> findNameRelative(List<Product> list, String name) {
       List<Product> productList;
       productList=this.productDAO.findNameRelative(list,name);
     return productList;
    }
}
