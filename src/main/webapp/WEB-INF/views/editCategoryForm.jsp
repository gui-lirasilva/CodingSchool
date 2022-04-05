<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Editar categoria</title>
        <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
        <meta content="text/html;charset=UTF-8">
    </head>
    <body>
        <div class="container">
            <br><br>
            <form action="/admin/categories/${category.code}" method="post">
                <input type="hidden" name="id" value="${category.id}"/> <br>
                <div class="mb-3 row">
                    <label class="form-label">Nome:</label>
                    <input type="text" class="form-control" name="name" value="${category.name}"/> <br>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Código:</label>
                    <input type="text" class="form-control" name="code" value="${category.code}"/> <br>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Ordem no sistema:</label>
                    <input type="number" class="form-control" name="order" value="${category.order}"/> <br>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Descrição:</label>
                    <input type="text" class="form-control" name="description" value="${category.description}"/> <br>
                </div>
                <div class="mb-3 form-check">
                    <c:choose>
                        <c:when test="${category.active == true}">
                            <input type="checkbox" class="form-check-input" style="height: 20px; width: 20px"
                                   value="true" name="active" value="${category.active}" checked/>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" class="form-check-input" style="height: 20px; width: 20px"
                                   value="true" name="active" value="${category.active}"/>
                        </c:otherwise>
                    </c:choose>
                    <label class="form-label">Categoria ativa</label> <br><br>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Link para ícone:</label>
                    <input type="text" class="form-control" name="iconPath" value="${category.iconPath}"/> <br>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Código hexadecimal para cor:</label>
                    <input type="text" class="form-control" name="colorCode" value="${category.colorCode}"/> <br>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Guia de estudo:</label>
                    <input type="text" class="form-control" name="studyGuide" value="${category.studyGuide}"/> <br>
                </div>
                <input type="submit" class="btn btn-default" value="Enviar">
            </form>
        </div>
    </body>
</html>
