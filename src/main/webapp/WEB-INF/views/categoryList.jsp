<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/atualizaCategoria" var="atualizaCategoria"/>
<d:url value="/alteraVisibilidade" var="alteraVisibilidade"/>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <a href="/insereCategoria">
            <button>New category</button>
        </a>
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
                    <td id="tdId${CategoriaDTO.id}">${CategoriaDTO.id}</td>
                    <td>${CategoriaDTO.name}</td>
                    <td>${CategoriaDTO.code}</td>
                    <td>${CategoriaDTO.order}</td>
                    <td>${CategoriaDTO.description}</td>
                    <td id="active${CategoriaDTO.id}">${CategoriaDTO.active}</td>
                    <td>${CategoriaDTO.iconPath}</td>
                    <td>${CategoriaDTO.colorCode}</td>
                    <td>${CategoriaDTO.studyGuide}</td>
                    <td>
                        <a href="/atualizaCategoria?id=${CategoriaDTO.id}">
                            <button>EDIT</button>
                        </a>
                    </td>
                    <td>
                        <button onclick="switchStatus(event, ${CategoriaDTO.id})" type="submit">
                            Change visibility
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
 <script src="/assets/js/scripts.js"></script>
</html>
