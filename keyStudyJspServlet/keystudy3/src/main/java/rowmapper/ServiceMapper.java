package rowmapper;

import model.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements RowMapper<Service> {
    @Override
    public Service mapRow(ResultSet resultSet) throws SQLException {
        Service service = new Service();

        service.setService_Id(resultSet.getInt("service_id"));
        service.setService_Name(resultSet.getString("service_name"));
        service.setArea(resultSet.getInt("service_area"));
        service.setService_Cost(resultSet.getDouble("service_cost"));
        service.setService_Max_Peole(resultSet.getInt("service_max_people"));
        service.setRent_Type_ID(resultSet.getInt("rent_type_id"));
        service.setService_Type_Id(resultSet.getInt("service_Type_Id"));
        service.setStandard_Room(resultSet.getString("standard_room"));
        service.setDescription_Other(resultSet.getString("description_orther_convenienve"));
        service.setPool_Area(resultSet.getInt("pool_area"));
        service.setNumber_Of_Floor(resultSet.getInt("number_of_floors"));
        return service;
    }
}
