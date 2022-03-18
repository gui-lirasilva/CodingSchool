package com.coddingSchool.infrastructure;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/codding_school");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("");
        comboPooledDataSource.setMaxPoolSize(3);
        this.dataSource = comboPooledDataSource;
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
