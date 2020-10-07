package rowmapper;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet) throws SQLException {
       User user =new User();
       user.setUserName(resultSet.getString("username"));
       user.setPassWord(resultSet.getString("password"));
       return user;
    }
}
