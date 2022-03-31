package br.com.coddingSchool.servlets;

import br.com.coddingSchool.dao.CategoryDao;
import br.com.coddingSchool.dto.CategoryDTO;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.util.JpaUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Atualiza category", value = "/atualizaCategoria")
public class UpdateCategoryServlet extends HttpServlet {

    private CategoryDao categoryDao = new CategoryDao(JpaUtil.getEntityManager());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        CategoryDTO categoryDTO = new CategoryDTO(categoryDao.findById(id));
        request.setAttribute("category", categoryDTO);
        RequestDispatcher rd = request.getRequestDispatcher("/editCategoryForm.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.valueOf(request.getParameter("id"));

        Category category = categoryDao.findById(id);

        category.setName(request.getParameter("name"));
        category.setCode(request.getParameter("code"));
        category.setOrder(Integer.parseInt(request.getParameter("order")));
        category.setDescription(request.getParameter("description"));
        category.setActive(request.getParameter("active") != null);
        category.setIconPath(request.getParameter("iconPath"));
        category.setColorCode(request.getParameter("colorCode"));
        category.setStudyGuide(request.getParameter("studyGuide"));

        categoryDao.updateCategory(category);

        response.sendRedirect("/listaCategorias");
    }
}
