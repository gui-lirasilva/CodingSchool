<%@ page import="br.com.coddingSchool.dao.CategoryDao" %>
<%@ page import="br.com.coddingSchool.util.JpaUtil" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="br.com.coddingSchool.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.coddingSchool.helpers.HelperCsv" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <table border="1">
            <%
                CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());
                List<Category> categoryList = categoryDao.listAll();
            %>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Code</td>
                <td>Order</td>
                <td>Description</td>
                <td>Active</td>
                <td>Icon</td>
                <td>Color</td>
                <td>Study guide</td>
            </tr>
            <%for (Category c : categoryList) { %>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getName() %></td>
                    <td><%= c.getCode() %></td>
                    <td><%= c.getOrder() %></td>
                    <td><%= c.getDescription() %></td>
                    <td><%= HelperCsv.isActive(c.getActive()) %></td>
                    <td><%= c.getIconPath() %></td>
                    <td><%= c.getColorCode() %></td>
                    <td><%= c.getStudyGuide() %></td>
                </tr>
          <%}%>
        </table>
    </body>
</html>
