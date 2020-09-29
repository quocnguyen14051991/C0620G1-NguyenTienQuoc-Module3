package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImp;

import javax.security.auth.login.CredentialException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customers"})
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "delete":
                break;
            default:

                break;
        }

    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Customer customer=this.customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if(customer==null){
            requestDispatcher=request.getRequestDispatcher("error-404.jsp");
        }else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int id=(int)(Math.random()*10000);
        Customer customer=new Customer(id,name,email,address);
        this.customerService.save(customer);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("mesage","new customer was created");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher requestDispatcher ;
        if(customer==null){
            requestDispatcher=request.getRequestDispatcher("error-404.jsp");

        }else {
            request.setAttribute("customer",customer);
            requestDispatcher=request.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            requestDispatcher.forward(request,response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("customer/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}