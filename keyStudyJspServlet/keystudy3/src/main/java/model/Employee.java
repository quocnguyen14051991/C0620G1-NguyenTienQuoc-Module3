package model;

public class Employee {
    private Integer employee_Id;
    private String employee_Name;
    private String employee_Birthday;
    private double employee_Salary;
    private String employee_Id_Card;
    private String employee_Phone;
    private String employee_Email;
    private String employee_Address;
    private Integer position_Id;
    private Integer education_Degree_Id;
    private Integer division_Id;
    private String username;

    public Integer getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(Integer employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getEmployee_Name() {
        return employee_Name;
    }

    public void setEmployee_Name(String employee_Name) {
        this.employee_Name = employee_Name;
    }

    public String getEmployee_Birthday() {
        return employee_Birthday;
    }

    public void setEmployee_Birthday(String employee_Birthday) {
        this.employee_Birthday = employee_Birthday;
    }

    public double getEmployee_Salary() {
        return employee_Salary;
    }

    public void setEmployee_Salary(double employee_Salary) {
        this.employee_Salary = employee_Salary;
    }

    public String getEmployee_Id_Card() {
        return employee_Id_Card;
    }

    public void setEmployee_Id_Card(String employee_Id_Card) {
        this.employee_Id_Card = employee_Id_Card;
    }

    public String getEmployee_Phone() {
        return employee_Phone;
    }

    public void setEmployee_Phone(String employee_Phone) {
        this.employee_Phone = employee_Phone;
    }

    public String getEmployee_Email() {
        return employee_Email;
    }

    public void setEmployee_Email(String employee_Email) {
        this.employee_Email = employee_Email;
    }

    public String getEmployee_Address() {
        return employee_Address;
    }

    public void setEmployee_Address(String employee_Address) {
        this.employee_Address = employee_Address;
    }

    public Integer getPosition_Id() {
        return position_Id;
    }

    public void setPosition_Id(Integer position_Id) {
        this.position_Id = position_Id;
    }

    public Integer getEducation_Degree_Id() {
        return education_Degree_Id;
    }

    public void setEducation_Degree_Id(Integer education_Degree_Id) {
        this.education_Degree_Id = education_Degree_Id;
    }

    public Integer getDivision_Id() {
        return division_Id;
    }

    public void setDivision_Id(Integer division_Id) {
        this.division_Id = division_Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Employee(Integer employee_Id, String employee_Name, String employee_Birthday, double employee_Salary, String employee_Id_Card, String employee_Phone, String employee_Email,
                    String employee_Address, Integer position_Id, Integer education_Degree_Id, Integer division_Id, String username) {
        this.employee_Id = employee_Id;
        this.employee_Name = employee_Name;
        this.employee_Birthday = employee_Birthday;
        this.employee_Salary = employee_Salary;
        this.employee_Id_Card = employee_Id_Card;
        this.employee_Phone = employee_Phone;
        this.employee_Email = employee_Email;
        this.employee_Address = employee_Address;
        this.position_Id = position_Id;
        this.education_Degree_Id = education_Degree_Id;
        this.division_Id = division_Id;
        this.username = username;
    }

    public Employee() {
    }
}
