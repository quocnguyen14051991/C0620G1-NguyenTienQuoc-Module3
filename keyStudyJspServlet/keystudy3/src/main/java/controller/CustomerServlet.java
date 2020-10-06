package controller;

import bo.CustomerBO;
import bo.CustomerBOImpl;
import model.Customer;
import model.TypeOfCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO = new CustomerBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("view/home.jsp");
        } else if (action.equals("create")) {
            String idCustomer = null;
            Integer id = Integer.valueOf(request.getParameter("id"));
            Integer typeId = Integer.valueOf(request.getParameter("typeCustomerId"));
            String name = request.getParameter("name");
            String birthDay = request.getParameter("birhDay");
            int gender = Integer.parseInt(request.getParameter("gender"));
            String idCard = request.getParameter("idCard");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            idCustomer = customerBO.insertCustomer(new Customer(id, typeId, name, birthDay, gender,
                    idCard, phone, email, address));
            request.setAttribute("idCustomer", idCustomer);
            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            List<Customer> customerList = customerBO.listCustomer();
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            String value= request.getParameter("checkboxCustomer");
            Integer id = Integer.valueOf(request.getParameter("id"));
            boolean check = customerBO.deleteCustomer(id);
            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            List<Customer> customerList = customerBO.listCustomer();
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        } else if (action.equals("edit")) {
            Integer customerId = Integer.valueOf(request.getParameter("idEdit"));
            Integer typeId = Integer.valueOf(request.getParameter("typeCustomerId"));
            String customerName = request.getParameter("nameEdit");
            String customerBirthDay = request.getParameter("birhDayEdit");
            int customerGender = Integer.parseInt(request.getParameter("gender"));
            String customerIdCard = request.getParameter("idCard");
            String customerPhone = request.getParameter("phone");
            String customerEmail = request.getParameter("email");
            String customerAddress = request.getParameter("address");
            Customer customer = new Customer(customerId, typeId, customerName, customerBirthDay, customerGender, customerIdCard
                    , customerPhone, customerEmail, customerAddress);


            customerBO.editCustomer(customer);
            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            List<Customer> customerList = customerBO.listCustomer();
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("view/home.jsp");
        } else if (action.equals("listAll")) {
            List<Customer> customerList = customerBO.listCustomer();
            request.setAttribute("customerList", customerList);
            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        }
    }
}
