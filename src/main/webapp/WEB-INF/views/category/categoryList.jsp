<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:list-template title="Lista de categorias">
    <h2>Categorias</h2>
    <br><br>
    <a href="/admin/categories/new">
        <button type="button" class="btn btn-primary"> Nova categoria </button>
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
            <c:forEach items="${categories}" var="categoryDto">
                <tr class="col" data-code-category="${categoryDto.code}">
                    <td>${categoryDto.name}</td>
                    <td>${categoryDto.code}</td>
                    <td id="active${categoryDto.id}" class="activeStatus">${categoryDto.active == true ? "ATIVA" : "INATIVA"}</td>
                    <td class="text-center">
                        <a href="/admin/subcategories/${categoryDto.code}">
                            Subcategorias
                        </a>
                    </td>
                    <td class="text-center">
                        <a class="btn btn-default" role="button" href="/admin/categories/${categoryDto.code}">
                            EDITAR
                        </a>
                    </td>
                    <td class="text-center">
                        <c:if test="${categoryDto.active}">
                            <button type="button" class="btn btn-default switch-categoryStatus">
                                Desativar
                            </button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</templates:list-template>