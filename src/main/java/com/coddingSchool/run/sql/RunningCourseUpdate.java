package com.coddingSchool.run.sql;

import com.coddingSchool.infrastructure.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RunningCourseUpdate {

    private static void updateCourse() {

        int modifiedLines;

        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE course SET `visible`= ?")) {
            stmt.setBoolean(1, true);
            stmt.execute();
            modifiedLines = stmt.getUpdateCount();
            System.out.printf("Quantity of updated courses = %d", modifiedLines);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        updateCourse();
    }
}
