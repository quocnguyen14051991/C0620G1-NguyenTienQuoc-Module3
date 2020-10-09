package dao;

import model.RentType;
import model.Service;
import model.ServiceType;

import java.util.List;

public interface ServiceDAO {
    List<Service> listAllService();
    List<RentType> listAllRentType();
    List<ServiceType> listAllServiceType();
    String insertService(Service service);

}
