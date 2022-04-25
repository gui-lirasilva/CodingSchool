<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
  <head>
    <title>Cadastrar novo curso</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel='stylesheet' href='/assets/css/style.css'>
    <meta content="text/html;charset=UTF-8">
  </head>
  <body>
    <div class="container">
      <div class="row">
        <h2>Novo curso</h2>
      </div>
      <%--@elvariable id="courseFormDTO" type="courseFormDTO"--%>
      <form:form action="/admin/courses" method="post" modelAttribute="courseFormDTO">
        <div class="mb-3 row">
          <label class="form-label">Nome</label>
          <input type="text" class="form-control" name="name" value="${courseFormDTO.name}"
                 placeholder="Digite aqui o nome do curso"/>
          <form:errors path="name" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Código</label>
          <input type="text" class="form-control" name="code" value="${courseFormDTO.code}"
                 placeholder="Por exemplo: java, desenvolvimento-web (Não utilize letras maiúsculas, acentos ou caracteres especiais)"/>
          <form:errors path="code" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 row">
          <label class="form-label">
            Duração do curso <span class="text-muted checkBox-helper">Tempo estimado da duração do curso, entre 1 e 20 horas</span>
          </label>
          <input type="number" class="form-control" name="estimatedTime" value="${courseFormDTO.estimatedTime}"
                 min="1" max="20"/>
          <form:errors path="estimatedTime" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 form-check row">
          <input type="checkbox" class="form-check-input"
                 value="true" name="visible" ${courseFormDTO.isVisible() ? 'checked' : ''}/>
          <label class="form-label">
            Curso visivel?
            <span class="text-muted checkBox-helper">O curso pode ser privado(padrão) ou público</span>
          </label>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Público alvo</label>
          <input type="text" class="form-control" name="target" value="${courseFormDTO.target}"
                 placeholder="Uma descrição de para quem é o curso"/>
          <form:errors path="target" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Instrutor</label>
          <input type="text" class="form-control" name="instructor" value="${courseFormDTO.instructor}"
                 placeholder="O nome do instrutor que ministra o curso"/>
          <form:errors path="instructor" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Ementa do curso</label>
          <textarea class="form-control" name="description" rows="6"
                    placeholder="Uma descrição detalhada do que será abordado no curso">${courseFormDTO.description}</textarea>
          <form:errors path="description" cssClass="alert-danger"/>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Habilidades desenvolvidas</label>
          <textarea class="form-control" name="developedSkills" rows="6"
                    placeholder="Um texto sobre quais capacidades a pessoa que faz o curso terá exercitado">${courseFormDTO.developedSkills}</textarea>
          <form:errors path="developedSkills" cssClass="alert-danger"/>
        </div>

        <div class="mb-3 row">
          <label>Subcategoria</label>
          <select name="subcategory" class="form-control">
            <c:forEach items="${subcategoryDTOList}" var="subcategory">
              <option value="${subcategory.id}">${subcategory.name}</option>
            </c:forEach>
            <form:errors path="subcategory" cssClass="alert-danger"/>
          </select>
        </div>
        <div class="row">
          <input type="submit" class="btn btn-success" value="Enviar"/>
        </div>
      </form:form>
    </div>

  </body>
</html>
