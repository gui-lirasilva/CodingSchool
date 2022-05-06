<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>Editar categoria</title>
        <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
        <link rel='stylesheet' href='/assets/css/style.css'>
        <meta content="text/html;charset=UTF-8">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2>Editar categoria</h2>
            </div>
            <%--@elvariable id="categoryFormDTO" type="categoryFormDTO"--%>
            <form:form action="/admin/categories/${category.code}" method="post" modelAttribute="categoryFormDTO">
                <input type="hidden" name="id" value="${category.id}"/>
                <div class="mb-3 row">
                    <label class="form-label">Nome</label>
                    <input type="text" class="form-control" name="name" value="${category.name}"
                           placeholder="Digite aqui o nome da categoria"/>
                    <form:errors path="name" cssClass="alert-danger"/>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Código</label>
                    <input type="text" class="form-control" name="code" value="${category.code}"
                           placeholder="Por exemplo: java, desenvolvimento-web (Não utilize letras maiúsculas, acentos ou caracteres especiais)"/>
                    <form:errors path="code" cssClass="alert-danger"/>
                </div>
                <div class="mb-3 form-check row">
                    <input type="checkbox" class="form-check-input"
                           value="true" name="active" ${category.isActive() ? 'checked' : ''}
                           placeholder=/>
                    <label class="form-label">
                        Categoria ativa?
                        <span class="text-muted checkBox-helper">Mostra ou deixa de mostrar a categoria na listagem dos alunos, de formações, etc.</span>
                    </label>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Ordem da categoria</label>
                    <input type="number" class="form-control" name="orderInSystem" value="${category.orderInSystem}"
                           placeholder="Por exemplo: a categoria de ordem 1 aparece antes da categoria de ordem 2"/>
                    <form:errors path="orderInSystem" cssClass="alert-danger"/>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Guias de estudo</label>
                    <textarea class="form-control" name="studyGuide" rows="6"
                              placeholder="Um texto apontando para formações para ajudar pessoas perdidas">${category.studyGuide}</textarea>
                    <form:errors path="studyGuide" cssClass="alert-danger"/>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Caminho do ícone</label>
                    <input type="text" class="form-control" name="iconPath" value="${category.iconPath}"
                           placeholder="por exemplo: /imagens/categorias/programacao.svg"/>
                    <form:errors path="iconPath" cssClass="alert-danger"/>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Cor</label>
                    <input type="text" class="form-control" name="colorCode" value="${category.colorCode}"
                           placeholder="por exemplo: #fcc14a"/>
                    <form:errors path="colorCode" cssClass="alert-danger"/>
                </div>
                <div class="mb-3 row">
                    <label class="form-label">Descrição</label>
                    <input type="text" class="form-control" name="description" value="${category.description}"
                           placeholder="por exemplo: iOS, Android, PhoneGap, e mais..."/>
                    <form:errors path="description" cssClass="alert-danger"/>
                </div>
                <div class="row">
                    <input type="submit" class="btn btn-success" value="Enviar">
                </div>
            </form:form>
        </div>
    </body>
</html>
