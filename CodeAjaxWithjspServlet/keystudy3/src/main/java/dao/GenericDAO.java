package dao;//

import rowmapper.RowMapper;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    /* common cho query */
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameter) throws SQLException;

    /* common cho insert */
    String insert(String sql, Object... parameter);

    /* common cho Update */
    String update(String sql, Object... parameter);
    /* sum record Pagenation */
    int sumRecord(String sql);

}
