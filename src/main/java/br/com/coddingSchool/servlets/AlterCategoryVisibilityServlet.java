package br.com.coddingSchool.servlets;

import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.util.JpaUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterCategoryVisibilityServlet", value = "/alteraVisibilidade")
public class AlterCategoryVisibilityServlet extends HttpServlet {

    private CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(request.getParameter("id"));
        Category category = categoryDao.findById(id);
        category.toggleVisibility();
        categoryDao.updateCategory(category);
        response.setStatus(204);
    }
}
