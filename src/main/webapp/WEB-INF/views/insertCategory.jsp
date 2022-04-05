<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Insert category</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
    <meta content="text/html;charset=UTF-8">
  </head>
  <body>
    <div class="container">
      <br><br><br>
      <form action="/admin/categories" method="post">
        <div class="mb-3 row">
          <label class="form-label">Nome:</label>
          <input type="text" class="form-control" name="name" placeholder="Digite aqui o nome da categoria"/> <br>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Código: </label>
          <input type="text" class="form-control" name="code"
                 placeholder="Por exemplo: java, desenvolvimento-web (Não utilize letras maiúsculas, acentos ou caracteres especiais)"/> <br>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Ordem no sistema:</label>
          <input type="number" class="form-control" name="order"
                 placeholder="Por exemplo: a categoria de ordem 1 aparece antes da categoria de ordem 2"/>
          <br>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Descrição:</label>
          <input type="text" class="form-control" name="description"
            placeholder="Uma descrição suncinta da categoria"/> <br>
        </div>
        <div class="mb-3 form-check">
          <input type="checkbox" class="form-check-input" style="height: 20px; width: 20px" value="true" name="active"
            placeholder="Mostra ou deixa de mostrar a categoria na listagem dos alunos, de formações, etc."/>
          <label class="form-label">Categoria ativa</label>
          <br> <br>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Link para ícone:</label>
          <input type="text" class="form-control" name="iconPath"
          placeholder="Por exemplo: /images/categoria/programacao.svg"/> <br>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Código para cor:</label>
          <input type="text" class="form-control" name="colorCode"
                 placeholder="Código hexadecimal para a cor utilizada pela categoria"/> <br>
        </div>
        <div class="mb-3 row">
          <label class="form-label">Guia de estudo:</label>
          <input type="text" class="form-control" name="studyGuide"
                 placeholder="Um texto apontando para informações para ajudar pessoas perdidas"/> <br>
        </div>
        <input type="submit" class="btn btn-default" value="Enviar" />
      </form>
    </div>

  </body>
</html>
