package bo;

import model.Customer;
import model.TypeOfCustomer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO {
    List<Customer> listCustomer();
    String insertCustomer(Customer customer);
    List<TypeOfCustomer> listTypeOfCustomer();
    boolean deleteCustomer(Integer id);
    boolean editCustomer(Customer customer);
    int endPage(int numRecord);
    List<Customer> recordForPage(int numRecord,int pageIndex);
    public List<Customer> findName(String name)  throws SQLException;
}
