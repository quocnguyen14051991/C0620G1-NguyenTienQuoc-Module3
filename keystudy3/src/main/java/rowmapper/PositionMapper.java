package rowmapper;

import model.Position;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements RowMapper<Position> {
    @Override
    public Position mapRow(ResultSet resultSet) throws SQLException {
        Position position =new Position();
        position.setPosition_ID(resultSet.getInt("position_id"));
        position.setPosition_Name(resultSet.getString("position_name"));
        return position;
    }
}
