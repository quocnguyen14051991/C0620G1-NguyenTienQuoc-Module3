package controller;

import bo.CustomerBO;
import bo.CustomerBOImpl;
import com.google.gson.Gson;
import model.Customer;
import model.TypeOfCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
            String messages = null;
            Integer id = Integer.valueOf(request.getParameter("id"));
            Integer typeId = Integer.valueOf(request.getParameter("typeCustomerId"));
            String name = request.getParameter("name");
            String birthDay = request.getParameter("birhDay");
            int gender = Integer.parseInt(request.getParameter("gender"));
            String idCard = request.getParameter("idCard");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            messages = customerBO.insertCustomer(new Customer(id, typeId, name, birthDay, gender,
                    idCard, phone, email, address));
            request.setAttribute("messages", messages);
            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            List<Customer> customerList = customerBO.recordForPage(5, 1);
            request.setAttribute("customerList", customerList);
            request.setAttribute("endPage", endPage);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);


        } else if (action.equals("delete")) {
            int endPage = customerBO.endPage(5);
            request.setAttribute("endPage", endPage);
            String[] toDelete = request.getParameterValues("toDelete[]");
            Integer id = null;
            try {
                id = Integer.valueOf(request.getParameter("id"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (toDelete != null) {
                int[] toBeDeleted = new int[toDelete.length];
                for (int i = 0; i < toDelete.length; i++) {
                    toBeDeleted[i] = Integer.parseInt(toDelete[i]);
                    String check = customerBO.deleteCustomer(toBeDeleted[i]);
                }
            } else if (id != null) {
                customerBO.deleteCustomer(id);
            }
            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            List<Customer> customerList = customerBO.recordForPage(5, 1);
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        } else if (action.equals("edit")) {

            Gson gson = new Gson();
            String messageEdit = "";
            int endPage = customerBO.endPage(5);
            Integer customerId = Integer.valueOf(request.getParameter("idCusEdit"));
            Integer typeId = Integer.valueOf(request.getParameter("typeCusEdit"));
            String customerName = request.getParameter("nameCusEdit");
            String customerBirthDay = request.getParameter("birthDayCusEdit");
            int customerGender = Integer.parseInt(request.getParameter("genderCusEdit"));
            String customerIdCard = request.getParameter("idCardCusEdit");
            String customerPhone = request.getParameter("phoneCusEdit");
            String customerEmail = request.getParameter("emailCusEdit");
            String customerAddress = request.getParameter("addressCusEdit");
            Customer customer = new Customer(customerId, typeId, customerName, customerBirthDay, customerGender, customerIdCard
                    , customerPhone, customerEmail, customerAddress);

            messageEdit = customerBO.editCustomer(customer);

            PrintWriter out = response.getWriter();
            out.print(gson.toJson(messageEdit));
            out.flush();
            out.close();

            List<TypeOfCustomer> typeOfCustomerList = customerBO.listTypeOfCustomer();
            request.setAttribute("typeOfCustomerList", typeOfCustomerList);
            List<Customer> customerList = customerBO.recordForPage(5, 1);
            request.setAttribute("endPage", endPage);
            request.setAttribute("customerList", customerList);
            request.setAttribute("messageEdit", messageEdit);
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

            request.setAttribute("endPage", endPage);

            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        } else if (action.equals("search")) {
            String valueSearch = request.getParameter("valueSearch");
            List<Customer> customerList = null;
            try {
                customerList = customerBO.findName(valueSearch);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("view/customer.jsp").forward(request, response);
        }
    }
}
