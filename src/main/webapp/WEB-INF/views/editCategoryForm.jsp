<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin/categories/${category.code}" method="post">
    <input type="hidden" name="id" value="${category.id}"/> <br>
    <label>Name:</label>
    <input type="text" name="name" value="${category.name}"/> <br>
    <label>Code: </label>
    <input type="text" name="code" value="${category.code}"/> <br>
    <label>Order:</label>
    <input type="number" name="order" value="${category.order}"/> <br>
    <label>Description:</label>
    <input type="text" name="description" value="${category.description}"/> <br>
    <label>Active:</label>
    <c:choose>
        <c:when test="${category.active==true}">
            <input type="checkbox" value="true" name="active" value="${category.active}" checked/> <br>
        </c:when>
        <c:otherwise>
            <input type="checkbox" value="true" name="active" value="${category.active}"/> <br>
        </c:otherwise>
    </c:choose>
    <label>Icon path:</label>
    <input type="text" name="iconPath" value="${category.iconPath}"/> <br>
    <label>Color code:</label>
    <input type="text" name="colorCode" value="${category.colorCode}"/> <br>
    <label>Study guide:</label>
    <input type="text" name="studyGuide" value="${category.studyGuide}"/> <br>

    <input type="submit" value="Enviar">
</form>
</body>
</html>
