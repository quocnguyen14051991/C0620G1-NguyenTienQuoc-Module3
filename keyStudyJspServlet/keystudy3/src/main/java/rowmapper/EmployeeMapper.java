package rowmapper;

import model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet) throws SQLException {
        Employee employee =new Employee();
        employee.setEmployee_Id(resultSet.getInt("employee_id"));
        employee.setEmployee_Name(resultSet.getString("employee_name"));
        employee.setEmployee_Birthday(resultSet.getString("employee_birthday"));
        employee.setEmployee_Salary(resultSet.getDouble("employee_salary"));
        employee.setEmployee_Id_Card(resultSet.getString("employee_id_card"));
        employee.setEmployee_Phone(resultSet.getString("employee_phone"));
        employee.setEmployee_Email(resultSet.getString("employee_email"));
        employee.setEmployee_Address(resultSet.getString("employee_address"));
        employee.setPosition_Id(resultSet.getInt("position_id"));
        employee.setEducation_Degree_Id(resultSet.getInt("education_degree_id"));
        employee.setDivision_Id(resultSet.getInt("division_id"));
        employee.setUsername(resultSet.getString("username"));
        return employee;
    }
}
