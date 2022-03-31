<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/insereCategoria" var="insereCategoria"/>
<html>
  <head>
      <title>Insert category</title>
  </head>
  <body>
    <form action="${insereCategoria}" method="post">
      <label>Name:</label>
      <input type="text" name="name"/> <br>
      <label>Code: </label>
      <input type="text" name="code"/> <br>
      <label>Order:</label>
      <input type="number" name="order"/> <br>
      <label>Description:</label>
      <input type="text" name="description"/> <br>
      <label>Active:</label>
      <input type="checkbox" value="true" name="active"/> <br>
      <label>Icon path:</label>
      <input type="text" name="iconPath"/> <br>
      <label>Color code:</label>
      <input type="text" name="colorCode"/> <br>
      <label>Study guide:</label>
      <input type="text" name="studyGuide"/> <br>

      <input type="submit" value="Enviar">
    </form>
  </body>
</html>
