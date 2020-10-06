package bo;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import model.Customer;
import model.TypeOfCustomer;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO =new CustomerDAOImpl();
    @Override
    public List<Customer> listCustomer() {
        return customerDAO.listCustomer() ;
    }

    @Override
    public String insertCustomer(Customer customer) {
        String mesage=customerDAO.insertCustomer(customer);
        if(mesage==null){
            mesage="This field is not invalid";
        }
        return customerDAO.insertCustomer(customer);
    }

    @Override
    public List<TypeOfCustomer> listTypeOfCustomer() {
        return customerDAO.listTypeOfCustomer();
    }

    @Override
    public boolean deleteCustomer(Integer id) {
       return customerDAO.deleteCustomer(id);
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return customerDAO.editCustomer(customer);
    }

}
