package bo;

import model.*;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO {
    List<Employee> listAllEmployee();
    String insertEmployee(Employee employee);
    List<User> listUser();
    List<Division> listDivision();
    List<Position> listPosition();
    List<EducationDegree> listEducationDegree();
    boolean deleteEmployee(Integer id);
    boolean editEmployee(Customer customer);
    int endPage(int numRecord);
    List<Customer> recordForPage(int numRecord,int pageIndex);
    public List<Customer> findName(String name)  throws SQLException;
}
