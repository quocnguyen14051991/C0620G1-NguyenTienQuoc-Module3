package rowmapper;

import model.ServiceType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceTypeMapper implements RowMapper<ServiceType> {
    @Override
    public ServiceType mapRow(ResultSet resultSet) throws SQLException {
        ServiceType serviceType =new ServiceType();
        serviceType.setServiceTypeId(resultSet.getInt("service_type_id"));
        serviceType.setServiceTypeName(resultSet.getString("service_type_name"));
        return serviceType;
    }
}
