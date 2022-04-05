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
            <h3>Categorias</h3>
            <a href="/admin/categories/new">
                <button type="button" class="btn btn-primary"> Nova categoria </button>
            </a>
            <br><br>
        </div>
        <div class="container">
            <div class="row">
                <table class="table table-bordered ">
                    <tr class="col">
                        <td>Id</td>
                        <td>Nome</td>
                        <td>Código</td>
                        <td>Status</td>
                    </tr>
                    <c:forEach items="${categories}" var="CategoriaDTO">
                        <tr class="col">
                            <td id="tdId${CategoriaDTO.id}">${CategoriaDTO.id}</td>
                            <td>${CategoriaDTO.name}</td>
                            <td>${CategoriaDTO.code}</td>
                            <td id="active${CategoriaDTO.id}">${CategoriaDTO.active == true ? "ATIVA" : "INATIVA"}</td>
                            <td>
                                <a href="/admin/subcategories/${CategoriaDTO.code}">
                                    Subcategorias
                                </a>
                            </td>
                            <td>
                                <a href="/admin/categories/${CategoriaDTO.code}">
                                    <button type="button" class="btn btn-default"> EDITAR </button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>


    </body>
</html>
