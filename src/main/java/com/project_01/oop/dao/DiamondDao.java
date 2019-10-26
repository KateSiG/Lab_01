package com.project_01.oop.dao;

import com.project_01.oop.Entity.Diamond;
import org.apache.log4j.Logger;

import java.util.List;

public class DiamondDao extends AbstractDao<Diamond> {
    private static final Logger LOG = Logger.getLogger(DiamondDao.class);

    private final static String SELECT_ALL_DIAMONDS = "SELECT * FROM public.diamond";
    private final static String INSERT_INTO_DIAMONDS = "INSERT INTO daimond " +
            "(carat, price, isprecious, transparency) VALUES (?,?,?,?)";
    private final static String UPDATE_CARAT_DIAMONDS = "UPDATE daimond " +
                "carat=? WHERE id=?";
     private final static String DELETE_DIAMONDS = "DELETE daimond " +
                "WHERE id=?";

    @Override
    public List<Diamond> getAll() {
        return getAll(SELECT_ALL_DIAMONDS, m -> new Diamond(m.getInt("id")));
    }

    @Override
    public boolean create(Diamond e) {
        return createUp(INSERT_INTO_DIAMONDS, statement -> {
            statement.setDouble(1, e.getCarat());
            statement.setDouble(2, e.getPrice());
            statement.setBoolean(3, e.isPrecious());
            statement.setString(4, e.getTransparency().toString());
        });
    }

    @Override
    public boolean update(Diamond e) {
        return createUp(UPDATE_CARAT_DIAMONDS, statement -> {
            statement.setDouble(1, e.getCarat());
            statement.setLong(2, e.getId());
        });
    }

    @Override
    public boolean delete(Diamond e) {
        return createUp(DELETE_DIAMONDS, statement ->{
            statement.setLong(1, e.getId());
        });
    }
}
