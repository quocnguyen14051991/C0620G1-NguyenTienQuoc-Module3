package dao;

import model.RentType;
import model.Service;
import model.ServiceType;
import rowmapper.RentTypeMapper;
import rowmapper.ServiceMapper;
import rowmapper.ServiceTypeMapper;

import java.util.List;

public class ServiceDAOIml extends AbstractDAO<Service> implements ServiceDAO {
    private static final String selectAllService = "select * from service";
    private static final String selectAllRentType = "select * from rent_type";
    private static final String selectAllServiceType = "select * from service_type";
    private static final String INSERT_SERVICE = "insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_orther_convenienve,pool_area,number_of_floors) values(?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public List<Service> listAllService() {
        return query(selectAllService, new ServiceMapper());
    }

    @Override
    public List<RentType> listAllRentType() {
        return query(selectAllRentType, new RentTypeMapper());
    }

    @Override
    public List<ServiceType> listAllServiceType() {
        return query(selectAllServiceType, new ServiceTypeMapper());
    }

    @Override
    public String insertService(Service service) {
        return insert(INSERT_SERVICE, service.getService_Id(), service.getService_Name(), service.getArea(), service.getService_Cost()
                , service.getService_Max_Peole(), service.getRent_Type_ID(), service.getService_Type_Id(), service.getStandard_Room(),
                service.getDescription_Other(), service.getArea(), service.getNumber_Of_Floor());
    }

    public static void main(String[] args) {
        ServiceDAOIml serviceDAOIml = new ServiceDAOIml();
//        System.out.println(serviceDAOIml.listAllServiceType().toString());
//        System.out.println(serviceDAOIml.listAllRentType().toString());
        Service service = new Service(7, "quoc", 20, 20, 20, 2, 1,
                "room", "ss", 20, 20);
        System.out.println(service);
      String a=  serviceDAOIml.insert(INSERT_SERVICE,service.getService_Id(),service.getService_Id(),service.getArea(),service.getService_Cost()
        ,service.getService_Max_Peole(),service.getRent_Type_ID(),service.getService_Type_Id(),service.getStandard_Room(),service.getDescription_Other(),service.getArea(),service.getNumber_Of_Floor());
        System.out.println(a);
    }
}
