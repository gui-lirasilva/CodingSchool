<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Alterar subcategoria</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel='stylesheet' href='/assets/css/style.css'>
    <meta content="text/html;charset=UTF-8">
</head>
<body>
<div class="container">
    <div class="row">
        <h2>Alterar subcategoria</h2>
    </div>
    <%--@elvariable id="subcategoryFormDTO" type="subcategoryFormDTO"--%>
    <form:form action="/admin/subcategories/${categoryDTO.code}/${subcategoryDTO.code}" method="post" modelAttribute="subcategoryFormDTO">
        <input type="hidden" name="id" value="${subcategoryDTO.id}"/>
        <div class="mb-3 row">
            <label class="form-label">Nome</label>
            <input type="text" class="form-control" name="name" value="${subcategoryDTO.name}"
                   placeholder="Digite aqui o nome da categoria"/>
            <form:errors path="name" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 row">
            <label class="form-label">Código</label>
            <input type="text" class="form-control" name="code" value="${subcategoryDTO.code}"
                   placeholder="Por exemplo: java, desenvolvimento-web (Não utilize letras maiúsculas, acentos ou caracteres especiais)"/>
            <form:errors path="code" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 form-check row">
            <input type="checkbox" class="form-check-input"
                   value="true" name="active" ${subcategoryDTO.isActive() ? 'checked' : ''}/>
            <label class="form-label">
                Subcategoria ativa?
                <span class="text-muted checkBox-helper">Mostra ou deixa de mostrar a categoria na listagem dos alunos, de formações, etc.</span>
            </label>
        </div>
        <div class="mb-3 row">
            <label class="form-label">Ordem da subcategoria</label>
            <input type="number" class="form-control" name="orderInSystem" value="${subcategoryDTO.orderInSystem}"
                   placeholder="Por exemplo: a categoria de ordem 1 aparece antes da categoria de ordem 2"/>
            <form:errors path="orderInSystem" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 row">
            <label class="form-label">Guias de estudo</label>
            <textarea class="form-control" name="studyGuide" rows="6"
                      placeholder="Um texto apontando para formações para ajudar pessoas perdidas">${subcategoryDTO.studyGuide}</textarea>
            <form:errors path="studyGuide" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 row">
            <label class="form-label">Descrição</label>
            <input type="text" class="form-control" name="description" value="${subcategoryDTO.description}"
                   placeholder="por exemplo: iOS, Android, PhoneGap, e mais..."/>
            <form:errors path="description" cssClass="alert-danger"/>
        </div>

        <div class="mb-3 row">
            <label>Categoria</label>
            <select name="category" class="form-control">
                <c:forEach items="${categoryDtoList}" var="category">
                    <option value="${category.id}" ${category.id == subcategoryDTO.category.id ? 'selected' : ''}>
                            ${category.name}
                    </option>
                </c:forEach>
                <form:errors path="category" cssClass="alert-danger"/>
            </select>
        </div>
        <div class="row">
            <input type="submit" class="btn btn-success" value="Enviar"/>
        </div>
    </form:form>
</div>

</body>
</html>
