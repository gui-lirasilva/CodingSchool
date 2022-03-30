package br.com.coddingSchool.servlets;

import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.dto.CategoryFormDTO;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.util.JpaUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Atualiza category", value = "/atualizaCategoria")
public class UpdateCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int order = Integer.parseInt(request.getParameter("order"));
        String description = request.getParameter("description");
        boolean active = request.getParameter("active") != null;
        String iconPath = request.getParameter("iconPath");
        String colorCode = request.getParameter("colorCode");
        String studyGuide = request.getParameter("studyGuide");

        CategoryFormDTO categoryFormDTO = new CategoryFormDTO(name, code, order, description, active, iconPath,
                colorCode, studyGuide);

        Category category = categoryFormDTO.toEntity();
        categoryDao.updateCategoryById(id, category);

        response.sendRedirect("/listaCategorias");
    }
}
