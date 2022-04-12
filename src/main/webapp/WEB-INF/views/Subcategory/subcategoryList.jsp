<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista de subcategorias</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
    <meta content="text/html;charset=UTF-8">
</head>
<body>
<div class="container">
    <h4>${Category.name}</h4>
    <h2>Subcategorias</h2>
    <br><br>
    <a href="/admin/subcategories/new">
        <button type="button" class="btn btn-primary"> Nova subcategoria </button>
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
        <c:forEach items="${subcategories}" var="SubcategoriaDTO">
            <tr class="col">
                <td>${SubcategoriaDTO.name}</td>
                <td>${SubcategoriaDTO.code}</td>
                <td id="active${SubcategoriaDTO.id}">${SubcategoriaDTO.active == true ? "ATIVA" : "INATIVA"}</td>
                <td class="text-center">
                    <a href="/admin/courses/${Category.code}/${SubcategoriaDTO.code}">
                        Cursos
                    </a>
                </td>
                <td class="text-center">
                    <a class="btn btn-default" role="button" href="/admin/subcategories/${Category.code}/${SubcategoriaDTO.code}">
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