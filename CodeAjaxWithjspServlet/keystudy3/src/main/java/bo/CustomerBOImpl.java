package bo;

import common.Validation;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import model.Customer;
import model.TypeOfCustomer;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.Validation.*;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public List<Customer> listCustomer() {
        return customerDAO.listCustomer();
    }

    @Override
    public String insertCustomer(Customer customer) {
        String messages = "";
        String errormsg = " ";
        String messageSum = "Not Success";
        boolean flag = true;

        if (customer.getCustomerName() == null || customer.getCustomerName().equals("")) {
            errormsg = "Please Input Name";
            flag = false;
        } else if (!Validation.isValid(customer.getCustomerName(), REGEX_NAME)) {
            errormsg = "Please Do not Input Digit Name";
            flag = false;
        }

        messages += customer.getCustomerName() + "," + errormsg + ",";
        if (customer.getCustomerPhone() == null || customer.getCustomerPhone().equals("")) {
            errormsg = "Please Input Phone";
            flag = false;
        } else if (!Validation.isValid(customer.getCustomerPhone(), Validation.REGEX_PHONE1)) {
            errormsg = " Please Do not Input Digit Phone";
            flag = false;
        }
        messages += customer.getCustomerPhone() + "," + errormsg + ",";
        errormsg = " ";
        if (customer.getCustomerIdCard() == null || customer.getCustomerIdCard().equals("")) {
            errormsg = "Please Input Id Card";
            flag = false;
        } else if (!Validation.isValid(customer.getCustomerIdCard(), Validation.REGEX_ID_NUMBER)) {
            errormsg = " Please Do not Input Digit Id Card";
            flag = false;
        }
        messages += customer.getCustomerIdCard() + "," + errormsg + ",";
        errormsg = " ";

        if (customer.getCustomerEmail() == null || customer.getCustomerEmail().equals("")) {
            errormsg = "Please Input Email";
            flag = false;
        } else if (!Validation.isValid(customer.getCustomerEmail(), Validation.REGEX_EMAIL)) {
            errormsg = " Please Do not Input Digit Email";
            flag = false;
        }
        messages += customer.getCustomerEmail() + "," + errormsg;

        if (flag) {
            messageSum = customerDAO.insertCustomer(customer);
        }
        messages += "," + messageSum;
        return messages;
    }

    @Override
    public List<TypeOfCustomer> listTypeOfCustomer() {
        return customerDAO.listTypeOfCustomer();
    }

    @Override
    public String deleteCustomer(Integer id) {


        return customerDAO.deleteCustomer(id);
    }

    @Override
    public String editCustomer(Customer customer) {
        boolean flag = true;
        String erroSmg = " ";
        String message = "";
        String name=customer.getCustomerName();
        if (customer.getCustomerName() == null || customer.getCustomerName().equals("")) {
            erroSmg = "Please Input Name";
            flag = false;
        } else if (!Validation.isValid(name, REGEX_NAME)) {
            erroSmg = "Name is not valid Input again please";
            flag = false;
        }
        message += erroSmg + ",";

        erroSmg=" ";
        if(customer.getCustomerBirthDay()==null|| customer.getCustomerBirthDay().equals("")){
            erroSmg="Please Input birth day";
            flag=false;
        }else if(Validation.isvalidBirthDay(customer.getCustomerBirthDay()) == false){
            erroSmg="birth Day is not valid";
            flag=false;
        }
        message+=erroSmg+",";

        erroSmg = " ";
        if (customer.getCustomerIdCard() == null || customer.getCustomerIdCard().equals("")) {
            erroSmg += "Please Input id Card";
            flag = false;
        } else if (!Validation.isValid(customer.getCustomerIdCard(), REGEX_ID_NUMBER)) {
            erroSmg += "id card Is not valid";
            flag = false;
        }
        message += erroSmg + ",";

        erroSmg = " ";
        if (customer.getCustomerPhone() == null || customer.getCustomerPhone().equals("")) {
            erroSmg += "please Enter Number Phone";
            flag = false;
        } else if (!isValid(customer.getCustomerPhone(), REGEX_PHONE)) {
            erroSmg += "Number Phone is not valid";
            flag = false;
        }
        message += erroSmg + ",";

        erroSmg = " ";
        if (customer.getCustomerAddress() == null || customer.getCustomerAddress().equals("")) {
            erroSmg += "Please Input Address";
            flag = false;
        } else if (!isValid(customer.getCustomerAddress(), REGEX_ADDRESS)) {
            erroSmg = "Address is not valid";
            flag = false;
        }
        message += erroSmg + ",";

        if (flag) {
            return message += customerDAO.editCustomer(customer);
        }
        message += "Not Success";
        return message;
    }

    @Override
    public int endPage(int numRecord) {
        return customerDAO.endPage(numRecord);
    }

    @Override
    public List<Customer> recordForPage(int numRecord, int pageIndex) {
        return customerDAO.recordForPage(numRecord, pageIndex);
    }

    @Override
    public List<Customer> findName(String name) throws SQLException {
        return customerDAO.findName(name);
    }

}
