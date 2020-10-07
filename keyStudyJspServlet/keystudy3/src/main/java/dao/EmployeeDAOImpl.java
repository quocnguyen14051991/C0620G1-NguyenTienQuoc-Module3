package dao;

import model.*;
import rowmapper.*;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl extends AbstractDAO<Employee> implements EmployeeDAO {
    private static final String LIST_ALL_EMPLOYEE="SELECT * FROM employee";
    private static final String LIST_ALL_USER="SELECT * FROM user";
    private static final String LIST_ALL_DIVISION="SELECT * FROM division";
    private static final String LIST_ALL_POSITION="SELECT * FROM position";
    private static final String LIST_ALL_EDUCATION="SELECT * FROM education_degree";
    @Override
    public List<Employee> listAllEmployee() {
        return query(LIST_ALL_EMPLOYEE,new EmployeeMapper());
    }

    @Override
    public String insertEmployee(Employee employee) {
        return null;
    }


    @Override
    public List<User> listUser() {
        return query(LIST_ALL_USER,new UserMapper());
    }

    @Override
    public List<Division> listDivision() {
        return query(LIST_ALL_DIVISION,new DivisionMapper());
    }

    @Override
    public List<Position> listPosition() {
        return query(LIST_ALL_POSITION,new PositionMapper());
    }

    @Override
    public List<EducationDegree> listEducationDegree() {
        return query(LIST_ALL_EDUCATION,new EducationDegreeMapper());
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

    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO =new EmployeeDAOImpl();

    }
}
