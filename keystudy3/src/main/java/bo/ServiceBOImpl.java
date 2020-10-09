package bo;

import dao.ServiceDAO;
import dao.ServiceDAOIml;
import model.RentType;
import model.Service;
import model.ServiceType;

import java.util.List;

public class ServiceBOImpl implements ServiceBO {
ServiceDAO serviceDAO =new ServiceDAOIml();
    @Override
    public List<Service> listAllService() {
        return serviceDAO.listAllService();
    }

    @Override
    public List<RentType> listAllRentType() {
        return serviceDAO.listAllRentType();
    }

    @Override
    public List<ServiceType> listAllServiceType() {
        return serviceDAO.listAllServiceType();
    }

    @Override
    public String insertService(Service service) {
        return serviceDAO.insertService(service);
    }
}
