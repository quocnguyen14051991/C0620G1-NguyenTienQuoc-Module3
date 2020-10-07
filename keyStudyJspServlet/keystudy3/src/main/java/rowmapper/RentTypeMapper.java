package rowmapper;

import model.RentType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentTypeMapper implements RowMapper<RentType> {

    @Override
    public RentType mapRow(ResultSet resultSet) throws SQLException {
        RentType rentType =new RentType();
        rentType.setRenTypeId(resultSet.getInt("rent_type_id"));
        rentType.setRenTypeName(resultSet.getString("rent_type_name"));
        rentType.setRentTypeCost(resultSet.getDouble("rent_type_cost"));
        return rentType;
    }
}
