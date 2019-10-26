package com.project_01.oop.dao;

import com.project_01.oop.persistance.DataSourceFactory;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T>  implements EntityDao<T>{
    private static final Logger LOG = Logger.getLogger(AbstractDao.class);

    private final String SELECT_MINERAL_BY_ID = "SELECT * FROM ? WHERE = ?";

    public List<T> getAll(String q, EntityMapper<T> mapper) {
        List<T> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(q);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                T entity = mapper.map(resultSet);

                result.add(entity);
            }

        } catch (SQLException e) {
            LOG.error("Exception while getting all entities");
        }

        return result;
    }

    public T getEntityById(int id, T t){
        try(PreparedStatement ps = DataSourceFactory.getPreparedStatement(SELECT_MINERAL_BY_ID)){
            ps.setString(1, t.getClass().toString());
            ps.setLong(2, id);
        }catch (SQLException e) {
            LOG.error("Exception while getting all entities");
        }
        return t;
    }

    public boolean createUp(String q, StatementMapper<T> statementMapper) {
        try(PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(q);) {
            statementMapper.map(preparedStatement);

            int result = preparedStatement.executeUpdate();

            return result == 1;
        } catch (SQLException e) {
            LOG.error("Could not create or update entity!!", e);
        }

        return false;
    }
}
