<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <a href="/admin/categories/new">
            <button>New category</button>
        </a>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Código</td>
                <td>Status</td>
            </tr>
            <c:forEach items="${categories}" var="CategoriaDTO">
                <tr>
                    <td id="tdId${CategoriaDTO.id}">${CategoriaDTO.id}</td>
                    <td>${CategoriaDTO.name}</td>
                    <td>${CategoriaDTO.code}</td>
                    <td id="active${CategoriaDTO.id}">${CategoriaDTO.active == true ? "ATIVA" : "INATIVA"}</td>
                    <td>
                        <a href="/admin/categories">
                            Subcategorias
                        </a>
                    </td>
                    <td>
                        <a href="/admin/categories/${CategoriaDTO.code}">
                            <button>EDITAR</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
