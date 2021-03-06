package dao;

import com.sun.org.apache.regexp.internal.RE;
import model.Customer;
import model.TypeOfCustomer;
import rowmapper.CustomerMapper;
import rowmapper.TypeOfCustomerMapper;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl extends AbstractDAO<Customer> implements CustomerDAO {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String SELECT_ALL_TYPE_OF_CUSTOMER = "select * from customer_type";
    private static final String INSERT_CUSTOMER = "insert into customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card\n" +
            ",customer_phone,customer_email,customer_address)  values(?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id=?";
    private static final String EDIT_CUSTOMER = "update customer set customer_type_id=?,customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where customer_id=?";

    private static final String SUM_RECORD = "select count(*) from customer";
    private static final String RECORD_PAGING = "select * from customer limit ? offset ? ";
    private static final String SEARCH_BY_NAME = "select * from customer where `customer_name` like ? ";


    @Override
    public List<Customer> listCustomer() {

        return query(SELECT_ALL_CUSTOMER, new CustomerMapper());
    }

    @Override
    public String insertCustomer(Customer customer) {
        return insert(INSERT_CUSTOMER, customer.getCustomerId(), customer.getCustomerType(), customer.getCustomerName(), customer.getCustomerBirthDay()
                , customer.getCustomerGender(), customer.getCustomerIdCard(), customer.getCustomerPhone(), customer.getCustomerEmail()
                , customer.getCustomerAddress());
    }

    @Override
    public List<TypeOfCustomer> listTypeOfCustomer() {
        return query(SELECT_ALL_TYPE_OF_CUSTOMER, new TypeOfCustomerMapper());
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        return update(DELETE_CUSTOMER, id);
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return update(EDIT_CUSTOMER, customer.getCustomerType(), customer.getCustomerName(), customer.getCustomerBirthDay()
                , customer.getCustomerGender()
                , customer.getCustomerIdCard(), customer.getCustomerPhone(), customer.getCustomerEmail(),
                customer.getCustomerAddress(), customer.getCustomerId());
    }

    @Override
    public int endPage(int numRecord) {
        int sumRecord = sumRecord(SUM_RECORD);
        int endPage = sumRecord / numRecord;
        if (sumRecord % numRecord != 0) {
            endPage++;
        }
        return endPage;
    }

    @Override
    public List<Customer> recordForPage(int numRecord, int pageIndex) {
        return query(RECORD_PAGING, new CustomerMapper(), numRecord, (pageIndex - 1) * numRecord);
    }

    @Override
    public List<Customer> findName(String name)  {
        name="%"+name+"%";
        return query(SEARCH_BY_NAME,new CustomerMapper(),name);
    }



    public static void main(String[] args) {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
//        System.out.println(customerDAO.endPage(5));
//        System.out.println(customerDAO.findName("quoc"));

//        System.out.println(customerDAO.listTypeOfCustomer().toString());
//        System.out.println(customerDAO.listCustomer().toString());
//        System.out.println(customerDAO.deleteCustomer(3));
//        System.out.println(customerDAO.editCustomer(1));
//Customer customer=new Customer(1,1,
//        "2020-02-02","2020-02-02",0,"200","qippc",
//        "qioocss","2000");
//        System.out.println(customer.toString());
//        System.out.println( customerDAO.editCustomer(customer));
//        System.out.println();
    }
}
