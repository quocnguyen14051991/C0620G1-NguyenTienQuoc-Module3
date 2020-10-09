package bo;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.*;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
EmployeeDAO employeeDAO =new EmployeeDAOImpl();
    @Override
    public List<Employee> listAllEmployee() {
        return employeeDAO.listAllEmployee();
    }

    @Override
    public String insertEmployee(Employee employee) {
        return null;
    }

    @Override
    public List<User> listUser() {
        return employeeDAO.listUser();
    }

    @Override
    public List<Division> listDivision() {
        return employeeDAO.listDivision();
    }

    @Override
    public List<Position> listPosition() {
        return employeeDAO.listPosition();
    }

    @Override
    public List<EducationDegree> listEducationDegree() {
        return employeeDAO.listEducationDegree();
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        return false;
    }

    @Override
    public boolean editEmployee(Customer customer) {
        return false;
    }

    @Override
    public int endPage(int numRecord) {
        return 0;
    }

    @Override
    public List<Customer> recordForPage(int numRecord, int pageIndex) {
        return null;
    }

    @Override
    public List<Customer> findName(String name) throws SQLException {
        return null;
    }
}
