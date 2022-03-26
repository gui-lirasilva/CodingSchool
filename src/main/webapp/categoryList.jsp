<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <a href="/insereCategoria">New category</a>
        <table border="1">
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
            <c:forEach items="${categories}" var="Categoria">
                <tr>
                    <td>${Categoria.id}</td>
                    <td>${Categoria.name}</td>
                    <td>${Categoria.code}</td>
                    <td>${Categoria.order}</td>
                    <td>${Categoria.description}</td>
                    <td>${Categoria.active}</td>
                    <td>${Categoria.iconPath}</td>
                    <td>${Categoria.colorCode}</td>
                    <td>${Categoria.studyGuide}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
