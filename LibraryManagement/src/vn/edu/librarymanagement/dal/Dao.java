package vn.edu.librarymanagement.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    boolean insert(T t) throws Exception;

    boolean update(T t) throws Exception;

    boolean delete(int id) throws Exception;

    List<T> getTableData(String input) throws Exception;

    boolean isUsed(String input) throws Exception;

    T findById(String id) throws Exception;

    T setValue(ResultSet rs) throws SQLException;
}
