package controller;

import bo.ServiceBO;
import bo.ServiceBOImpl;
import model.RentType;
import model.Service;
import model.ServiceType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceBO serviceBO = new ServiceBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("view/home.jsp");
        } else if (action.equals("create")) {
            Integer service_Id = Integer.valueOf(request.getParameter("idService"));
            String service_Name = request.getParameter("nameService");
            int area = Integer.parseInt(request.getParameter("areaService"));
            double service_Cost= Double.parseDouble(request.getParameter("costService"));
            int service_Max_Peole= Integer.parseInt(request.getParameter("maxPeople"));
            Integer rent_Type_ID= Integer.valueOf(request.getParameter("rentTypeID"));
            Integer service_Type_Id= Integer.valueOf(request.getParameter("serviceType"));
            String standard_Room=request.getParameter("standardRoomService");
            String description_Other=request.getParameter("description");
            double pool_Area= Double.parseDouble(request.getParameter("poolArea"));
            int number_Of_Floor= Integer.parseInt(request.getParameter("numOffloor"));
            serviceBO.insertService(new Service(service_Id,service_Name,area,service_Cost,service_Max_Peole,rent_Type_ID,service_Type_Id,standard_Room,description_Other,pool_Area,number_Of_Floor));
            List<RentType> rentTypeList = serviceBO.listAllRentType();
            request.setAttribute("rentTypeList", rentTypeList);
            List<ServiceType> serviceTypeList = serviceBO.listAllServiceType();
            request.setAttribute("serviceTypeList", serviceTypeList);
            List<Service> serviceList = serviceBO.listAllService();
            request.setAttribute("serviceList", serviceList);
            request.getRequestDispatcher("view/Service.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("view/home.jsp");
        } else if (action.equals("listAll")) {
            List<Service> serviceList = serviceBO.listAllService();
            List<RentType> rentTypeList = serviceBO.listAllRentType();
            request.setAttribute("rentTypeList", rentTypeList);
            List<ServiceType> serviceTypeList = serviceBO.listAllServiceType();
            request.setAttribute("serviceTypeList", serviceTypeList);
            request.setAttribute("serviceList", serviceList);
            request.getRequestDispatcher("view/Service.jsp").forward(request, response);
        }
    }
}
