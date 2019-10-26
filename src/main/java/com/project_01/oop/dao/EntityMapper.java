package com.project_01.oop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface EntityMapper<T> {
    T map(ResultSet rs) throws SQLException;
}
