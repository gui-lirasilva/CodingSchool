package br.com.coddingSchool.servlets;

import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.util.JpaUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterCategoryVisibilityServlet", value = "/alteraVisibilidade")
public class AlterCategoryVisibilityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());

        Category category = categoryDao.findById(id);
        category.toggleVisibility();
        categoryDao.updateCategory(category);

        response.setStatus(204);
//        response.sendRedirect("/listaCategorias");
    }
}
