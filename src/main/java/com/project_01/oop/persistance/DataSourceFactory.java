package com.project_01.oop.persistance;

import org.apache.log4j.Logger;
import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class DataSourceFactory {
    private static final Logger LOG = Logger.getLogger(DataSourceFactory.class);

    private static final DataSourceFactory INSTANCE = new DataSourceFactory();

    private static DataSource dataSource;

    private DataSourceFactory(){}

    static {
        Properties properties = new Properties();
        try{
            properties.load(DataSourceFactory.class.getResourceAsStream("/db.properties"));
            PGPoolingDataSource   source = new PGPoolingDataSource();
            source.setServerName(properties.getProperty("DB_SERVER"));
            source.setDatabaseName(properties.getProperty("DB_NAME"));
            source.setUser(properties.getProperty("DB_USER"));
            source.setPassword(properties.getProperty("DB_PASS"));
            dataSource = source;
            LOG.info("DB created: " + dataSource);
        } catch (IOException e){
            LOG.error("While get connection " + e);
        }

    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error("Error while connection creation", e);
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }
}
