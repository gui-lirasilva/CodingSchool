package br.com.coddingSchool.infrastructure;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionFactoryTest {

    @Test
    void getConnection__shouldConnect() {
        assertDoesNotThrow(() -> {
            Connection connection = new ConnectionFactory().getConnection();
        }, "Connection not established");
    }
}