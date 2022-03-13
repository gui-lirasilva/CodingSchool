package com.coddingSchool.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/codding_school", "root", "133708");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
