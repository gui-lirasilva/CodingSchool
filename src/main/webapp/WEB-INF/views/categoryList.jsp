<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Lista de categorias</title>
        <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
        <meta content="text/html;charset=UTF-8">
    </head>
    <body>
        <div class="container">
            <h2>Categorias</h2>
            <br><br>
            <a href="/admin/categories/new">
                <button type="button" class="btn btn-primary"> Nova categoria </button>
            </a>
            <br><br>
                <table class="table table-bordered justify-content-center">
                    <thead>
                        <th>Nome</th>
                        <th>Código</th>
                        <th>Status</th>
                        <th></th>
                        <th></th>
                    </thead>
                    <tbody>
                        <c:forEach items="${categories}" var="CategoriaDTO">
                            <tr class="col">
                                <td>${CategoriaDTO.name}</td>
                                <td>${CategoriaDTO.code}</td>
                                <td id="active${CategoriaDTO.id}">${CategoriaDTO.active == true ? "ATIVA" : "INATIVA"}</td>
                                <td class="text-center">
                                    <a href="/admin/subcategories/${CategoriaDTO.code}">
                                        Subcategorias
                                    </a>
                                </td>
                                <td class="text-center">
                                    <a class="btn btn-default" role="button" href="/admin/categories/${CategoriaDTO.code}">
                                        EDITAR
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
            </table>
        </div>
    </body>
</html>
