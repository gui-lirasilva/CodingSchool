package com.coddingSchool.run.sql;

import com.coddingSchool.infrastructure.ConnectionFactory;

import java.sql.*;

public class RunningCourseInsert {

    private static void insertCourse() {

        int id;
        String name = "Course name";
        String code = "course-code";
        int estimatedTime = 10;
        boolean visible = true;
        String target = "Target audience";
        String instructor = "Instructor name";
        String description = "Course description";
        String developedSkills = "Developed skills";
        int subcategoryId = 1;
        String studyGuide = "Study guide";


        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection
                .prepareStatement("INSERT INTO `course`(name, code, estimated_time," +
                        " visible, target, instructor, description, developed_skills, subcategory_id) VALUES" +
                        " (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);

            stmt.setString(1, name);
            stmt.setString(2, code);
            stmt.setInt(3, estimatedTime);
            stmt.setBoolean(4, visible);
            stmt.setString(5, target);
            stmt.setString(6, instructor);
            stmt.setString(7, description);
            stmt.setString(8, developedSkills);
            stmt.setInt(9, subcategoryId);
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();
            while(resultSet.next()) {
                id = resultSet.getInt(1);
                System.out.printf("New course id = %d", id);
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertCourse();
    }
}
