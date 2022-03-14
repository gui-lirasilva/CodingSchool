package com.coddingSchool.run.sql;

import com.coddingSchool.infrastructure.ConnectionFactory;

import java.sql.*;

public class RunningCourseDelete {

    private static void describeCourse(Connection connection, String courseCode) {

        int id;
        String name;
        String code;
        int estimatedTime;
        boolean visible;
        String target;
        String instructor;
        String description;
        String developedSkills;
        int subcategoryId;
        String studyGuide;

        try(PreparedStatement stmt = connection.prepareStatement("SELECT * FROM course WHERE `code`= ?")) {

            stmt.setString(1, courseCode);
            stmt.execute();
            ResultSet resultSet = stmt.getResultSet();
            while(resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                code = resultSet.getString("code");
                estimatedTime = resultSet.getInt("estimated_time");
                visible = resultSet.getBoolean("visible");
                target = resultSet.getString("target");
                instructor = resultSet.getString("instructor");
                description = resultSet.getString("description");
                developedSkills = resultSet.getString("developed_skills");
                subcategoryId = resultSet.getInt("subcategory_id");
                studyGuide = resultSet.getString("study_guide");

                System.out.printf("id = %d, name = %s, code = %s, estimated time = %d, visible = %b, target = %s," +
                                " instructor = %s, description = %s, developed skills = %s, subcategory id = %d," +
                                " study guide = %s\n",
                        id, name, code, estimatedTime, visible, target, instructor, description, developedSkills,
                        subcategoryId, studyGuide);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteCourse(String code) {

        int modifiedLines;

        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM course WHERE `code`= ?")) {

            stmt.setString(1, code);
            System.out.println("The following course will be deleted:");
            describeCourse(connection, code);
            stmt.execute();
            modifiedLines = stmt.getUpdateCount();
            System.out.printf("Quantity of deleted lines = %d", modifiedLines);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        deleteCourse("course-code");
    }
}
