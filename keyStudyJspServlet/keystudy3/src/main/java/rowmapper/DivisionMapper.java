package rowmapper;

import model.Division;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionMapper implements RowMapper<Division> {
    @Override
    public Division mapRow(ResultSet resultSet) throws SQLException {
        Division division =new Division();
        division.setDivison_Id(resultSet.getInt("division_id"));
        division.setDivison_Name(resultSet.getString("division_name"));
        return division;
    }
}
