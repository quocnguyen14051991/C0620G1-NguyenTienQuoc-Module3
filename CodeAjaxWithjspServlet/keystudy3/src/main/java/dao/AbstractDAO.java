package dao;//import dao.BaseDAO;

import dao.GenericDAO;
import rowmapper.RowMapper;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {
    BaseDAO baseDAO = new BaseDAO();

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = baseDAO.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            setParameter(preparedStatement, parameters);
            /* con 1 buoc setparam cho preparedStatement; */
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException throwables) {
            return null;
        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//            } catch (SQLException e) {
//                return null;
//            }
        }
    }

    @Override
    public String insert(String sql, Object... parameter) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = baseDAO.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            setParameter(preparedStatement, parameter);
            preparedStatement.executeUpdate();
            connection.commit();
            return "Insert Success";
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return null;
//            }
        }
        return null;
    }

    @Override
    public String update(String sql, Object... parameters) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = baseDAO.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            setParameter(preparedStatement, parameters);
            preparedStatement.executeUpdate() ;
            connection.commit();

            return "Update Success";

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
       return "Update Fail";
    }

    @Override
    public int sumRecord(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = baseDAO.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void setParameter(PreparedStatement statement, Object[] parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                int index = i + 1;
                Object parameter = parameters[i];
                if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                }else if(parameter instanceof Double){
                    statement.setDouble(index,(Double) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* vay la xong ^ ^ */
}
