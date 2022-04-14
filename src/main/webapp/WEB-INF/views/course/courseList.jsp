<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista de cursos</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
    <meta content="text/html;charset=UTF-8">
</head>
<body>
<div class="container">
    <h4>${subcategory.name}</h4>
    <h2>Cursos</h2>
    <br><br>
    <a href="/admin/courses/new">
        <button type="button" class="btn btn-primary"> Novo curso </button>
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
        <c:forEach items="${paginatedCourses.content}" var="paginatedCourses">
            <tr class="col">
                <td>${paginatedCourses.name}</td>
                <td>${paginatedCourses.code}</td>
                <td id="active${paginatedCourses.id}">${paginatedCourses.visible == true ? "ATIVO" : "INATIVO"}</td>
                <td class="text-center">
                    <a class="btn btn-default" role="button" href="/admin/courses/${paginatedCourses.code}">
                        EDITAR
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <nav>
        <ul class="pagination pagination-lg">
            <li class="${paginatedCourses.first == true ? "disabled" : ""}">
                <a href="?page=${paginatedCourses.number > 0 ? paginatedCourses.number-1 : paginatedCourses.number}" aria-label="Previous">
                    <span class="disabled" aria-hidden="true"><<</span>
                </a>
            </li>
            <c:forEach begin="1" end="${paginatedCourses.totalPages}" varStatus="loop">
                <li class="${loop.index-1 == paginatedCourses.number ? "active" : ""}">
                    <a href="?page=${loop.index-1}">
                        <span>${loop.index}</span>
                    </a>
                </li>
            </c:forEach>
            <li class="${paginatedCourses.last == true ? "disabled" : ""}">
                <a href="?page=${paginatedCourses.number < paginatedCourses.totalPages-1 ? paginatedCourses.number+1 : paginatedCourses.number}" aria-label="Next">
                    <span class="disabled" aria-hidden="true">>></span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
