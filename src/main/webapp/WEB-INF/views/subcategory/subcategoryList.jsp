<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:list-template title="Lista de subcategorias">
    <h4>${Category.name}</h4>
    <h2>Subcategorias</h2>
    <br><br>
    <a href="/admin/subcategories/new">
        <button type="button" class="btn btn-primary"> Nova subcategoria </button>
    </a>
    <br><br>
    <table class="table table-bordered justify-content-center">
        <thead>
        <th>Nome</th>
        <th>Código</th>
        <th>Status</th>
        <th></th>
        <th></th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach items="${subcategories}" var="subcategoryDto">
            <tr class="col" data-code-subcategory="${subcategoryDto.code}">
                <td>${subcategoryDto.name}</td>
                <td>${subcategoryDto.code}</td>
                <td id="active${subcategoryDto.id}" class="activeStatus">${subcategoryDto.active == true ? "ATIVA" : "INATIVA"}</td>
                <td class="text-center">
                    <a href="/admin/courses/${Category.code}/${subcategoryDto.code}">
                        Cursos
                    </a>
                </td>
                <td class="text-center">
                    <a class="btn btn-default" role="button" href="/admin/subcategories/${Category.code}/${subcategoryDto.code}">
                        EDITAR
                    </a>
                </td>
                <td class="text-center">
                    <c:if test="${subcategoryDto.active}">
                        <button type="button" class="btn btn-default switch-status">
                            Desativar
                        </button>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</templates:list-template>