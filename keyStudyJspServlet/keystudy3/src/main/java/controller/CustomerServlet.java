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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO = new CustomerBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("view/home.jsp");
        } else if (action.equals("create")) {
            int endPage = customerBO.endPage(5);

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
            List<Customer> customerList = customerBO.recordForPage(5,1);
            request.setAttribute("customerList", customerList);
            request.setAttribute("endPage",endPage);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        } else if (action.equals("delete")) {
//            String[] valueCheckbox= request.getParameterValues("checkboxCustomer");
            int endPage = customerBO.endPage(5);
            request.setAttribute("endPage", endPage);

            Integer id = Integer.valueOf(request.getParameter("id"));
            boolean check = customerBO.deleteCustomer(id);
            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            List<Customer> customerList = customerBO.recordForPage(5,1);
            request.setAttribute("customerList", customerList);

            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        } else if (action.equals("edit")) {
            int endPage = customerBO.endPage(5);
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
            List<Customer> customerList = customerBO.recordForPage(5,1);
            request.setAttribute("endPage",endPage);
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {

            response.sendRedirect("view/home.jsp");

        } else if (action.equals("listAll")) {


            int endPage = customerBO.endPage(5);
            request.setAttribute("endPage", endPage);
            List<Customer> customerList = customerBO.recordForPage(5, 1);
            request.setAttribute("customerList", customerList);
            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);

        } else if (action.equals("pagination")) {
            int endPage = customerBO.endPage(5);
            request.setAttribute("endPage", endPage);

            int indexPage = Integer.parseInt(request.getParameter("page_index"));
            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            List<Customer> customerList = customerBO.recordForPage(5, indexPage);

            request.setAttribute("endPage",endPage);

            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        } else if(action.equals("search")){
            String valueSearch=request.getParameter("valueSearch");
            List<Customer> customerList= null;
            try {
                customerList = customerBO.findName(valueSearch);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("customerList",customerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request,response);
        }
    }
}
