package Servlet;

import Obj.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet" ,urlPatterns = {"","/lisCustomer"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Soihara","20/20/1999","Đà Nẵng","anh/jav_1.jpg"));
        customerList.add(new Customer("Maria Oz","20/20/1999","Đà Nẵng","anh\\jav_2.jpg"));
        customerList.add(new Customer("Koheo shio","20/20/1999","Đà Nẵng","anh\\jav_3.jpg"));
        customerList.add(new Customer("Boe samchi","20/20/1999","Đà Nẵng","anh\\jav_4.jpg"));
        request.setAttribute("list",customerList);
        request.getRequestDispatcher("listCustomer.jsp").forward(request,response);
    }
}
