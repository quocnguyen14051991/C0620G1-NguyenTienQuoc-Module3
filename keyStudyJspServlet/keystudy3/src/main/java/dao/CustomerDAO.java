package dao;

import model.Customer;
import model.TypeOfCustomer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> listCustomer();
    String insertCustomer(Customer customer);
    List<TypeOfCustomer> listTypeOfCustomer();
    boolean deleteCustomer(Integer id);
    boolean editCustomer(Customer customer);

}
