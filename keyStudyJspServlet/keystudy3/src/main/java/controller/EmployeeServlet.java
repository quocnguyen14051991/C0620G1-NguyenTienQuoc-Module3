package controller;

import bo.EmployeeBO;
import bo.EmployeeBOImpl;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO =new EmployeeBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            response.sendRedirect("");
        }else if(action.equals("listAll")){
            List<Employee> employeeList =employeeBO.listAllEmployee();
            request.setAttribute("employeeList",employeeList);
            List<User> userList =employeeBO.listUser();
            request.setAttribute("userList",userList);
            List<Position> positionList=employeeBO.listPosition();
            request.setAttribute("positionList",positionList);
            List<EducationDegree> educationDegreeList =employeeBO.listEducationDegree();
            request.setAttribute("educationDegreeList",educationDegreeList);
            List<Division> divisionList=employeeBO.listDivision();
            request.setAttribute("divisionList",divisionList);
            request.getRequestDispatcher("view/Employeee.jsp").forward(request,response);
        }
    }
}
