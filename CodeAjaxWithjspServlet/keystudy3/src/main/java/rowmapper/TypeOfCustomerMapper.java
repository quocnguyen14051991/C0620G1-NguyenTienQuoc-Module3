package rowmapper;

import model.TypeOfCustomer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeOfCustomerMapper implements RowMapper<TypeOfCustomer> {
    @Override
    public TypeOfCustomer mapRow(ResultSet resultSet) throws SQLException {
        TypeOfCustomer typeOfCustomer =new TypeOfCustomer();
        typeOfCustomer.setIdCustomerType(resultSet.getInt("customer_type_id"));
        typeOfCustomer.setNameTypeCustomer(resultSet.getString("customer_type_name"));
        return typeOfCustomer;
    }
}
