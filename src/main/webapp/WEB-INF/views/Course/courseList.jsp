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
        <c:forEach items="${courseDTOList}" var="CourseDTO">
            <tr class="col">
                <td>${CourseDTO.name}</td>
                <td>${CourseDTO.code}</td>
                <td id="active${CourseDTO.id}">${CourseDTO.visible == true ? "ATIVO" : "INATIVO"}</td>
                <td class="text-center">
                    <a class="btn btn-default" role="button" href="/admin/courses/${CourseDTO.code}">
                        EDITAR
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <nav>
        <ul class="pagination pagination-lg">
            <li class="${firstPage == true ? "disable" : ""}">
                <a href="?page=${pageNumber > 0 ? pageNumber-1 : ""}" aria-label="Previous">
                    <span class="disabled" aria-hidden="true"><<</span>
                </a>
            </li>
            <c:forEach begin="1" end="${totalPages}" varStatus="totalPage">
                <li class="${totalPage.index-1 == pageNumber ? "disable" : ""}">
                    <a href="?page=${totalPage.index-1}">
                        <span>${totalPage.index}</span>
                    </a>
                </li>
            </c:forEach>
            <li class="${lastPage == true ? "disable" : ""}">
                <a href="?page=${pageNumber < totalPages-1 ? pageNumber+1 : ""}" aria-label="Next">
                    <span class="disabled" aria-hidden="true">>></span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
