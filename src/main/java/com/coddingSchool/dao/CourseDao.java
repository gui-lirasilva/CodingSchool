package com.coddingSchool.dao;

import com.coddingSchool.infrastructure.ConnectionFactory;
import com.coddingSchool.model.Course;
import com.coddingSchool.model.Subcategory;

import java.sql.*;

public class CourseDao {

    public static void insertNewCourse(Course course) {

        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO `courses`(name, code, estimated_time," +
                            " visible, target, instructor, description, developed_skills, subcategory_id) VALUES" +
                            " (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);

            Long subcategoryId = findSubcategoryId(connection, course.getSubcategory());

            stmt.setString(1, course.getName());
            stmt.setString(2, course.getCode());
            stmt.setInt(3, course.getEstimatedTime());
            stmt.setBoolean(4, course.getVisible());
            stmt.setString(5, course.getTarget());
            stmt.setString(6, course.getInstructor());
            stmt.setString(7, course.getDescription());
            stmt.setString(8, course.getDevelopedSkills());
            stmt.setLong(9, subcategoryId);
            stmt.execute();

            try(ResultSet resultSet = stmt.getGeneratedKeys()){
                while(resultSet.next()) {
                    course.setId(resultSet.getLong(1));
                    System.out.printf("New course id = %d", course.getId());
                }
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCourse(Course course) {

        int modifiedLines;

        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM courses WHERE `code`= ?")) {
            stmt.setString(1, course.getCode());
            System.out.println("The following course will be deleted:");
            describeCourse(connection, course);
            stmt.execute();
            modifiedLines = stmt.getUpdateCount();
            System.out.printf("Quantity of deleted lines = %d", modifiedLines);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAllCourses() {

        int modifiedLines;

        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE courses SET `visible`= ?")) {
            stmt.setBoolean(1, true);
            stmt.execute();
            modifiedLines = stmt.getUpdateCount();
            System.out.printf("Quantity of updated courses = %d", modifiedLines);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Long findSubcategoryId(Connection connection, Subcategory subcategory) {

        Long subcategoryId = 0L;

        try(PreparedStatement stmt = connection
                .prepareStatement("SELECT `id` FROM subcategories WHERE `code` = ?")){
            stmt.setString(1, subcategory.getCode());
            stmt.execute();
            try(ResultSet resultSet = stmt.getResultSet()){
                while(resultSet.next()) {
                    subcategoryId = resultSet.getLong("id");
                };
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subcategoryId;
    }

    private static void describeCourse(Connection connection, Course course) {

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

        try(PreparedStatement stmt = connection.prepareStatement("SELECT * FROM courses WHERE `code`= ?")) {
            stmt.setString(1, course.getCode());
            stmt.execute();
            try (ResultSet resultSet = stmt.getResultSet()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
