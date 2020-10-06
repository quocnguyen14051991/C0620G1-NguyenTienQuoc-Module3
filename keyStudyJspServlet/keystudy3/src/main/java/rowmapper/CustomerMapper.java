package rowmapper;

import model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(resultSet.getInt("customer_id"));
        customer.setCustomerType(resultSet.getInt("customer_type_id"));
        customer.setCustomerName(resultSet.getString("customer_name"));
        customer.setCustomerBirthDay(resultSet.getString("customer_birthday"));
        customer.setCustomerGender(Integer.parseInt(resultSet.getString("customer_gender")));
        customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
        customer.setCustomerPhone(resultSet.getString("customer_phone"));
        customer.setCustomerEmail(resultSet.getString("customer_email"));
        customer.setCustomerAddress(resultSet.getString("customer_address"));
        return customer;
    }
}
