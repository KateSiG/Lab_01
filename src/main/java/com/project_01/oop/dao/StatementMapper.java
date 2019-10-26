package com.project_01.oop.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface StatementMapper<T> {
    void map(PreparedStatement ps) throws SQLException;
}
