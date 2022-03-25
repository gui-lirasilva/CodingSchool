<%@ page import="br.com.coddingSchool.dao.CategoryDao" %>
<%@ page import="br.com.coddingSchool.util.JpaUtil" %>
<%@ page import="br.com.coddingSchool.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="br.com.coddingSchool.helpers.HelperCsv" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Categories</title>
</head>
<h2>Categories:</h2>
<body>
<%  CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());
    List<Category> categoryList = categoryDao.listAll();
    PrintWriter print = response.getWriter();
    for (Category c : categoryList) { %>
        <ul>
            <li>Category id = <%= c.getId() %></li>
            <br>
            <li>Category name = <%= c.getName() %></li>
            <br>
            <li>Category code = <%= c.getCode() %></li>
            <br>
            <li>Order = <%= c.getOrder() %></li>
            <br>
            <li>Description = <%= c.getDescription() %></li>
            <br>
            <li>Active = <%= HelperCsv.isActive(c.getActive()) %></li>
            <br>
            <li>Icon path = <%= c.getIconPath() %></li>
            <br>
            <li>Hexadecimal color code = <%= c.getColorCode() %></li>
            <br>
            <li>Study guide = <%= c.getStudyGuide() %></li>
        </ul>
        <p>------------------------------------------------------------------------------------------------------------------</p>
        <br>
        <br>
        <br>
       <%
} %>
</body>
</html>
