<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dashboard administrativo</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
    <meta content="text/html;charset=UTF-8">
</head>
<body>
<div class="container">
    <h2>Categorias</h2>
    <table class="table table-bordered justify-content-center">
        <thead>
        <th>Nome</th>
        <th>Total de cursos</th>
        </thead>
        <tbody>
        <c:forEach items="${categoryAndCourses}" var="categoryAndCourses">
            <tr class="col">
                <td>${categoryAndCourses.name}</td>
                <td>${categoryAndCourses.coursesNumber}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h3>Instrutor com mais cursos</h3>
    <table class="table table-bordered justify-content-center">
        <thead>
        <th>Nome</th>
        <th>Total de cursos</th>
        </thead>
        <tbody>
            <tr class="col">
                <td>${instructorProjection.name}</td>
                <td>${instructorProjection.coursesNumber}</td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>