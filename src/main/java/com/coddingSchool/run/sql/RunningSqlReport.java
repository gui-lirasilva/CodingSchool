package com.coddingSchool.run.sql;

import com.coddingSchool.infrastructure.ConnectionFactory;

import java.io.*;
import java.sql.*;

public class RunningSqlReport {

    private static String findSubcategoryName(Connection connection, int subcategoryId) {

        String subcategoryName = "";

       try(PreparedStatement stmt = connection.prepareStatement("SELECT `name` FROM subcategories WHERE `id` = ?")) {
           stmt.setLong(1, subcategoryId);
           stmt.execute();
           try(ResultSet resultSet = stmt.getResultSet()) {
               while(resultSet.next()) {
                   subcategoryName = resultSet.getString("name");
               };
           }
           return subcategoryName;
       } catch (SQLException e) {
           return e.getMessage();
       }
    }

    private static void courseReport() {
        int id;
        String name;
        int estimatedTime;
        int subcategoryId;
        String subcategoryName;

        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT c.id, c.name, c.estimated_time," +
                    " c.subcategory_id, s.name FROM courses c INNER JOIN subcategories s ON c.subcategory_id = s.id" +
                    " WHERE visible = ?")) {
            stmt.setBoolean(1 ,true);
            stmt.execute();

            try (OutputStream os = new FileOutputStream("sqlReport.html")) {
                PrintStream ps = new PrintStream(os);

                ps.println("<html>");
                ps.println("<head>");
                ps.println("<meta charset=\"UTF-8\">");
                ps.println("</head>");
                ps.println("<body>");

                try(ResultSet resultSet = stmt.getResultSet()){
                    while(resultSet.next()) {
                        id = resultSet.getInt("id");
                        name = resultSet.getString("name");
                        estimatedTime = resultSet.getInt("estimated_time");
                        subcategoryId = resultSet.getInt("subcategory_id");
                        subcategoryName = resultSet.getString(5);

                        ps.println( String.format("""
                                    <ul> 
                                        <li>Course id = %d</li>
                                        <br>
                                        <li>Course name = %s</li>
                                        <br>
                                        <li>Estimated time = %d hours</li>
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
                                id, name, estimatedTime, subcategoryId, subcategoryName));

                    }
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

        courseReport();
    }

}
