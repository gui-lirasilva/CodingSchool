package com.coddingSchool.run;

import com.coddingSchool.helpers.HelperCsv;
import com.coddingSchool.infrastructure.ConnectionFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunningSqlQuery {

    private static void firstQuery() {
        int id;
        String name;
        String code;
        int order;
        String description;
        boolean active;
        String iconPath;
        String colorCode;

        try(Connection connection = new ConnectionFactory().getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute("SELECT * FROM `category` where `active` = true ORDER BY `order`");
            ResultSet resultSet = stmt.getResultSet();

            while(resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                code = resultSet.getString("code");
                order = resultSet.getInt("order");
                description = resultSet.getString("description");
                active = resultSet.getBoolean("active");
                iconPath = resultSet.getString("iconPath");
                colorCode = resultSet.getString("colorCode");

                System.out.printf("id = %d, name = %s, code = %s, order = %d, description = %s, active = %b," +
                                " icon path = %s, color code = %s" +
                                "\n-----------------------------------------------------------------------------------\n",
                        id, name, code, order, description, active, iconPath, colorCode);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void secondQuery() {
        int id;
        String name;
        String code;
        int order;
        String description;
        boolean active;
        int categoryId;
        String study_guide;

        try(Connection connection = new ConnectionFactory().getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute("SELECT * FROM `subcategory` where `active` = true ORDER BY `order`");
            ResultSet resultSet = stmt.getResultSet();

            while(resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                code = resultSet.getString("code");
                order = resultSet.getInt("order");
                description = resultSet.getString("description");
                active = resultSet.getBoolean("active");
                categoryId = resultSet.getInt("category_id");
                study_guide = resultSet.getString("study_guide");

                System.out.printf("id = %d, name = %s, code = %s, order = %d, description = %s, active = %b," +
                                " category id = %d, study guide = %s" +
                                "\n-----------------------------------------------------------------------------------\n",
                        id, name, code, order, description, active, categoryId, study_guide);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void thirdQuery() {
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

        try(Connection connection = new ConnectionFactory().getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute("SELECT * FROM `course` where `visible` = true");
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
                                " study guide = %s" +
                                "\n---------------------------------------------------------------------------------\n",
                        id, name, code, estimatedTime, visible, target, instructor, description, developedSkills,
                        subcategoryId, studyGuide);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fourthQuery() {
        int id;
        String name;
        String code;
        int order;
        String description;
        boolean active;
        int categoryId;
        String study_guide;

        try(Connection connection = new ConnectionFactory().getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute("SELECT `name` FROM `subcategory` where `description` = ''");
            ResultSet resultSet = stmt.getResultSet();

            while(resultSet.next()) {
                name = resultSet.getString("name");
                System.out.println(name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String findSubcategoryName(Connection connection, int subcategoryId) {

        String queryForSearchSubcategory = String.format("SELECT `name` FROM subcategory WHERE `id` = %d",
                subcategoryId);
        String subcategoryName = "";

       try{
           Statement stmt = connection.createStatement();
           stmt.execute(queryForSearchSubcategory);
           ResultSet resultSet = stmt.getResultSet();

           while(resultSet.next()) {
               subcategoryName = resultSet.getString("name");
           };

           return subcategoryName;
       } catch (SQLException e) {
           return e.getMessage();
       }
    }

    private static void courseReport() {
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
        String subcategoryName;

        try(Connection connection = new ConnectionFactory().getConnection()) {
            Statement stmt1 = connection.createStatement();
            stmt1.execute("SELECT * FROM `course` where `visible` = true");
            ResultSet resultSet1 = stmt1.getResultSet();

            try (OutputStream os = new FileOutputStream("sqlReport.html")) {
                PrintStream ps = new PrintStream(os);

                ps.println("<html>");
                ps.println("<head>");
                ps.println("<meta charset=\"UTF-8\">");
                ps.println("</head>");
                ps.println("<body>");

                while(resultSet1.next()) {
                    id = resultSet1.getInt("id");
                    name = resultSet1.getString("name");
                    code = resultSet1.getString("code");
                    estimatedTime = resultSet1.getInt("estimated_time");
                    visible = resultSet1.getBoolean("visible");
                    target = resultSet1.getString("target");
                    instructor = resultSet1.getString("instructor");
                    description = resultSet1.getString("description");
                    developedSkills = resultSet1.getString("developed_skills");
                    subcategoryId = resultSet1.getInt("subcategory_id");
                    studyGuide = resultSet1.getString("study_guide");
                    subcategoryName = findSubcategoryName(connection, subcategoryId);

                    ps.println( String.format("""
                                    <ul> 
                                        <li>Course id = %d</li>
                                        <br>
                                        <li>Course name = %s</li>
                                        <br>
                                        <li>Course code = %s</li>
                                        <br>
                                        <li>Estimated time = %d</li>
                                        <br>
                                        <li>Visibility = %s</li>
                                        <br>
                                        <li>Target = %s</li>
                                        <br>
                                        <li>Instructor = %s</li>
                                        <br>
                                        <li>Description = %s</li>
                                        <br>
                                        <li>Developed skills = %s</li>
                                        <br>
                                        <li> Subcategory: </li>
                                        <ul> 
                                            <li> id = %d</li>
                                            <li> name = %s</li>
                                        </ul>
                                    </ul>
                                    <p>------------------------------------------------------------------------------------------------------------------</p>
                                    <br>
                                    <br>
                                    <br>
                                    """,
                            id, name, code, estimatedTime, HelperCsv.isPublic(visible), target, instructor, description,
                            developedSkills, subcategoryId, subcategoryName));

                }

                ps.println("</body>");
                ps.println("</html>");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)  {

//        firstQuery();
//        secondQuery();
//        thirdQuery();
//        fourthQuery();
        courseReport();
    }

}
