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
            <c:forEach items="${categories}" var="CategoriaDTO">
                <tr>
                    <td>${CategoriaDTO.id}</td>
                    <td>${CategoriaDTO.name}</td>
                    <td>${CategoriaDTO.code}</td>
                    <td>${CategoriaDTO.order}</td>
                    <td>${CategoriaDTO.description}</td>
                    <td>${CategoriaDTO.active}</td>
                    <td>${CategoriaDTO.iconPath}</td>
                    <td>${CategoriaDTO.colorCode}</td>
                    <td>${CategoriaDTO.studyGuide}</td>
                    <td><a href="/editarCategoria?id=${CategoriaDTO.id}">EDIT</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
